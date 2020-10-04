package com.fuegodequasar.util;

import com.fuegodequasar.constant.Constants;
import com.fuegodequasar.dto.PositionDTO;

public class Util {

	public PositionDTO extractValues(String location) {

		PositionDTO result = new PositionDTO();
		String[] locationSplit = location.split(Constants.EQUALS.getDescripcion());
		result.setY(Float.parseFloat(locationSplit[2].trim()));
		String[] locationSecondSplit = locationSplit[1].split(Constants.AND.getDescripcion());
		result.setX(Float.parseFloat(locationSecondSplit[0].trim()));
		return result;

	}

	public Integer maxValue(int n1, int n2, int n3) {

		if (n1 > n2) {
			if (n1 > n3) {
				return n1;
			} else {
				return n3;
			}
		} else if (n2 > n3) {
			return n2;
		} else {
			return n3;
		}

	}

}
