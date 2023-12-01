package com.opos.cmn.an.g.a.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/a/a/b.class */
public class b extends a {
    private OutputStream d;
    private InputStream e;

    public b(Context context, f fVar) {
        super(context, fVar);
        this.d = null;
        this.e = null;
    }

    private Map<String, String> c() {
        Map<String, List<String>> headerFields = this.f24542c.getHeaderFields();
        HashMap hashMap = null;
        HashMap hashMap2 = null;
        if (headerFields != null) {
            hashMap2 = null;
            if (headerFields.size() > 0) {
                Iterator<Map.Entry<String, List<String>>> it = headerFields.entrySet().iterator();
                while (true) {
                    hashMap2 = hashMap;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, List<String>> next = it.next();
                    if (next != null) {
                        String key = next.getKey();
                        List<String> value = next.getValue();
                        if (value != null && value.size() > 0) {
                            HashMap hashMap3 = hashMap;
                            if (hashMap == null) {
                                hashMap3 = new HashMap();
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("getResponseHeaderMap key=");
                            sb.append(key != null ? key : com.igexin.push.core.b.l);
                            sb.append(",value=");
                            String str = com.igexin.push.core.b.l;
                            if (value.get(0) != null) {
                                str = value.get(0);
                            }
                            sb.append(str);
                            com.opos.cmn.an.f.a.b("HttpURLSyncTask", sb.toString());
                            hashMap3.put(key, value.get(0));
                            hashMap = hashMap3;
                        }
                    }
                }
            }
        }
        return hashMap2;
    }

    public g a() {
        com.opos.cmn.an.f.a.b("HttpURLSyncTask", "execute start");
        if (this.f24542c != null) {
            try {
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", "connect start");
                this.f24542c.connect();
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", "connect end");
                if ("POST".equals(this.b.b) && this.b.g != null && this.b.g.length > 0) {
                    OutputStream outputStream = this.f24542c.getOutputStream();
                    this.d = outputStream;
                    outputStream.write(this.b.g);
                    this.d.flush();
                }
                long j = -1;
                int responseCode = this.f24542c.getResponseCode();
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", "code=" + responseCode);
                String responseMessage = this.f24542c.getResponseMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("msg=");
                sb.append(responseMessage != null ? responseMessage : com.igexin.push.core.b.l);
                com.opos.cmn.an.f.a.b("HttpURLSyncTask", sb.toString());
                try {
                    this.e = this.f24542c.getInputStream();
                } catch (IOException e) {
                }
                String headerField = this.f24542c.getHeaderField("Content-Length");
                if (!com.opos.cmn.an.c.a.a(headerField)) {
                    j = Long.parseLong(headerField);
                }
                return new g.a().a(responseCode).a(responseMessage).a(j).a(c()).a(this.e).a();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("HttpURLSyncTask", "", e2);
                return null;
            }
        }
        return null;
    }

    public void b() {
        try {
            if (this.d != null) {
                this.d.close();
            }
            if (this.e != null) {
                this.e.close();
            }
            if (this.f24542c != null) {
                this.f24542c.disconnect();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("HttpURLSyncTask", "", e);
        }
    }
}
