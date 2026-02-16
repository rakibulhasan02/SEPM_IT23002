package com.example.TestSpringJPA;
//package com.example.springdbweb;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
    }

    public void saveUser(User user) {
        repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
