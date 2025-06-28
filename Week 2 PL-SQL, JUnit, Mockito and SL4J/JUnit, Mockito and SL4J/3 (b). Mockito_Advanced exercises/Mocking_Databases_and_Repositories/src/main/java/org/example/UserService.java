package org.example;

public class UserService {

    private UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserNameById(Long id) {
        User user = userRepository.findById(id);
        return user != null ? user.getName() : "Unknown";
    }
}
