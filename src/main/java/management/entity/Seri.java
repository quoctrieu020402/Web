package management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SOSERI")
public class Seri {
	@Id
	@Column(name = "SOSERI")
	private String id;
	
	@Column(name = "GIANHAP")
	private Double importPrice;
	
	@Column(name = "TRANGTHAI")
	private boolean status;
	
	@Column(name = "NGAYBAN")
	private Date saleDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MASP",referencedColumnName = "MASP")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "MAPN")
	private Receipt receipt;
	
	@OneToMany(mappedBy = "seri")
	private List<Warranty> warranties = new ArrayList<Warranty>();
	
	@OneToMany(mappedBy = "seri")
	private Set<DetailsReturnVoucher> detailsReturnVouchers; 
	
	@OneToMany(mappedBy = "seri")
	private Set<DetailsExchangeVoucher> detailsExchangeVouchers;

}
