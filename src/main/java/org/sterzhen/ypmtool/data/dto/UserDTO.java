package org.sterzhen.ypmtool.data.dto;

import org.sterzhen.ypmtool.data.entities.ToolUser;
import org.sterzhen.ypmtool.data.entities.ToolUserRole;

public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private Long roleId;
    private UserRoleDTO userRole;
    private String forename;
    private String surname;
    private String patronymic;
    private String telephone;
    private String email;

    public static UserDTO of(ToolUser user) {
        if (user == null) {
            return null;
        }
        var dto = new UserDTO();
        dto.setId(user.getId());
        dto.setLogin(user.getLogin());
        dto.setUserRole(UserRoleDTO.of(user.getUserRole()));
        dto.setForename(user.getForename());
        dto.setSurname(user.getSurname());
        dto.setPatronymic(user.getPatronymic());
        dto.setTelephone(user.getTelephone());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public ToolUser toEntity() {
        var entity = new ToolUser();
        entity.setId(id);
        entity.setLogin(login);
        entity.setPassword(password);
        if (roleId != null) {
            var role = new ToolUserRole();
            role.setId(roleId);
            entity.setUserRole(role);
        } else {
            entity.setUserRole(userRole != null ? userRole.toEntity() : null);
        }
        entity.setForename(forename);
        entity.setSurname(surname);
        entity.setPatronymic(patronymic);
        entity.setTelephone(telephone);
        entity.setEmail(email);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
