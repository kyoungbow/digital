package com.booking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.booking.domain.CustomUser;
import com.booking.domain.MemberVO;
import com.booking.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
public class CustomUserDetail implements UserDetailsService {
	
	@Autowired @Setter
	private MemberMapper member;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn(username);
		MemberVO vo = member.read(username); 
		return vo == null ? null : new CustomUser(vo);
	}
	
}
