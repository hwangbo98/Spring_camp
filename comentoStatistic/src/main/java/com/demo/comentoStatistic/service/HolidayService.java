package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.HolidayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    @Autowired
    private HolidayMapper holidayMapper;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<LocalDate> getHolidays(int year) {
        List<String> holidaysStr = holidayMapper.findHolidaysByYear(year);
        System.out.println("Holidays: " + holidaysStr); // 디버깅용 로그 추가
        return holidaysStr.stream()
                .map(date -> LocalDate.parse(date, DATE_FORMATTER))
                .collect(Collectors.toList());
    }
}