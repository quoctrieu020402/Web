package management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAI_KHOAN")
public class Account {
	@Id
	@Column(name = "EMAIL", length = 500)
	private String email;
	
	@Column(name = "MATKHAU", length = 60)
	private String password;
	
	@Column(name = "TRANHTHAI")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "MACV")
	private Role role;
	
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	@OneToOne(mappedBy = "account")
	private Staff staff;
	
	
}
