package com.ficohsa.verifydna.util;


public class ConstantUtils {
	// HTTP Status Code - Keys
	public static final int API_RESPONSE_CODE_OK_KEY = 200;
	public static final int API_RESPONSE_CODE_OK_KEY_CREATE = 201;
	public static final int API_RESPONSE_CODE_BAD_REQUEST_KEY = 400;
	public static final int API_RESPONSE_CODE_FORBIDDEN_KEY = 403;
	public static final int API_RESPONSE_CODE_NOT_FOUND_KEY = 404;
	public static final int API_RESPONSE_CODE_UNAUTHORIZED_KEY = 401;
	public static final int API_RESPONSE_CODE_CONFLICT_KEY = 409;
	public static final int API_RESPONSE_CODE_INTERNAL_SERVER_ERROR_KEY = 500;
	public static final int API_RESPONSE_CODE_SERVICE_UNAVAILABLE = 503;

	// HTTP Status Code - Values
	public static final String API_RESPONSE_CODE_OK_VALUE = "OK";
	public static final String API_RESPONSE_CODE_BAD_REQUEST_VALUE = "Solicitud incorrecta";
	public static final String API_RESPONSE_CODE_FORBIDDEN_VALUE = "Prohibido";
	public static final String API_RESPONSE_CODE_UNAUTHORIZED_VALUE = "No autorizado";
	public static final String API_RESPONSE_CODE_NOT_FOUND_VALUE = "No encontrado";
	public static final String API_RESPONSE_CODE_CONFLICT_VALUE = "Conflicto";
	public static final String API_RESPONSE_CODE_INTERNAL_SERVER_ERROR_VALUE = "Error del servidor interno";

	private ConstantUtils() {
		
	}
}
