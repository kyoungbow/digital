package com.booking.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data @Alias("auth")

public class AuthVO {
	private String id;
	private String auth;
	
}
