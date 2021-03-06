package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.utils.*;
import hust.soict.hedspi.aims.media.*;

import  java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    
    public void addMedia(Media item1, Media item2) {
    	if(itemsOrdered.size() + 2 <= MAX_NUMBERS_ORDER) {
    		addMedia(item1);
    		addMedia(item2);
    	} else {
    		System.out.println("Full!");
    	}
    }
    
    public void addMedia(ArrayList<Media> itemList) {
    	if ( itemsOrdered.size() + itemList.size() <= MAX_NUMBERS_ORDER) {
    		itemsOrdered.addAll(itemList);
    		System.out.println("Success!");
    	} else {
    		System.out.println("Full!");
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
    
    public boolean removeMedia(int itemID) {
        for (var item : itemsOrdered) {
            if (item.getID() == itemID) {
                itemsOrdered.remove(item);
                return true;
            }
        }
        return false;
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

	public void printItem() {
		for (var item : itemsOrdered) {
			System.out.println(item.getID()+ " - " + item.getTitle()+ " - " + item.getCategory() +" - "+ item.getCost());
		}
	}
    
	public Media getALuckyItem() {
	    int index = new Random().nextInt(itemsOrdered.size());
	    return itemsOrdered.get(index);
	}
}
	
//    public DigitalVideoDisc getItemlucky() {
//    	int rand_int = (int) (Math.random() * (qtyOrdered + 1));
//    	DigitalVideoDisc disc = itemOrdered[rand_int];
//    	System.out.println(disc.getTitle() + " - " +disc.getCategory() + " - " +disc.getDirector() +" - "+ disc.getLength() + " - " +  disc.getCost() );
//    	for ( int i = rand_int ; i < qtyOrdered ; i++) {
//    		itemOrdered[i] = itemOrdered[i+1]; 
//    	}
//    	--qtyOrdered;
//    	return disc;
