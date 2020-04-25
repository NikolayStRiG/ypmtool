package org.sterzhen.ypmtool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.sterzhen.ypmtool.data.dto.LabelDTO;
import org.sterzhen.ypmtool.data.dto.TaskDTO;
import org.sterzhen.ypmtool.services.TaskService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "")
    public Collection<TaskDTO> findAll() {
        return taskService.findAll().stream()
                .map(TaskDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public TaskDTO findById(@PathVariable(name = "id") Long id) {
        return taskService.findById(id)
                .map(TaskDTO::of)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
    }

    @PostMapping(path = "")
    public TaskDTO create(@RequestBody TaskDTO dto, Authentication auth) {
        dto.setCreateUser(new LabelDTO(null, auth.getName(), null));
        var createEntity = taskService.create(dto.toEntity());
        return TaskDTO.of(createEntity);
    }
}
