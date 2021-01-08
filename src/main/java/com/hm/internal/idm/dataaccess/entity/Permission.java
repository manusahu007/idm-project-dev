package com.hm.internal.idm.dataaccess.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Table(name = "PERMISSION")
@Entity
public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5220217551871879903L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "FEATURE")
	private String feature;
	@Column(name = "STATUS")
	private Character status;
	@Column(name = "TYPE")
	private Boolean type;
	@Column(name = "CREATE_DATE")
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATE_DATE")
    private Timestamp updatedAt;
	 
    
    
    @JsonBackReference
    @ManyToMany(mappedBy = "permissions" , fetch = FetchType.LAZY ,targetEntity = Role.class,cascade = CascadeType.ALL)
    private Set<Role> roles;
	//private Role role;
	 
	
	public Long getId() {
		return id;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", description=" + description + ", feature=" + feature
				+ ", status=" + status + ", type=" + type + "]";
	}

	

		
	
	

}
