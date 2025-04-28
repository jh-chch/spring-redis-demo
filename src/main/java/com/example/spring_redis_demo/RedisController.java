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

    // String 저장하면서 TTL 설정
    @PostMapping("/string/{key}/ttl")
    public void setValueWithTTL(@PathVariable String key,
            @RequestParam long seconds,
            @RequestBody String value) {
        redisService.setValueWithTTL(key, value, seconds);
    }

    // TTL 조회
    @GetMapping("/ttl/{key}")
    public Long getTTL(@PathVariable String key) {
        return redisService.getTTL(key);
    }

    // 특정 게시글(postId) 좋아요를 증가시킨다고 가정
    // 회원당1회, redis에 없으면 db조회, 스케쥴링으로 모아놓고 DB에 저장하는 등.. 추가적인 부분은 생략
    // key가 없으면 0 부터 증가된다.
    @PostMapping("/like/{postId}")
    public Long like(@PathVariable String postId) {
        return redisService.likePost(postId);
    }

    @PostMapping("/unlike/{postId}")
    public Long unlike(@PathVariable String postId) {
        return redisService.unlikePost(postId);
    }

}
