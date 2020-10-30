package com.biz.grade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GradeVO {
	
	private String g_number;
	private String g_name;
	private int g_kor;
	private int g_eng;
	private int g_math;
	private int g_sum;
	private int g_avg;

}
