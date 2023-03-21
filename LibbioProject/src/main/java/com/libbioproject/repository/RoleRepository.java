package com.libbioproject.repository;

import com.libbioproject.domain.Role;
import com.libbioproject.domain.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByType(RoleType roleType);
}
