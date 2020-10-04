package com.fuegodequasar.serviceimpl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fuegodequasar.constant.Constants;
import com.fuegodequasar.dto.PositionDTO;
import com.fuegodequasar.dto.QueryResultDTO;
import com.fuegodequasar.service.WolframRestClientService;
import com.fuegodequasar.util.Util;
import com.google.gson.Gson;

@Service
public class WolframRestClientServiceImpl implements WolframRestClientService {

	@Override
	public PositionDTO validateLocation(Float kenobiDist, Float skywalkerDist, Float satoDist) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(
				Constants.WOLFRAM_ALPHA_API.getWolframAlphaEndPoint(kenobiDist, skywalkerDist, satoDist),
				HttpMethod.GET, null, String.class);

		String json = response.getBody();
		Gson gson = new Gson();

		QueryResultDTO queryResult = gson.fromJson(json, QueryResultDTO.class);
		String resultValidateLocation = queryResult.getQueryresult().getPods().get(0).getSubpods().get(0)
				.getPlaintext();

		if (!resultValidateLocation.trim().equals(Constants.NO_SOLUTIONS_EXIST.getDescripcion())) {
			Util util = new Util();
			return util.extractValues(resultValidateLocation);
		} else {
			return null;
		}

	}

}
