package br.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "factories")
@Entity
public class Factories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(mappedBy = "factories_id", cascade = CascadeType.ALL) 
	private List<Cars> cars;

	@Column(name = "name")
	private String name;

	@Column(name = "docName")
	private String docName;

	@Column(name = "country_code")
	private String country_code;

	@Lob
	@Column(name = "content")
	private byte[] content;

	public void getName() {
		// TODO Auto-generated method stub
		
	}

	public void setDocName(String fileName) {
		// TODO Auto-generated method stub
		
	}

	public void setId(long id2) {
		// TODO Auto-generated method stub
		
	}

}
