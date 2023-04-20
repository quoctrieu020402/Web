package management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailsBillPk implements Serializable{

	private Long detailsCartId;
	
	private String billId;

}
