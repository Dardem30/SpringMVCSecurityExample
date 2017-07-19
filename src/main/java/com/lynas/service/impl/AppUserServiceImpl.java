package com.lynas.service.impl;

import com.lynas.model.AppUser;
import com.lynas.model.UserRole;
import com.lynas.service.AppUserService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sazzad on 2/11/16.
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void insertAppUser(AppUser appUser) {
        UserRole role =sessionFactory.getCurrentSession().get(UserRole.class,1);
        List<UserRole> userRoles=new ArrayList<>();
        userRoles.add(role);
        appUser.setRoles(userRoles);
        sessionFactory
                .getCurrentSession()
                .save(appUser);
    }

    @Transactional
    public AppUser getUserByUserName(String userName) {
        return (AppUser) sessionFactory.getCurrentSession()
                .createCriteria(AppUser.class)
                .add(Restrictions.eq("userName", userName))
                .uniqueResult();
    }
}
