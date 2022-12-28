package com.myPatient.patientDirectory;

import com.myPatient.patientDirectory.model.myPatient;
import com.myPatient.patientDirectory.service.patientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller used to accept requests from the user and send to service for responses
@RestController
@RequestMapping("/myPatient")
public class myPatientResource
{
    private final patientService patientService;
    /*just allows the service class to be used on the controller
    the object is created for the
    */
    public myPatientResource(patientService patientservice) {
        this.patientService = patientservice;
    }
    @GetMapping("/all")
    public ResponseEntity<List<myPatient>> getAllPatients()
    {
        List<myPatient> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
        /*allows the controller to create a list with all active patients in the
        database and the response entity informs user of success
        */
    }
    @GetMapping("/find/{mrn}")
    public ResponseEntity<myPatient> getPatientByMrn(@PathVariable("mrn") Long mrn)
    {
        myPatient patient = patientService.findPatientByMrn(mrn);
        return new ResponseEntity<>(patient, HttpStatus.OK);
        /*made original method static****
        */
    }
    @PostMapping("/add")
    public ResponseEntity<myPatient> addPatient(@RequestBody myPatient patient)
    {
        myPatient newPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<myPatient> updatePatient(@RequestBody myPatient patient)
    {
        myPatient updatePatient = patientService.updatePatient(patient);
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{mrn}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long mrn)
    {
        patientService.deletePatient(mrn);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
