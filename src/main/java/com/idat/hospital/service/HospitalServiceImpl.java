package com.idat.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.hospital.dto.HospitalDTO;
import com.idat.hospital.model.Hospital;
import com.idat.hospital.repository.HospitalRepository;


@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	@Override
	public List<HospitalDTO> listar() {
		
		List<HospitalDTO> listaDto = new ArrayList<>();
		HospitalDTO hospitalDto = null;
		
		for (Hospital hospital : repository.findAll()) {
			hospitalDto = new HospitalDTO();
			hospitalDto.setIdDto(hospital.getIdHospital());
			hospitalDto.setNombreDto(hospital.getNombre());
			hospitalDto.setDireccionDto(hospital.getDireccion());
			listaDto.add(hospitalDto);
		}
		return listaDto;
	}

	@Override
	public HospitalDTO obtener(Integer id) {
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTO hospitalDto = new HospitalDTO();
		hospitalDto.setIdDto(hospital.getIdHospital());
		hospitalDto.setNombreDto(hospital.getNombre());
		hospitalDto.setDireccionDto(hospital.getDireccion());
		
		return hospitalDto;
	}

	@Override
	public void registrar(HospitalDTO hospitalDTO) {
		Hospital hospital = new Hospital();
		hospital.setNombre(hospitalDTO.getNombreDto());
		hospital.setDireccion(hospitalDTO.getDireccionDto());
		repository.save(hospital);
	}

	@Override
	public void actualizar(HospitalDTO hospitalDTO) {
		Hospital hospital = new Hospital();
		hospital.setIdHospital(hospitalDTO.getIdDto());
		hospital.setNombre(hospitalDTO.getNombreDto());
		hospital.setDireccion(hospitalDTO.getDireccionDto());
		repository.saveAndFlush(hospital);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	
}
