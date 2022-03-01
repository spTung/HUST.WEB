package hust.soict.hedspi.aims.media;

import java.util.Objects;

public abstract class Media implements Comparable{
	protected int ID;
	protected String title;
	protected String category;
	protected float cost;
	
	public Media() {
	}
	
	public Media(int ID, String title, String category, float cost) {
		super();
		this.ID = ID;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Media) {
    		Media a = (Media)obj;
    		if(this.title.equals(a.title)) return true;
    	}
    	return false;
    }
	
    @Override
    public int compareTo(Object obj) {
        return this.title.compareTo(((Media)obj).title);
    }

	public int getID() {
        return ID;
    }
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public float getCost() {
		return cost;
	}	
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public abstract void print();

}
