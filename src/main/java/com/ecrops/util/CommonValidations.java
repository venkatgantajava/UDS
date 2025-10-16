package com.ecrops.util;

public class CommonValidations {
    static String message;

    public static boolean validateScheme(Integer scheme) {
        if (scheme == null || scheme == 0) {
            message = "Invalid data";
            return false; 
        }
        return true; 
    }

	public static boolean validateTarget(Double target) {
		 if (target == null || target == 0) {
	            message = "Invalid data";
	            return false; 
	        }
		return false;
	}
    
}

