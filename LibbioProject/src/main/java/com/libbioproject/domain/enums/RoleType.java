package com.libbioproject.domain.enums;

public enum RoleType {

    ROLE_USER("Customer"),
    ROLE_ADMIN("Administrator");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
