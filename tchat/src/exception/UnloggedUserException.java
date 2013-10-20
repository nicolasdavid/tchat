package exception;

public class UnloggedUserException extends Exception{
        
	/**
	 * 
	 */
	private static final long serialVersionUID = 7787005321773070398L;
	public UnloggedUserException(){
		
	}
/**
 * 
 * @param message
 * 		Details about the exception
 */
	public UnloggedUserException(String message){
		super(message);
	}
/**
 * 
 * @param cause
 * 		Cause of the Exception
 */
	public UnloggedUserException(Throwable cause){
		super(cause);
	}
/**
 * 
 * @param message
 * 		Details about the exception
 * @param cause
 * 		Cause of the Exception
 */
	public UnloggedUserException(String message, Throwable cause){
		super(message, cause);
	}
}