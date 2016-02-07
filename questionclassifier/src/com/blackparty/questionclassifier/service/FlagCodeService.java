package com.blackparty.questionclassifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackparty.questionclassifier.DAO.FlagCodeDAO;
import com.blackparty.questionclassifier.models.FlagCode;

@Service
public class FlagCodeService {
	@Autowired
	private FlagCodeDAO flagCodeDao;
	
	public FlagCode getFlag(String code){
		return flagCodeDao.getFlag(code);
	}
}
