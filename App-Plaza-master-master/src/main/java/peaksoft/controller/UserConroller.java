package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.impl.UserService;

@Controller
@RequestMapping("/users")
public class UserConroller {
    private final UserService userService;

    public UserConroller(UserService userService) {
        this.userService = userService;
    }

}
