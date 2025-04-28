package com.example.spring_redis_demo;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Value (String) 저장 및 조회
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Hash 저장 및 조회회
    public void setHashValue(String key, String field, String value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public Map<Object, Object> getHashAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // List 저장 및 조회
    public void addToList(String key, String value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public List<String> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    // Set 저장 및 조회
    public void addToSet(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    public Set<String> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // Sorted Set 저장 및 조회
    public void addToZSet(String key, String value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    public Set<String> getZSet(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }

    // value TTL 설정
    public void setValueWithTTL(String key, String value, long seconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(seconds));
    }

    public Long getTTL(String key) {
        return redisTemplate.getExpire(key);
    }
}
