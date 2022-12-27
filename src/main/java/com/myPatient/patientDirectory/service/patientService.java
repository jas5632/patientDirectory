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
//THE SERVICE CLASS
public class patientService
    /*
    this is the service class that allows the database to be manipulated
     */
{
    private final PatientRepo patientRepo;
    /*
    PatientRepo is created as an object so each instance of the patientService class is able to use it
    allows database to be accessed and modified
     */
    @Autowired
    public patientService(PatientRepo patientRepo)
    //Basic constructor that allows the PatientRepo class to be used
    {
        this.patientRepo = patientRepo;
    }

    public myPatient addPatient(myPatient patient)
            /*
            creates the first instance of the object myPatient. creates a random MRN that would be assigned to the
            individual and saved.
             */
    {
        patient.setMrn(Long.parseLong(UUID.randomUUID().toString()));
        return patientRepo.save(patient);
    }
    public List<myPatient> findAllPatients()
    {
        return patientRepo.findAll();
        //
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
