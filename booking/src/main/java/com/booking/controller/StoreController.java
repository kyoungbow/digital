package com.booking.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booking.domain.MemberVO;
import com.booking.domain.StoreVO;
import com.booking.service.MemberService;
import com.booking.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("store")
@AllArgsConstructor
public class StoreController {
	private StoreService storeservice;
	private MemberService memberservice;
	
	@GetMapping("getStore")
	public void get(Principal principal, Model model){
		StoreVO store = storeservice.read(principal.getName());
		model.addAttribute("store", store);
	}
	
	@GetMapping("storeRegister")
	public void register(Principal principal, Model model){
		MemberVO mem = memberservice.get(principal.getName());
		model.addAttribute("member", mem);
	}
	
	@PostMapping("storeRegister")
	public String storeRegister(StoreVO store){
		storeservice.register(store);
		
		return "redirect:/member/mypage";
	}
	
	@PostMapping("chkCode")
	@ResponseBody
	public int chkCode(@RequestParam("st_code") String st_code){
		int cnt = storeservice.chkCode(st_code);
		return cnt;
	}
	
	
}
