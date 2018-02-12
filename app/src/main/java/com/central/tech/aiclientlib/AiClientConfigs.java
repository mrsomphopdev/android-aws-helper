package com.central.tech.aiclientlib;

/**
 * Created by mrdevxus on 2/9/18.
 */

public class AiClientConfigs {

    private String accessKey;
    private String secretKey;
    private String apiKey;
    private String serviceName = "execute-api";
    private String region = "ap-southeast-1";

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getRegion() {
        return region;
    }

    public AiClientConfigs(String accessKey, String secretKey, String apiKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.apiKey = apiKey;
    }

    public AiClientConfigs(String accessKey, String secretKey, String apiKey,
                           String serviceName, String region) {

        this(accessKey, secretKey, apiKey);
        this.serviceName = serviceName;
        this.region = region;
    }
}
