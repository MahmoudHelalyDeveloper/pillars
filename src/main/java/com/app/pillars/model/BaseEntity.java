package com.app.pillars.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Configurable(preConstruction = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public  class BaseEntity {


    @CreatedBy
    @Column(updatable = false)
    private Integer createdBy;
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;


    @LastModifiedBy
    @Column(insertable = false )

    private Integer updatedBy;

    @LastModifiedDate
    @Column(insertable = false )
    private Date updatedDate;




}