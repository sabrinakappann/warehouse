package com.storage.warehouse.roles;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
