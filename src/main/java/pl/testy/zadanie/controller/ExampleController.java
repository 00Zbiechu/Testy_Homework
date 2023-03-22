package pl.testy.zadanie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ExampleController {

    @GetMapping
    public ResponseEntity<String> getName(){
        return ResponseEntity.ok("Mateusz");
    }
}
