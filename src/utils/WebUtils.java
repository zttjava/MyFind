package utils;

import java.util.UUID;

public class WebUtils {

	public static String makeId() {
		// UUID 128 36Î»×Ö·û

		return UUID.randomUUID().toString();
	}

}
