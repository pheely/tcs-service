package com.bns.fft.tcs.service.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bns.fft.tcs.common.domain.AssignedTransit;
import com.bns.fft.tcs.common.domain.Branch;
import com.bns.fft.tcs.common.domain.Level;
import com.bns.fft.tcs.common.domain.Officer;
import com.bns.fft.tcs.common.domain.Role;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tcs")
public class TCSController {
	@RequestMapping(method=RequestMethod.GET, value= "/locate/officerId", params = {"officerId", "transitNum"}) 
	List<Officer> getListOfOfficersByID(@RequestParam("officerId") String officerId, @RequestParam("transitNum") String transitNum ) {
		// Stub - simulate J3 officer locate by officer Id result - one record will be returned
		// The response is defined by copybook J3PRFRL1
		// How to invoke: http://localhost:8080/tcs/locate/officerId?officerId=1234567&transitNum=80002
		
		List<Officer> officers = new ArrayList<Officer>();
		Officer officer = new Officer(officerId);
		officer.setFirstName("Lisa");
		officer.setLastName("Raty");
		officer.setInitials("");
		officer.setShortName(new StringBuilder(officer.getFirstName().substring(0,1)).append(officer.getLastName()).toString().toUpperCase());
		officer.setOfficerCardNumber("123456789");
		officer.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		officer.setTransitNum(transitNum);
		officer.setRole(Role.CUSTOMER_SERVICE);
		officer.setLevel(Level.THREE);
		
		List<AssignedTransit> transits = new ArrayList<AssignedTransit>();
		transits.add(new AssignedTransit(new Branch("80002", "SCOTIA PLAZA"), Role.CUSTOMER_SERVICE, Level.THREE));
		officer.setAssignedTransits(transits);
		officer.setAbsenceStartDate(null);
		officer.setAbsenceEndDate(null);
		officer.setPipStartDate(null);
		officer.setPipEndDate(null);
		officer.setEmailAddress(null);

		officers.add(officer);
		
		return officers;
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/locate/name", params = {"firstName", "lastName"}) 
	List<Officer> getListOfOfficersByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		// Stub - simulate J3 officer locate by officer Id result - one record will be returned
		// How to invoke: http://localhost:8080/tcs/locate/name?firstName=philip&lastName=Yang
		
		List<Officer> officers = new ArrayList<Officer>();
		Officer officer = new Officer("1717308");
		officer.setFirstName("Lisa");
		officer.setLastName("Raty");
		officer.setInitials("");
		officer.setShortName(new StringBuilder(officer.getFirstName().substring(0,1)).append(officer.getLastName()).toString().toUpperCase());
		officer.setOfficerCardNumber("123456789");
		officer.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		officer.setTransitNum("80002");
		officer.setRole(Role.TRANSACTIONAL);
		officer.setLevel(Level.ONE);
		
		List<AssignedTransit> transits = new ArrayList<AssignedTransit>();
		transits.add(new AssignedTransit(new Branch("80002", "SCOTIA PLAZA"), Role.TRANSACTIONAL, Level.ONE));
		officer.setAssignedTransits(transits);
		officer.setAbsenceStartDate(null);
		officer.setAbsenceEndDate(null);
		officer.setPipStartDate(null);
		officer.setPipEndDate(null);
		officer.setEmailAddress(null);

		officers.add(officer);
		
		officer = new Officer("1717774");
		officer.setFirstName("Lisa");
		officer.setLastName("Raty");
		officer.setInitials("");
		officer.setShortName(new StringBuilder(officer.getFirstName().substring(0,1)).append(officer.getLastName()).toString().toUpperCase());
		officer.setOfficerCardNumber("123456789");
		officer.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		officer.setTransitNum("71001");
		officer.setRole(Role.MANAGEMENT);
		officer.setLevel(Level.TWO);
		
		transits = new ArrayList<AssignedTransit>();
		transits.add(new AssignedTransit(new Branch("71001", "MONTREAL CENTRAL ACCOUNTING UNIT"), Role.MANAGEMENT, Level.TWO));
		officer.setAssignedTransits(transits);
		officer.setAbsenceStartDate(null);
		officer.setAbsenceEndDate(null);
		officer.setPipStartDate(null);
		officer.setPipEndDate(null);
		officer.setEmailAddress(null);

		officers.add(officer);
		
		return officers;
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/profile/{officerId}")
	Officer getOfficerProfile(@PathVariable String officerId) {
		// Now we will call some service to retrieve the officer profile
		// some code
		
		Officer officer = new Officer(officerId);
		
		// Populate officer with the response from the service call
		officer.setFirstName("Lisa");
		officer.setLastName("Raty");
		officer.setInitials("");
		officer.setShortName(new StringBuilder(officer.getFirstName().substring(0,1)).append(officer.getLastName()).toString().toUpperCase());
		officer.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
		List<AssignedTransit> transits = new ArrayList<AssignedTransit>();
		transits.add(new AssignedTransit(new Branch("71001", "MONTREAL CENTRAL ACCOUNTING UNIT"), Role.TRANSACTIONAL, Level.ONE));
		transits.add(new AssignedTransit(new Branch("70722", "NORTH BAY - BUSINESS BANKING CENTRE"), Role.MANAGEMENT, Level.TWO));
		transits.add(new AssignedTransit(new Branch("80002", "SCOTIA PLAZA"), Role.CUSTOMER_SERVICE, Level.THREE));
		officer.setAssignedTransits(transits);
		
		// How to handle the error when an officer is not found?
		
		return officer;
	}
}
