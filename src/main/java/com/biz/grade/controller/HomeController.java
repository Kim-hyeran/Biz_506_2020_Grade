package com.biz.grade.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.grade.model.GradeVO;
import com.biz.grade.service.GradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	@Qualifier("gradeServiceV1")
	private GradeService gradeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<GradeVO> gradeList = gradeService.selectAll();
		
		gradeList=sumAvg(gradeList); 

		model.addAttribute("GRADE_LIST", gradeList);
		model.addAttribute("BODY", "GRADE_LIST");

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(@ModelAttribute("G_VO") GradeVO gradeVO, Model model) {

		model.addAttribute("G_VO", gradeVO);
		model.addAttribute("BODY", "GRADE_INPUT");

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute GradeVO gradeVO) {
		int ret = gradeService.insert(gradeVO);

		if (ret > 0) {
			log.debug("{}개의 INSERT 명령을 수행하였습니다.", ret);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("id") String g_number, Model model) {
		GradeVO gradeVO = gradeService.findById(g_number);

		model.addAttribute("G_VO", gradeVO);
		model.addAttribute("BODY", "GRADE_INPUT");

		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute GradeVO gradeVO) {
		int ret = gradeService.update(gradeVO);

		if (ret > 0) {
			log.debug("{}개의 UPDATE 명령을 수행하였습니다.", ret);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") String g_number) {
		gradeService.delete(g_number);
		
		return "redirect:/";
	}
	
	public List<GradeVO> sumAvg (List<GradeVO> gradeList) {
		for(GradeVO gradeVO : gradeList) {
			int sum=gradeVO.getG_kor()+gradeVO.getG_eng()+gradeVO.getG_math();
			gradeVO.setG_sum(sum);
			
			int avg=gradeVO.getG_sum()/3;
			gradeVO.setG_avg(avg);			
		}
		
		return gradeList;
	}

}
