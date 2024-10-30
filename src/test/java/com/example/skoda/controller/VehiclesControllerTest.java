package com.example.skoda.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.skoda.request.SetSpeedThresholdReq;
import com.example.skoda.response.SetSpeedThresholdResp;
import com.example.skoda.service.VehiclesService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = VehiclesController.class)
public class VehiclesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehiclesService vehicleService;

	SetSpeedThresholdReq req = new SetSpeedThresholdReq("veh1", 85);
	SetSpeedThresholdResp resp = new SetSpeedThresholdResp("veh1", 85, "Success");

	@Test
	public void VehicleControllerTest_setSpeedThreshold_thenReturnSpeedThreshold() throws Exception {

		when(vehicleService.setSpeedThreshold(req)).thenReturn(resp);
		resp = vehicleService.setSpeedThreshold(req);

		assertThat(resp).isNotNull();
		assertEquals(resp.getVin(), req.getVin());
		assertEquals(resp.getSpeedLimit(), req.getSpeedLimit());

	}

	@Test
	public void VehicleControllerTest_givenVIN_thenReturnSpeedThreshold() {

		when(vehicleService.getSpeedThreshold("veh1")).thenReturn(resp);

		resp = vehicleService.getSpeedThreshold("veh1");

		System.out.println("VehicleControllerTest_givenVIN_thenReturnSpeedThreshold status:" + resp.getStatus());

		assertThat(resp).isNotNull();
		assertEquals(resp.getVin(), "veh1");

	}

}
