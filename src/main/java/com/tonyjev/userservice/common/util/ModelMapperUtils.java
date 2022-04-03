package com.tonyjev.userservice.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelMapperUtils {

    private static final ModelMapper mapper = new ModelMapper();

    public static Object map(Object source, Class<?> targetClass) {
        mapper.getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // Setter 안쓰기 위해 접근 레밸을 PRIVATE 으로 설정(기본 : PUBLIC)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(source, targetClass);
    }

}
