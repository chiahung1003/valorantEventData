package com.valorant.dbService.repository;

import com.valorant.dbService.entity.SignUpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SignUpInfoRepository extends JpaRepository<SignUpInfo, Long>, JpaSpecificationExecutor<SignUpInfo> {

    boolean existsByUid(String uid);
}