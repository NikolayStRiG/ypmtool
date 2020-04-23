package org.sterzhen.ypmtool.servises;

import org.springframework.stereotype.Service;
import org.sterzhen.ypmtool.data.entities.ToolUserRole;
import org.sterzhen.ypmtool.data.repositories.ToolUserRoleRepository;

import java.util.Collection;

@Service
public class ToolUserRoleServiceImpl implements ToolUserRoleService {

    private final ToolUserRoleRepository roleRepository;

    public ToolUserRoleServiceImpl(ToolUserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Collection<ToolUserRole> findAll() {
        return roleRepository.findAll();
    }
}
