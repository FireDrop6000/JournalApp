package org.pratik.journalapp;

import org.junit.jupiter.api.Test;
import org.pratik.journalapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    EmailService emailService;

    @Test
    void testSendMail() {
        emailService.sendEmail("oraonpakhi@gmail.com", "Testing java mail sender",
                "Hi aap kaise hain? This message was sent from an application SMTP server.");
    }
}
