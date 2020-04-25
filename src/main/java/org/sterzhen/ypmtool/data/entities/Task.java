package org.sterzhen.ypmtool.data.entities;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(nullable = false)
    private Integer priority;
    @ManyToOne(optional = false)
    private TaskType type;
    @ManyToOne(optional = false)
    private ToolUser responsibleUser;
    @Column
    private ZonedDateTime finishTime;
    @ManyToOne(optional = false)
    private ToolUser createUser;
    @Column(nullable = false)
    private ZonedDateTime createTime;

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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType tag) {
        this.type = tag;
    }

    public ToolUser getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(ToolUser responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public ZonedDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(ZonedDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public ToolUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(ToolUser createUser) {
        this.createUser = createUser;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }
}
