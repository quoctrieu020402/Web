package management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NHAN_VIEN")
public class Staff {
	@Id
	@Column(name = "MANV", length = 10)
	private String id;
	
	@Column(name = "HO", length = 50)
	private String surname;
	
	@Column(name = "TEN", length = 50)
	private String name;
	
	@Column(name = "STD", length = 10)
	private String phoneNumber;
	
	@Column(name = "GIOITINH", length = 10)
	private String gender;
	
	@Column(name = "DIACHI", length = 1000)
	private String address;
	
	@Column(name = "ANH", length = 500)
	private String image;
	
	@Column(name = "NGAYSINH")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date dateOfBirth;
	
	@OneToOne
	@JoinColumn(name = "EMAIL")
	private Account account;
	
	@OneToMany(mappedBy = "staff")
	private List<Promotion> promotions = new ArrayList<Promotion>();
	
	@OneToMany(mappedBy = "staff")
	private List<ProductExchangeVoucher> exchangeVouchers = new ArrayList<ProductExchangeVoucher>();

	@OneToMany(mappedBy = "staff")
	private List<Warranty> warranties = new ArrayList<Warranty>();
	
	@OneToMany(mappedBy = "staff")
	private List<Bill> bills = new ArrayList<Bill>();
	
	@OneToMany(mappedBy = "staff")
	private List<DetailsUpdatePrice> detailsUpdatePrices = new ArrayList<DetailsUpdatePrice>();
}
