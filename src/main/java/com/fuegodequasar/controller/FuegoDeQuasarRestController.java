package com.fuegodequasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuegodequasar.dto.ResponseDTO;
import com.fuegodequasar.dto.SatellitesDTO;
import com.fuegodequasar.service.SignatureService;

@RestController
@RequestMapping("/fuego_de_quasar")
public class FuegoDeQuasarRestController {

	@Autowired
	private SignatureService signatureService;

	@PostMapping(value = "/topsecret")
	public ResponseEntity<Object> topsecret(@RequestBody SatellitesDTO request) {

		ResponseEntity<Object> responseService = null;
		ResponseDTO response = new ResponseDTO();

		try {

			signatureService.getLocation(request.getSatellites().get(0).getDistance(),
					request.getSatellites().get(1).getDistance(), request.getSatellites().get(2).getDistance(),
					response);

			signatureService.getMessage(request.getSatellites().get(0).getMessage(),
					request.getSatellites().get(1).getMessage(), request.getSatellites().get(2).getMessage(), response);

			if (!response.isError()) {

				responseService = new ResponseEntity<>(response, HttpStatus.OK);
				return responseService;

			} else {

				responseService = new ResponseEntity<>(HttpStatus.NOT_FOUND);
				return responseService;

			}

		} catch (Exception e) {

			responseService = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return responseService;

		}

	}

}
