package management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SAN_PHAM")
public class Product {
	@Id
	@Column(name = "MASP", length = 10)
	private String id;
	
	@Column(name = "TENSP", length = 10)
	private String name;
	
	@Column(name = "KICHTHUOC", length = 10)
	private String size;
	
	@Column(name = "GIA")
	private Double price;
	
	@Column(name = "HINHANH", length = 10)
	private String image;
	
	@Column(name = "MAUSAC", length = 10)
	private String color;
	
	@Column(name = "HANG", length = 100)
	private String branch;
	
	@Column(name = "THOIGIANBH", length = 10)
	private Date warrantyPeriod;
	
	@Column(name = "THOIGIANTRAHANG", length = 10)
	private Date deliveryTime;
	
	@OneToOne(mappedBy = "product")
	private Seri seri;
	
	@ManyToOne
	@JoinColumn(name = "MADM")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<DetailsPromotion> detailsPromotions; 
	
	@OneToMany(mappedBy = "product")
	private List<DetailsUpdatePrice> detailsUpdatePrices = new ArrayList<DetailsUpdatePrice>();

	public Product() {
		super();
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(Date warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Seri getSeri() {
		return seri;
	}

	public void setSeri(Seri seri) {
		this.seri = seri;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<DetailsPromotion> getDetailsPromotions() {
		return detailsPromotions;
	}

	public void setDetailsPromotions(Set<DetailsPromotion> detailsPromotions) {
		this.detailsPromotions = detailsPromotions;
	}

	public List<DetailsUpdatePrice> getDetailsUpdatePrices() {
		return detailsUpdatePrices;
	}

	public void setDetailsUpdatePrices(List<DetailsUpdatePrice> detailsUpdatePrices) {
		this.detailsUpdatePrices = detailsUpdatePrices;
	}
	
	
}
