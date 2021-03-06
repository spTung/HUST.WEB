package hust.soict.hedspi.aims.media;

public abstract class Media {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		if (ID != other.ID)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
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
