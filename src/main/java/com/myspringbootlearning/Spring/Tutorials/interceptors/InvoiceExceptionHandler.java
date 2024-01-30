package com.myspringbootlearning.Spring.Tutorials.interceptors;

import com.myspringbootlearning.Spring.Tutorials.exceptions.InvoiceNotFoundException;
import com.myspringbootlearning.Spring.Tutorials.models.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class InvoiceExceptionHandler {

//    @ExceptionHandler(InvoiceNotFoundException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorType> handleInvoiceNotFound(InvoiceNotFoundException ine) {
//        return new ResponseEntity<>( new ErrorType(ine.getMessage(),
//                "INVOICE_NOT_FOUND", "Data Not Found", "406"), HttpStatus.NOT_ACCEPTABLE);
//    }
}
