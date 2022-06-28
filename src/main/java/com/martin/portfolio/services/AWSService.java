package com.martin.portfolio.services;

import com.martin.portfolio.DAO.AWSDAO;
import com.martin.portfolio.models.AWSCreds;
import org.springframework.stereotype.Service;

@Service
public class AWSService {

    private final AWSDAO awsDAO;

    public AWSService(AWSDAO awsDAO) {
        this.awsDAO = awsDAO;
    }

    public AWSCreds getAllAWS() {
        return awsDAO.getAllAWS();
    }

    public AWSCreds addAWS(AWSCreds awsCreds) {
        return awsDAO.addAWS(awsCreds);
    }

    public void deleteAWS() {
        awsDAO.deleteAWS();
    }

}
