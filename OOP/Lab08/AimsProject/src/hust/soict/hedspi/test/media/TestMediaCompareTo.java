package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.*;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		
        Collection<Media> collection = new ArrayList<>();
		
		CompactDisc cd1 = new CompactDisc(1,"TuanPeter","Sieu nhan gao","Sieu nhan","Hang phim phuong nam",(float) 1.0);
		cd1.addTrack(new Track("sieu nhan do",15));
		cd1.addTrack(new Track("Sieu nhan vang", 20));
		collection.add(cd1);
		CompactDisc cd2 = new CompactDisc(2,"PeterTuan","Sieu nhan cuong phong","Sieu nhan","Hang phim phuong nam",(float) 2.0);
		cd2.addTrack(new Track("sieu nhan den",11));
		cd2.addTrack(new Track("Sieu nhan trang", 28));	
		cd2.addTrack(new Track("Sieu nhan nau", 55));
		collection.add(cd2);
		CompactDisc cd3 = new CompactDisc(3,"KillTuanPerter","Sieu nhan sam set","Sieu nhan","Hang phim phuong nam",(float) 3.0);
		cd3.addTrack(new Track("sieu nhan bac",30));
//		DigitalVideoDisc dvd = new DigitalVideoDisc(4,40,"Sieu nhan nhen","Sieu nhan","Hang phim phuong nam",(float) 4.0);		
		collection.add(cd3);
//		collection.add(dvd);
		
		java.util.Iterator iterator = collection.iterator();
		System.out.println("---------------------------------");
		System.out.println("The Media currently in the order are: ");
		
		while (iterator.hasNext()) {
			
			System.out.println("Play track: " + ((CompactDisc)iterator.next()).getTitle());
		} 
		
        Collections.sort((List)collection);
		iterator = collection.iterator();
		
		System.out.println("----------------------------------");
		System.out.println("Media in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((CompactDisc)iterator.next()).getTitle());
		}
		System.out.println("-----------------------------------");
		
		
	}

}
