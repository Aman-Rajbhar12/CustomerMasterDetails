package daynilgroupcustomerdetail.globalexception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import daynilgroupcustomerdetail.validationexception.ApiError;
import daynilgroupcustomerdetail.validationexception.ApiValidationError;
import daynilgroupcustomerdetail.validationexception.RequestValidationException;

@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object>handleIdNotFoundException(IdNotFoundException exception){
		Response response = new Response();
		response.setMessage("Id Not Founde");
		ResponseEntity<Object> entity =new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity; 
	}
	
	@ExceptionHandler(DataNotFoundInDatabase.class)
	public ResponseEntity<Object>handleDataNotFoundException(DataNotFoundInDatabase exception){
		Response response = new Response();
		response.setMessage("Data NotFound In Database");
		ResponseEntity<Object> entity =new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(NameNotFound.class)
	public ResponseEntity<Object>handleNameNotFoundException(NameNotFound exception){
		Response response = new Response();
		response.setMessage("Name Not Found");
		ResponseEntity<Object> entity =new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	


	@ExceptionHandler(RequestValidationException.class)
	public final ResponseEntity<Object> validationEx(RequestValidationException ex, final WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());    
		ex.printStackTrace();
		apiError.setSubErrors(new ArrayList<>());
		for (FieldError fe : ex.getErrorFields()) {
			apiError.getSubErrors()
					.add(ApiValidationError.builder().field(fe.getField()).message(fe.getDefaultMessage())
							.object(fe.getObjectName()).rejectedValue(fe.getRejectedValue()).build());
		}
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
