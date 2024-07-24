package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YearMonthCountDto {
    private String yearMonth;
    private int totCnt;
}