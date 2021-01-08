package com.hm.internal.idm.dataaccess.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ROLE")
public class Role {

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    
   
	@Column(name = "STATUS")
    private Character status;
    @Column(name = "ENTERPRISE_CODE")
    private String enterpriseCode;
    @Column(name = "CREATE_DATE")
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATE_DATE")
    private Timestamp updatedAt;
    
    
  
    @ManyToMany(cascade = CascadeType.PERSIST, targetEntity = Permission.class,fetch = FetchType.EAGER )
    @JoinTable(name = "role_permissions", joinColumns = {@JoinColumn(name = " role_id")}, inverseJoinColumns = {@JoinColumn(name = " permission_id")})
	private Set<Permission> permissions;
    

    public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Long getId() {
		return id;
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
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", enterpriseCode=" + enterpriseCode + "]";
	}
	
	
	
	
    
	
}

