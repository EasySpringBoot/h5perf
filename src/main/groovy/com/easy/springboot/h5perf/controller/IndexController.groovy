package com.easy.springboot.h5perf.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by jack on 2017/4/22.
 */
@Controller
class IndexController {

    /**
     * 方法上面使用了@PreAuthorize(“hasRole(‘user’)”)，表示访问这个方法需要拥有user角色。
     * 如果希望控制到权限层面，可以使用@PreAuthorize(“hasPermission()”)。
     *
     * 这里只是用了其中的一个用法，更多的使用方法可以去看官方文档。
     *
     * 需要注意的是，Spring Security默认的角色前缀是”ROLE_”,使用hasRole方法时已经默认加上了，
     * 因此我们在数据库里面的用户角色应该是“ROLE_user”，在user前面加上”ROLE_”前缀。
     *
     * @return
     */
    @RequestMapping(value = ["", "/", "/index"])
//    @PreAuthorize("hasAnyRole('USER')")
    def index() {
        new ModelAndView("/indexPage")
    }

}
