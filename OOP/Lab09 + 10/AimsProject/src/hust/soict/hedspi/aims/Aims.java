package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.order.*;
import hust.soict.hedspi.aims.media.*;

import java.util.Scanner;

import javax.naming.LimitExceededException;

public class Aims {
	
	public static void chooseType() {
		System.out.println("Choose type of item: ");
        System.out.println("1. Book");
        System.out.println("2. CompactDisc");
        System.out.println("3. DigitalVideoDisc");
        System.out.println("Please choose a number: 1-2-3");      
	}
	
	public static Media getInfo() {
		int type;
		String temp;
		String tempTitle, tempCategory, tempAuthor, tempArtist, tempDirector;
		int tempId, tempLength = 0;
		float tempCost;
		Scanner keyboard = new Scanner(System.in);
		chooseType();
		type = keyboard.nextInt();
		switch (type) {
		case 1:
			Book newBook = new Book();
			
			System.out.println("Enter B'ID : ");
			tempId = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter B'title : ");
			tempTitle = keyboard.nextLine();
			System.out.println("Enter B'category : ");
			tempCategory = keyboard.nextLine();
			System.out.println("Enter B'cost : ");
			tempCost = keyboard.nextFloat();
			keyboard.nextLine();
			System.out.println("Enter B'author'name : ");
			tempAuthor = keyboard.nextLine();
			newBook.addAuthor(tempAuthor);
			
			newBook = new Book(tempId, tempTitle, tempCategory, tempCost);
			
			return newBook;	
		case 2:
			CompactDisc newCD = new CompactDisc();
			
			System.out.println("Enter CD'ID : ");
			tempId = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter CD'title : ");
			tempTitle = keyboard.nextLine();
			System.out.println("Enter CD'category : ");
			tempCategory = keyboard.nextLine();
			System.out.println("Enter CD'director : ");
			tempDirector = keyboard.nextLine();
			System.out.println("Enter CD'cost : ");
			tempCost = keyboard.nextFloat();
			keyboard.nextLine();
			System.out.println("Enter CD'artist'name : ");
			tempArtist = keyboard.nextLine();
			
			newCD = new CompactDisc(tempId, tempArtist, tempLength, tempTitle, tempCategory, tempDirector, tempCost);
			
			//add
			
			do {
				System.out.println("Do you want to add Track(y/n) ?");
				temp = keyboard.nextLine();
				if(temp.equals("y") || temp.equals("Y")) {
					Track track = new Track();
					System.out.println("Track title : ");
					tempTitle = keyboard.nextLine();
					System.out.println("Track length : ");
					tempLength = keyboard.nextInt();
					keyboard.nextLine();
					track = new Track(tempTitle,tempLength);
					newCD.addTrack(track);
				} else {
					break;
				}
				
			} while (true);
			
			//play
			
			System.out.println("Do you want to play this CD(y/s) : ");
			temp = keyboard.nextLine();
			if(temp.equals("y") || temp.equals("Y")) {
				try {
					newCD.play();
				} catch (PlayerException e) {
					e.printStackTrace();
				}
			}
				
			return newCD;
		case 3:
			DigitalVideoDisc newDVD = new DigitalVideoDisc();
			
			System.out.println("Enter DVD'ID : ");
			tempId = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter DVD'title : ");
			tempTitle = keyboard.nextLine();
			System.out.println("Enter DVD'category : ");
			tempCategory = keyboard.nextLine();
			System.out.println("Enter DVD'director : ");
			tempDirector = keyboard.nextLine();
			System.out.println("Enter DVD'length : ");
			tempLength = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter DVD'cost : ");
			tempCost = keyboard.nextFloat();
			keyboard.nextLine();
			
			newDVD = new DigitalVideoDisc(tempId, tempLength, tempTitle, tempCategory, tempDirector, tempCost);
			
			//play
			
			System.out.println("Do you want to play this DVD(y/s) : ");
			temp = keyboard.nextLine();
			if(temp.equals("y") || temp.equals("Y")) {
				try {
					newDVD.play();
				} catch (PlayerException e) {
					e.printStackTrace();
				}			
			}
			
			return newDVD;
		default:
			return null;
		}
	}
		
    public static void main(String[] args) throws Exception {
        Order myOrder = null;
        int select;
        int id;
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
                		Media media = getInfo();
                		if(media != null) {
                			myOrder.addMedia(media);
                		} else {
                			System.out.println("Can't add!");
                		}
                	} catch (Exception e) {
                		System.out.println("Order not exist!");
                	}
                    break;
                case 3:
                	try {
                		System.out.println("Enter ID :");
                		id = sc.nextInt();
                		myOrder.removeMedia(id);
                	} catch (Exception e) {
                		System.out.println("Order not exist!");
                	}
                    break;
                case 4:
                	try{
                		myOrder.printOrder();
                	} catch (Exception e) {
                		System.out.println("Order not exist!");
                	}
                    break;
                default:
                    break;
            }
            System.out.println("");
        } while(select != 0);
    }
}

