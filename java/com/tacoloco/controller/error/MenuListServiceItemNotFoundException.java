package com.tacoloco.controller.error;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Heikel Khaldi
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuListServiceItemNotFoundException extends RuntimeException {

    
    
    public MenuListServiceItemNotFoundException(Long id) {
        super("Menu Item is not foundL "+id);
    }
}
