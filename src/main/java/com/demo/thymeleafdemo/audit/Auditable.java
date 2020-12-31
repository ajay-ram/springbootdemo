package com.demo.thymeleafdemo.audit;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<Type> {

    @CreatedBy
    @Column(name="created_by")
    protected Type createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="created_date")
    protected Date createdDate;

    @LastModifiedBy
    @Column(name="modified_by")
    protected Type lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name="modified_date")
    protected Date lastModifiedDate;

    public Type getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Type createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Type getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Type lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}