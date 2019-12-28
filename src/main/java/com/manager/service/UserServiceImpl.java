package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entity.User;
import com.manager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepo.findAllActiveUser();
        return userList;
    }

    @Override
    public Optional<User> findUserById(long id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        return userRepo.save(user) == null ? false : true;
    }

    @Override
    public long countUser() {
        return userRepo.count();
    }

    @Override
    public void removeUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getUserByHouseId(long houseId) {
        return userRepo.getHouseByHouseId(houseId);
    }

    @Override
    public User checkLogin(String email, String password) {
        return userRepo.checkLogin(email, password);
    }

    @Override
    public User checkUserEmail(String email) {
        return userRepo.checkUserEmail(email);
    }

    @Override
    public int setIdImageByEmail(String idImage, String email) {
        return userRepo.setIdImageByEmail(idImage, email);
    }

    @Override
    public int setProfileImageByEmail(String profileImage, String email) {
        return userRepo.setProfileImageByEmail(profileImage, email);
    }
}
