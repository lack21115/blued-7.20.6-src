package com.getui.gtc.base.http;

import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Response;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/CallServerInterceptor.class */
public class CallServerInterceptor implements Interceptor {
    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpURLConnection connection = chain.connection();
        if (connection.getDoOutput() && request.body() != null) {
            OutputStream outputStream = connection.getOutputStream();
            request.body().writeTo(outputStream);
            Util.closeQuietly(outputStream);
        }
        int responseCode = connection.getResponseCode();
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        MediaType parse = MediaType.parse("text/json; charset=utf-8");
        if (connection.getContentType() != null) {
            parse = MediaType.parse(connection.getContentType());
        }
        return new Response.Builder().code(responseCode).headers(headerFields).message(connection.getResponseMessage()).body(ResponseBody.create(parse, connection.getContentLength(), responseCode == 200 ? connection.getInputStream() : connection.getErrorStream())).request(request).build();
    }
}
