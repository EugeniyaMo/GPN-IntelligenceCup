package ru.task.gpnintelligencecup.controller;


import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.task.gpnintelligencecup.models.User;
import ru.task.gpnintelligencecup.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getInfo")
    public ResponseEntity<?> getUserInfo(@RequestParam String userId, @RequestParam String groupId,
                                         @RequestParam String userAccessToken) throws ClientException, ApiException {
        User user = userService.getUserInfo(userId, groupId, userAccessToken);
        return ResponseEntity.ok().body("ok");
    }
}
