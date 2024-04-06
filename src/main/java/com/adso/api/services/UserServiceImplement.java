package com.adso.api.services;

import com.adso.api.interfaces.UserRepository;
import com.adso.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @SuppressWarnings("null")
    public User save(User user) {
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public void delete(User user) {
        userRepository.delete(user);
    }
}
