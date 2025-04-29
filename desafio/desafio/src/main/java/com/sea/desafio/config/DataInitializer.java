package com.sea.desafio.config;


import com.sea.desafio.model.RoleUser;
import com.sea.desafio.repository.UserRepository;
import com.sea.desafio.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final UserRepository userRepository;

    public DataInitializer(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Cria usuário admin
        if (!userRepository.existsByUsername("admin")) {
            userService.createUser("admin", "123qwe!@#", RoleUser.ROLE_ADMIN);
            System.out.println("Usuário admin criado com senha");
        }

        // Cria usuário padrão
        if (!userRepository.existsByUsername("user")) {
            userService.createUser("user", "123qwe123", RoleUser.ROLE_USER);
            System.out.println("Usuário padrão criado com senha");
        }
    }
}
