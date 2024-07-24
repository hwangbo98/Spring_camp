package com.demo.comentoStatistic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PingController {

    @RequestMapping(value = "/ping", produces = "application/json")
    @ResponseBody
    public Object healthCheck() {
        ZonedDateTime now = ZonedDateTime.now();
        Map<String, Object> map = new HashMap<>();
        map.put("today", now.format(DateTimeFormatter.ofPattern("MM:dd")));
        return map;
    }
}