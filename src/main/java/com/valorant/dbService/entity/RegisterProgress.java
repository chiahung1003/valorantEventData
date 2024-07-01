package com.valorant.dbService.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "register_progress")
public class RegisterProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "register_progress_id", nullable = false)
    private Long registerProgressId;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "count", nullable = false)
    private Long count;

}
