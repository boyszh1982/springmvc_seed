package com.nameless.service.impl;

import org.springframework.stereotype.Service;

import com.nameless.model.HomeVo;
import com.nameless.service.IHome;

@Service
public class HomeImpl implements IHome {

	public Object toHome(HomeVo homeVo) {
		// TODO Auto-generated method stub
		return homeVo.getVersion();
	}

}
