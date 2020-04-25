package org.sterzhen.ypmtool.services;

import org.sterzhen.ypmtool.data.entities.ToolUserRole;

import java.util.Collection;

public interface ToolUserRoleService {

    Collection<ToolUserRole> findAll();
}
