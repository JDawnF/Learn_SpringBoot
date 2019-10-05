package com.baichen.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Date: 2019-10-05 09:37
 * @Author: baichen
 * @Description 通用mapper，特别注意，该接口不能被扫描到，否则会出错
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
