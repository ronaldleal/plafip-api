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

    public User doLogin(String email) {
        return null;
    }

    public User createUser(User user) {
        user.setPassword(encryptService.encode(user.getPassword()));
        var entity = modelMapperService.map(user, UserEntity.class);
        userRepository.save(entity);
        return modelMapperService.map(entity, User.class);
    }

    public User doLogin(User user) {
        user.setPassword(encryptService.encode(user.getPassword()));
        var entity = modelMapperService.map(user, UserEntity.class);
        entity = userRepository.findByEmailAndPassword(entity.getEmail(), entity.getPassword());
        return Optional.ofNullable(entity)
                .map(r -> modelMapperService.map(r, User.class))
                .orElse(null);
    }
}
