package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private static ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(int ID ,String artist, int length, String title, String category, String director, float cost) {
		super(ID, length, director, title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Track exists!");
		} else {
			tracks.add(track);
			System.out.println("Success!");
		}
	}
		
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Delete successfully!");
		} else {
			System.out.println("Track not exists");
		}
	}
	
	public int getLength() {
		int len = 0;
		for (var t : tracks) {
			 len += t.getLength(); 
		}
		return len;
	}	
	
	@Override
	public void print() {
		System.out.println("CD :" + this.getID() + " - " + this.getTitle() + " - " + this.getCategory() + " - " +
							this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + " - " + this.getArtist());
	}
				
	@Override
	public void play() {
		System.out.println("Tittle: " + this.getTitle());
		System.out.println("Artist: " + this.getArtist());
		System.out.println("Length: " + this.getLength());
		if(tracks.isEmpty()) {
			System.out.println("tracks run out!");
		} else {
			for ( var i : tracks) {
				i.play();
			}
		}
	}
}
