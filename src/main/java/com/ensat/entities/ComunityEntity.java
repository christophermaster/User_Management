package com.ensat.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "COMUNITY")
public class ComunityEntity implements Serializable{
	
	private static final long serialVersionUID = -5703889625848068724L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "COM_ID", length=30)
	private Integer id;
	
	@Column(name = "COM_NAME", length=30)
	private String nameComunity;
	
	@Column(name = "COM_TYPE", length=20)
	private String typeComunity;
	

	@OneToMany(mappedBy = "comunityEntity", cascade = CascadeType.ALL)  
	private List<OwnerEntity> ownerlist = new ArrayList<>();
	

	public ComunityEntity() {
		
	}
	
	

	public ComunityEntity(Integer id, String nameComunity, String typeComunity) {
		super();
		this.id = id;
		this.nameComunity = nameComunity;
		this.typeComunity = typeComunity;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameComunity() {
		return nameComunity;
	}

	public void setNameComunity(String nameComunity) {
		this.nameComunity = nameComunity;
	}

	public String getTypeComunity() {
		return typeComunity;
	}

	public void setTypeComunity(String typeComunity) {
		this.typeComunity = typeComunity;
	}



	public List<OwnerEntity> getOwnerlist() {
		return ownerlist;
	}



	public void setOwnerlist(List<OwnerEntity> ownerlist) {
		this.ownerlist = ownerlist;
	}
	
	

}
