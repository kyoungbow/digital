package com.booking.mapper;

import java.util.List;

import com.booking.domain.StoreVO;

public interface StoreMapper {
	StoreVO read(String id);
	
	int insertStore(StoreVO store);
	
	int updateStore(StoreVO store);
	
	int deleteStore(String st_code);
	
	List<StoreVO> getList(String id);
	
}
