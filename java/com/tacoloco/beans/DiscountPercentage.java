package com.tacoloco.beans;

/**
 *
 * @author Heikel Khaldi
 * 
 * This is the discount evaluation at run time to determine which object to create 
 * of the DiscountStartegy type at run time 
 * 
 */
public class DiscountPercentage  {

  private double discountPercentage;
  
  
  public DiscountPercentage(int size){
      if(size<4){
          this.discountPercentage = new NoDiscountStrategy().applyDiscount();
      }else{
          this.discountPercentage = new WithDiscountStrategy().applyDiscount();
      }
  }

    public double getDiscount() {
        return discountPercentage;
    }
}
