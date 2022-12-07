package com.myPatient.patientDirectory;

import com.myPatient.patientDirectory.model.myPatient;
import com.myPatient.patientDirectory.service.patientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controller used to accept requests from the user and send to service for responses
@RestController
@RequestMapping("/myPatient")
public class myPatientResource
{
    private final patientService patientservice;
    //just allows the service class to be used on the controller

    public myPatientResource(patientService patientservice) {
        this.patientservice = patientservice;
    }
    @GetMapping
    public ResponseEntity<List<myPatient>> getAllPatients()
    {
        List<myPatient> patients = patientservice.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
        /*allows the controller to create a list with all active patients in the
        database and the response entity informs user of success
        */
    }
    @GetMapping("/find/{mrn}")
    public ResponseEntity<myPatient> getPatientByMrn(@PathVariable("mrn") Long mrn)
    {
        myPatient patient = patientService.findPatientByMrn();
        return new ResponseEntity<>(patient, HttpStatus.OK);
        /*made original method static****
        */
    }
}
