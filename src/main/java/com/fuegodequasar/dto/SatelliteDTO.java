package com.fuegodequasar.dto;

public class SatelliteDTO {

	private String name;
	private Float distance;
	private String[] message;

	public SatelliteDTO() {
	}

	public SatelliteDTO(String name, Float distance, String[] message) {
		this.name = name;
		this.distance = distance;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

}
