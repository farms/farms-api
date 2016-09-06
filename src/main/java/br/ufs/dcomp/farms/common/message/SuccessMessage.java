package br.ufs.dcomp.farms.common.message;

import java.util.HashMap;
import java.util.Map;

import br.ufs.dcomp.farms.model.enums.MessageEnum;

public final class SuccessMessage extends Message {
	
	private Map<Integer, String> messageMap = new HashMap<Integer, String>();

	public SuccessMessage(Integer code, String description) {
		super(MessageEnum.SUCCESS, code, description);
		messageMap.put(code, description); // TODO For validity in tests.
	}
	
	private static final Integer RESEARCHER_LOGGED_CODE = 1000;
	private static final String RESEARCHER_LOGGED_DESCRIPTION = "Researcher logged successfully.";
	public static final SuccessMessage RESEARCHER_LOGGED = new SuccessMessage(RESEARCHER_LOGGED_CODE, RESEARCHER_LOGGED_DESCRIPTION);
	
	private static final Integer PASSWORD_CHANGED_CODE = 1001;
	private static final String PASSWORD_CHANGED_DESCRIPTION = "Password changed successfully.";
	public static final SuccessMessage PASSWORD_CHANGED = new SuccessMessage(PASSWORD_CHANGED_CODE, PASSWORD_CHANGED_DESCRIPTION);
	
	private static final Integer RESEARCHER_REGISTERED_CODE = 1002;
	private static final String RESEARCHER_REGISTERED_DESCRIPTION = "Researcher registered successfully.";
	public static final SuccessMessage RESEARCHER_REGISTERED = new SuccessMessage(RESEARCHER_REGISTERED_CODE, RESEARCHER_REGISTERED_DESCRIPTION);
	
	private static final Integer RESEARCHER_UPDATED_CODE = 1003;
	private static final String RESEARCHER_UPDATED_DESCRIPTION = "Researcher updated successfully.";
	public static final SuccessMessage RESEARCHER_UPDATED = new SuccessMessage(RESEARCHER_UPDATED_CODE, RESEARCHER_UPDATED_DESCRIPTION);
	
	private static final Integer RESEARCHER_EXCLUDED_CODE = 1004;
	private static final String RESEARCHER_EXCLUDED_DESCRIPTION = "Researcher excluded successfully.";
	public static final SuccessMessage RESEARCHER_EXCLUDED = new SuccessMessage(RESEARCHER_EXCLUDED_CODE, RESEARCHER_EXCLUDED_DESCRIPTION);
	
	private static final Integer ACCOUNT_CONFIRMED_CODE = 1005;
	private static final String ACCOUNT_CONFIRMED_DESCRIPTION = "Account confirmed successfully.";
	public static final SuccessMessage ACCOUNT_CONFIRMED = new SuccessMessage(ACCOUNT_CONFIRMED_CODE, ACCOUNT_CONFIRMED_DESCRIPTION);
}