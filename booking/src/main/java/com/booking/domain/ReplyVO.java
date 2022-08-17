package com.booking.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rp_num;
	private String rp_id;
	private String rp_store;
	private int rp_count;
	private Date rp_regdate;
	
}
