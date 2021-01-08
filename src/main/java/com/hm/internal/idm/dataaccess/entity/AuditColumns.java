package com.hm.internal.idm.dataaccess.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

public class AuditColumns implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6836792941589261692L;

	@Column(name = "CREATE_DATE")
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATE_DATE")
    private Timestamp updatedAt;
}
