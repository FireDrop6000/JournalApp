package org.pratik.journalapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pratik.journalapp.entity.User;
import org.pratik.journalapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsServiceTests {
    @InjectMocks
    private CustomUserDetailsService userDetailsService;

    @Mock
    private UserRepository userRepository;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findUserByUsername() {
        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("Siken").password("kajdfnfadmp").roles(new ArrayList<>()).build());
        UserDetails userDetails = userDetailsService.loadUserByUsername("Siken");
        assertNotNull(userDetails);
    }
}
