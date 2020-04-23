package org.sterzhen.ypmtool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.sterzhen.ypmtool.data.dto.UserDTO;
import org.sterzhen.ypmtool.servises.ToolUserService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@PreAuthorize("hasAuthority('ADMIN')")
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ToolUserService userService;

    @GetMapping(path = "")
    public Collection<UserDTO> findAll() {
        return userService.findAll().stream()
                .map(UserDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public UserDTO findById(@PathVariable(name = "id") Long id) {
        return userService.findById(id)
                .map(UserDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = " + id + " not found"));
    }

    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping(path = "/current_user")
    public UserDTO getCurrentUser(Authentication auth) {
        return userService.findByLogin(auth.getName())
                .map(UserDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("User with login " + auth.getName() + " not found"));
    }

    @PostMapping(path = "")
    public UserDTO createUser(@RequestBody UserDTO dto) {
        return UserDTO.of(userService.createUser(dto.toEntity()));
    }
}
