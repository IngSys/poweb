package pe.org.pub.eess.poe.util;

public class MEFTransactionException extends Exception {
	 
	/**
	 * 
	 */
    private static final long serialVersionUID = 1084333472983905120L;
	
	private String errMsg;
	private Exception exception;
 
	 
	public String getErrMsg() {
		return errMsg;
	}
 
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
 
	public MEFTransactionException(String errMsg, Exception ex) {
		this.errMsg = errMsg;
		this.exception = ex;
	}
	
	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
}
