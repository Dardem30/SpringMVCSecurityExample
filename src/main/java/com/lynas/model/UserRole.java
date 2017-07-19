package com.lynas.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LynAs on 19-Feb-16
 */
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String roleName;
//@ManyToMany
////@JoinTable(name = "AppUser", joinColumns = @JoinColumn(name = "AppUser_id"),
////inverseJoinColumns = @JoinColumn(name = "role_id"))
//private List<AppUser> appUserList;
//
//    public List<AppUser> getAppUserList() {
//        return appUserList;
//    }
//
//    public void setAppUserList(List<AppUser> appUserList) {
//        this.appUserList = appUserList;
//    }

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
