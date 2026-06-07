package com.keshav.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keshav.model.user;
import com.keshav.repositories.userRepository;
import com.keshav.services.userService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService  {

    private final userRepository userRepository;

    @Override
    public user createUser(user user) {
        return userRepository.save(user);
    }

    @Override
    public user getUserById(long id) {
        Optional<user> otp = userRepository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new RuntimeException("User not found");   
    }

    @Override
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        Optional<user> otp = userRepository.findById(id);

        if (otp.isEmpty()) {
            throw new RuntimeException("User not found with id " + id);
        }

        userRepository.deleteById(otp.get().getId());
    }

    @Override
    public user updateUser(Long id, user user) {
        Optional<user> otp = userRepository.findById(id);

        if (otp.isEmpty()) {
            throw new RuntimeException("User not found with id " + id);
        }

        user existUser = otp.get();

        // Update fields
        existUser.setFullName(user.getFullName());
        existUser.setEmail(user.getEmail());
        existUser.setRole(user.getRole());

        return userRepository.save(existUser);
    }
}
