package com.melvis.daos;

import java.util.ArrayList;

import com.melvis.models.Diagnosis;


public interface DiagnosisDAOInterface {

	void insertDiagnosis(Diagnosis diag, int pat_id, int doc_id);
	ArrayList<Diagnosis> getdiagnosis();

}
