package com.myogui.ecommercejava.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myogui.ecommercejava.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheUserImpl<T> implements CacheUser<T> {
    private final RedisTemplate<String, String> redisTemplate;
    private HashOperations<String, String, String> hashOperations;
    private final ObjectMapper mapper;
    //private final ApplicacionProperties properties;

    @PostConstruct
    void setHashOperations() {
        hashOperations = this.redisTemplate.opsForHash();
        this.redisTemplate.expire(Constants.NAME_MAP_USER, Duration.ofMillis(60000)); //TODO properties.getTimeOfLife()));
    }

    @Override
    public String save(String key, String value) {
        hashOperations.put(Constants.NAME_MAP_USER, key, value);
        return value;
    }

    @Override
    public String recover(String key) {
        var item = hashOperations.get(Constants.NAME_MAP_USER, key);
        if (item == null) return null;
        return item;
    }
}
