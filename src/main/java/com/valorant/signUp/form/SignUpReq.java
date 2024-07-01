package com.valorant.signUp.form;

import lombok.Data;

/**
 * @author KenLi
 * @date 2023-07-31
 */
@Data
public class SignUpReq {
    private String uid;

    private String name;

    private String phone;

    private String custId;

    private String email;

    private String birthday;

    private String address;

    private String riotId;
}
