package Flight.Category;


public abstract class Category {
	
	protected String categoryName;
	protected int avaiableSeats;
	protected int price;
	
	public int getAvaiableSeats() {
		return avaiableSeats;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
