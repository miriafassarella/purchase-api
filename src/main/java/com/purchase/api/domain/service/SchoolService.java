package com.purchase.api.domain.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.purchase.api.domain.model.School;
import com.purchase.api.domain.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	public List<School> listSchools(){
		return schoolRepository.findAll();
	}
	
	public School searchSchool(Long schoolId) {
		
		Optional<School> schoolCurrent = schoolRepository.findById(schoolId);
		return schoolCurrent.get();
		
	}
	public School addSchool(School school) {
		return schoolRepository.save(school);
	}
	
	public void removeSchool(Long schoolId) {
		Optional<School> schoolCurrent = schoolRepository.findById(schoolId);
		schoolRepository.delete(schoolCurrent.get());
			
		}
	public School updateSchool(School school, Long schoolId) {
		Optional<School> schoolCurrent = schoolRepository.findById(schoolId);
		BeanUtils.copyProperties(school, schoolCurrent.get(), "id"); 
			  
		return schoolRepository.save(schoolCurrent.get());
			
	}
	
}
