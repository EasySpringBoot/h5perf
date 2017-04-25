package com.easy.springboot.h5perf.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by jack on 2017/4/22.
 */
@Controller
class LoginController {

    @RequestMapping("/login")
    String login() {
        "loginPage"
    }

    @RequestMapping("/403")
    String page403() {
        "403Page"
    }
}
