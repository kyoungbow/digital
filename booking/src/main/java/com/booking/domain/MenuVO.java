package com.booking.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("menu")
public class MenuVO {
	private Long m_code;
	private String st_code;
	private String m_name;
	private int m_price;
	private int m_count;
}
