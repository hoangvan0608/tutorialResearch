package com.example.tutorial.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseModel implements Serializable {
    private Long insertId;
    @CreatedDate
    private Timestamp insertTime;
    private Long updateId;
    private Timestamp updateTime;
}
