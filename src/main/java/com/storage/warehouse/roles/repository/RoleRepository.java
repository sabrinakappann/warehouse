package com.storage.warehouse.roles.repository;

import com.storage.warehouse.roles.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
