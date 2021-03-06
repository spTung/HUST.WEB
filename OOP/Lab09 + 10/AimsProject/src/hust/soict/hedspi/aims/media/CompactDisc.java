package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private static List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(int ID ,String artist, int length, String title, String category, String director, float cost) {
		super(ID, length, director, title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(int ID ,String artist, String title, String category, String director, float cost) {
		super(ID, director, title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	
	public String getArtist() {
		return artist;
	}
	
    public void setArtist(String artist) {
        this.artist = artist;
    }
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Track exists!");
		} else {
			tracks.add(track);
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
	
    @Override
    public int getLength() {
        int len = 0;
        return tracks.stream().map(track -> track.getLength()).reduce(len, (x, y) -> x + y);
    }
	
	@Override
    public int compareTo(Object obj) {
    	int trackCheck = Integer.valueOf(this.tracks.size()).compareTo(((CompactDisc)obj).tracks.size()); //ss num
    	if(trackCheck != 0) return trackCheck;
    	else return Integer.valueOf(this.getLength()).compareTo(((CompactDisc)obj).getLength()); // ss leng
    }
	
	@Override
	public void print() {
		System.out.println("CD :" + this.getID() + " - " + this.getTitle() + " - " + this.getCategory() + " - " +
							this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + " - " + this.getArtist());
	}
				
	@Override
	public void play() throws PlayerException {
		if(this.getLength() <= 0) {
			System.err.println("ERROR: CD length is 0");
			throw (new PlayerException());
		}
		
		System.out.println("Playing CD: " +  this.getTitle());
		System.out.println("CD length: " + this.getLength());
		
		java.util.Iterator iter = tracks.iterator();
		Track nextTrack;
		
		while(iter.hasNext()) {
			nextTrack = (Track) iter.next();
			try {
				nextTrack.play();
			} catch (PlayerException e) {
				e.printStackTrace();
			}
		}
	}
}
