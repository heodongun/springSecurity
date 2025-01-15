package com.jiraynor.springsecurity.service;

import com.jiraynor.springsecurity.dto.JoinDTO;
import com.jiraynor.springsecurity.entity.UserEntity;
import com.jiraynor.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public void joinProcess(JoinDTO joinDTO) {

        //db에 이미 동일한 username을 가진 유저가 존재를 하는지?
        boolean isUser=userRepository.existsByUsername(joinDTO.getUsername());
        if(isUser){
            return;
        }

        UserEntity data=UserEntity.builder()
                .username(joinDTO.getUsername())
                .password(bCryptPasswordEncoder.encode(joinDTO.getPassword()))
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(data);
    }
}
