package com.qssi_wms.ephs.shared.common.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class UserEntity {

	@Id
    @Column(name="user_id", unique=true, nullable=false, length=10)
    private String userId;
	
	@Column(name = "password")
    private String password;
    
    @Transient
    private String name;
	
	
}
