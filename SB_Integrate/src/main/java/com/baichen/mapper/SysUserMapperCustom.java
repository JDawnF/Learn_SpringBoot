package com.baichen.mapper;

import com.baichen.pojo.SysUser;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Date: 2019-10-05 09:45
 * @Author: baichen
 * @Description 自定义查询接口
 */
@Repository
public interface SysUserMapperCustom {
    /**
     * 通过ID查询用户
     *
     * @param id ID
     * @return 用户集合
     */
    List<SysUser> queryUserSimplyInfoById(String id);
}
