package com.rrojase.retomitoccode.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ApplicationContext context;

    public <S, T>List<T> toList(List<S> source, Class<T> target, String...mapperQualifier) {
        ModelMapper mapper = this.getModelMapper(mapperQualifier);
        return source
                .stream()
                .map(e->mapper.map(e, target))
                .toList();
    }

    public <S, T> T toMap(S source, Class<T> target, String...mapperQualifier) {
        ModelMapper mapper = this.getModelMapper(mapperQualifier);
        return mapper.map(source, target);
    }

    private ModelMapper getModelMapper(String... mapperQualifier) {
        if (mapperQualifier.length == 0 || mapperQualifier[0] == null || mapperQualifier[0].isEmpty()){
            return context.getBean("defaultMapper", ModelMapper.class);
        }
        return context.getBean(mapperQualifier[0], ModelMapper.class);
    }
}
