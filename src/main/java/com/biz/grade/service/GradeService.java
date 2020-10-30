package com.biz.grade.service;

import java.util.List;

import com.biz.grade.model.GradeVO;

public interface GradeService {
	
	public List<GradeVO> selectAll();
	public GradeVO findById(String g_number);
	public int insert(GradeVO gradeVO);
	public int update(GradeVO gradeVO);
	public int delete(String g_number);

}
