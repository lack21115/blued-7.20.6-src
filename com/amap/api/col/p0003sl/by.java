package com.amap.api.col.p0003sl;

import java.util.Hashtable;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.by  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/by.class */
public final class by extends da {

    /* renamed from: a  reason: collision with root package name */
    private String f4801a;

    public by(String str) {
        this.f4801a = str;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return this.f4801a;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final boolean isSupportIPV6() {
        return false;
    }
}
