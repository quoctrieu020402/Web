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
@Table(name = "KHACH_HANG")
public class Customer {
	@Id
	@Column(name = "MAKH", length = 10)
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
	
	@OneToMany(mappedBy = "customer")
	private List<ProductExchangeVoucher> exchangeVouchers = new ArrayList<ProductExchangeVoucher>();
	
	@OneToMany(mappedBy = "customer")
	private List<DetailsCart> detailsCarts = new ArrayList<DetailsCart>();
}
