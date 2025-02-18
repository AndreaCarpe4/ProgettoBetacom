package com.betacom.fe.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WebUtils {
	
	public static Object convertInObject(Object inp, Class<?> tipo) {
		
		Object res = new Object();
		ObjectMapper mapper = new ObjectMapper();
		
		res = mapper.convertValue(inp, tipo);
		
		return res;
		
	}

}
