package management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHUC_VU")
public class Role {
	@Id
	@Column(name = "MACV", length = 10)
	private String id;
	
	@Column(name = "TENCV",length = 100)
	private String name;
	
	@OneToMany(mappedBy = "role")
	private List<Account> accounts = new ArrayList<Account>();
}
