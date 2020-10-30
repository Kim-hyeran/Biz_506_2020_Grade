package com.biz.grade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.grade.model.GradeVO;

public interface GradeDao {
	
	@Select("SELECT * FROM tbl_grade ORDER BY g_number")
	public List<GradeVO> selectAll();
	
	@Select("SELECT * FROM tbl_grade WHERE g_number = #{g_number}")
	public GradeVO findById(String g_number);
	
	public int insert(GradeVO gradeVO);
	
	public int update(GradeVO gradeVO);
	
	@Delete("DELETE FROM tbl_grade WHERE g_number = #{g_number}")
	public int delete(String g_number);

}
