package com.myPatient.patientDirectory.repo;

import com.myPatient.patientDirectory.model.myPatient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<myPatient, Long>
        /*jpa repository needs to know what class its gonna be using and the primary key
         the primary key is the second parameter shown. its a long due to the program using
         an MRN as a universal tracer of all objects. The MRN is the only variable that cannot exist twice
         because PatientRepo extends JpaRepository it allows you to use all the functions in the JpaRepository
         class
         */
{
    void deletePatientByMrn(long mrn);

    Optional<myPatient> findPatientByMrn(long mrn);
}
