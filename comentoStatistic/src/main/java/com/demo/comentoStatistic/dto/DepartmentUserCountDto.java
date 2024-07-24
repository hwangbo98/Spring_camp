package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentUserCountDto {
    private String department;
    private int userCount;
}