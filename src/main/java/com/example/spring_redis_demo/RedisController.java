package com.example.spring_redis_demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    // String 저장 및 조회
    @PostMapping("/string/{key}")
    public void setValue(@PathVariable String key, @RequestBody String value) {
        redisService.setValue(key, value);
    }

    @GetMapping("/string/{key}")
    public String getValue(@PathVariable String key) {
        return redisService.getValue(key);
    }

    // Hash 저장 및 조회
    @PostMapping("/hash/{key}/{field}")
    public void setHashValue(@PathVariable String key, @PathVariable String field, @RequestBody String value) {
        redisService.setHashValue(key, field, value);
    }

    @GetMapping("/hash/{key}")
    public Map<Object, Object> getHashAll(@PathVariable String key) {
        return redisService.getHashAll(key);
    }

    // List 저장 및 조회
    @PostMapping("/list/{key}")
    public void addToList(@PathVariable String key, @RequestBody String value) {
        redisService.addToList(key, value);
    }

    @GetMapping("/list/{key}")
    public List<String> getList(@PathVariable String key) {
        return redisService.getList(key);
    }

    // Set 저장 및 조회
    @PostMapping("/set/{key}")
    public void addToSet(@PathVariable String key, @RequestBody String value) {
        redisService.addToSet(key, value);
    }

    @GetMapping("/set/{key}")
    public Set<String> getSet(@PathVariable String key) {
        return redisService.getSet(key);
    }

    // Sorted Set 저장 및 조회
    @PostMapping("/zset/{key}")
    public void addToZSet(@PathVariable String key, @RequestParam String value, @RequestParam double score) {
        redisService.addToZSet(key, value, score);
    }

    @GetMapping("/zset/{key}")
    public Set<String> getZSet(@PathVariable String key) {
        return redisService.getZSet(key);
    }

}
