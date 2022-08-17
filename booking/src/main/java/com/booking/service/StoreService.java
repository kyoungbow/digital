package com.booking.service;

import com.booking.domain.StoreVO;

public interface StoreService {
	
	StoreVO read (String id);
	
	void register (StoreVO store);
	
	boolean modifyStore(StoreVO store);
	
	boolean deleteStore(StoreVO store);
	
}
