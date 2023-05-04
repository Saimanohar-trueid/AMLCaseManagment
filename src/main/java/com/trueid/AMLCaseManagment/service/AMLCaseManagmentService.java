package com.trueid.AMLCaseManagment.service;

import java.util.List;

import com.trueid.AMLCaseManagment.entity.AMLWorldCheckCaseData;
import com.trueid.AMLCaseManagment.entity.AMLWorldCheckCaseManagment;



public interface AMLCaseManagmentService {

	String amlCreateCase();
	
	List<AMLWorldCheckCaseData> amlUpdateCase(List<AMLWorldCheckCaseData> amlCaseDetails);
	
	AMLWorldCheckCaseManagment amlUpdateCaseMange(AMLWorldCheckCaseManagment amlMangCaseDetails);
	
	List<AMLWorldCheckCaseManagment> amlGetAllCases();
	
	List<AMLWorldCheckCaseManagment> amlGetByCaseStatus(String caseStatus);
	
	List<AMLWorldCheckCaseData> amlGetCaseById(Long caseId);
}
