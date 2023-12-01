package com.zx.a.I8b7;

import com.zx.a.I8b7.e1;
import com.zx.a.I8b7.g0;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/g.class */
public class g implements g0 {
    @Override // com.zx.a.I8b7.g0
    public e1 a(g0.a aVar) throws IOException {
        v0 v0Var = (v0) aVar;
        b1 b1Var = v0Var.f28526c;
        HttpURLConnection httpURLConnection = v0Var.d;
        if (httpURLConnection.getDoOutput() && b1Var.d != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            c1 c1Var = (c1) b1Var.d;
            outputStream.write(c1Var.f28420c, c1Var.d, c1Var.b);
            l1.a(outputStream);
        }
        int responseCode = httpURLConnection.getResponseCode();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        n0 b = n0.b("text/json; charset=utf-8");
        if (httpURLConnection.getContentType() != null) {
            b = n0.b(httpURLConnection.getContentType());
        }
        String responseMessage = httpURLConnection.getResponseMessage();
        e1.a aVar2 = new e1.a();
        aVar2.b = responseCode;
        aVar2.d = new HashMap(headerFields);
        aVar2.f28432c = responseMessage;
        aVar2.e = f1.a(b, httpURLConnection.getContentLength(), responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
        aVar2.f28431a = b1Var;
        return aVar2.a();
    }
}
