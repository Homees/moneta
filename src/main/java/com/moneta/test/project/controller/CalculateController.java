package com.moneta.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneta.test.project.service.CalculateService;

@RestController
public class CalculateController {
	
	@Autowired
	private CalculateService service;

	@RequestMapping(value = "/calculate")
	public ResponseEntity<String> processNumber(@RequestParam(value = "number", required = true) String number) {
		String response = service.calculateInput(number);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
