package org.example.angularfejavabe.service;

import org.example.angularfejavabe.model.User;
import org.example.angularfejavabe.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    Long userId = 1L;
    String name = "John";
    String email = "John@domain.com";
    
    User user1 = new User(userId, name, email);

    @Test
    void findAll() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user1));
        List<User> users = userService.findAll();
        assertEquals(1, users.size());
        assertEquals(userId, users.get(0).getId());
        assertEquals(name, users.get(0).getName());
        assertEquals(email, users.get(0).getEmail());
    }

    @Test
    void save() {
        when(userRepository.save(user1)).thenReturn(user1);
        
        User savedUser = userService.save(user1);
        
        assertNotNull(savedUser);
        assertEquals(userId, savedUser.getId());
        assertEquals(name, savedUser.getName());
        assertEquals(email, savedUser.getEmail());
        
        verify(userRepository, times(1)).save(user1);
    }
}