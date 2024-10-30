package com.example.skoda.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.skoda.model.VehiclesViolations;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VehiclesViolationsRepositoryTest {
	
	
	@Autowired
	VehiclesViolationsRepository vehiclesViolationsRepo;
	
	
	@Test
	public void testSaveVehicleViolations() {
		
		VehiclesViolations vehicleViolations = new VehiclesViolations();
		vehicleViolations.setLangitude(100.00f);
		vehicleViolations.setLatitude(50.00f);
		vehicleViolations.setSpeed_limit(90);
		vehicleViolations.setVin("mockTest1");
		vehicleViolations.setViolatedDate("2024-10-20 10:00:00");
		
		VehiclesViolations resp = vehiclesViolationsRepo.save(vehicleViolations);
		assertNotNull(resp);
		assertEquals("mockTest1", resp.getVin());	
	}
	
	@Test
	public void testFindAllByVIN() {
		
		testSaveVehicleViolations();
		
		List<VehiclesViolations> resp = vehiclesViolationsRepo.findAllByVIN("mockTest1");
		assertNotNull(resp);
		assertEquals("mockTest1", resp.get(0).getVin());
	}
	

}
