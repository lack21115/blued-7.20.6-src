package com.amap.api.col.p0003sl;

import android.content.Context;
import android.provider.MediaStore;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.cs  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cs.class */
public final class cs extends hg<String, a> {

    /* renamed from: com.amap.api.col.3sl.cs$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cs$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f4821a;
        public int b = -1;
    }

    public cs(Context context, String str) {
        super(context, str);
        this.h = "/map/styles";
    }

    private static a b(byte[] bArr) throws hf {
        a aVar = new a();
        aVar.f4821a = bArr;
        return aVar;
    }

    @Override // com.amap.api.col.p0003sl.hg
    protected final /* synthetic */ a a(byte[] bArr) throws hf {
        return b(bArr);
    }

    public final void a(String str) {
        this.h = str;
    }

    @Override // com.amap.api.col.p0003sl.hg
    protected final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.hg
    protected final /* bridge */ /* synthetic */ a d(String str) throws hf {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getIPV6URL() {
        return dw.a(getURL());
    }

    @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", ho.f(this.g));
        hashMap.put(MediaStore.EXTRA_OUTPUT, "bin");
        String a2 = hr.a();
        String a3 = hr.a(this.g, a2, ib.b(hashMap));
        hashMap.put("ts", a2);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return this.h;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final boolean isSupportIPV6() {
        return true;
    }
}
