package com.codingchallenge.springboot.app.zipcode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codingchallenge.springboot.app.zipcode.models.entity.ZipCodes;
import com.codingchallenge.springboot.app.zipcode.models.service.IZipCodeService;

@RestController
public class ZipCodeController {
	
	@Autowired
	private IZipCodeService zipCodeService;
	
	@GetMapping("/listAll")
	public List<ZipCodes> listAll() {
		return zipCodeService.findAll();
	}
	
	@GetMapping("/zip-codes/{zip_code}")
	public ResponseEntity<ZipCodes> getZipCode(@PathVariable Integer zip_code) {
		ZipCodes zipCode = zipCodeService.findById(zip_code);
		if (zipCode == null) {
			return new ResponseEntity<ZipCodes>(zipCode, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ZipCodes>(zipCode, HttpStatus.OK);
	}
}
