package com.component;


//import javax.annotation.PostConstruct;

//import org.redisson.Redisson;
//import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class RedisClient {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
//     private Redisson redisson;
//	 @PostConstruct
//	 public void initRdies(){
//		 setLocation("LTMac-50:7b:9d:a4:4f:d9","d9");
//		 setLocation("LTMac-50:7b:9d:a4:4f:d8","d8");
//		 setLocation("LTMac-50:7b:9d:a4:4f:d7","d7");
//		 setLocation("LTMac-50:7b:9d:a4:4f:d6","d6");
//		 redisTemplate.opsForValue().set("LTMac-00:1c:82:11:41:a2", "v-ani.0.1.1.3");
//		 log.info(getLocation("LTMac-00:1c:82:11:41:a3"));
//	 }
	/* public String getLocation(String key){
		String location = "";
	    RBucket<String> bucket = null;
	    try {
	        bucket = redisson.getBucket(key);
	    } catch (Exception e) {
	        log.error("Failed to connect to redis.", e);
	    }
	    if (bucket != null && bucket.isExists()) {
//	                bucket.set(treeNeNode, Constants.CACHE_TIMEOUT, TimeUnit.SECONDS);
	    	location =  bucket.get();
	    }else{
	    	 log.info("not find from redis:", key);
	    }
	    
	    return location;
    }
	 
	 public void setLocation(String key,String value){
	    RBucket<String> bucket = null;
	    try {
	        bucket = redisson.getBucket(key);
	    } catch (Exception e) {
	        log.error("Failed to connect to redis.", e);
	    }
	    if (bucket != null && !bucket.isExists()) {
                bucket.set(value, 3600, TimeUnit.SECONDS);
	    }else{
	    	 log.info("vlue is exists in redis:");
	    }
    }*/
	 public String getLocation(String key) {
		 String value = "";
		 if(key != null) value = redisTemplate.opsForValue().get(key).toString();
		 log.info("get location from redis:", key+"=="+value);
		return value;
	}
}
