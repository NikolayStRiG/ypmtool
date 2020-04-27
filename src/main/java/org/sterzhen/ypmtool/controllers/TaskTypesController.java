package org.sterzhen.ypmtool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sterzhen.ypmtool.data.dto.TaskTypeDTO;
import org.sterzhen.ypmtool.data.repositories.TaskTypeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/task_types")
public class TaskTypesController {

    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @GetMapping(path = "")
    public Collection<TaskTypeDTO> findAll() {
        return taskTypeRepository.findAll().stream()
                .map(TaskTypeDTO::of)
                .collect(Collectors.toList());
    }
}
