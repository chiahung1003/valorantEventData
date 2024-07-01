package com.valorant.dbService.repository;

import com.valorant.dbService.entity.RegisterProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegisterProgressRepository extends JpaRepository<RegisterProgress, Long>, JpaSpecificationExecutor<RegisterProgress> {

    RegisterProgress findByArea(String area);
}