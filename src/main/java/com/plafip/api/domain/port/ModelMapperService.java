package com.plafip.api.domain.port;

public interface ModelMapperService {
    <T, R> T map(R input, Class<T> destination);
}
