package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }
	
	public Track() {
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Track) {
    		Track a = (Track)obj;
    		if(!title.equals(a.getTitle())) return false;
    		if(this.length != a.length) return false;
    		return true;
    	}
    	return false;
    }

	public void play() throws PlayerException {
		
		if(this.getLength() <= 0) {
			System.err.println("ERROR: Track length is 0");
			throw(new PlayerException());
		}
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
}
