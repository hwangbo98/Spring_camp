package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YearMonthPostCountDto {
    private String yearMonth;
    private int postCount;
}