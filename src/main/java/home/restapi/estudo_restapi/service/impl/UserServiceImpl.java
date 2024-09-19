package home.restapi.estudo_restapi.service.impl;

import org.springframework.stereotype.Service;

import home.restapi.estudo_restapi.domain.model.User;
import home.restapi.estudo_restapi.domain.repository.UserRepository;
import home.restapi.estudo_restapi.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User newUser) {
        if (userRepository.existsByAccountNumber(newUser.getAccount().getNumber())) {
            throw new IllegalArgumentException("Usuário com essa conta já existe!");
        }

        return userRepository.save(newUser);
    }

}
