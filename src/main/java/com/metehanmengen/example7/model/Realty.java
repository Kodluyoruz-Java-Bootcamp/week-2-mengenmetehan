package src.main.java.com.metehanmengen.example7.model;

import java.time.LocalDateTime;

public class Realty {
	
	private Long no;
	private String title;
	private LocalDateTime publishedDate;
	private User user;
	private RealtyAccountType status;

	private RealtyType type;
	private ProvinceNames province = ProvinceNames.ISTANBUL;
	private String district;

	/*
	Default olarak ilan satılık, kiralık değil. Değiştirilebilir.
	Ayrıca hem satılık hem kiralık olabilir diye böyle yapıldı.
	 */
	private boolean isSale = true;
	private boolean isRental = false;
	
	public Realty() {
		super();
	}
	
	public Realty(Long no, String title, LocalDateTime publishedDate,
				  User user, RealtyAccountType status, RealtyType type) {
		super();
		this.no = no;
		this.title = title;
		this.publishedDate = publishedDate;
		this.user = user;
		this.status = status;
		this.type = type;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public RealtyAccountType getStatus() {
		return status;
	}

	public void setStatus(RealtyAccountType status) {
		this.status = status;
	}


	public ProvinceNames getProvince() {
		return province;
	}

	public void setProvince(ProvinceNames province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public RealtyType getType() {
		return type;
	}

	public void setType(RealtyType type) {
		this.type = type;
	}

	public boolean isSale() {
		return isSale;
	}

	public void setSale(boolean sale) {
		isSale = sale;
	}

	public boolean isRental() {
		return isRental;
	}

	public void setRental(boolean rental) {
		isRental = rental;
	}

	@Override
	public String toString() {
		return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate + ", user=" + user
				+ ", status=" + getStatus() + ", province=" + province + "]";
	}


}
