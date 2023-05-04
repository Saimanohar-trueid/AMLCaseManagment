package com.trueid.AMLCaseManagment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trueid.AMLCaseManagment.entity.AMLWorldCheckCaseManagment;




public interface AMLCaseManagmentRepo extends JpaRepository<AMLWorldCheckCaseManagment, Long> {

	List<AMLWorldCheckCaseManagment> findByStatus(String status);

	

}
