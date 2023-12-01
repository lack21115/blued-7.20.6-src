package okhttp3.internal.http;

import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/BridgeInterceptor.class */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.a = cookieJar;
    }

    private String a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i2);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
            i = i2 + 1;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.a(request.url(), false));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        boolean z = false;
        if (request.header("Accept-Encoding") == null) {
            z = false;
            if (request.header("Range") == null) {
                z = true;
                newBuilder.header("Accept-Encoding", Constants.CP_GZIP);
            }
        }
        List<Cookie> loadForRequest = this.a.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", a(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.a());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.a(this.a, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && Constants.CP_GZIP.equalsIgnoreCase(proceed.header("Content-Encoding")) && HttpHeaders.d(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(proceed.header("Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
