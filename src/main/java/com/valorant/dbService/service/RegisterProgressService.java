package com.valorant.dbService.service;

import com.valorant.dbService.entity.RegisterProgress;
import com.valorant.dbService.repository.RegisterProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KenLi
 * @date 2023-07-25
 */
@Service
public class RegisterProgressService {
    private RegisterProgressRepository registerProgressRepository;

    @Autowired
    public void setRegisterProgressRepository(RegisterProgressRepository registerProgressRepository) {
        this.registerProgressRepository = registerProgressRepository;
    }

    public List<RegisterProgress> findAll() {
        return registerProgressRepository.findAll();
    }

    public RegisterProgress findByArea(String area) {
        return registerProgressRepository.findByArea(area);
    }

    public void saveAll(List<RegisterProgress> registerProgressList) {
        registerProgressRepository.saveAll(registerProgressList);
    }
}
