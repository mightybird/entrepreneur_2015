package org.sicdlab.entrepreneur.utils;

import java.util.UUID;

public class UUIDGenerator {

	public static String randomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
