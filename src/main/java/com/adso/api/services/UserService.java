package com.adso.api.services;

import com.adso.api.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();

    public User save(User user);

    public User findById(Long id);

    public void delete(User user);
}
