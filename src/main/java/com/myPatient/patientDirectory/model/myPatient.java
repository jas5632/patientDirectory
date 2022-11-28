package com.myPatient.patientDirectory.model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
//allows class to be mapped to any databases
    public class myPatient implements Serializable
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable= false, updatable = false)
//once the data is set it can no longer be updated
        private long mrn;
        @Column(nullable= false, updatable = false)
        private String firstName;
        private String lastName;
        private String assignedNurse;
        private String assignedRoom;
        private String dob;
        private String address;
        private long phoneNumber;
        private String emergencyType;
        private String patientPicture;
        private String insurance;

//variable for the class so each patient created has the fields required

        public myPatient () {}
        public myPatient (long mrn, String firstName, String lastName, String assignedNurse, String assignedRoom, String dob,
                 String address, long phoneNumber, String emergencyType, String patientPicture, String insurance)
        {
//constructor for creating each patient object
            this.mrn = mrn;
            this.firstName = firstName;
            this.lastName = lastName;
            this.assignedNurse = assignedNurse;
            this.assignedRoom = assignedRoom;
            this.dob = dob;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.emergencyType = emergencyType;
            this.patientPicture = patientPicture;
            this.insurance = insurance;
        }
        //creating each setter and getter for the object
        public long getMrn()
        {
            return mrn;
        }
        public void setMrn (long mrn)
        {
            this.mrn = mrn;
        }

        public String getFirstName()
        {
            return firstName;
        }
        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

        public String getLastName()
        {
            return lastName;
        }
        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }
        public String getAssignedNurse()
        {
            return assignedNurse;
        }
        public void setAssignedNurse(String assignedNurse)
        {
            this.assignedNurse = assignedNurse;
        }
        public String getAssignedRoom()
        {
            return assignedRoom;
        }
        public void setAssignedRoom(String assignedRoom)
        {
            this.assignedRoom = assignedRoom;
        }
        public String getDob()
        {
            return dob;
        }
        public void setDob(String dob)
        {
            this.dob = dob;
        }
        public String getAddress()
        {
            return address;
        }
        public void setAddress(String address)
        {
            this.address = address;
        }
        public long getPhoneNumber()
        {
            return phoneNumber;
        }
        public void setPhoneNumber(long phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }
        public String getEmergencyType()
        {
            return emergencyType;
        }
        public void setEmergencyType(String emergencyType)
        {
            this.emergencyType = emergencyType;
        }
        public String getPatientPicture()
        {
            return patientPicture;
        }
        public void setPatientPicture(String patientPicture)
        {
            this.patientPicture = patientPicture;
        }
        public String getInsurance()
        {
            return insurance;
        }
        public void setInsuracne(String insurance)
        {
            this.insurance = insurance;
        }
        //TEST RUN FOR ALL VARIABLES BEING IN THE CORRECT FIELDS
        @Override
        public String toString()
        {
            return "Patient demographics " + "MRN : " + mrn +
	'/' + "NAME : " + firstName +  lastName +
	'/' + "ASSIGNED NURSE : " + assignedNurse +
	'/' + "ASSIGNED ROOM : " + assignedRoom +
	'/' + "DOB : " + dob +
	'/' + "ADDRESS : " + address +
	'/' + "PHONE NUMBER : " + phoneNumber +
	'/' + "EMERGENCY TYPE : " + emergencyType +
	'/' + "PATIENT PICTURE " + patientPicture +
	'/' + "INSURANCE : " + insurance;
        }
    }

