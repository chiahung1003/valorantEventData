package com.valorant.signUp.controller;

import com.valorant.dbService.entity.SignUpInfo;
import com.valorant.dbService.service.SignUpInfoService;
import com.valorant.signUp.form.SignUpReq;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.EncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author KenLi
 * @date 2023-07-31
 */
@RestController
public class SignUpController {

    private SignUpInfoService signUpInfoService;

    @Autowired
    public void setSignUpInfoService(SignUpInfoService signUpInfoService) {
        this.signUpInfoService = signUpInfoService;
    }

    @GetMapping("api/v1/user/exist/{uid}")
    public boolean isExistById(@PathVariable String uid) throws EncodingException {
        String id = ESAPI.encoder().encodeForURL(uid);
        return signUpInfoService.isExistById(id);
    }


    @PostMapping("api/v1/user/signUp")
    public void signUp(@RequestBody SignUpReq signUpReq) throws ParseException {
        String uid = ESAPI.encoder().decodeFromJSON(signUpReq.getUid());
        String name = ESAPI.encoder().decodeFromJSON(signUpReq.getName());
        String custId = ESAPI.encoder().decodeFromJSON(signUpReq.getCustId());
        String phone = ESAPI.encoder().decodeFromJSON(signUpReq.getPhone());
        String email = ESAPI.encoder().decodeFromJSON(signUpReq.getEmail());
        String birthday = ESAPI.encoder().decodeFromJSON(signUpReq.getBirthday());
        String address = ESAPI.encoder().decodeFromJSON(signUpReq.getAddress());
        String riotId = ESAPI.encoder().decodeFromJSON(signUpReq.getRiotId());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Taipei"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthday);

        SignUpInfo signUpInfo = new SignUpInfo();
        signUpInfo.setUid(uid);
        signUpInfo.setName(name);
        signUpInfo.setCustId(custId);
        signUpInfo.setPhone(phone);
        signUpInfo.setEmail(email);
        signUpInfo.setBirthday(birthdayDate);
        signUpInfo.setAddress(address);
        signUpInfo.setRiotId(riotId);
        signUpInfo.setCreateAt(Date.from(zonedDateTime.toInstant()));

        signUpInfoService.save(signUpInfo);
    }
}
