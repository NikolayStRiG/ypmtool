package org.sterzhen.ypmtool.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.sterzhen.ypmtool.data.dto.UserDTO;
import org.sterzhen.ypmtool.servises.ToolUserService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private final ToolUserService userService;

    public UserController(ToolUserService userService) {
        this.userService = userService;
    }

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

    @GetMapping(path = "/current_user")
    public UserDTO getCurrentUser(Authentication auth) {
        return userService.findByLogin(auth.getName())
                .map(UserDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("User with login " + auth.getName() + " not found"));
    }
}
