package com.example.demo.Service1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud")
public class FraudController {

    @Autowired
    private FraudService fraudService;

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkCard(@RequestParam String cardNumber) {
        boolean isBlacklisted = fraudService.isCardBlacklisted(cardNumber);
        return ResponseEntity.ok(isBlacklisted);
    }
}
