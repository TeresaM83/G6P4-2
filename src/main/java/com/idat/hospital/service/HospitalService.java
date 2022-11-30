package com.idat.hospital.service;

import java.util.List;

import com.idat.hospital.dto.HospitalDTO;


public interface HospitalService {
	
	public List<HospitalDTO> listar();
	public HospitalDTO obtener(Integer id);
	public void registrar(HospitalDTO hospitalDto);
	public void actualizar(HospitalDTO hospitalDto);
	public void eliminar(Integer id);
	
}
