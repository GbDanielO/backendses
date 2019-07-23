package br.com.ses.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ EntidadeNaoEncontradaException.class })

    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException( EntidadeNaoEncontradaException ex ) {

        return ResponseEntity.badRequest().body( ex.getMessage() );
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable( HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request ) {

        return handleExceptionInternal( ex, ex.getMessage(), headers, HttpStatus.BAD_REQUEST, request );
    }

}
