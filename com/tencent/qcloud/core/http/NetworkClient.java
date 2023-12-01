package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.task.RetryStrategy;
import javax.net.ssl.HostnameVerifier;
import okhttp3.Dns;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/NetworkClient.class */
public abstract class NetworkClient {
    protected Dns dns;
    protected boolean enableDebugLog;
    protected HttpLogger httpLogger;
    protected RetryStrategy retryStrategy;

    public abstract NetworkProxy getNetworkProxy();

    public void init(QCloudHttpClient.Builder builder, HostnameVerifier hostnameVerifier, Dns dns, HttpLogger httpLogger) {
        this.retryStrategy = builder.retryStrategy;
        this.httpLogger = httpLogger;
        this.enableDebugLog = builder.enableDebugLog;
        this.dns = dns;
    }
}
