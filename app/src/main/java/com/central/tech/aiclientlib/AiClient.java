package com.central.tech.aiclientlib;

import android.support.annotation.NonNull;
import okhttp3.Request;
import java.io.IOException;

/**
 * Created by mrdevxus on 2/9/18.
 */

//@Keep
public class AiClient {

    public static Request signRequestV4(@NonNull Request request,
                                        @NonNull AiClientConfigs configs) throws IOException {

        return AWSSignerHelpers.signV4(request, configs);
    }

    public static AWSInterceptor AWSSigningRequestV4Interceptor(@NonNull AiClientConfigs configs) {
        return new AWSInterceptor(configs);
    }
}
