package org.freud.message.controller;

import org.freud.message.dto.Greetings;
import org.freud.message.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired
    private GreetingsService greetingsService;

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message") String message) {

        for (int i = 0; i < 10; i++) {
            Greetings greetings = Greetings.builder()
                    .message(message + " i")
                    .timestamp(System.currentTimeMillis())
                    .build();

            greetingsService.sendGreeting(greetings);
        }
    }
}
