package com.tencent.qcloud.core.http;

import android.net.wifi.WifiEnterpriseConfig;
import com.tencent.qcloud.core.http.HttpLoggingInterceptor;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/OkHttpLoggingUtils.class */
public class OkHttpLoggingUtils {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private static boolean bodyEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase(WifiEnterpriseConfig.IDENTITY_KEY)) ? false : true;
    }

    private static boolean isContentLengthTooLarge(long j) {
        return j > 2048;
    }

    private static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 16) {
                    return true;
                }
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
                i = i2 + 1;
            }
        } catch (EOFException e) {
            return false;
        }
    }

    public static void logMessage(String str, HttpLoggingInterceptor.Logger logger) {
        logger.logRequest(str);
    }

    public static void logQuicRequestHeaders(Map<String, String> map, HttpLoggingInterceptor.Logger logger) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            logger.logRequest(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void logRequest(Request request, Protocol protocol, HttpLoggingInterceptor.Level level, HttpLoggingInterceptor.Logger logger) throws IOException {
        boolean z = true;
        boolean z2 = level == HttpLoggingInterceptor.Level.BODY;
        boolean z3 = z2 || level == HttpLoggingInterceptor.Level.HEADERS;
        RequestBody body = request.body();
        if (body == null) {
            z = false;
        }
        String str = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
        String str2 = str;
        if (!z3) {
            str2 = str;
            if (z) {
                str2 = str + " (" + body.contentLength() + "-byte body)";
            }
        }
        logger.logRequest(str2);
        if (z3) {
            if (z) {
                if (body.contentType() != null) {
                    logger.logRequest("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    logger.logRequest("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                String name = headers.name(i2);
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    logger.logRequest(name + ": " + headers.value(i2));
                }
                i = i2 + 1;
            }
            if (!z2 || !z || isContentLengthTooLarge(body.contentLength())) {
                logger.logRequest("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
                logger.logRequest("--> END " + request.method() + " (encoded body omitted)");
            } else {
                try {
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    Charset charset = UTF8;
                    MediaType contentType = body.contentType();
                    if (contentType != null) {
                        charset = contentType.charset(UTF8);
                    }
                    logger.logRequest("");
                    if (!isPlaintext(buffer)) {
                        logger.logRequest("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                        return;
                    }
                    logger.logRequest(buffer.readString(charset));
                    logger.logRequest("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } catch (Exception e) {
                    logger.logRequest("--> END " + request.method());
                }
            }
        }
    }

    public static void logResponse(Response response, long j, HttpLoggingInterceptor.Level level, HttpLoggingInterceptor.Logger logger) {
        String str;
        String str2;
        Headers headers;
        boolean z = true;
        boolean z2 = level == HttpLoggingInterceptor.Level.BODY;
        boolean z3 = z2 || level == HttpLoggingInterceptor.Level.HEADERS;
        ResponseBody body = response.body();
        if (body == null) {
            z = false;
        }
        long contentLength = z ? body.contentLength() : 0L;
        if (contentLength != -1) {
            str = contentLength + "-byte";
        } else {
            str = "unknown-length";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<-- ");
        sb.append(response.code());
        sb.append(' ');
        sb.append(response.message());
        sb.append(' ');
        sb.append(response.request().url());
        sb.append(" (");
        sb.append(j);
        sb.append("ms");
        if (z3) {
            str2 = "";
        } else {
            str2 = ", " + str + " body";
        }
        sb.append(str2);
        sb.append(')');
        logger.logResponse(response, sb.toString());
        if (z3) {
            int size = response.headers().size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                logger.logResponse(response, headers.name(i2) + ": " + headers.value(i2));
                i = i2 + 1;
            }
            if (!z2 || !HttpHeaders.d(response) || !z || isContentLengthTooLarge(contentLength)) {
                logger.logResponse(response, "<-- END HTTP");
            } else if (bodyEncoded(response.headers())) {
                logger.logResponse(response, "<-- END HTTP (encoded body omitted)");
            } else {
                try {
                    BufferedSource source = body.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer = source.buffer();
                    Charset charset = UTF8;
                    MediaType contentType = body.contentType();
                    if (contentType != null) {
                        try {
                            charset = contentType.charset(UTF8);
                        } catch (UnsupportedCharsetException e) {
                            logger.logResponse(response, "");
                            logger.logResponse(response, "Couldn't decode the response body; charset is likely malformed.");
                            logger.logResponse(response, "<-- END HTTP");
                            return;
                        }
                    }
                    if (!isPlaintext(buffer)) {
                        logger.logResponse(response, "");
                        logger.logResponse(response, "<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
                        return;
                    }
                    if (contentLength != 0) {
                        logger.logResponse(response, "");
                        logger.logResponse(response, buffer.clone().readString(charset));
                    }
                    logger.logResponse(response, "<-- END HTTP (" + buffer.size() + "-byte body)");
                } catch (Exception e2) {
                    logger.logResponse(response, "<-- END HTTP");
                }
            }
        }
    }
}
