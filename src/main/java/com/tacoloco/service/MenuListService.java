
package com.tacoloco.service;

import com.tacoloco.beans.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Heikel Khaldi
 */
@Repository
// we are faking a service call from a DB layer we should implemet a Jpa or Crud Repository
public  class MenuListService{

    private static List<MenuItem> menu = new ArrayList<>();

    static {
        menu.add(new MenuItem(1L, "Veggie Taco","Guaccamole, Lettuce, tomato and sourcream", 2.50,"veggie.jpg"));
        menu.add(new MenuItem(2L, "Chicken Taco","Chicken, Lettuce,cilantro, tomato and mild sauce",3.00,"chicken.jpg"));
        menu.add(new MenuItem(3L, "Beef Taco","Beef, Lettuce,cilantro, tomato and mild sauce", 3.00,"beef.jpg"));
        menu.add(new MenuItem(4L, "Chorizo Taco","Chorizo, Lettuce, tomato and sourcream", 3.50,"chorizo.jpg"));
    }
    // faking the findAll() interface method usually used with implementing
    //JpaRepository or any type or Repsoitory
    public List<MenuItem> findAll(){
        return menu;
    };
    
    //faking the save method
    public void save(MenuItem item){
       menu.add(item);
      
    }
    //faking the delete method
    // using an iterator to be able to remove an item for a list
    public void delete(Long id){
       Iterator it = menu.iterator();
       while(it.hasNext()){
           MenuItem item = (MenuItem) it.next();
           if(id==item.getItemId()){
             it.remove();
            }
       }
    }
    //faking the findOne method
    public MenuItem findById(Long id){
        
        for(MenuItem item: menu){
            if(id==item.getItemId()){
                return item;
            }
        }
        return null;
        
    }
}
