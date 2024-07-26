package org.example.testsecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.testsecurity.dto.JoinDTO;
import org.example.testsecurity.entity.UserEntity;
import org.example.testsecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        boolean isUser = userRepository.existByUsername(joinDTO.getUsername());
        if (isUser) {
            return;
        }

        UserEntity entity = new UserEntity();

        entity.setUsername(joinDTO.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        entity.setRole("ROLE_USER");

        userRepository.save(entity);
    }
}
