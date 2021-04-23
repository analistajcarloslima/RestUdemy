package br.com.jow.exception;

import java.io.Serializable;
import java.util.Date;

// Serializar um objeto signica preparar ele ( transformar em bytes) para ser enviardo ou armazenado em disco
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

}
