package utils;

import java.util.UUID;

public class WebUtils {

	public static String makeId() {
		// UUID 128 36λ�ַ�

		return UUID.randomUUID().toString();
	}

}
