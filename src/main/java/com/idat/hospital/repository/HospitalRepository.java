package com.idat.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.hospital.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
