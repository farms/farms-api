package br.ufs.dcomp.farms.core;

import org.mindrot.jbcrypt.BCrypt;

public class FarmsCrypt {
	
	public FarmsCrypt() {}

	public static String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	public static boolean checkPassword(String password, String hashedPassword){
		return BCrypt.checkpw(password, hashedPassword);
	}
}