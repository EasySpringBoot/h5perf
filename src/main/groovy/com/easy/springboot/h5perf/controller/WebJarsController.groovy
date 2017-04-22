package com.easy.springboot.h5perf.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.HandlerMapping
import org.webjars.WebJarAssetLocator

import javax.servlet.http.HttpServletRequest

/**
 * Created by jack on 2017/4/22.
 */
@Controller
class WebJarsController {
    WebJarAssetLocator assetLocator = new WebJarAssetLocator();

    @ResponseBody
    @RequestMapping("/webjarslocator/{webjar}/**")
    def ResponseEntity<?> locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
        try {
            String mvcPrefix = "/webjarslocator/" + webjar + "/"; // This prefix must match the mapping path!
            String mvcPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
            String fullPath = assetLocator.getFullPath(webjar, mvcPath.substring(mvcPrefix.length()));
            return new ResponseEntity<>(new ClassPathResource(fullPath), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
