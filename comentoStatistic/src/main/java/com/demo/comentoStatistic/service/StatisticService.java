package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    @Autowired
    StatisticMapper statisticMapper;

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

    public List<YearCountDto> getNonHolidayLogins() {
        return statisticMapper.selectNonHolidayLogins();
    }
}