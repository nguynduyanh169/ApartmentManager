package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manager.entity.User;

@Service
public interface UserService {

    public List<User> getAllUser();

    public List<User> getUserByHouseId(long houseId);

    public Optional<User> findUserById(long id);

    public boolean saveUser(User user);

    public long countUser();

    public void removeUser(long id);

    public User checkLogin(String email, String password);

    public User checkUserEmail(String email);

    public int setIdImageByEmail(String idImage, String email);

    public int setProfileImageByEmail(String profileImage, String email);
}
