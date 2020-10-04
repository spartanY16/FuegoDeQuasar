package com.fuegodequasar.constant;

public enum Constants {

	WOLFRAM_ALPHA_API("https://api.wolframalpha.com/v2/query"), APP_ID("appid=HGRQHW-KXQA7J2V4J"), PARAMETERS("?"),
	NEW_PARAMETER("&"), KENOBI_X("-500"), KENOBI_Y("-200"), SKYWALKER_X("100"), SKYWALKER_Y("-100"), SATO_X("500"),
	SATO_Y("100"), CONFIGURATION("&output=json&includepodid=Result"), EQUALS("="), AND("and"), NO_SOLUTIONS_EXIST("(no solutions exist)");

	private String descripcion;

	Constants(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;

	}

	public String getWolframAlphaEndPoint(Float kenobiDist, Float skywalkerDist, Float satoDist) {

		return descripcion + PARAMETERS.getDescripcion() + APP_ID.getDescripcion() + NEW_PARAMETER.getDescripcion()
				+ "input=solve(" + KENOBI_X.getDescripcion() + "-a)^2plus(" + KENOBI_Y.getDescripcion() + "-b)^2="
				+ Math.round(kenobiDist * kenobiDist) + "\n(" + SKYWALKER_X.getDescripcion() + "-a)^2plus("
				+ SKYWALKER_Y.getDescripcion() + "-b)^2=" + Math.round(skywalkerDist * skywalkerDist) + "\n("
				+ SATO_X.getDescripcion() + "-a)^2plus(" + SATO_Y.getDescripcion() + "-b)^2="
				+ Math.round(satoDist * satoDist) + CONFIGURATION.getDescripcion() + NEW_PARAMETER.getDescripcion()
				+ APP_ID.getDescripcion();

	}

}
