package org.sterzhen.ypmtool.data.entities;

import javax.persistence.*;

@Entity
public class ToolUserRole {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleLevel level;
    @Column(nullable = false, unique = true)
    private String tag;
    @Column(nullable = false, unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleLevel getLevel() {
        return level;
    }

    public void setLevel(RoleLevel level) {
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
