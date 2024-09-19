package home.restapi.estudo_restapi.service;

import home.restapi.estudo_restapi.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User newUser);
}

