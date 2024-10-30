package com.example.skoda.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.skoda.model.Vehicles;
import com.example.skoda.model.VehiclesViolations;
import com.example.skoda.request.SetSpeedThresholdReq;
import com.example.skoda.response.SetSpeedThresholdResp;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VehiclesRepositoryTest {
	
	
	
	@Autowired
	VehiclesRepository vehiclesRepo;
	
	Vehicles vehicle = new Vehicles("mockTest1", 85);
	
	
	@Test
	public void testSaveThreshold() {
		
		
		
		Vehicles resp = vehiclesRepo.save(vehicle);
		assertNotNull(resp);
		assertEquals("mockTest1", resp.getVin());
		
	}
	
	
	@Test
	public void findByVIN() {
		
		testSaveThreshold();
		
		Vehicles resp = vehiclesRepo.findByVIN("mockTest1");
		assertNotNull(resp);
		assertEquals("mockTest1", resp.getVin());
		
	}
	
	
	

}
