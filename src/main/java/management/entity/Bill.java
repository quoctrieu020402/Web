package management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HOA_DON")
public class Bill {
	@Id
	@Column(name = "MAHD", length = 10)
	private String id;
	
	@Column(name = "TRANGTHAI")
	private boolean status;
	
	@Column(name = "NGAYAD")
	private Date createDate;
	
	@Column(name = "NGAYTAOHOADON")
	private Date applicableDate;
	
	@ManyToOne
	@JoinColumn(name = "MASHIP")
	private Ship ship;
	
	@ManyToOne
	@JoinColumn(name = "MANV")
	private Staff staff;
	
	@OneToMany(mappedBy = "bill")
	private List<DetailsBill> detailsBills = new ArrayList<DetailsBill>();
}
