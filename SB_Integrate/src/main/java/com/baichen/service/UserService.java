package com.baichen.service;

import com.baichen.pojo.SysUser;

import java.util.List;

/**
 * @Date: 2019-10-05 11:15
 * @Author: baichen
 * @Description
 */
public interface UserService {

    /**
     * 创建
     *
     * @param user 用户
     */
    void create(SysUser user);

    /**
     * 更新
     *
     * @param user 用户
     */
    void update(SysUser user);

    /**
     * 移除
     *
     * @param userId 用户ID
     */
    void remove(String userId);

    /**
     * 查询
     *
     * @param userId 用户ID
     * @return 用户
     */
    SysUser queryById(String userId);

    /**
     * 查询用户集合
     *
     * @param user 用户
     * @return 用户集合
     */
    List<SysUser> queryUserList(SysUser user);

    /**
     * 分页查询用户集合
     *
     * @param user     用户
     * @param page     当前页
     * @param pageSize 每页大小
     * @return 用户集合
     */
    List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    /**
     * 查询
     *
     * @param userId 用户ID
     * @return 用户
     */
    SysUser queryUserByIdCustom(String userId);

    /**
     * 保存
     *
     * @param user 用户
     */
    void saveUserTransactional(SysUser user);

}
