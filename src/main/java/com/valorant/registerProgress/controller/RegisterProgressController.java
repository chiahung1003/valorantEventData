package com.valorant.registerProgress.controller;

import com.valorant.dbService.entity.RegisterProgress;
import com.valorant.dbService.service.RegisterProgressService;
import com.valorant.registerProgress.from.RegisterProgressRsp;
import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KenLi
 * @date 2023-07-25
 */
@RestController
public class RegisterProgressController {

    private RegisterProgressService registerProgressService;

    @Autowired
    public void setRegisterProgressService(RegisterProgressService registerProgressService) {
        this.registerProgressService = registerProgressService;
    }

    @GetMapping("api/v1/admin/registerProgress")
    public List<RegisterProgressRsp> getRegisterProgress() {
        List<RegisterProgress> registerProgressList = registerProgressService.findAll();
        List<RegisterProgressRsp> registerProgressRspList = new ArrayList<>();

        for (RegisterProgress registerProgress : registerProgressList) {
            RegisterProgressRsp registerProgressRsp = new RegisterProgressRsp();
            registerProgressRsp.setArea(ESAPI.encoder().encodeForJSON(registerProgress.getArea()));
            registerProgressRsp.setCount(ESAPI.encoder().encodeForJSON(String.valueOf(registerProgress.getCount())));
            registerProgressRspList.add(registerProgressRsp);
        }

        return registerProgressRspList;
    }
}
