package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentPostCountDto {
    private String department;
    private int postCount;
}