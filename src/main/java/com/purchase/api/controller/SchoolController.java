package com.purchase.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.api.domain.model.School;
import com.purchase.api.domain.service.SchoolService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
@RestController
@RequestMapping("/schools")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping
	public List<School> listDirection(){
		return schoolService.listSchools();
	}
	@GetMapping("/{schoolId}")
	public ResponseEntity<School> searchSchool(@PathVariable Long schoolId){
		
			School schoolCurrent = schoolService.searchSchool(schoolId);
			return ResponseEntity.status(HttpStatus.FOUND).body(schoolCurrent);
	}
	@PostMapping
	public ResponseEntity<School> addSchool(@RequestBody School school){
		School schooolSave = schoolService.addSchool(school);
		return ResponseEntity.status(HttpStatus.CREATED).body(schooolSave);
	}
	
	@DeleteMapping("/{schoolId}")
	public ResponseEntity<School> removeSchool(@PathVariable Long schoolId){
		schoolService.removeSchool(schoolId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	@PutMapping("/{schoolId}")
	public ResponseEntity<School> updateSchool(@RequestBody School school, @PathVariable Long schoolId){
		School schoolSave  = schoolService.updateSchool(school, schoolId);
		return ResponseEntity.status(HttpStatus.OK).body(schoolSave);
	}
}
