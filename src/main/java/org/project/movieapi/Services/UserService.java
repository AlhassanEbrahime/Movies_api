package org.project.movieapi.Services;

import org.project.movieapi.Entites.User;

public interface UserService {
    User findByEmail(String email);
    boolean isEmailExists(String email);
    void saveUser(User user);
}
