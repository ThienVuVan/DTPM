package com.bookstore.service.impl;

import com.bookstore.entity.Role;
import com.bookstore.repository.RoleRepository;
import com.bookstore.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role retrieveById(Integer id) {
        return roleRepository.findRoleByRoleId(id);
    }
}
