package com.booking.mapper;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.booking.domain.AuthVO;
import com.booking.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberMapperTests {
	
	@Setter @Autowired
	private PasswordEncoder password;
	
	@Setter @Autowired
	private MemberMapper membermapper;
	
	@Setter @Autowired
	private DataSource ds;
	
	@Test
	public void testExist(){
		assertNotNull(membermapper);
	}
	
	
	@Test
	public void testInsertMember(){
		MemberVO member = new MemberVO();
		
		member.setId("kyoungbow2");
		member.setPw(password.encode("123123!!"));
		member.setName("testname");
		member.setPhone("01011111111");
		member.setEmail("test@email.com");
		member.setAddress("테스트지역");
		
		membermapper.insertMember(member);
		log.info(member);
		
		AuthVO auth = new AuthVO();
		auth.setId(member.getId());
		auth.setAuth("ROLE_MANAGER");
		
		membermapper.insertAuth(auth);
		log.info(member);
	}
	
	
	@Test
	public void testInsertAuth() {
		AuthVO vo = new AuthVO();
		vo.setId("kyoungbo");
		vo.setAuth("ROLE_MANAGER");
		
		log.info(vo);
		membermapper.insertAuth(vo);
	}
	@Test
	public void testRead(){
		MemberVO vo = membermapper.read("test3");
		log.warn(vo);
		
	}
	
	@Test
	public void testUpdate(){
		MemberVO member = membermapper.read("kyoungbow");
		member.setPw(password.encode("rlarudqh!!"));
		member.setPhone("22");
		member.setEmail("test@email.com");
		member.setAddress("테스트지역");
		member.setDetailaddr("ㅇㅇ");
		member.setPostcode("21313");
		
		membermapper.updateMember(member);
	}
	
	@Test
	public void testDelete(){
		
	membermapper.deleteMember("TESTID");
	}
	
	@Test
	public void testUpdateType(){
		MemberVO member = membermapper.read("kyoungbow");
		member.setType("1");
		
		membermapper.updateType(member.getId());
		log.warn(member);
	}
	
	@Test
	public void testAuth(){
		AuthVO auth = membermapper.readAuth("kyoungbow");
		auth.setAuth("ROLE_HANANIM");
		membermapper.updateAuth(auth);
	}
}
