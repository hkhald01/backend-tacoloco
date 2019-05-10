package com.tacoloco.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Heikel Khaldi
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuListServiceItemNotFoundException  extends RuntimeException{


}
