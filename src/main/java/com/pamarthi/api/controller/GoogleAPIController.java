package com.pamarthi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pamarthi.api.exceptions.NotFoundException;
import com.pamarthi.api.services.GoogleApiService;

@RestController
@RequestMapping("/api/v1/google")
public class GoogleAPIController {

	@Autowired
	private GoogleApiService googleApiService;

	@GetMapping("/place/search")
	public ResponseEntity<String> searchPlace(@RequestParam String search) {
		try {
			String data = googleApiService.searchPlace(search);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/place")
	public ResponseEntity<String> searchPlaceById(@RequestParam String id) {
		try {
			String data = googleApiService.getPlaceById(id);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
