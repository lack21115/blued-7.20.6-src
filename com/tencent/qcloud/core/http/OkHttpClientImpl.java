package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.http.HttpLoggingInterceptor;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.http.interceptor.HttpMetricsInterceptor;
import com.tencent.qcloud.core.http.interceptor.RetryInterceptor;
import com.tencent.qcloud.core.http.interceptor.TrafficControlInterceptor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/OkHttpClientImpl.class */
public class OkHttpClientImpl extends NetworkClient {
    private EventListener.Factory mEventListenerFactory = new EventListener.Factory() { // from class: com.tencent.qcloud.core.http.OkHttpClientImpl.1
        public EventListener create(Call call) {
            return new CallMetricsListener(call);
        }
    };
    private OkHttpClient okHttpClient;

    @Override // com.tencent.qcloud.core.http.NetworkClient
    public NetworkProxy getNetworkProxy() {
        return new OkHttpProxy(this.okHttpClient);
    }

    @Override // com.tencent.qcloud.core.http.NetworkClient
    public void init(QCloudHttpClient.Builder builder, HostnameVerifier hostnameVerifier, Dns dns, HttpLogger httpLogger) {
        super.init(builder, hostnameVerifier, dns, httpLogger);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(httpLogger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        this.okHttpClient = builder.mBuilder.followRedirects(true).followSslRedirects(true).hostnameVerifier(hostnameVerifier).dns(dns).connectTimeout(builder.connectionTimeout, TimeUnit.MILLISECONDS).readTimeout(builder.socketTimeout, TimeUnit.MILLISECONDS).writeTimeout(builder.socketTimeout, TimeUnit.MILLISECONDS).eventListenerFactory(this.mEventListenerFactory).addNetworkInterceptor(new HttpMetricsInterceptor()).addInterceptor(httpLoggingInterceptor).addInterceptor(new RetryInterceptor(builder.retryStrategy)).addInterceptor(new TrafficControlInterceptor()).build();
    }
}
