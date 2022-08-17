package com.booking.service;

import com.booking.domain.AuthVO;
import com.booking.domain.MemberVO;

public interface MemberService {
	
	MemberVO read(String id);
	
	void join(MemberVO member);
	
	boolean modifyMember(MemberVO member);
	
	boolean removeMember(MemberVO member);

	public int chkid(String id);
	
	MemberVO get(String id);
	
//	AuthVO readAuth(String id);
//	
//	boolean modifyAuth(AuthVO auth);
//	
	boolean deleteAuth(AuthVO auth);
//	
	AuthVO getAuth(String id);
	
}
