package br.com.jow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Essa classe irá retornar a mensagem de erro personalizada
//é necessário adiconar a notação de retorno para Bad Request

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperation  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UnsuportedMathOperation (String exception){
        super(exception);
    }
}
