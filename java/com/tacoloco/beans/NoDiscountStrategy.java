
package com.tacoloco.beans;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * @author Heikel Khaldi
 *
 *   implemetation of the discount strategy to return 0 %
 */
@JsonSerialize
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount() {
       return 0.0;
    }

}
