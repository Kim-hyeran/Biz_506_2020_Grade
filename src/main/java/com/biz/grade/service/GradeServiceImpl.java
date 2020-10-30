package com.biz.grade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.grade.mapper.GradeDao;
import com.biz.grade.model.GradeVO;

@Service("gradeServiceV1")
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	private GradeDao gradeDao;

	@Override
	public List<GradeVO> selectAll() {
		// TODO Auto-generated method stub
		return gradeDao.selectAll();
	}

	@Override
	public GradeVO findById(String g_number) {
		// TODO Auto-generated method stub
		return gradeDao.findById(g_number);
	}

	@Override
	public int insert(GradeVO gradeVO) {
		// TODO Auto-generated method stub
		return gradeDao.insert(gradeVO);
	}

	@Override
	public int update(GradeVO gradeVO) {
		// TODO Auto-generated method stub
		return gradeDao.update(gradeVO);
	}

	@Override
	public int delete(String g_number) {
		// TODO Auto-generated method stub
		return gradeDao.delete(g_number);
	}

}
