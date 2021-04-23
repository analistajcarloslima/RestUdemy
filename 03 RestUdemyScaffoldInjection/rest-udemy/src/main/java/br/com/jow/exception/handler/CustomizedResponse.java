package br.com.jow.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jow.exception.ExceptionResponse;
import br.com.jow.exception.UnsuportedMathOperation;

@RestController
@RestControllerAdvice
public class CustomizedResponse extends ResponseEntityExceptionHandler {
    //ESSE METODO vai retornar yum erro de alguma exception no java
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//ESSE METODO vai retornar yum erro de bad request caso de erro na classe unsuportedOperation
    @ExceptionHandler(UnsuportedMathOperation.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
