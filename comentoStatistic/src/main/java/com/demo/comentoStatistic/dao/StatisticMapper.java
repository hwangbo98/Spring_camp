package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

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
   List<YearCountDto> selectNonHolidayLogins();
}