/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tacoloco.service;

import com.tacoloco.beans.DiscountPercentage;
import com.tacoloco.beans.MenuItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dev
 */
@Component
//Generic commponent we can use Service but component will do also
public class OrderMenuService {

    // a list of tacos stored in a param OrderList
    private List<MenuItem> orderList;
    private double discountPercentage;
    private double discountTotal;
    private double totalOrderPrice;
    private double discountedOrderPrice;
    private int orderSize;

    public OrderMenuService() {
        this.orderList = new ArrayList<>();
        this.totalOrderPrice = 0.0;
        this.discountedOrderPrice = 0.0;
        this.discountPercentage = 0.0;

        this.orderSize = this.orderList.size();
        this.discountTotal = this.discountPercentage * this.totalOrderPrice;
        this.discountedOrderPrice = this.totalOrderPrice = this.discountTotal;
    }

    // add an item and send the OrderMenuService object back to automate the cart 
    // avoing multiple calls to update the cart on CRUD operation
    public OrderMenuService addItem(MenuItem item) {
        if (null != orderList) {
            this.orderList.add(item);

        }
        return calculateOrderTotal();
    }

    // removing an item and send the OrderMenuService object back to automate the cart 
    // avoing multiple calls to update the cart on CRUD operation
    public OrderMenuService removeItem(MenuItem item) {
        if (null != orderList) {
            this.orderList.remove(item);

        }
        return calculateOrderTotal();
    }
    // clear items and send the OrderMenuService object back to automate the cart 
    // avoing multiple calls to update the cart on CRUD operation
    public OrderMenuService cancelOrder() {
        this.orderList = new ArrayList<>();
        this.totalOrderPrice = 0.0;
        this.discountedOrderPrice = 0.0;
        this.discountPercentage = 0.0;
        this.orderSize = this.orderList.size();
        this.discountTotal = 0.0;

        return this;
    }

    //private function that  calculate the cart total
    private OrderMenuService calculateOrderTotal() {

        double price = 0.0;

        for (MenuItem menuItem : this.orderList) {

            price += menuItem.getItemPrice();
        }

        this.totalOrderPrice = price;
        this.discountPercentage = new DiscountPercentage(this.orderList.size()).getDiscount();

        this.discountTotal = this.discountPercentage * this.totalOrderPrice;
        this.discountedOrderPrice = this.totalOrderPrice - this.discountTotal;
        this.orderSize = this.orderList.size();
        return this;
    }

    public List<MenuItem> getOrderList() {
        return orderList;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getDiscountTotal() {
        return discountTotal;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public double getDiscountedOrderPrice() {
        return discountedOrderPrice;
    }

    public void setOrderList(List<MenuItem> orderList) {
        this.orderList = orderList;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountTotal(double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public void setDiscountedOrderPrice(double discountedOrderPrice) {
        this.discountedOrderPrice = discountedOrderPrice;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

}
