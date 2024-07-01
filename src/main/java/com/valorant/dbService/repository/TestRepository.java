package com.valorant.dbService.repository;

import com.valorant.dbService.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface TestRepository extends JpaRepository<Test, Long>, JpaSpecificationExecutor<Test> {

}