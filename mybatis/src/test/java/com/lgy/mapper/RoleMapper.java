package com.lgy.mapper;

import com.lgy.po.Role;

public interface RoleMapper {

    Role getRole(Long id);

    Role findRole(String roleName);

    int deleteRole(Long id);

    int insertRole(Role role);
}
