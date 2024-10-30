package com.example.skoda.request;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SetSpeedThresholdReq {

	@NotNull
	@Size(max = 17)
	private String vin;

	@NotNull
	private int speedLimit;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	@Override
	public String toString() {
		return "SetSpeedThresholdReq [vin=" + vin + ", speedLimit=" + speedLimit + "]";
	}

	public SetSpeedThresholdReq(@NotNull @Size(max = 17) String vin, @NotNull int speedLimit) {
		super();
		this.vin = vin;
		this.speedLimit = speedLimit;
	}

	public SetSpeedThresholdReq() {
		super();
	}
	
	

}
