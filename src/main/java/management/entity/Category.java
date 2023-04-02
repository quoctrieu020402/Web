package management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DANH_MUC")
public class Category {
	@Id
	@Column(name = "MADM", length = 10)
	private String id;
	
	@Column(name = "TENDM", length = 250)
	private String name;
	
	@Column(name = "TRANGTHAI")
	private boolean status;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<Product>();
}
