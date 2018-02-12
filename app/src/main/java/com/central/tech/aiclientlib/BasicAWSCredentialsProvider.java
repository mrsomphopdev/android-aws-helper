package com.central.tech.aiclientlib;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

/**
 * Created by mrdevxus on 2/9/18.
 */

public class BasicAWSCredentialsProvider implements AWSCredentialsProvider {

    private String accessKey;
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public BasicAWSCredentialsProvider(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public AWSCredentials getCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    @Override
    public void refresh() {

    }


}
