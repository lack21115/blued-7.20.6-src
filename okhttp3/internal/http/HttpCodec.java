package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/HttpCodec.class */
public interface HttpCodec {
    Response.Builder a(boolean z) throws IOException;

    ResponseBody a(Response response) throws IOException;

    Sink a(Request request, long j);

    void a() throws IOException;

    void a(Request request) throws IOException;

    void b() throws IOException;

    void c();
}
