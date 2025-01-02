package org.pratik.journalapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.pratik.journalapp.entity.User;
import org.pratik.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Disabled
    @Test
    public void testAdd() {
        assertEquals(4, 2 + 2);
    }

    @ParameterizedTest
    @Disabled
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testNewUser(User user) {
        assertNotNull(userService.saveNewUser(user));
    }

    @Disabled
    @Test
    public void getJournalEntries() {
        User user = userRepository.findByUsername("Pratik");
        assertTrue(user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @Disabled
    @CsvSource({
            "1, 1, 2",
            "2, 10, 12",
            "3, 3, 9"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
