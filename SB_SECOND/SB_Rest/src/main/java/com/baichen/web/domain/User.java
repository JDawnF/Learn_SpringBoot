package com.baichen.web.domain;

/**
 *  用户模型
 *
 * @author baichen
 * @since 2019/9/21
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
