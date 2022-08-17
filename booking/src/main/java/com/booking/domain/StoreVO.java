package com.booking.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("store")
public class StoreVO {
	private String st_code;
	private String st_id;
	private String st_name;
	private String st_content;
	private String st_tel;
	private String st_addr;
	private String st_detailaddr;
	private String st_cat;
	private int st_score;
	private String st_open;
	private String st_close;
	private Date st_regdate;
}
