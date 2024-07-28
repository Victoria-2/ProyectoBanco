package ar.utn.frbb.tup.controller.handler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true) //no acepta cosas que no esten definidas
@JsonInclude(JsonInclude.Include.NON_NULL) //no acepta null
public class CustomApiError {
    private Integer errorCode;
    private String errorMessage;

    public CustomApiError(){}
    public CustomApiError(String errorMessage){
        this.errorMessage = errorMessage;
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
