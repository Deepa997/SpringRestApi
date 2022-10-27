package com.appsdevoloperblog.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appsdevoloperblog.app.ws.ui.model.response.Errormessage;

@ControllerAdvice
public class Exceptionhandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class })

	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		String Errormessage = ex.getLocalizedMessage();
		if (Errormessage == null)
			Errormessage = ex.toString();
		Errormessage em = new Errormessage(new Date(), Errormessage);
		return new ResponseEntity<>(em, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

		@ExceptionHandler(value = { NullPointerException.class,UserserviceException.class })
		
		public ResponseEntity<Object> handlespecificException(Exception ex, WebRequest request) {
			String Errormessage=ex.getLocalizedMessage();
			if(Errormessage==null)Errormessage=ex.toString();
			Errormessage em=new Errormessage(new Date(),Errormessage);
			return new ResponseEntity<>(em, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}


}
