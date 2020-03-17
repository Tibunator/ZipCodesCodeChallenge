package com.codingchallenge.springboot.app.zipcode.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.codingchallenge.springboot.app.zipcode.models.entity.ZipCodes;

public interface ZipCodesRepo extends CrudRepository<ZipCodes, Integer> {

}
