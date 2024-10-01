package com.example.demo.Service1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FraudControllerTest {

    @InjectMocks
    private FraudController fraudController;

    @Mock
    private FraudService fraudService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckCard_BlacklistedCard_ReturnsTrue() {
        // Dado
        String blacklistedCard = "1234567812345678";
        when(fraudService.isCardBlacklisted(blacklistedCard)).thenReturn(true);

        // Cuando
        ResponseEntity<Boolean> response = fraudController.checkCard(blacklistedCard);

        // Entonces
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(true, response.getBody());
    }

    @Test
    void testCheckCard_NonBlacklistedCard_ReturnsFalse() {
        // Dado
        String nonBlacklistedCard = "0000000000000000";
        when(fraudService.isCardBlacklisted(nonBlacklistedCard)).thenReturn(false);

        // Cuando
        ResponseEntity<Boolean> response = fraudController.checkCard(nonBlacklistedCard);

        // Entonces
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(false, response.getBody());
    }
}
