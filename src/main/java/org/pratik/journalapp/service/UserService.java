package org.pratik.journalapp.service;

import java.util.Arrays;
import java.util.List;

import org.pratik.journalapp.entity.User;
import org.pratik.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUserName(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            return null;
        }
    }

    public User saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));

            userRepository.save(user);
            return user;

        } catch (Exception e) {
            log.error("Error occured for {}", user.getUsername(), e);
            log.debug("hello world");
            return null;
        }
    }

    public User saveNewAdmin(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER", "ADMIN"));

            userRepository.save(user);
            return user;

        } catch (Exception e) {
            return null;
        }

    }

    public User updateUser(User newUser, String username) {
        try {
            User oldUser = userRepository.findByUsername(username);
            oldUser.setUsername(
                    !newUser.getUsername().equals("")
                            ? newUser.getUsername()
                            : oldUser.getUsername());
            oldUser.setPassword(!newUser.getPassword().equals("")
                    ? passwordEncoder.encode(newUser.getPassword())
                    : oldUser.getPassword());
            userRepository.save(oldUser);
            return oldUser;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteUser(String username) {
        try {
            userRepository.deleteByUsername(username);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
