package com.example.crowdfunding.services;

import com.example.crowdfunding.dto.CredentialDto;
import com.example.crowdfunding.dto.SignUpDto;
import com.example.crowdfunding.dto.UserDto;
import com.example.crowdfunding.exceptions.AppException;
import com.example.crowdfunding.mappers.UserMapper;
import com.example.crowdfunding.model.User;
import com.example.crowdfunding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDto login(CredentialDto credentialDto) {
        User user = userRepository.findByEmail(credentialDto.getEmail())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialDto.getPassword()), user.getPassword()))
            return userMapper.toUserDto(user);
        else
            throw new AppException("Wrong password", HttpStatus.UNAUTHORIZED);
    }

    public UserDto register(SignUpDto userDto)
    {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent())
            throw new AppException("User already exists", HttpStatus.CONFLICT);

        User user = userMapper.signUpToUser(userDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }
}
