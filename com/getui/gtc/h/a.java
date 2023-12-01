package com.getui.gtc.h;

import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.crypt.GtRASCryptoInterceptor;
import com.getui.gtc.base.util.io.IOUtils;
import com.getui.gtc.server.ServerManager;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/h/a.class */
public final class a {
    public static void a(String str, int i) throws Exception {
        while (true) {
            String server = ServerManager.getServer("gtc.bs");
            try {
                Request.Builder cryptInterceptor = new Request.Builder().url(String.format("%s/api.php?format=json&t=1", server)).method("POST").body(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), b(str, i))).cryptInterceptor(new GtRASCryptoInterceptor(com.getui.gtc.c.b.i, com.getui.gtc.c.b.h));
                Request build = cryptInterceptor.tag("type" + i + " task ").build();
                com.getui.gtc.i.c.a.a("type " + i + " data: " + str);
                Response execute = d.f8420a.newCall(build).execute();
                ServerManager.confirmServer("gtc.bs", server);
                execute.close();
                return;
            } catch (Exception e) {
                com.getui.gtc.i.c.a.b("type " + i + " error : " + e.getMessage());
                if (!(e instanceof IOException) || !ServerManager.switchServer("gtc.bs", server)) {
                    throw e;
                }
                com.getui.gtc.i.c.a.b("type " + i + " failed with server: " + server + ", try again with: " + ServerManager.getServer("gtc.bs"));
            }
        }
        throw e;
    }

    private static String b(String str, int i) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", "upload_BI");
        jSONObject.put("BIType", String.valueOf(i));
        jSONObject.put("cid", com.getui.gtc.c.b.d);
        jSONObject.put("BIData", new String(IOUtils.encode(str.getBytes(), 0), "UTF-8"));
        return jSONObject.toString();
    }
}
