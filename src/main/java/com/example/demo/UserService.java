package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public AppUser fetchUser(String userName) {
        return userRepo.findByUserName(userName);
    }

    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    public AppRole saveRole(AppRole appRole) {
        return roleRepo.save(appRole);
    }

    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepo.findByUserName(username);
        AppRole appRole = roleRepo.findByName(roleName);
        user.getAppRoles().add(appRole);
    }
}
