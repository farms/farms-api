package br.ufs.dcomp.farms.common.message;

import br.ufs.dcomp.farms.model.enums.MessageEnum;

public abstract class Message {

	private MessageEnum type;
	private Integer code;
	private String description;
	private Object data;
	
	public Message(MessageEnum type, Integer code, String description) {
		super();
		this.type = type;
		this.code = code;
		this.description = description;
	}
	
	public MessageEnum getType() {
		return type;
	}

	public void setType(MessageEnum type) {
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}