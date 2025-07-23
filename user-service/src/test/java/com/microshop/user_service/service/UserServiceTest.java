package com.microshop.user_service.service;

import com.microshop.user_service.model.User;
import com.microshop.user_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(1L, "hansini", "rawpassword", "hansini@mail.com", "USER");
    }

    @Test
    void testRegister_EncodesPasswordAndSavesUser() {
        when(passwordEncoder.encode("rawpassword")).thenReturn("encodedpassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User result = userService.register(testUser);

        assertEquals("encodedpassword", result.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testFindByUsername_ReturnsUser() {
        when(userRepository.findByUsername("hansini")).thenReturn(Optional.of(testUser));

        Optional<User> found = userService.findByUsername("hansini");

        assertTrue(found.isPresent());
        assertEquals("hansini", found.get().getUsername());
    }
}
