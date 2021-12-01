package com.comp.store.exception.handler;

import com.comp.store.exception.AbstractInvalidDataException;
import com.comp.store.exception.ConvertingException;
import com.comp.store.exception.InvalidEntityDataException;
import com.comp.store.exception.NoSuchEntityException;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String bodyOfResponse;

    @ExceptionHandler(value = {ConstraintViolationException.class, DataIntegrityViolationException.class})
    public RedirectView handleMyException(HttpServletRequest request,
                                          HttpServletResponse response) throws IOException {
        RedirectView rw = new RedirectView("/errorPage");
        rw.setStatusCode(HttpStatus.MOVED_PERMANENTLY); // you might not need this
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        outputFlashMap.put("myAttribute", true);
        return rw;
    }

    @ExceptionHandler(value = {ConvertingException.class, InvalidEntityDataException.class})
    protected ResponseEntity<Object> handleDataException(AbstractInvalidDataException ex, WebRequest request) {
        bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {NoSuchEntityException.class})
    protected ResponseEntity<Object> handleEntityException(NoSuchEntityException ex, WebRequest request) {
        bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleUnknownException(Exception ex, WebRequest request) {
        bodyOfResponse = "Unexpected error. Try again or check your entity.";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}

