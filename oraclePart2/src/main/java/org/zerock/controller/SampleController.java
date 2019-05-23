package org.zerock.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basic() {
		log.info("basic.....");
	}
	
	@GetMapping("/basicGet") //Get만 매핑
	public void basicGet2() {
		log.info("GET");
	}
	
	@GetMapping("/ex01")
	public String ex01 (SampleDTO dto) {
		log.info("" + dto);
		
		return "ex01";
	}
	
	@RequestMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";
	}
	
	@RequestMapping("/ex02List") //리스트
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		
		return "ex02List";
	}
	
	@RequestMapping("/ex02Array") //배열
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.deepToString(ids));
		
		return "ex02Array";
	}
	
	@GetMapping("ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos : " + list);
		
		return "ex02Bean";
	}
	
//	@InitBinder  //@DateTimeFormat을 이용하는 경우엔, @InitBinder는 불필요하다.
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}
	
}
