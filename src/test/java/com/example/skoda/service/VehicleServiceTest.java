package com.example.skoda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.skoda.model.Vehicles;
import com.example.skoda.repository.VehiclesRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VehicleServiceTest {

	@InjectMocks
	private VehiclesService vehiclesService;

	@Mock
	private VehiclesRepository vehiclesRepo;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	Vehicles vehicle = new Vehicles("mockTest1", 85);
	
	@Test
	public void testSaveThreshold() {
		
		when(vehiclesRepo.saveAndFlush(vehicle)).thenReturn(vehicle);
		Vehicles found = vehiclesRepo.saveAndFlush(vehicle);
		assertEquals("mockTest1", found.getVin());
	}
	

	@Test
	public void testFindByVIN() {
		
		when(vehiclesRepo.findByVIN("mockTest1")).thenReturn(vehicle);
		Vehicles found = vehiclesRepo.findByVIN("mockTest1");
		assertEquals("mockTest1", found.getVin());
	}

}
