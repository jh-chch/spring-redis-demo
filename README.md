## Docker redis
```
docker run -d --name redis-test -p 6379:6379 redis
```

## StringRedisTemplate
### String 저장/조회
```
curl -X POST localhost:8080/redis/string/testKey -H "Content-Type: text/plain" -d "testValue"
curl localhost:8080/redis/string/testKey
```
### Hash 저장/조회
```
curl -X POST localhost:8080/redis/hash/user:1/name -H "Content-Type: text/plain" -d "John"
curl -X POST localhost:8080/redis/hash/user:1/age -H "Content-Type: text/plain" -d "30"
curl localhost:8080/redis/hash/user:1
```
### List 저장/조회
```
curl -X POST localhost:8080/redis/list/chat:room1 -H "Content-Type: text/plain" -d "Hello"
curl -X POST localhost:8080/redis/list/chat:room1 -H "Content-Type: text/plain" -d "World"
curl localhost:8080/redis/list/chat:room1
```
### Set 저장/조회
```
curl -X POST localhost:8080/redis/set/post:likes:1 -H "Content-Type: text/plain" -d "userA"
curl -X POST localhost:8080/redis/set/post:likes:1 -H "Content-Type: text/plain" -d "userB"
curl localhost:8080/redis/set/post:likes:1
```
### Sorted Set 저장/조회
```
curl -X POST "localhost:8080/redis/zset/leaderboard?value=userA&score=100"
curl -X POST "localhost:8080/redis/zset/leaderboard?value=userB&score=200"
curl -X POST "localhost:8080/redis/zset/leaderboard?value=userC&score=150"
curl localhost:8080/redis/zset/leaderboard
```
### TTL 설정해서 저장 후 남은 시간 조회
```
curl -X POST "localhost:8080/redis/string/tempKey/ttl?seconds=10" -H "Content-Type: text/plain" -d "temporary value"
curl localhost:8080/redis/ttl/tempKey
```
