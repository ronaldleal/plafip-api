package com.plafip.api.infra.data.dao;

import com.plafip.api.domain.model.User;
import com.plafip.api.domain.port.EncryptService;
import com.plafip.api.domain.port.ModelMapperService;
import com.plafip.api.domain.port.UserAdapter;
import com.plafip.api.infra.data.entity.UserEntity;
import com.plafip.api.infra.data.repository.UserRepository;

import java.util.Optional;

public class UserDao implements UserAdapter {
    private final UserRepository userRepository;
    private final EncryptService encryptService;
    private final ModelMapperService modelMapperService;

    public UserDao(UserRepository userRepository,
                   EncryptService encryptService,
                   ModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.encryptService = encryptService;
        this.modelMapperService = modelMapperService;
    }

    public User createUser(User user) {
        user.setPassword(encryptService.encode(user.getPassword()));
        var entity = modelMapperService.map(user, UserEntity.class);
        userRepository.save(entity);
        return modelMapperService.map(entity, User.class);
    }

    public User doLogin(User user) {
        var entity = modelMapperService.map(user, UserEntity.class);
        entity = userRepository.findByEmailOrUsername(entity.getEmail(), entity.getUsername());
        return Optional.ofNullable(entity)
                .filter(r -> encryptService.isMatched(user.getPassword(), r.getPassword()))
                .map(r -> modelMapperService.map(r, User.class))
                .orElse(null);
    }

    public User findUser(User user){
        var entity = userRepository.findByEmailOrUsername(user.getEmail(), user.getUsername());
        return Optional.ofNullable(entity)
                .map(u -> modelMapperService.map(entity, User.class))
                .orElse(null);
    }
}
