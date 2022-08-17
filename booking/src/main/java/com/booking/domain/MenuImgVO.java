package com.booking.domain;

import lombok.Data;

@Data
public class MenuImgVO {
	private Long m_code;
	private String uuid;
	private String origin;
	private String path;
	private boolean image;
}
