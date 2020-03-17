package com.codingchallenge.springboot.app.zipcode.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingchallenge.springboot.app.zipcode.models.entity.ZipCodes;
import com.codingchallenge.springboot.app.zipcode.models.repository.ZipCodesRepo;

@Service
public class ZipCodeService implements IZipCodeService{

	@Autowired
	private ZipCodesRepo zipCodesRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<ZipCodes> findAll() {
		return (List<ZipCodes>) zipCodesRepo.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ZipCodes findById(Integer zip_code) {
		// TODO Auto-generated method stub
		return zipCodesRepo.findById(zip_code).orElse(null);
	}

}
