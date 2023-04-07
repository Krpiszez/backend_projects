package com.libbioproject.domain.enums;

public enum RoleType {

    ROLE_CUSTOMER("Customer"),
    ROLE_ADMIN("Administrator"),
    ROLE_LIBRARY_OWNER("LibraryOwner");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
