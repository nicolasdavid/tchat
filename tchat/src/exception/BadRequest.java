package exception;

public class BadRequest extends Exception{
        
	public BadRequest(){
		
	}
/**
 * 
 * @param message
 * 		Details about the exception
 */
	public BadRequest(String message){
		super(message);
	}
/**
 * 
 * @param cause
 * 		Cause of the Exception
 */
	public BadRequest(Throwable cause){
		super(cause);
	}
/**
 * 
 * @param message
 * 		Details about the exception
 * @param cause
 * 		Cause of the Exception
 */
	public BadRequest(String message, Throwable cause){
		super(message, cause);
	}
}