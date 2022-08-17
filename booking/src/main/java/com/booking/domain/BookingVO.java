package com.booking.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BookingVO {
	private Long bk_num;
	private String bk_id;
	private String bk_store;
	private String bk_menu;
	private String bk_name;
	private int bk_price;
	private int count;
	private Date bk_regdate;
}
