package com.booking.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.domain.AuthVO;
import com.booking.domain.MemberVO;
import com.booking.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service @AllArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService{
	private MemberMapper membermapper;
	private PasswordEncoder password;
	
	
	@Override
	public MemberVO read(String id) {
		// TODO Auto-generated method stub
		return membermapper.read(id) ;
	}
	
	@Override
	public void join(MemberVO member) {
		member.setPw(password.encode(member.getPw()));
		membermapper.insertMember(member);
		AuthVO auth = new AuthVO();
		auth.setAuth("ROLE_MEMBER");
		auth.setId(member.getId());
		membermapper.insertAuth(auth);
	}


	@Override
	public MemberVO get(String id) {
		// TODO Auto-generated method stub
		return membermapper.read(id);
	}
	
	@Override
	public int chkid(String id) {
		int cnt = membermapper.chkid(id);
		return cnt;
	}
	
	@Override
	public boolean modifyMember(MemberVO member) {
		
		if(member.getPw() != null && !member.getPw().equals("")){
			member.setPw(password.encode(member.getPw()));
			
		} 
		return membermapper.updateMember(member) > 0;
	}
	
	@Override
	public boolean removeMember(MemberVO member) {
		membermapper.deleteAuth(member.getId());
		return membermapper.deleteMember(member.getId()) > 0;
	}

	@Override
	public boolean deleteAuth(AuthVO auth) {
		return membermapper.deleteAuth(auth.getId()) > 0;
	}

	@Override
	public AuthVO getAuth(String id) {
		// TODO Auto-generated method stub
		return membermapper.readAuth(id);
	}

	

	

}
