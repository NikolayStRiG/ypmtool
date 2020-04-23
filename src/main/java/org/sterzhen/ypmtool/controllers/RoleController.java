package org.sterzhen.ypmtool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sterzhen.ypmtool.data.dto.UserRoleDTO;
import org.sterzhen.ypmtool.servises.ToolUserRoleService;

import java.util.Collection;
import java.util.stream.Collectors;

@PreAuthorize("isFullyAuthenticated()")
@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private ToolUserRoleService roleService;

    @GetMapping(path = "")
    public Collection<UserRoleDTO> findAll() {
        return roleService.findAll().stream()
                .map(UserRoleDTO::of)
                .collect(Collectors.toList());
    }
}
