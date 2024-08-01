package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.*;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    @RequestMapping(value = "/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year) {
        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value = "/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearMonthCountDto> getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month) {
        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    @GetMapping(value = "/api/v1/departments/userCounts", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DepartmentUserCountDto>> getDepartmentUserCounts() {
        return ResponseEntity.ok(statisticService.getDepartmentUserCounts());
    }

    @GetMapping(value = "/api/v1/departments/loginCounts", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DepartmentLoginCountDto>> getDepartmentLoginCounts() {
        return ResponseEntity.ok(statisticService.getDepartmentLoginCounts());
    }

    @GetMapping(value = "/api/v1/posts/yearMonthCounts", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<YearMonthPostCountDto>> getYearMonthPostCounts() {
        return ResponseEntity.ok(statisticService.getYearMonthPostCounts());
    }

    @GetMapping(value = "/api/v1/departments/postCounts", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DepartmentPostCountDto>> getDepartmentPostCounts() {
        return ResponseEntity.ok(statisticService.getDepartmentPostCounts());
    }

    @GetMapping(value = "/api/v1/logins/averageDaily", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Double> getAvgDailyLogins() {
        return ResponseEntity.ok(statisticService.getAvgDailyLogins());
    }

//    @GetMapping(value = "/api/v1/logins/nonHoliday", produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<List<YearCountDto>> getNonHolidayLogins() {
//        return ResponseEntity.ok(statisticService.getNonHolidayLogins());
//    }
     @GetMapping(value = "/api/v1/logins/holiday/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<YearCountDto>> getHolidayLogins(@PathVariable("year") int year) {
        return ResponseEntity.ok(statisticService.getHolidayLogins(year));
    }

    @GetMapping(value = "/api/v1/logins/nonHoliday/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<YearCountDto>> getNonHolidayLogins(@PathVariable("year") int year) {
        return ResponseEntity.ok(statisticService.getNonHolidayLogins(year));
    }
}
