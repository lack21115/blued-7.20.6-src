package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudServiceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpResponse.class */
public final class HttpResponse<T> {
    final HttpRequest<T> request;
    final Response response;

    public HttpResponse(HttpRequest<T> httpRequest, Response response) {
        this.request = httpRequest;
        this.response = response;
    }

    public static void checkResponseSuccessful(HttpResponse httpResponse) throws QCloudServiceException {
        if (httpResponse == null) {
            throw new QCloudServiceException("response is null");
        }
        if (httpResponse.isSuccessful()) {
            return;
        }
        QCloudServiceException qCloudServiceException = new QCloudServiceException(httpResponse.message());
        qCloudServiceException.setStatusCode(httpResponse.code());
        throw qCloudServiceException;
    }

    public final InputStream byteStream() {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body().byteStream();
    }

    public final byte[] bytes() throws IOException {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body().bytes();
    }

    public int code() {
        return this.response.code();
    }

    public final long contentLength() {
        if (this.response.body() == null) {
            return 0L;
        }
        return this.response.body().contentLength();
    }

    public String header(String str) {
        return this.response.header(str);
    }

    public Map<String, List<String>> headers() {
        return this.response.headers().toMultimap();
    }

    public final boolean isSuccessful() {
        Response response = this.response;
        return response != null && response.isSuccessful();
    }

    public String message() {
        return this.response.message();
    }

    public HttpRequest<T> request() {
        return this.request;
    }

    public final String string() throws IOException {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body().string();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "http code = %d, http message = %s %nheader is %s", Integer.valueOf(code()), message(), this.response.headers().toMultimap());
    }
}
