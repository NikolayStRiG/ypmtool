package org.sterzhen.ypmtool.services;

import org.sterzhen.ypmtool.data.entities.Task;

import java.util.Collection;
import java.util.Optional;

public interface TaskService {
    Collection<Task> findAll();

    Optional<Task> findById(Long id);

    Task create(Task newTask);
}
