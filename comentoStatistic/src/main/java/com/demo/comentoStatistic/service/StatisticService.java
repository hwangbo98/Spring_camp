package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticService {

    @Autowired
    StatisticMapper statisticMapper;

    @Autowired
    HolidayService holidayService;

//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    public YearCountDto getYearLogins(String year) {
        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month) {
        return statisticMapper.selectYearMonthLogin(year + month);
    }

    public List<DepartmentUserCountDto> getDepartmentUserCounts() {
        return statisticMapper.selectDepartmentUserCounts();
    }

    public List<DepartmentLoginCountDto> getDepartmentLoginCounts() {
        return statisticMapper.selectDepartmentLoginCounts();
    }

    public List<YearMonthPostCountDto> getYearMonthPostCounts() {
        return statisticMapper.selectYearMonthPostCounts();
    }

    public List<DepartmentPostCountDto> getDepartmentPostCounts() {
        return statisticMapper.selectDepartmentPostCounts();
    }

    public Double getAvgDailyLogins() {
        return statisticMapper.selectAvgDailyLogins();
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<YearCountDto> getHolidayLogins(int year) {
        List<YearCountDto> allLogins = statisticMapper.selectLogins();
        List<LocalDate> holidays = holidayService.getHolidays(year);

        System.out.println("All Logins: " + allLogins); // 디버깅용 로그 추가
        System.out.println("Holidays: " + holidays); // 디버깅용 로그 추가

        return allLogins.stream()
                .filter(dto -> {
                    LocalDate date = LocalDate.parse(dto.getYear(), DATE_FORMATTER);
                    return holidays.contains(date);
                })
                .collect(Collectors.toList());
    }

    public List<YearCountDto> getNonHolidayLogins(int year) {
        List<YearCountDto> allLogins = statisticMapper.selectLogins();
        List<LocalDate> holidays = holidayService.getHolidays(year);

        return allLogins.stream()
                .filter(dto -> {
                    LocalDate date = LocalDate.parse(dto.getYear(), DATE_FORMATTER);
                    return !holidays.contains(date) && !isWeekend(date);
                })
                .collect(Collectors.toList());
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == java.time.DayOfWeek.SATURDAY || date.getDayOfWeek() == java.time.DayOfWeek.SUNDAY;
    }
}