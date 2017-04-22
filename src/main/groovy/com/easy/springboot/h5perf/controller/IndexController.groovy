package com.easy.springboot.h5perf.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by jack on 2017/4/22.
 */
@Controller
class IndexController {
    @RequestMapping(value=["","/","/index"])
    def index() {
        new ModelAndView("/index")
    }
}
