package management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CT_CAPNHAT_GIA")
public class DetailsUpdatePrice {
	@EmbeddedId
	private DetailsUpdatePricePK id;

	@Column(name = "GIA")
	private Double price;
	
	@MapsId("productId")
	@ManyToOne
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "MANV")
	private Staff staff;
	
	@OneToMany(mappedBy = "detailsUpdatePrice")
	private List<DetailsCart> detailsCarts = new ArrayList<DetailsCart>();
}
