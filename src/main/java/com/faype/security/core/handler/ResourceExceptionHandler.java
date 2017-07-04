package com.faype.security.core.handler;

import com.faype.security.core.domain.ErrorDetails;
import com.faype.security.core.exception.DomainExistenceException;
import com.faype.security.core.exception.DomainNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wmfsystem
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    
    @ExceptionHandler(DomainNotFoundException.class)
    public ResponseEntity<ErrorDetails>
            handleDomainNotFoundException(DomainNotFoundException e,
                    HttpServletRequest request) {
        ErrorDetails erro = new ErrorDetails();
        erro.setStatus(404l);
        erro.setTitle(e.getMessage());
        erro.setDeveloperMessage(e.getMessage());
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DomainExistenceException.class)
    public ResponseEntity<ErrorDetails> handleDomainExistenceException(DomainExistenceException e, HttpServletRequest request) {

        ErrorDetails erro = new ErrorDetails();
        erro.setStatus(409l);
        erro.setTitle("Domain has exists | Domínio já existe!");
        erro.setDeveloperMessage(e.getMessage());
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDetails> handleDataIntegrityException(DataIntegrityViolationException e, HttpServletRequest request) {

        ErrorDetails erro = new ErrorDetails();
        erro.setTitle("Invalid Request | Requisição Inválida!");
        erro.setStatus(400l);
        erro.setDeveloperMessage("http://erros.wmfsystem.com/400");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}