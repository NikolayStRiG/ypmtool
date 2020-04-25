package org.sterzhen.ypmtool.data.dto;

import org.sterzhen.ypmtool.data.entities.TaskStatus;
import org.sterzhen.ypmtool.data.entities.TaskType;
import org.sterzhen.ypmtool.data.entities.ToolUser;

import java.util.Optional;

public class LabelDTO {

    private Long id;
    private String code;
    private String label;

    public static LabelDTO of(TaskStatus status) {
        if (status == null) {
            return null;
        }
        return new LabelDTO(null, status.name(), status.label());
    }

    public static TaskStatus toTaskStatus(LabelDTO dto) {
        return Optional.ofNullable(dto)
                .map(d -> TaskStatus.valueOf(d.code))
                .orElse(null);
    }

    public static LabelDTO of(TaskType type) {
        if (type == null) {
            return null;
        }
        return new LabelDTO(type.getId(), type.getType(), type.getName());
    }

    public static TaskType toTaskType(LabelDTO dto) {
        return Optional.ofNullable(dto)
                .map(t -> {
                    var e = new TaskType();
                    e.setId(t.getId());
                    e.setType(t.getCode());
                    return e;
                }).orElse(null);
    }

    public static LabelDTO of(ToolUser user) {
        if (user == null) {
            return null;
        }
        return new LabelDTO(user.getId(), user.getLogin(), user.label());
    }

    public static ToolUser toToolUser(LabelDTO dto) {
        return Optional.ofNullable(dto)
                .map(t -> {
                    var e = new ToolUser();
                    e.setId(t.getId());
                    e.setLogin(t.getCode());
                    return e;
                }).orElse(null);
    }

    public LabelDTO() {
    }

    public LabelDTO(Long id, String code, String label) {
        this.id = id;
        this.code = code;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
