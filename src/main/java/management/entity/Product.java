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

	
}
