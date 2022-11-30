package com.idat.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.hospital.dto.HospitalDTO;
import com.idat.hospital.service.HospitalService;


@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@GetMapping("/listar")
	public @ResponseBody List<HospitalDTO> listar(){
		return service.listar();
	}
	
}
