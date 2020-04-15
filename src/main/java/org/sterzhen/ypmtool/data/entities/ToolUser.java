package org.sterzhen.ypmtool.data.entities;

import javax.persistence.*;

@Entity
public class ToolUser {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @ManyToOne(optional = false)
    private ToolUserRole userRole;
    @Column(nullable = false)
    private String forename;
    @Column(nullable = false)
    private String surname;
    @Column
    private String patronymic;
    @Column
    private String telephone;
    @Column
    private String email;

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

    public ToolUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(ToolUserRole userRole) {
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
