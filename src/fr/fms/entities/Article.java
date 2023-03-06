package fr.fms.entities;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Entité
 */

public class Article {
	private int Id;
	private String Description;
	private String Brand;
	private Double Price;

	public Article(int Id, String Description, String Brand, Double Price) {		
		this.Id = Id;
		this.Description = Description;
		this.Brand = Brand;
		this.Price = Price;
	}
	
	public Article(String Description, String Brand, Double Price) {		
		this.Description = Description;
		this.Brand = Brand;
		this.Price = Price;
	}
	
	public Article(int Id) {		
		this.Id = Id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return Brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		Brand = brand;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return Price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		Price = price;
	}
}