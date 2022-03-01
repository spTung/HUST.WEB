package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.order.*;
import hust.soict.hedspi.aims.media.*;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Order myOrder = null;
        int select;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Order Management Application: ");
            System.out.println("--------------------------------");
            System.out.println("1. Create new order");
            System.out.println("2. Add item to the order");
            System.out.println("3. Delete item by id");
            System.out.println("4. Display the items list of order");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            select = sc.nextInt();

            switch (select) {
                case 1:
                    myOrder = new Order();
                    System.out.println("Created successfully!");
                    break;
                case 2:
                    try {
                        System.out.println("Enter ID, Title, Category, Cost :");
                        Scanner sc1 = new Scanner(System.in);
                        Scanner sc2 = new Scanner(System.in);
                        Scanner sc3 = new Scanner(System.in);
                        Scanner sc4 = new Scanner(System.in);
                        int ID = sc1.nextInt();
                        String title = sc2.nextLine();
                        String category = sc3.nextLine();
                        float cost = sc4.nextLong();
                        Media itemTest = new Media(ID,title,category,cost);
                        myOrder.addMedia(itemTest);
                    } catch (Exception e) {
                          System.out.println("Somthing wrong!");
                    }
                    break;
                case 3:
                    System.out.println("Enter ID :");
                    Scanner sc5 = new Scanner(System.in);
                    int DEL_ID = sc5.nextInt();
                    if(myOrder.removeMedia(DEL_ID)) {
                    	System.out.println("Delete successfully");
                    } else {
                    	System.out.println("Something wrong!");
                    }
                    break;
                case 4:
                	System.out.println("Item Ordered : ");
                	myOrder.printItem();
                    break;
                default:
                    break;
            }
            System.out.println("");
        } while(select != 0);
    }
}