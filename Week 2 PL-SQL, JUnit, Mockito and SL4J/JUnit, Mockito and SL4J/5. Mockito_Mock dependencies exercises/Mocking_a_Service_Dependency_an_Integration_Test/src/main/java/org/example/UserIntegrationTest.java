package org.example;
package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;  // This will be injected into the controller

    @Test
    public void whenUserExists_thenReturns200AndUserJson() throws Exception {
        // Arrange: stub the service
        User alice = new User(1L, "Alice");
        when(userService.getUserById(1L)).thenReturn(alice);

        // Act & Assert: perform GET /users/1
        mockMvc.perform(get("/users/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    public void whenUserNotFound_thenReturns200AndNullBody() throws Exception {
        // Arrange: stub service to return null
        when(userService.getUserById(2L)).thenReturn(null);

        // Act & Assert: GET /users/2 returns 200 with empty body
        mockMvc.perform(get("/users/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}

