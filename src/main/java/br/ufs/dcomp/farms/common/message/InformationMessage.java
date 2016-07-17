package br.ufs.dcomp.farms.common.message;

import java.util.HashMap;
import java.util.Map;

import br.ufs.dcomp.farms.model.enums.MessageEnum;

public class InformationMessage extends Message {

	private Map<Integer, String> messageMap = new HashMap<Integer, String>();
	
	public InformationMessage(Integer code, String description) {
		super(MessageEnum.INFORMATION, code, description);
		messageMap.put(code, description); // TODO For validity in tests.
	}

}
