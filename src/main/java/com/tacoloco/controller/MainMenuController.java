package com.tacoloco.controller;

import com.tacoloco.beans.MenuItem;
import com.tacoloco.service.MenuListService;
import com.tacoloco.service.OrderMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Heikel Khaldi
 */
// to allow calls from different servers
@CrossOrigin(origins = "*", allowedHeaders = "*")
// to send  a json response to the caller
@RestController
public class MainMenuController {

    @Autowired
    // create a lose coupling known as Dependency Injection
    private MenuListService menuService;
   
    @Autowired
     // create a lose coupling known as Dependency Injection
    private OrderMenuService orderMenuService;

    @GetMapping(value = "/menu")
    // rest call to send all items of the menu to choose from
    public List<MenuItem> getMenu() {
        return this.menuService.findAll();
    }
    
    //method to add an item to the Order using a post method, a json object is sent from the UI
    //to the service using the @RequestBody, the response is the object OrderMenuService
    @PostMapping(value = "/addItemOrder")
    public @ResponseBody OrderMenuService addItem(@RequestBody MenuItem item) {
        
        return this.orderMenuService.addItem(item);
    }
    //method to remove an item to the Order using a post method, a json object is sent from the UI
    //to the service using the @RequestBody, the response is the object OrderMenuService
    @PostMapping(value = "/removeItemOrder")
    public  OrderMenuService removeItem(@RequestBody MenuItem item) {
        return this.orderMenuService.removeItem(item);
    }
    //method to clear/cancel an item to the Order using a post method, a json object is sent from the UI
    //to the service 
    @DeleteMapping(value = "/cancelOrder")
    public OrderMenuService cancelOrder() {
        return this.orderMenuService.cancelOrder();
    }
    
    
    /******** Methods that are not required for the application but for demonstration */
    
    //method just for purpose of demonstration not needed for the actual implementation
    //we pass the id of the item we can try it using postman client
    //get method
    @GetMapping(value = "/menu/{id}")
    public MenuItem retreiveMenuItem(@PathVariable Long id){
       
        return  this.menuService.findById(id);
    }
    //method just for purpose of demonstration not needed for the actual implementation
    //we pass the new menu Item to the DB layer  (no db in our case just a static list of items
    //item we can try it using postman client
    @PostMapping(value="/menu/addmenu")
    public void addMenuItem(@RequestBody MenuItem item) {
        this.menuService.save(item);
    }
    //method just for purpose of demonstration not needed for the actual implementation
    //we pass the new menu Item to the DB layer  (no db in our case just a static list of items
    //itemId we can try it using postman client
    @DeleteMapping(value="/menu/removemenu/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        this.menuService.delete(id);
    }
}
