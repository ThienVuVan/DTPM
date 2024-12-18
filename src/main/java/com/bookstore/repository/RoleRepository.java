package com.bookstore.repository;

import com.bookstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRoleId(Integer id);
}
