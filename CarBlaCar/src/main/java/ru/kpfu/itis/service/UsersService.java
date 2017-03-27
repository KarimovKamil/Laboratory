package ru.kpfu.itis.service;

import ru.kpfu.itis.forms.UserForm;
import ru.kpfu.itis.model.User;

import java.util.List;

public interface UsersService {
    User addUser(UserForm user);

    User findById(Long id);

    void update(User user);

    List<User> findAll();

    User findByNickname(String name);

    User findByEmail(String email);
}
