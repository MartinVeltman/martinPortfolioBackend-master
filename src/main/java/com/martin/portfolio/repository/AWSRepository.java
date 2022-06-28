package com.martin.portfolio.repository;

import com.martin.portfolio.models.AWSCreds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AWSRepository extends JpaRepository<AWSCreds, Long> {

}
