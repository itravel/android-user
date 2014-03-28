package demo.travel.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperFactory {
	private static final class ObjectMapperHolder {
		private static final ObjectMapper INSTANCE = new ObjectMapper();
	}
	
	public static final ObjectMapper create(){
		return ObjectMapperHolder.INSTANCE;
	}
}
