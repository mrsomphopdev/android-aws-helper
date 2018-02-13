package com.central.tech.aiclientlib;

import android.support.annotation.NonNull;
import okhttp3.*;
import java.io.IOException;

/**
 * Created by mrdevxus on 2/13/18.
 */

public class AWSInterceptor implements Interceptor {
    @NonNull
    private final AiClientConfigs configs;


    public AWSInterceptor(@NonNull AiClientConfigs configs) {
        this.configs = configs;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request signedRequest = AiClient.signRequestV4(chain.request(),configs);
        return chain.proceed(signedRequest);
    }
}