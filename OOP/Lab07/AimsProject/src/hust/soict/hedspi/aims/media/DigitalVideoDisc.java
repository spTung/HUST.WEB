package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {   
    public DigitalVideoDisc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(int ID, int length,  String title, String category, String director, float cost) {
		super(ID, length, director, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public boolean search(String title) {
    	String[] split_title = title.split(" "); //tach
    	for(String t : split_title) {
    		if(!this.title.contains(t)) // kiem tra neu title khong chua t tra ve false
    			return  false;
    	}
    	return true;
    }
	
	@Override
	public void print() {
		System.out.println("DVD : "  + this.getID() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() +
						" - " + this.getLength() + " - " + this.getCost());
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
