package com.zhu.security.impl;

import com.google.common.collect.Sets;
import com.zhu.framework.helper.DatabaseHelper;
import com.zhu.security.SmartSecurity;

import java.util.Set;

/**
 * 应用安全控制
 */
public class AppSecurity implements SmartSecurity {
    @Override
    public String getPassword(String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
        return DatabaseHelper.queryEntity(String.class, sql, username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT p.permission_name FROM role r, role_permission rp, " +
                "permission p WHERE r.id = rp.role_id AND p.id = rp.permission_id " +
                "AND r.role_name = ?";
        return Sets.newHashSet(DatabaseHelper.queryEntityList(String.class, sql, roleName));
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "SELECT r.role_name FROM user u, user_role ur, role r " +
                "WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.username = ?";
        return Sets.newHashSet(DatabaseHelper.queryEntityList(String.class, sql, username));
    }
}
