package com.tacoloco.beans;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author Heikel Khaldi
 * 
 * interface to use the Strategy Design Pattern to determine the discount percentage
 */
@JsonSerialize
public interface DiscountStrategy {
      public double applyDiscount();
}
