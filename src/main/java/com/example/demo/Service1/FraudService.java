package com.example.demo.Service1;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FraudService {
    private List<String> blacklistedCards = new ArrayList<>();

    public FraudService() {
        // Inicializar la lista negra con algunos números de tarjeta (ejemplo)
        blacklistedCards.add("1234567812345678");
        blacklistedCards.add("8765432187654321");
        blacklistedCards.add("1111222233334444");
        blacklistedCards.add("5555666677778888");
    }

    public boolean isCardBlacklisted(String cardNumber) {
        return blacklistedCards.contains(cardNumber);
    }
}
