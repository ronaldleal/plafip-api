package com.plafip.api.infra.service;

import com.plafip.api.domain.port.ModelMapperService;
import org.modelmapper.ModelMapper;

public class ModelMapperServiceImpl implements ModelMapperService {

    private final ModelMapper modelMapper;

    public ModelMapperServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public <T, R> T map(R input, Class<T> destination) {
        return modelMapper.map(input, destination);
    }
}
