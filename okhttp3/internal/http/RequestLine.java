package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/RequestLine.class */
public final class RequestLine {
    private RequestLine() {
    }

    public static String a(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        String str = encodedPath;
        if (encodedQuery != null) {
            str = encodedPath + '?' + encodedQuery;
        }
        return str;
    }

    public static String a(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        if (b(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(a(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }
}
