package ec.cart.model;

public class Product {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product(int id, String name, Double price, String image, String category) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	private String name;
	private double price;
	private String image;
	private String category;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ image + "]";
	}

}
