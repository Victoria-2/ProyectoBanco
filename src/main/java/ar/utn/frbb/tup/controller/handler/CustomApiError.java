package ar.utn.frbb.tup.controller.handler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true) //no acepta cosas que no esten definidas
@JsonInclude(JsonInclude.Include.NON_NULL) //no acepta null
public class CustomApiError {
    private Integer errorCode;
    private String errorMessage;

    public CustomApiError(){}
    public CustomApiError(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public CustomApiError(String errorMessage, Integer errorCode){
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    //getters y setters
    public Integer getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
