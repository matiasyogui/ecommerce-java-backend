package com.myogui.ecommercejava.handle;

import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.exceptions.Error;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductErrorHandle {
    Logger log = LogManager.getLogger(ProductErrorHandle.class);

    @ResponseBody
    @ExceptionHandler(ApiRestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Error messageErrorHandle(ApiRestException ex) {
        log.error(ex);
        return Error.of(ex.getMessage());
    }
}
