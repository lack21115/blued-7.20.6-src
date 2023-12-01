package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.kb;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.iv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/iv.class */
public final class iv extends hv {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5184a;
    private String b;

    public iv(byte[] bArr, String str) {
        this.b = "1";
        this.f5184a = (byte[]) bArr.clone();
        this.b = str;
        setDegradeAbility(kb.a.SINGLE);
        setHttpProtocol(kb.c.HTTP);
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final byte[] getEntityBytes() {
        return this.f5184a;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f5184a.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        String c2 = ib.c(ip.b);
        String str = this.b;
        byte[] a2 = ib.a(ip.f5173a);
        byte[] bArr = new byte[a2.length + 50];
        System.arraycopy((Object) this.f5184a, 0, (Object) bArr, 0, 50);
        System.arraycopy((Object) a2, 0, (Object) bArr, 50, a2.length);
        return String.format(c2, "1", str, "1", "open", hw.a(bArr));
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final boolean isHostToIP() {
        return false;
    }
}
