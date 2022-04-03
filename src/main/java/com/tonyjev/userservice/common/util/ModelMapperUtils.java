package com.tonyjev.userservice.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelMapperUtils {

    private static final ModelMapper mapper = new ModelMapper();

    public static Object mapStrict(Object source, Class<?> targetClass) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(source, targetClass);
    }

}
