package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.kb;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.iv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/iv.class */
public final class iv extends hv {
    private byte[] a;
    private String b;

    public iv(byte[] bArr, String str) {
        this.b = "1";
        this.a = (byte[]) bArr.clone();
        this.b = str;
        setDegradeAbility(kb.a.SINGLE);
        setHttpProtocol(kb.c.HTTP);
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final byte[] getEntityBytes() {
        return this.a;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        String c = ib.c(ip.b);
        String str = this.b;
        byte[] a = ib.a(ip.a);
        byte[] bArr = new byte[a.length + 50];
        System.arraycopy((Object) this.a, 0, (Object) bArr, 0, 50);
        System.arraycopy((Object) a, 0, (Object) bArr, 50, a.length);
        return String.format(c, "1", str, "1", "open", hw.a(bArr));
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final boolean isHostToIP() {
        return false;
    }
}
