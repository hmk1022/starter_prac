package com.sbs.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article { // 여기서 Article이라는 객체를 만들어주고 형식을 정해준다?
	private long id;
	private String regDate;
	private String title;
	private String body;
}
