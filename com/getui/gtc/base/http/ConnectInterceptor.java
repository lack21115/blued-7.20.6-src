package com.getui.gtc.base.http;

import com.getui.gtc.base.http.Interceptor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/ConnectInterceptor.class */
public class ConnectInterceptor implements Interceptor {
    public final GtHttpClient client;

    public ConnectInterceptor(GtHttpClient gtHttpClient) {
        this.client = gtHttpClient;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = chain.request();
        HttpURLConnection connection = chain.connection();
        connection.setDoInput(true);
        connection.setDoOutput(request.body() != null);
        connection.setConnectTimeout(this.client.getConnectTimeout());
        connection.setReadTimeout(this.client.getReadTimeout());
        connection.setInstanceFollowRedirects(this.client.isFollowRedirects());
        connection.setUseCaches(this.client.isUseCache());
        if ("https".equalsIgnoreCase(request.url().getProtocol())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            if (this.client.getSslSocketFactory() != null) {
                httpsURLConnection.setSSLSocketFactory(this.client.getSslSocketFactory());
            }
            if (this.client.getHostnameVerifier() != null) {
                httpsURLConnection.setHostnameVerifier(this.client.getHostnameVerifier());
            }
        }
        Map<String, String> headers = request.headers();
        if (headers != null && headers.size() > 0) {
            for (String str : headers.keySet()) {
                connection.setRequestProperty(str, headers.get(str));
            }
        }
        connection.connect();
        return realInterceptorChain.proceed(request, connection);
    }
}
