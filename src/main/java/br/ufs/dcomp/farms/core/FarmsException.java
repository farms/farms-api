package br.ufs.dcomp.farms.core;

import br.ufs.dcomp.farms.common.message.ErrorMessage;

public class FarmsException extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorMessage errorMessage = null;
	
	public FarmsException() {
        super();
    }
	
	public FarmsException(ErrorMessage errorMessage) {
		super(errorMessage.getDescription());
		this.errorMessage = errorMessage;
	}
	
	public FarmsException(Throwable cause) {
        super(cause);
    }
	
	public FarmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FarmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
	
	@Override
    public String getMessage() {
        return errorMessage.getDescription();
    }
	
	@Override
    public String toString() {
        return errorMessage.getDescription();
    }
}
