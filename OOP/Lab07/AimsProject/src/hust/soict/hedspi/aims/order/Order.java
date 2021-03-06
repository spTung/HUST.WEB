package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.utils.*;
import hust.soict.hedspi.aims.media.*;

import  java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBERS_ORDER = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    public static int nbOrders = 0;
    MyDate dateOrdered;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Order(){
        if( nbOrders < MAX_LIMITED_ORDERS)
        {
            nbOrders += 1;
            dateOrdered = new MyDate();
        }
        else
        {
            System.out.println("Maxinum limit!");
        }
    }

    public String getDateOrdered(){
        return dateOrdered.getDay() + "-" + dateOrdered.getMonth() + "-" + dateOrdered.getYear();
    }
    
    public void addMedia(Media item) {
    	if( itemsOrdered.size() == MAX_NUMBERS_ORDER) {
    		System.out.print("Full");
    	}else {
    		itemsOrdered.add(item);
    		System.out.println("Success!");
    	}
    	
    }
              
    public void removeMedia(Media item) {
    	if(itemsOrdered.size() <= 0) {
    		System.out.println("Empty!");
    	} else {
    		for( int i = 0 ; i < itemsOrdered.size() ; i++) {
    			if(itemsOrdered.get(i) == item) {
    				itemsOrdered.remove(i);
    			}
    		}
    	}
    }
    
    public void removeMedia(int id) {
    	if(itemsOrdered.size() <= 0) {
            System.out.println("Empty!");
            return;
        }
        if(id < itemsOrdered.size())
                itemsOrdered.remove(id);
    }
        
	public float totalCost() {
		float total = 0;
		Media mediaItem;
		java.util.Iterator iter = itemsOrdered.iterator();
		while(iter.hasNext()) {
			mediaItem = (Media) (iter.next());
			total += mediaItem.getCost();
		}
		return total;
	}
   
	public Media getALuckyItem() {
	    int index = new Random().nextInt(itemsOrdered.size());
	    return itemsOrdered.get(index);
	}	
	
    public void printOrder(){
        System.out.println("*************************Order*************************");
        System.out.println("Date : " + getDateOrdered());
        System.out.println("Ordered items :");
        for ( int i = 0 ; i < itemsOrdered.size() ; i++)
        {
        	System.out.printf("%d: ",i+1); 
			itemsOrdered.get(i).print();
        }
        System.out.println("Total cost : " + totalCost());
        System.out.println("******************************************************");
    }
}