package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/mm/dd") //@DateTimeFormat을 이용하는 경우엔, @InitBinder는 불필요하다.
	private Date dueDate;
}
