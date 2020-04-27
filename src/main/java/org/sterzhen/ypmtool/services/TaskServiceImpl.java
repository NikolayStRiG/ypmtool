package org.sterzhen.ypmtool.services;

import org.springframework.stereotype.Service;
import org.sterzhen.ypmtool.data.entities.Task;
import org.sterzhen.ypmtool.data.entities.TaskStatus;
import org.sterzhen.ypmtool.data.entities.TaskType;
import org.sterzhen.ypmtool.data.entities.ToolUser;
import org.sterzhen.ypmtool.data.repositories.TaskRepository;
import org.sterzhen.ypmtool.data.repositories.TaskTypeRepository;
import org.sterzhen.ypmtool.data.repositories.ToolUserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskTypeRepository taskTypeRepository;
    private final ToolUserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskTypeRepository taskTypeRepository, ToolUserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskTypeRepository = taskTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task create(Task newTask) {
        var createUser = findUser(newTask.getCreateUser())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        var responsibleUser = findUser(newTask.getResponsibleUser()).orElse(createUser);
        var taskType = findTaskType(newTask.getType())
                .orElseThrow(() -> new EntityNotFoundException("Task type not found"));

        newTask.setStatus(TaskStatus.NEW);
        newTask.setType(taskType);
        newTask.setResponsibleUser(responsibleUser);
        newTask.setCreateTime(ZonedDateTime.now());
        newTask.setCreateUser(createUser);
        return taskRepository.save(newTask);
    }

    private Optional<ToolUser> findUser(ToolUser user) {
        Optional<ToolUser> result = Optional.empty();
        if (user != null) {
            if (user.getId() != null) {
                result = userRepository.findById(user.getId());
            } else if (user.getLogin() != null) {
                result = userRepository.findByLogin(user.getLogin());
            }
        }
        return result;
    }

    private Optional<TaskType> findTaskType(TaskType type) {
        Optional<TaskType> result = Optional.empty();
        if (type != null) {
            if (type.getId() != null) {
                result = taskTypeRepository.findById(type.getId());
            } else if (type.getType() != null) {
                result = taskTypeRepository.findByType(type.getType());
            }
        }
        return result;
    }
}
