package com.myPatient.patientDirectory.repo;

import com.myPatient.patientDirectory.model.myPatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<myPatient, Long>
{
    void deletePatientByMrn(long mrn);

    Optional<myPatient> findPatientByMrn(long mrn);
}
