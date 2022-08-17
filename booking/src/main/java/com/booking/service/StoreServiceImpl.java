package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.domain.AuthVO;
import com.booking.domain.MemberVO;
import com.booking.domain.StoreVO;
import com.booking.mapper.MemberMapper;
import com.booking.mapper.StoreMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service @AllArgsConstructor
public class StoreServiceImpl implements StoreService {
	
	@Setter @Autowired
	private StoreMapper storemapper;
	
	@Setter @Autowired
	private MemberMapper membermapper;
	
	@Override
	public StoreVO read(String id) {
		// TODO Auto-generated method stub
		return storemapper.read(id);
	}

	@Override
	public void register(StoreVO store) {
		storemapper.insertStore(store);
		MemberVO member = membermapper.read(store.getSt_id());
		AuthVO authVO = membermapper.readAuth(store.getSt_id());
		authVO.setAuth("ROLE_MANAGER");
		member.setType("1");
		membermapper.updateAuth(authVO);
		membermapper.updateType(member.getId());
	}

	@Override
	public boolean modifyStore(StoreVO store) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStore(StoreVO store) {
		// TODO Auto-generated method stub
		return false;
	}

}
