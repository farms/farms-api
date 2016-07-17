package br.ufs.dcomp.farms.core;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.common.message.InformationMessage;
import br.ufs.dcomp.farms.common.message.SuccessMessage;

@XmlRootElement
public class FarmsResponse {
	
	public FarmsResponse() {}

	public static Response ok(SuccessMessage message) {
		return Response.ok(message).build();
	}
	
	public static Response ok(Object object) {
		return Response.ok().entity(object).build();
	}
	
	public static Response ok(SuccessMessage message, Object data) {
		message.setData(data);
		return Response.ok().entity(message).build();
	}
	
	public static Response error(ErrorMessage message) {
		return Response.ok(message).build();
	}
	
	public static Response info(InformationMessage message) {
		return Response.ok(message).build();
	}	
}
