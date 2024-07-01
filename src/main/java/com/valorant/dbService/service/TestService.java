package com.valorant.dbService.service;

import com.valorant.dbService.entity.Test;
import com.valorant.dbService.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KenLi
 * @date 2023-07-07
 */
@Service
public class TestService {
    private TestRepository testRepository;

    @Autowired
    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }
}
