package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.hh  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hh.class */
public abstract class hh<T, V> extends hg<T, V> {
    public hh(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.p0003sl.hg
    protected abstract String c();

    @Override // com.amap.api.col.p0003sl.hg
    protected abstract V d(String str) throws hf;

    @Override // com.amap.api.col.p0003sl.kb
    public byte[] getEntityBytes() {
        try {
            return c().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.hg, com.amap.api.col.p0003sl.kb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 9.3.1");
        hashMap.put("x-INFO", hr.b(this.g));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.3.1", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
