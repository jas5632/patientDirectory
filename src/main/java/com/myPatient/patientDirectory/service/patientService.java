package com.myPatient.patientDirectory.service;

import com.myPatient.patientDirectory.exception.UserNotFoundException;
import com.myPatient.patientDirectory.model.myPatient;
import com.myPatient.patientDirectory.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class patientService
{
    private final PatientRepo patientRepo;
    @Autowired
    public patientService(PatientRepo patientRepo)
    {
        this.patientRepo = patientRepo;
    }
    public myPatient addPatient(myPatient patient)
    {
        patient.setMrn(Long.parseLong(UUID.randomUUID().toString()));
        return patientRepo.save(patient);
    }
    public List<myPatient> findAllPatients()
    {
        return patientRepo.findAll();
    }
    public myPatient updatePatient(myPatient patient)
    {
        return patientRepo.save(patient);
    }
    public myPatient findPatientByMrn(long mrn)
    {
        return patientRepo.findPatientByMrn(mrn).orElseThrow(() -> new UserNotFoundException("Patient with MRN: "+ mrn +" not found"));
    }
    public void deletePatient(long mrn)
    {
        patientRepo.deletePatientByMrn(mrn);
    }
}
