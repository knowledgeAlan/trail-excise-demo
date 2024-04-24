package com.zcd.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:23 pm
 */
public class User {

    @NotNull
    private Long id;

    @NotNull
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
