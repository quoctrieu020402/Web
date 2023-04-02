package management.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIET_HOADON")
public class DetailsBill {
	@EmbeddedId
	private DetailsBillPk id;
	
	@MapsId("billId")
	@ManyToOne
	private Bill bill;
	
	@MapsId("detailsCartId")
	@ManyToOne
	private DetailsCart detailsCart;
}
