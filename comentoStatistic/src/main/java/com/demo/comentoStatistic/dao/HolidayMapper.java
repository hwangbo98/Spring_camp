package com.demo.comentoStatistic.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HolidayMapper {

    @Select("SELECT holiday_date FROM statistic3.holidays WHERE YEAR(holiday_date) = #{year}")
    List<String> findHolidaysByYear(int year);
}