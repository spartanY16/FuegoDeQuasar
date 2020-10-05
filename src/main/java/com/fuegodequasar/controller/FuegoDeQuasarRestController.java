package com.fuegodequasar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuegodequasar.constant.Constants;
import com.fuegodequasar.dto.ResponseDTO;
import com.fuegodequasar.dto.SatelliteDTO;
import com.fuegodequasar.dto.SatellitesDTO;
import com.fuegodequasar.dto.SatellitesSplitDTO;
import com.fuegodequasar.service.SignatureService;

@RestController
@RequestMapping("/fuego_de_quasar")
public class FuegoDeQuasarRestController {

	@Autowired
	private SignatureService signatureService;

	SatellitesSplitDTO satellitesSplit;

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

	@GetMapping(value = "/topsecret_split/kenobi")
	public ResponseEntity<Object> topsecretKenobiGet(@RequestHeader(value = "distance", required = true) Float distance,
			@RequestHeader(value = "message", required = true) String[] message) {

		SatelliteDTO kenobiSat = new SatelliteDTO(null, distance, message);

		return topsecretKenobiPost(kenobiSat);

	}

	@PostMapping(value = "/topsecret_split/kenobi")
	public ResponseEntity<Object> topsecretKenobiPost(@RequestBody SatelliteDTO request) {

		ResponseEntity<Object> responseService = null;

		try {

			if (this.satellitesSplit == null) {

				this.satellitesSplit = new SatellitesSplitDTO();

			}

			if (this.satellitesSplit.getKenobiSat() != null) {

				this.satellitesSplit.setSkywalkerSat(null);
				this.satellitesSplit.setSatoSat(null);

			}

			SatelliteDTO kenobiSat = new SatelliteDTO(Constants.KENOBI.getDescripcion(), request.getDistance(),
					request.getMessage());
			this.satellitesSplit.setKenobiSat(kenobiSat);

			if (this.satellitesSplit.getSkywalkerSat() != null && this.satellitesSplit.getSatoSat() != null) {

				List<SatelliteDTO> satellites = new ArrayList<>();
				satellites.add(this.satellitesSplit.getKenobiSat());
				satellites.add(this.satellitesSplit.getSkywalkerSat());
				satellites.add(this.satellitesSplit.getSatoSat());

				SatellitesDTO requestTopsecret = new SatellitesDTO();
				requestTopsecret.setSatellites(satellites);

				return topsecret(requestTopsecret);

			} else {

				ResponseDTO response = new ResponseDTO();
				response.setMessage(Constants.WITHOUT_INFORMATION.getDescripcion());
				responseService = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
				return responseService;

			}

		} catch (Exception e) {

			ResponseDTO response = new ResponseDTO();
			responseService = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			return responseService;

		}

	}

	@GetMapping(value = "/topsecret_split/skywalker")
	public ResponseEntity<Object> topsecretSkywalkerGet(
			@RequestHeader(value = "distance", required = true) Float distance,
			@RequestHeader(value = "message", required = true) String[] message) {

		SatelliteDTO skywalkerSat = new SatelliteDTO(null, distance, message);

		return topsecretSkywalkerPost(skywalkerSat);

	}

	@PostMapping(value = "/topsecret_split/skywalker")
	public ResponseEntity<Object> topsecretSkywalkerPost(@RequestBody SatelliteDTO request) {

		ResponseEntity<Object> responseService = null;

		try {

			if (this.satellitesSplit == null) {

				this.satellitesSplit = new SatellitesSplitDTO();

			}

			if (this.satellitesSplit.getSkywalkerSat() != null) {

				this.satellitesSplit.setKenobiSat(null);
				this.satellitesSplit.setSatoSat(null);

			}

			SatelliteDTO skywalker = new SatelliteDTO(Constants.SKYWALKER.getDescripcion(), request.getDistance(),
					request.getMessage());
			this.satellitesSplit.setSkywalkerSat(skywalker);

			if (this.satellitesSplit.getKenobiSat() != null && this.satellitesSplit.getSatoSat() != null) {

				List<SatelliteDTO> satellites = new ArrayList<>();
				satellites.add(this.satellitesSplit.getKenobiSat());
				satellites.add(this.satellitesSplit.getSkywalkerSat());
				satellites.add(this.satellitesSplit.getSatoSat());

				SatellitesDTO requestTopsecret = new SatellitesDTO();
				requestTopsecret.setSatellites(satellites);

				return topsecret(requestTopsecret);

			} else {

				ResponseDTO response = new ResponseDTO();
				response.setMessage(Constants.WITHOUT_INFORMATION.getDescripcion());
				responseService = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
				return responseService;

			}

		} catch (Exception e) {

			ResponseDTO response = new ResponseDTO();
			responseService = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			return responseService;

		}

	}

	@GetMapping(value = "/topsecret_split/sato")
	public ResponseEntity<Object> topsecretSatoGet(@RequestHeader(value = "distance", required = true) Float distance,
			@RequestHeader(value = "message", required = true) String[] message) {

		SatelliteDTO satoSat = new SatelliteDTO(null, distance, message);

		return topsecretSatoPost(satoSat);

	}

	@PostMapping(value = "/topsecret_split/sato")
	public ResponseEntity<Object> topsecretSatoPost(@RequestBody SatelliteDTO request) {

		ResponseEntity<Object> responseService = null;

		try {

			if (this.satellitesSplit == null) {

				this.satellitesSplit = new SatellitesSplitDTO();

			}

			if (this.satellitesSplit.getSatoSat() != null) {

				this.satellitesSplit.setKenobiSat(null);
				this.satellitesSplit.setSkywalkerSat(null);

			}

			SatelliteDTO sato = new SatelliteDTO(Constants.SATO.getDescripcion(), request.getDistance(),
					request.getMessage());
			this.satellitesSplit.setSatoSat(sato);

			if (this.satellitesSplit.getKenobiSat() != null && this.satellitesSplit.getSkywalkerSat() != null) {

				List<SatelliteDTO> satellites = new ArrayList<>();
				satellites.add(this.satellitesSplit.getKenobiSat());
				satellites.add(this.satellitesSplit.getSkywalkerSat());
				satellites.add(this.satellitesSplit.getSatoSat());

				SatellitesDTO requestTopsecret = new SatellitesDTO();
				requestTopsecret.setSatellites(satellites);

				return topsecret(requestTopsecret);

			} else {

				ResponseDTO response = new ResponseDTO();
				response.setMessage(Constants.WITHOUT_INFORMATION.getDescripcion());
				responseService = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
				return responseService;

			}

		} catch (Exception e) {

			ResponseDTO response = new ResponseDTO();
			responseService = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			return responseService;

		}

	}

}
