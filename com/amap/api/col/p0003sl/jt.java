package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.kb;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.jt  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jt.class */
public final class jt extends kb {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5229a;
    private Map<String, String> b;

    public jt(byte[] bArr, Map<String, String> map) {
        this.f5229a = bArr;
        this.b = map;
        setDegradeAbility(kb.a.SINGLE);
        setHttpProtocol(kb.c.HTTPS);
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final byte[] getEntityBytes() {
        return this.f5229a;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return this.b;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
