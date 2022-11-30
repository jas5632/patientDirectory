package com.myPatient.patientDirectory;

import com.myPatient.patientDirectory.model.myPatient;
import com.myPatient.patientDirectory.service.patientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//help me jesus
@RestController
@RequestMapping("/myPatient")
public class myPatientResource
{
    private final patientService patientservice;

    public myPatientResource(patientService patientservice) {
        this.patientservice = patientservice;
    }
    @GetMapping
    public ResponseEntity<List<myPatient>> getAllPatients()
    {
        List<myPatient> patients = patientservice.findAllPatients();
        return List<patients>;
    }
}
