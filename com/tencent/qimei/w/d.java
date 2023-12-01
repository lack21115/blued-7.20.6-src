package com.tencent.qimei.w;

import com.tencent.qimei.v.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/w/d.class */
public enum d implements com.tencent.qimei.f.a<String> {
    KEY_DATA_VERSION("version", ""),
    KEY_DATA_QM_REQUEST_URL("url", com.tencent.qimei.v.d.f24731a.u()),
    KEY_DATA_PEAK_TIME("peakTime", com.tencent.qimei.v.d.f24731a.g());
    
    public static final com.tencent.qimei.h.a<String> d = new com.tencent.qimei.h.d(new com.tencent.qimei.f.a[0]);
    public final String f;
    public final String g;

    d(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    @Override // com.tencent.qimei.f.a
    public String a() {
        return this.g;
    }

    public String a(String str) {
        return d.a(this, g.a(str));
    }

    @Override // com.tencent.qimei.f.a
    public String b() {
        return this.f;
    }
}
