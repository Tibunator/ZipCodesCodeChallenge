package com.codingchallenge.springboot.app.zipcode.models.service;

import java.util.List;

import com.codingchallenge.springboot.app.zipcode.models.entity.ZipCodes;

public interface IZipCodeService {
	public List<ZipCodes> findAll();
	public ZipCodes findById(Integer zip_code);
}
