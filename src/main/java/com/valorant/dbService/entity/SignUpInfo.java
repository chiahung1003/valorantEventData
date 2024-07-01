package com.valorant.dbService.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "sign_up_info")
public class SignUpInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sign_up_info_id", nullable = false)
    private Long signUpInfoId;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "riot_id")
    private String riotId;

    @Column(name = "create_at")
    private Date createAt;

}
