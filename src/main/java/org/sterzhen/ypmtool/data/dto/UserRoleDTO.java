package org.sterzhen.ypmtool.data.dto;

import org.sterzhen.ypmtool.data.entities.RoleLevel;
import org.sterzhen.ypmtool.data.entities.ToolUserRole;

public class UserRoleDTO {

    private Long id;
    private String level;
    private String tag;
    private String name;

    public static UserRoleDTO of(ToolUserRole role) {
        if (role == null) {
            return null;
        }
        var dto = new UserRoleDTO();
        dto.setId(role.getId());
        dto.setLevel(role.getLevel().name());
        dto.setTag(role.getTag());
        dto.setName(role.getName());
        return dto;
    }

    public ToolUserRole toEntity() {
        var entity = new ToolUserRole();
        entity.setId(id);
        entity.setLevel(level != null ? RoleLevel.valueOf(level) : null);
        entity.setTag(tag);
        entity.setName(name);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
