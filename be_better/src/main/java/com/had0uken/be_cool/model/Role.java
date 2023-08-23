package com.had0uken.be_cool.model;


import java.io.Serial;
import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 8727591400744974157L;
    @Id
    @Column(name = "role_id", unique = true, nullable = false)
    private int roleId;


    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "authorities", joinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "email", nullable = false, updatable = false)})
    private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName, Set<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}