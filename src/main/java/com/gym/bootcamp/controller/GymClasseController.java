package com.gym.bootcamp.controller;

import com.gym.bootcamp.service.GymClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping
@Validated

public class GymClasseController {
    private class GymClassController {
        private GymClassService authorService;

            @GetMapping("/authors")
            public ResponseEntity<AuthorResponse> getAuthorByFirstName(@RequestParam String firstName) {
                final var author = authorService.getByFirstName(firstName);
                final var response = AuthorResponse.builder()
                        .age(author.getAge())
                        .firstName(author.getFirstName())
                        .lastName(author.getLastName())
                        .build();

                return ResponseEntity.ok(response);
            }

            @PostMapping("/classes")
            public ResponseEntity<GymClassResponse> getAuthorByFirstName(@RequestBody @Valid GymClassCreationRequest request) {

                gymclassService.createGymClass(request.getFirstName(), request.getLastName(), request.getAge());
                return ResponseEntity.created(URI.create("/gymclass/")).build();
            }
        }
        }

}
