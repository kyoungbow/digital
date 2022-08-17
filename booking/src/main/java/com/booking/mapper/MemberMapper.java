package com.booking.mapper;

import com.booking.domain.AuthVO;
import com.booking.domain.MemberVO;

public interface MemberMapper {
	
	MemberVO read(String id);
	
	int insertMember(MemberVO member);
	
	int updateMember(MemberVO member);
	
	int deleteMember(String id);
	
	int insertAuth(AuthVO auth);
	
	int updateAuth(AuthVO auth);
	
	int deleteAuth(String id);
	
	AuthVO readAuth(String id);
	
	public int chkid(String id);
	
	int updateType(String id);
}
