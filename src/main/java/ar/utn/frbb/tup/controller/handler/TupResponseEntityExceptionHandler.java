package ar.utn.frbb.tup.controller.handler;

import ar.utn.frbb.tup.model.exception.ClienteAlreadyExistsException;
import ar.utn.frbb.tup.model.exception.PrestamoNoOtorgadoException;
import ar.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class TupResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {TipoCuentaAlreadyExistsException.class, IllegalArgumentException.class})
    protected  ResponseEntity<Object> handleMateriaNotFound(Exception ex, WebRequest request){
        CustomApiError error = new CustomApiError(ex.getMessage());
        return  handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {IllegalStateException.class, PrestamosNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
        CustomApiError error = new CustomApiError(ex.getMessage());
        error.setErrorCode(1234);
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }

    @ExceptionHandler(value = {ClienteAlreadyExistsException.class})
    protected ResponseEntity<Object> handleValidatorAlta(Exception ex, WebRequest request){
        CustomApiError error = new CustomApiError(ex.getMessage(), 409);
        return  handleExceptionInternal(ex,error,new HttpHeaders(),HttpStatus.CONFLICT ,request);
    }

    @ExceptionHandler(value = {PrestamoNoOtorgadoException.class})
    protected ResponseEntity<Object> handlePrestamoError(Exception ex, WebRequest request){
        String exceptionMessage = ex.getMessage();
        CustomApiError error = new CustomApiError();
        error.setErrorCode(564);
        error.setErrorMessage(exceptionMessage);
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        if(body == null){
            body = new CustomApiError(ex.getMessage());
        }
        return new ResponseEntity<>(body, headers, status);
    }


}
