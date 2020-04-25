package org.sterzhen.ypmtool.data.dto;

import org.sterzhen.ypmtool.data.entities.Task;

import java.time.ZonedDateTime;

public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private LabelDTO status;
    private Integer priority;
    private LabelDTO type;
    private LabelDTO responsibleUser;
    private ZonedDateTime finishTime;
    private LabelDTO createUser;
    private ZonedDateTime createTime;

    public static TaskDTO of(Task task) {
        if (task == null) {
            return null;
        }
        var dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setStatus(LabelDTO.of(task.getStatus()));
        dto.setPriority(task.getPriority());
        dto.setType(LabelDTO.of(task.getType()));
        dto.setResponsibleUser(LabelDTO.of(task.getResponsibleUser()));
        dto.setFinishTime(task.getFinishTime());
        dto.setCreateUser(LabelDTO.of(task.getCreateUser()));
        dto.setCreateTime(task.getCreateTime());
        return dto;
    }

    public Task toEntity() {
        var task = new Task();
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        task.setStatus(LabelDTO.toTaskStatus(status));
        task.setPriority(priority);
        task.setType(LabelDTO.toTaskType(type));
        task.setResponsibleUser(LabelDTO.toToolUser(responsibleUser));
        task.setFinishTime(finishTime);
        task.setCreateUser(LabelDTO.toToolUser(createUser));
        task.setCreateTime(createTime);
        return task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LabelDTO getStatus() {
        return status;
    }

    public void setStatus(LabelDTO status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LabelDTO getType() {
        return type;
    }

    public void setType(LabelDTO type) {
        this.type = type;
    }

    public LabelDTO getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(LabelDTO responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public ZonedDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public LabelDTO getCreateUser() {
        return createUser;
    }

    public void setCreateUser(LabelDTO createUser) {
        this.createUser = createUser;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }
}
