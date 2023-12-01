package com.getui.gtc.base.http;

import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/LoggerInterceptor.class */
public class LoggerInterceptor implements Interceptor {
    public static final int BASIC = 1;
    public static final int BODY = 4;
    static final int FLAG_UNSET = -1;
    public static final int HEADER = 2;
    private final int flags;
    private final Logger logger;

    public LoggerInterceptor(Logger logger) {
        this(logger, 5);
    }

    public LoggerInterceptor(Logger logger, int i) {
        this.logger = logger;
        this.flags = i;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Map<String, List<String>> headers;
        Map<String, String> headers2;
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        int logFlags = request.logFlags();
        if (logFlags == -1) {
            logFlags = this.flags;
        }
        StringBuilder sb = new StringBuilder();
        int i = logFlags & 1;
        if (i == 1) {
            sb.append(request.method() + " " + request.url().toString() + " " + request.tag() + "\n");
        }
        int i2 = logFlags & 2;
        if (i2 == 2 && (headers2 = request.headers()) != null && headers2.size() > 0) {
            for (Map.Entry<String, String> entry : headers2.entrySet()) {
                sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
        int i3 = logFlags & 4;
        if (i3 == 4 && request.body() != null && request.body().contentType().charset() != null) {
            if (request.body().contentLength() > 2147483647L) {
                sb.append("request body content length: " + request.body().contentLength() + "\n");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                request.body().writeTo(byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new String(byteArray, request.body().contentType().charset()) + "\n");
                newBuilder.body(RequestBody.create(request.body().contentType(), byteArray));
            }
        }
        this.logger.d(sb.toString());
        Response proceed = chain.proceed(newBuilder.build());
        Response.Builder newBuilder2 = proceed.newBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (i == 1) {
            sb2.append(proceed.code() + " " + proceed.message() + " " + request.url().toString() + " " + request.tag() + "\n");
        }
        if (i2 == 2 && (headers = proceed.headers()) != null && headers.size() > 0) {
            for (Map.Entry<String, List<String>> entry2 : headers.entrySet()) {
                if (entry2.getValue() != null && entry2.getValue().size() > 0) {
                    StringBuilder sb3 = new StringBuilder();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= entry2.getValue().size()) {
                            break;
                        }
                        sb3.append(entry2.getValue().get(i5));
                        if (i5 < entry2.getValue().size() - 1) {
                            sb3.append("; ");
                        }
                        i4 = i5 + 1;
                    }
                    sb2.append(entry2.getKey() + ": " + sb3.toString() + "\n");
                }
            }
        }
        if (i3 == 4 && proceed.body() != null && proceed.body().contentType().charset() != null) {
            if (proceed.body().contentLength() > 2147483647L) {
                sb2.append("response body content length: " + proceed.body().contentLength() + "\n");
            } else {
                byte[] bytes = proceed.body().bytes();
                sb2.append(new String(bytes, proceed.body().charset()) + "\n");
                newBuilder2.body(ResponseBody.create(proceed.body().contentType(), bytes));
            }
        }
        this.logger.d(sb2.toString());
        return newBuilder2.build();
    }
}
