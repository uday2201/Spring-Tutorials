package com.myspringbootlearning.Spring.Tutorials.controller;

import com.myspringbootlearning.Spring.Tutorials.exceptions.InvoiceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;
import java.util.Random;
@RestController
public class InvoiceController  {

    @GetMapping("/getInvoice")
    public String getInvoice() {
        if(new Random().nextInt(10)>5)
            throw new InvoiceNotFoundException("Invoice Not Found!");
        return "showInvoice";
    }
//
//    @Autowired
//    private ErrorAttributes errorAttributes;

//    @RequestMapping("/error")
//    public @ResponseBody Map<String, Object> handleError(HttpServletRequest req)
//    {
//        ServletWebRequest webRequest = new ServletWebRequest(req);
//        Map<String, Object> errors = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of());
//        errors.put("Format Of Error", "JSON");
//        return errors;
//    }

}
