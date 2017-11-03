package br.com.claroapi.http;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Celular {
 
	private int id;
	private String code;
	private String model;
	private String price;
	private String brand;
	private String photo;
	private String data;
 
	public Celular(){
 
	}
 
	public Celular(String price, String code, String model,
			String brand, String photo, String data) {
		super();
		this.code = code;
		this.model = model;
		this.price = price;
		this.brand = brand;
		this.photo = photo;
		this.data  = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
 

}