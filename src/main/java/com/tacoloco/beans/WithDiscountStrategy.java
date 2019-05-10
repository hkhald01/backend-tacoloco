package com.tacoloco.beans;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * @author Heikel Khaldi
 *
 *   implemetation of the discount strategy to return 20%
 */
@JsonSerialize
public class WithDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount() {
       return 0.2;
    }
}
