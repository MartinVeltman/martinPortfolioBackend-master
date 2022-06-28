package com.martin.portfolio.controllers;

import com.martin.portfolio.models.AWSCreds;
import com.martin.portfolio.services.AWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/aws")
public class AWSController {


    @Autowired
    AWSService awsService;

    @GetMapping("/creds")
    public AWSCreds getAWSCreds() {
        return awsService.getAllAWS();
    }

    @PostMapping("/creds")
    public AWSCreds addAWSCreds(@RequestBody AWSCreds awsCreds) {
        return awsService.addAWS(awsCreds);
    }

    @DeleteMapping("/delete")
    public void deleteAWSCreds() {
        awsService.deleteAWS();
    }

}
