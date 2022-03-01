package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
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

	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
}
