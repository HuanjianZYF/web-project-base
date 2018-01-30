package zyf.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zyf
 * @CreateAt 2018/1/9 下午3:45
 */
@Service
public class RedisService {

    @Resource
    private RedisTemplate<String, Object> template;

    /**
     * 保存到redis
     */
    public void setKeyValue(String key, Object value) {
        template.opsForValue().set(key, value);
    }

    /**
     * 读出redis
     */
    public Object getKey(String key) {
        return template.opsForValue().get(key);
    }

    /**
     * 删除某个键
     */
    public void deleteKey(String key) {
        template.delete(key);
    }

}
