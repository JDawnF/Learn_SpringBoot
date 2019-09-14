package com.baichen.autoconfigure.repository;

import com.baichen.autoconfigure.annotation.FirstLevelRepository;
import com.baichen.autoconfigure.annotation.SecondLevelRepository;

/**
 * 我的 {@link FirstLevelRepository}
 *
 * @author baichen
 */
@SecondLevelRepository(value = "myFirstLevelRepository") // Bean 名称
public class MyFirstLevelRepository {
}
