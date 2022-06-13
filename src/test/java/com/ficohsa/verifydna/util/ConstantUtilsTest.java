package com.ficohsa.verifydna.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstantUtilsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void ConstantUtils_Test() {
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_OK_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_OK_KEY_CREATE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_BAD_REQUEST_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_FORBIDDEN_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_NOT_FOUND_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_UNAUTHORIZED_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_CONFLICT_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_INTERNAL_SERVER_ERROR_KEY);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_SERVICE_UNAVAILABLE);

		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_OK_VALUE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_BAD_REQUEST_VALUE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_FORBIDDEN_VALUE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_UNAUTHORIZED_VALUE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_NOT_FOUND_VALUE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_CONFLICT_VALUE);
		Assertions.assertNotNull(ConstantUtils.API_RESPONSE_CODE_INTERNAL_SERVER_ERROR_VALUE);

	}
}
