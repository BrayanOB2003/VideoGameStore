package model;

public class Game {
	private double price;
	private String indentifier;
	private int quantity;
	
	public Game(double p, String id, int q) {
		price = p;
		indentifier = id;
		quantity = q;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIndentifier() {
		return indentifier;
	}

	public void setIndentifier(String indentifier) {
		this.indentifier = indentifier;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
