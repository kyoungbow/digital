package com.booking.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("member")
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String detailaddr;
	private String postcode;
	private int noshow;
	private Date joindate;
	private Date udtdate;
	private boolean enabled;
	private String type;
	private List<AuthVO> authList;
	
	
}

