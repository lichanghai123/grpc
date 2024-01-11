package com.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisAutoConfiguration {

	/**
	 * 配置key,value的序列化方式
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		StringRedisSerializer srs = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		template.setConnectionFactory(redisConnectionFactory);
		  // key采用String的序列化方式
	     template.setKeySerializer(srs);
	     // hash的key也采用String的序列化方式
	     template.setHashKeySerializer(srs);
	     // value序列化方式采用jackson
	     template.setValueSerializer(jsonRedisSerializer);
	     // hash的value序列化方式采用jackson
	     template.setHashValueSerializer(jsonRedisSerializer);
	     template.afterPropertiesSet();
		return template;
	}

	/**
	 * 配置使用注解的时候缓存配置，默认是序列化反序列化的形式，加上此配置则为 json 形式
	 */
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		RedisCacheConfiguration redisCacheConfiguration = config
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		return RedisCacheManager.builder(factory).cacheDefaults(redisCacheConfiguration).build();
	}

}
