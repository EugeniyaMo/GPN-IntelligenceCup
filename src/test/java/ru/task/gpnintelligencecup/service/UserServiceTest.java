package ru.task.gpnintelligencecup.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void getUserById() throws ClientException, ApiException {
        System.out.println(userService.getUserById("78385"));
    }

    @Test
    void isMember() throws ClientException, ApiException {
        String userAccessToken = "";
        System.out.println(userService.isMember("385316523", "159146575", userAccessToken));
    }
}
