package com.amap.api.col.p0003sl;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.iy  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/iy.class */
public final class iy extends hv {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f5197a = null;
    public Context b = null;

    @Override // com.amap.api.col.p0003sl.kb
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f5197a != null) {
                Iterator<String> keys = this.f5197a.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.f5197a.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String f = ho.f(this.b);
            stringBuffer.append("&key=".concat(String.valueOf(f)));
            String a2 = hr.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a2)));
            stringBuffer.append("&scode=" + hr.a(this.b, a2, "key=".concat(String.valueOf(f))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.2.9");
        hashMap.put("X-INFO", hr.b(this.b));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.2.9", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return hu.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
