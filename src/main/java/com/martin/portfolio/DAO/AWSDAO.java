package com.martin.portfolio.DAO;

import com.martin.portfolio.models.AWSCreds;
import com.martin.portfolio.repository.AWSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AWSDAO {

    @Autowired
    AWSRepository awsRepository;

    public AWSCreds getAllAWS() {
        return awsRepository.findAll().get(0);
    }

    public AWSCreds addAWS(AWSCreds awsCreds) {
        return awsRepository.save(awsCreds);
    }

    public void deleteAWS() {
        awsRepository.deleteAll();
    }
}
