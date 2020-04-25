package org.sterzhen.ypmtool.data.dto;

import org.sterzhen.ypmtool.data.entities.TaskType;

public class TaskTypeDTO {

    private Long id;
    private String type;
    private String name;
    private String description;

    public static TaskTypeDTO of(TaskType type) {
        if (type == null) {
            return null;
        }
        var dto = new TaskTypeDTO();
        dto.setId(type.getId());
        dto.setType(type.getType());
        dto.setName(type.getName());
        dto.setDescription(type.getDescription());
        return dto;
    }

    public TaskType toEntity() {
        var entity= new TaskType();
        entity.setId(id);
        entity.setType(type);
        entity.setName(name);
        entity.setDescription(description);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
