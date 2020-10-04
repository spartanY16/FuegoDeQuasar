package com.fuegodequasar.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuegodequasar.dto.PositionDTO;
import com.fuegodequasar.dto.ResponseDTO;
import com.fuegodequasar.service.SignatureService;
import com.fuegodequasar.service.WolframRestClientService;
import com.fuegodequasar.util.Util;

@Service
public class SignatureServiceImpl implements SignatureService {

	@Autowired
	private WolframRestClientService wolframRestClientService;

	@Override
	public void getLocation(Float kenobiDist, Float skywalkerDist, Float satoDist, ResponseDTO response) {

		PositionDTO positionResult = wolframRestClientService.validateLocation(kenobiDist, skywalkerDist, satoDist);

		if (positionResult != null) {
			response.setPosition(positionResult);
			response.setError(false);
		} else {
			response.setError(true);
		}
	}

	@Override
	public void getMessage(String[] kenobiMsn, String[] skywalkerMsn, String[] satoMsn, ResponseDTO response) {

		if (!response.isError()) {

			Util util = new Util();

			int iterator = util.maxValue(kenobiMsn.length, skywalkerMsn.length, satoMsn.length);

			List<String> constructor = new ArrayList<>();

			for (int i = 0; i < iterator; i++) {

				if (kenobiMsn.length > i && !constructor.contains(kenobiMsn[i]) && !kenobiMsn[i].equals("")) {
					constructor.add(kenobiMsn[i]);
				}
				if (skywalkerMsn.length > i && !constructor.contains(skywalkerMsn[i]) && !skywalkerMsn[i].equals("")) {
					constructor.add(skywalkerMsn[i]);
				}
				if (satoMsn.length > i && !constructor.contains(satoMsn[i]) && !satoMsn[i].equals("")) {
					constructor.add(satoMsn[i]);
				}

			}

			StringBuffer message = new StringBuffer();

			for (int i = 0; i < constructor.size(); i++) {
				message = message.append(constructor.get(i).toString());
				if (i != constructor.size() - 1) {
					message.append(" ");
				}
			}

			response.setMessage(message.toString());
			response.setError(false);

		}

	}

}
