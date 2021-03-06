package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Disc(int ID, int length, String director, String title, String category, float cost) {
		super(ID,title,category,cost);
		this.length = length;
		this.director = director;
	}
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public void print() {
    	System.out.println("Disc: " + this.getID() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost());
    }
}
