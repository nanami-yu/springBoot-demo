package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Resource
    private PersionService persionService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Map<String,Object> toshopping(HttpServletRequest request, @RequestBody String requestBody){
        Map<String,Object> map = new HashMap<>();
        List<Person> personList = persionService.listPerson();
        map.put("personList",personList);
        return map;
    }
}
