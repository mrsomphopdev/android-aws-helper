package com.central.tech.aiclientlib;

import android.support.annotation.NonNull;
import android.util.Log;

import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

/**
 * Created by mrdevxus on 2/9/18.
 */

class AWSHttpRequestHelpers {

    @NonNull
    static HttpUrl setEndpoint(Request.Builder builder, DefaultRequest awsRequest, HttpUrl url) {
        HttpUrl canonicalUrl = ensureTrailingSlash(builder, url);
        awsRequest.setEndpoint(canonicalUrl.uri());

        return canonicalUrl;
    }

    static void setQueryParams(@NonNull DefaultRequest awsRequest, @NonNull HttpUrl url) {
        for (String paramName : url.queryParameterNames()) {
            awsRequest.addParameter(paramName, url.queryParameter(paramName));
        }
    }

    static void setHttpMethod(@NonNull DefaultRequest awsRequest, @NonNull String method) {
        HttpMethodName methodName = HttpMethodName.valueOf(method);
        awsRequest.setHttpMethod(methodName);
    }

    static void setBody(@NonNull DefaultRequest awsRequest, @NonNull RequestBody body) throws IOException {
        if (body == null) {
            return;
        }
        Buffer buffer = new Buffer();
        body.writeTo(buffer);
        awsRequest.setContent(new ByteArrayInputStream(buffer.readByteArray()));
        awsRequest.addHeader("Content-Length", String.valueOf(body.contentLength()));
        buffer.close();
    }

    static void applyAwsHeaders(@NonNull Request.Builder builder, @NonNull Map<String, String> headers) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            Log.d("applyAwsHeaders",header.getKey() + header.getValue());
            builder.header(header.getKey(), header.getValue());
        }
    }

    @NonNull
    private static HttpUrl ensureTrailingSlash(@NonNull Request.Builder builder, @NonNull HttpUrl url) {
        String lastPathSegment = url.pathSegments().get(url.pathSize() - 1);
        if (!lastPathSegment.isEmpty()) {
            url = url.newBuilder().addPathSegment("").build();
            builder.url(url);
        }

        return url;
    }
}