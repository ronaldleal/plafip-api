package com.plafip.api.app.config;

import com.plafip.api.domain.port.*;
import com.plafip.api.domain.usecase.MovementUseCase;
import com.plafip.api.domain.usecase.UserUseCase;
import com.plafip.api.infra.data.dao.MovementDao;
import com.plafip.api.infra.data.dao.UserDao;
import com.plafip.api.infra.data.repository.MovementRepository;
import com.plafip.api.infra.data.repository.UserRepository;
import com.plafip.api.infra.service.EncryptServiceImpl;
import com.plafip.api.infra.service.ModelMapperServiceImpl;
import com.plafip.api.infra.service.PlafipSecurityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppProducers {


    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService modelMapperService(ModelMapper modelMapper){
        return new ModelMapperServiceImpl(modelMapper);
    }

    @Bean
    public EncryptService encryptService(BCryptPasswordEncoder bcryptPasswordEncoder){
        return new EncryptServiceImpl(bcryptPasswordEncoder);
    }

    @Bean
    public SecurityService plafipSecurityService(@Value("${app.jwt.secret}") String secret,
                                                 @Value("${app.jwt.expiration}") long expiration){
        return new PlafipSecurityService(secret, expiration);
    }

    @Bean
    public UserAdapter userAdapter(UserRepository userRepository, EncryptService encryptService,
                                   ModelMapperService modelMapperService){
        return new UserDao(userRepository, encryptService, modelMapperService);
    }
    @Bean
    public MovementAdapter movementAdapter(MovementRepository movementRepository,
                                           ModelMapperService modelMapperService,
                                           UserRepository userRepository
                                           ){
        return new MovementDao(modelMapperService, userRepository,movementRepository);
    }

    @Bean
    public UserUseCase userUseCase(UserAdapter userAdapter, SecurityService securityService){
        return new UserUseCase(userAdapter, securityService);
    }

    @Bean
    public MovementUseCase movementUseCase(MovementAdapter movementAdapter){
        return new MovementUseCase(movementAdapter);
    }
}
