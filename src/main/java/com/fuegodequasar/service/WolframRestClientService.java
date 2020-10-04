package com.fuegodequasar.service;

import com.fuegodequasar.dto.PositionDTO;

public interface WolframRestClientService {
	
	/**
	 * @param kenobiDist
	 * @param skywalkerDist
	 * @param satoDist
	 * @return
	 */
	public PositionDTO validateLocation (Float kenobiDist, Float skywalkerDist, Float satoDist);

}
