package br.ufs.dcomp.farms.common.message;

import java.util.HashMap;
import java.util.Map;

import br.ufs.dcomp.farms.model.enums.MessageEnum;

public class WarningMessage extends Message {

	private Map<Integer, String> messageMap = new HashMap<Integer, String>();
	
	public WarningMessage(Integer code, String description) {
		super(MessageEnum.INFORMATION, code, description);
		messageMap.put(code, description); // TODO For validity in tests.
	}

}
