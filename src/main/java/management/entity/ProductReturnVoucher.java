package management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHIEU_TRA")
public class ProductReturnVoucher {
	@Id
	@Column(name = "MAPT",length = 10)
	private String id;
	
	@Column(name = "NGAYTRA")
	private Date productReturnDate;
	
	@Column(name = "TRANGTHAI")
	private boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAPD",referencedColumnName = "MAPD")
	private ProductExchangeVoucher productExchangeVoucher;
	
	@ManyToMany(mappedBy = "returnVouchers")
	private List<Seri> seris = new ArrayList<Seri>();
	
	@ManyToOne
	@JoinColumn(name = "MASHIP")
	private Ship ship;
}
