package com.jiraynor.springsecurity.controller;

import com.jiraynor.springsecurity.dto.JoinDTO;
import com.jiraynor.springsecurity.service.JoinService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String post(JoinDTO joinDTO) {
        System.out.println("joinDTO = " + joinDTO);
        joinService.joinProcess(joinDTO);
        return "redirect:/login";
    }
}
