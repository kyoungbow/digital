package com.booking.controller;

import java.security.Principal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.booking.domain.MemberVO;
import com.booking.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
@RequestMapping("member")
@AllArgsConstructor
public class MemberController {
	private MemberService memberservice;
	
	@GetMapping("customer")
	@PreAuthorize("isAuthenticated()")
	public void customer(Principal principal, Model model){
		MemberVO vo = memberservice.get(principal.getName());
		model.addAttribute("member", vo);
	}
	
	
	@GetMapping("manager")
	public void manager(){
		
	}
	
	@GetMapping("admin")
	public void admin(){
		
	}
	
	@GetMapping("join")
	public void join(){
		
	}
	
	@PostMapping("join")
	public String join(MemberVO member){
		log.warn(member.getAuthList());
		log.info(member);
		memberservice.join(member);

		return "redirect:/member/login";
		
	}
	
	@GetMapping("login")
	public void login(String error, String logout, Model model,String id){
		log.info("error: " + error);
		log.info("logout: " + logout);
		if(error != null){
			model.addAttribute("error", "아이디 혹은 비밀번호를 확인하세요");
			
		}
		
		if(logout != null){
			model.addAttribute("logout", "logout");
			
		}
		
	}
	
	@PostMapping("chkid")
	@ResponseBody
	public int chkid(@RequestParam("id") String id){
		int cnt = memberservice.chkid(id);
		return cnt;
	}
	
	@GetMapping("mypage")
	public void mypage(Principal principal, Model model){
		MemberVO mem = memberservice.get(principal.getName());
		model.addAttribute("member", mem);
	}
	
	@PreAuthorize("principal.username == #member.id")
	@PostMapping("mypage")
	public String modifyMember(RedirectAttributes rttr, MemberVO member){
		
		if(memberservice.modifyMember(member)) {			
			rttr.addFlashAttribute("result", "수정");
		}
		log.info(member.getPw());
		return "redirect:/";
	}
	
	
}
