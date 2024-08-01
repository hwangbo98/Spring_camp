package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);

    YearMonthCountDto selectYearMonthLogin(String yearMonth);

    List<DepartmentUserCountDto> selectDepartmentUserCounts();

    List<DepartmentLoginCountDto> selectDepartmentLoginCounts();

    List<YearMonthPostCountDto> selectYearMonthPostCounts();

    List<DepartmentPostCountDto> selectDepartmentPostCounts();

    Double selectAvgDailyLogins();

    @Select("SELECT DATE_FORMAT(STR_TO_DATE(createDate, '%Y%m%d%H%i'), '%Y-%m-%d') AS year, COUNT(*) AS totCnt " +
            "FROM statistic3.requestInfo " +
            "WHERE requestCode = 'LIN' " +
            "GROUP BY DATE_FORMAT(STR_TO_DATE(createDate, '%Y%m%d%H%i'), '%Y-%m-%d')")
    List<YearCountDto> selectLogins();
}