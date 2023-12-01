package com.tencent.qcloud.core.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpLoggingInterceptor.class */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpLoggingInterceptor$Level.class */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpLoggingInterceptor$Logger.class */
    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger.1
            @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
            public void logException(Exception exc, String str) {
                Platform.e().a(4, str, (Throwable) null);
            }

            @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
            public void logRequest(String str) {
                Platform.e().a(4, str, (Throwable) null);
            }

            @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
            public void logResponse(Response response, String str) {
                Platform.e().a(4, str, (Throwable) null);
            }
        };

        void logException(Exception exc, String str);

        void logRequest(String str);

        void logResponse(Response response, String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        Connection connection = chain.connection();
        OkHttpLoggingUtils.logRequest(request, connection != null ? connection.protocol() : Protocol.HTTP_1_1, level, this.logger);
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            OkHttpLoggingUtils.logResponse(proceed, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime), level, this.logger);
            return proceed;
        } catch (Exception e) {
            Logger logger = this.logger;
            logger.logException(e, "<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level != null) {
            this.level = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }
}
