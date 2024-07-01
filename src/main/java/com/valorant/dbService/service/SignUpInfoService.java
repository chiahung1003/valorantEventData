package com.valorant.dbService.service;

import com.valorant.dbService.entity.SignUpInfo;
import com.valorant.dbService.repository.SignUpInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author KenLi
 * @date 2023-07-31
 */
@Service
public class SignUpInfoService {

    private SignUpInfoRepository signUpInfoRepository;

    @Autowired
    public void setSignUpInfoRepository(SignUpInfoRepository signUpInfoRepository) {
        this.signUpInfoRepository = signUpInfoRepository;
    }

    public boolean isExistById(String uid) {
        return signUpInfoRepository.existsByUid(uid);
    }

    public void save(SignUpInfo signUpInfo) {
        signUpInfoRepository.save(signUpInfo);
    }

}
