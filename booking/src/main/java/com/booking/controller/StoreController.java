package com.booking.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
//	@GetMapping("get")
//	public void get(Principal principal, Model model){
//		MemberVO mem = memberservice.get(principal.getName());
//		model.addAttribute("member", mem);
//	}
	
	@GetMapping("storeRegister")
	public void register(Principal principal, Model model){
		MemberVO mem = memberservice.get(principal.getName());
		model.addAttribute("member", mem);
	}
	
	@PostMapping("storeRegister")
	public String storeRegister(StoreVO store){
		storeservice.register(store);
		
		return "redirect:/";
	}
	
	
	
	
}
