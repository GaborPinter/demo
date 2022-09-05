package com.example.demo;

import java.time.LocalDate;

public class Voucher {

	private String id;
	
	private String name;
	private String discount;
	private LocalDate date;
	private int usable;
	
	public Voucher() {
	}
	
	public Voucher(String id, String name, String discount, LocalDate date, int usable) {
		super();
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.date = date;
		this.usable = usable;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getUsable() {
		return usable;
	}

	public void setUsable(int usable) {
		this.usable = usable;
	}

	@Override
	public String toString() {
		return "Voucher [id=" + id + ", name=" + name + ", discount=" + discount + ", date=" + date
				+ ", usable=" + usable + "]";
	}
}

