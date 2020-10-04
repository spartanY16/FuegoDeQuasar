package com.fuegodequasar.service;

import com.fuegodequasar.dto.ResponseDTO;

public interface SignatureService {

	/**
	 * @param kenobiDist
	 * @param skywalkerDist
	 * @param satoDist
	 * @param response
	 * @apiNote Método que retorna las coordenadas 'x' e 'y' del emisor del mensaje
	 *          por medio de las distancias de cada satelite.
	 */
	public void getLocation(Float kenobiDist, Float skywalkerDist, Float satoDist, ResponseDTO response);

	/**
	 * @param kenobiMsn
	 * @param skywalkerMsn
	 * @param satoMsn
	 * @param response
	 * @apiNote Método que retorna el mensaje descifrado por medio de los mensajes
	 *          de cada satélite.
	 */
	public void getMessage(String[] kenobiMsn, String[] skywalkerMsn, String[] satoMsn, ResponseDTO response);

}
