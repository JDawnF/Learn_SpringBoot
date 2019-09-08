package com.baichen.simple.repository;

import com.baichen.simple.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2019-09-08 21:05
 * @Author: baichen
 * @Description
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型存储方式，final确保一致性
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>(16);

    private final static AtomicInteger ID_GENERATOR = new AtomicInteger();//自增ID

    /**
     * 保存用户对象
     * @param user {@link User}
     * @return 如果成功返回<code>true</code>，否则，返回<code>false</code>
     */
    public boolean save(User user){
        // ID 从 1 开始
        Integer id = ID_GENERATOR.incrementAndGet();
        user.setId(id);
        // put 方法返回 null 时表示保存成功
        return repository.put(id,user) == null;
    }

    /**
     * 返回所有用户列表
     * @return 所有用户列表
     */
    public Collection<User> findAll(){
        return repository.values();
    }
}
