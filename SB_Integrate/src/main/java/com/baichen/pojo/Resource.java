package com.baichen.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Date: 2019-10-04 12:33
 * @Author: baichen
 * @Description 配置属性实体类,从配置文件中获取属性值
 */
@Configuration
@ConfigurationProperties(prefix="com.baichen.opensource")  // 资源文件前缀,注册到HelloController
@PropertySource(value="classpath:resource.properties")  // 资源文件路径
public class Resource {
    private String name;
    private String website;
    private String language;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
}
