package com.melvis.daos;

import java.util.ArrayList;

import com.melvis.models.Diagnosis;


public interface DiagnosisDAOInterface {

	//boolean insertDiagnosis(Diagnosis diag, int pat_id, int doc_id);
	ArrayList<Diagnosis> getdiagnosis();
	boolean insertDiagnosis(Diagnosis diagnosis);

}
