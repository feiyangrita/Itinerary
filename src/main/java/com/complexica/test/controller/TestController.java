package com.complexica.test.controller;

import com.complexica.test.model.NameEntity;
import com.complexica.test.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TestController {

    @Autowired
    private NameService nameService;

    @RequestMapping("/")
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homepage.html");
        return mav;
    }

    @RequestMapping("/welcome-msg")
    @ResponseBody
    public ResponseEntity<?> getWelcomeMsg(){
        final List<NameEntity> names = nameService.findAllNames();
        if (CollectionUtils.isEmpty(names)) {
            return ResponseEntity.ok("No names found");
        }
        return ResponseEntity.ok(names.parallelStream().map(n -> n.getName()).collect(Collectors.joining(" and ")));
    }


}
