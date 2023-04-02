package management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIET_GIOHANG")
public class DetailsCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Customer customer;
	

	@ManyToOne
	private DetailsUpdatePrice detailsUpdatePrice; 
	
	@Column(name = "SOLUONG")
	private Integer quantity;
	
	@Column(name = "TRANGTHAI")
	private boolean status;
	
	@OneToMany(mappedBy = "detailsCart")
	private List<DetailsBill> detailsBills = new ArrayList<DetailsBill>();
	
}
