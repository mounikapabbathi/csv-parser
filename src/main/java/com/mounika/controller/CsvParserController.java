package com.mounika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mounika.model.ParseRequest;
import com.mounika.model.ParseResponse;
import com.mounika.service.ParsingService;

@RestController
public class CsvParserController {
	
	@Autowired
	ParsingService parsingService;
	
	@GetMapping(value="/csvParser/parseString/{inputString}")
	public ResponseEntity<ParseResponse> doPost (
			@PathVariable("inputString") String request) {
			return processString(request);
	}
	
	private ResponseEntity<ParseResponse> processString(String request) {
		ParseResponse response;
		try {
			response = parsingService.parseCsvString(request);
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	private boolean validRequest(ParseRequest request) {
		if(request != null) {
			return (request.getInputString() != null && !request.getInputString().isEmpty()) ? true : false;
		}
		return false;
	}

}
