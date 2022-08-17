package com.booking.mapper;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.booking.domain.StoreVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class StoreMapperTests {
	
	@Setter @Autowired
	private StoreMapper storemapper;
	
	@Setter @Autowired
	private DataSource ds;
	
	@Test
	public void testExist(){
		assertNotNull(storemapper);
	}
	
	@Test
	public void insertStore(){
		StoreVO store = new StoreVO();
		
		store.setSt_code("1111-11-1111");
		store.setSt_id("kyoungbow");
		store.setSt_name("당당치킨");
		store.setSt_content("안녕하세요 당당치킨입니다. 저희는 국내 다른 브랜드와 차별화 되기위해 노력합니다.");
		store.setSt_tel("070-111-1111");
		store.setSt_addr("서울 특별시 영등포구 신길 3동 12-1");
		store.setSt_detailaddr("3층");
		store.setSt_cat("치킨");
		store.setSt_open("13시");
		store.setSt_close("21시");
		
		storemapper.insertStore(store);
	}
	
	@Test
	public void read(){
		StoreVO store = storemapper.read("kyoungbow");
		log.warn(store);
	}
	
//	@Test
//	public void testInsertMember(){
//		MemberVO member = new MemberVO();
//		
//		member.setId("kyoungbow");
//		member.setPw(password.encode("1234"));
//		member.setName("testname");
//		member.setPhone("01011111111");
//		member.setEmail("test@email.com");
//		member.setAddress("테스트지역");
//		
//		membermapper.insertMember(member);
//		log.info(member);
//		
//		AuthVO auth = new AuthVO();
//		auth.setId(member.getId());
//		auth.setAuth("ROLE_MANAGER");
//		
//		membermapper.insertAuth(auth);
//		log.info(member);
//	}
//	
//	
//	@Test
//	public void testInsertAuth() {
//		AuthVO vo = new AuthVO();
//		vo.setId("kyoungbo");
//		vo.setAuth("ROLE_MANAGER");
//		
//		log.info(vo);
//		membermapper.insertAuth(vo);
//	}
//	@Test
//	public void testRead(){
//		MemberVO vo = membermapper.read("test3");
//		log.warn(vo);
//		
//	}
//	
//	@Test
//	public void testUpdate(){
//		MemberVO member = membermapper.read("kyoungbow");
//		member.setPw(password.encode("rlarudqh!!"));
//		member.setPhone("22");
//		member.setEmail("test@email.com");
//		member.setAddress("테스트지역");
//		member.setDetailaddr("ㅇㅇ");
//		member.setPostcode("21313");
//		
//		membermapper.updateMember(member);
//	}
//	
//	@Test
//	public void testDelete(){
//		
//	membermapper.deleteMember("TESTID");
//	}
}
