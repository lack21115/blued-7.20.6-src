package com.getui.gtc.base.http;

import com.anythink.expressad.foundation.g.f.g.c;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/BridgeInterceptor.class */
public class BridgeInterceptor implements Interceptor {
    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = new Request.Builder(request);
        HttpURLConnection httpURLConnection = (HttpURLConnection) request.url().openConnection();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                builder.addHeader("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                builder.addHeader("Content-Length", Long.toString(contentLength)).removeHeader("Transfer-Encoding");
            } else {
                builder.addHeader("Transfer-Encoding", DownloadUtils.VALUE_CHUNKED).removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            builder.addHeader("Host", request.url().getHost());
        }
        if (request.header("Connection") == null) {
            builder.addHeader("Connection", c.f5066c);
        }
        boolean z = false;
        if (request.header("Accept-Encoding") == null) {
            z = false;
            if (request.header("Range") == null) {
                z = true;
                builder.addHeader("Accept-Encoding", "gzip");
            }
        }
        Response proceed = ((RealInterceptorChain) chain).proceed(builder.build(), httpURLConnection);
        Response.Builder request2 = new Response.Builder(proceed).request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && proceed.body() != null) {
            request2.body(ResponseBody.create(proceed.body().contentType(), -1L, new GZIPInputStream(proceed.body().byteStream()))).removeHeader("Content-Encoding").removeHeader("Content-Length");
        }
        return request2.build();
    }
}
