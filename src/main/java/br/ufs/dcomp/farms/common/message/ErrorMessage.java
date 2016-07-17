package br.ufs.dcomp.farms.common.message;

import java.util.HashMap;
import java.util.Map;

import br.ufs.dcomp.farms.model.enums.MessageEnum;

public class ErrorMessage extends Message {

	private Map<Integer, String> messageMap = new HashMap<Integer, String>();
	
	public ErrorMessage(Integer code, String description) {
		super(MessageEnum.ERROR, code, description);
		messageMap.put(code, description); // TODO For validity in tests.
	}
	
	/* start-system-messages */
	
	private static final Integer OPERATION_NOT_RESPONDING_CODE = 999;
	private static final String OPERATION_NOT_RESPONDING_DESCRIPTION = "This operation is not responding properly. The administrator has been notified.";
	public static final ErrorMessage OPERATION_NOT_RESPONDING = new ErrorMessage(OPERATION_NOT_RESPONDING_CODE, OPERATION_NOT_RESPONDING_DESCRIPTION);
	
	/* end-system-messages */
	
	private static final Integer RESEARCHER_NOT_FOUND_CODE = 2000;
	private static final String RESEARCHER_NOT_FOUND_DESCRIPTION = "Researcher not found.";
	public static final ErrorMessage RESEARCHER_NOT_FOUND = new ErrorMessage(RESEARCHER_NOT_FOUND_CODE, RESEARCHER_NOT_FOUND_DESCRIPTION);
	
	private static final Integer EMAIL_ALREADY_IN_USE_CODE = 2001;
	private static final String EMAIL_ALREADY_IN_USE_DESCRIPTION = "Email already in use.";
	public static final ErrorMessage EMAIL_ALREADY_IN_USE = new ErrorMessage(EMAIL_ALREADY_IN_USE_CODE, EMAIL_ALREADY_IN_USE_DESCRIPTION);
	
	private static final Integer LOGIN_INVALID_CODE = 2002;
	private static final String LOGIN_INVALID_DESCRIPTION = "Login invalid.";
	public static final ErrorMessage LOGIN_INVALID = new ErrorMessage(LOGIN_INVALID_CODE, LOGIN_INVALID_DESCRIPTION);
	
	private static final Integer PASSWORD_INVALID_CODE = 2003;
	private static final String PASSWORD_INVALID_DESCRIPTION = "Password invalid.";
	public static final ErrorMessage PASSWORD_INVALID = new ErrorMessage(PASSWORD_INVALID_CODE, PASSWORD_INVALID_DESCRIPTION);
	
	private static final Integer USERNAME_ALREADY_IN_USE_CODE = 2004;
	private static final String USERNAME_ALREADY_IN_USE_DESCRIPTION = "Username already in use.";
	public static final ErrorMessage USERNAME_ALREADY_IN_USE = new ErrorMessage(USERNAME_ALREADY_IN_USE_CODE, USERNAME_ALREADY_IN_USE_DESCRIPTION);
	
	private static final Integer SLUG_ALREADY_IN_USE_CODE = 2005;
	private static final String SLUG_ALREADY_IN_USE_DESCRIPTION = "Slug already in use.";
	public static final ErrorMessage SLUG_ALREADY_IN_USE = new ErrorMessage(SLUG_ALREADY_IN_USE_CODE, SLUG_ALREADY_IN_USE_DESCRIPTION);
	
	private static final Integer INSTITUTION_NOT_FOUND_CODE = 2006;
	private static final String INSTITUTION_NOT_FOUND_DESCRIPTION = "Institution not found.";
	public static final ErrorMessage INSTITUTION_NOT_FOUND = new ErrorMessage(INSTITUTION_NOT_FOUND_CODE, INSTITUTION_NOT_FOUND_DESCRIPTION);
}
