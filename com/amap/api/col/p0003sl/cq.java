package com.amap.api.col.p0003sl;

import android.content.Context;
import com.anythink.core.common.c.d;
import com.efs.sdk.base.Constants;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.cq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cq.class */
public final class cq extends hg<String, a> {
    private String j;
    private String k;
    private String l;
    private final String m;
    private boolean n;
    private String o;

    /* renamed from: com.amap.api.col.3sl.cq$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cq$a.class */
    public static final class a {
        public byte[] a;
        public int b = -1;
        public String c = null;
        public boolean d = false;
    }

    public cq(Context context, String str) {
        super(context, str);
        this.k = "1.0";
        this.l = "0";
        this.m = "lastModified";
        this.n = false;
        this.o = null;
        this.h = "/map/styles";
        this.i = true;
    }

    public cq(Context context, String str, boolean z) {
        super(context, str);
        this.k = "1.0";
        this.l = "0";
        this.m = "lastModified";
        this.n = false;
        this.o = null;
        this.n = z;
        if (z) {
            this.h = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            this.h = "/map/styles";
        }
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.hg
    /* renamed from: b */
    public a a(kc kcVar) throws hf {
        a aVar;
        if (kcVar != null) {
            a a2 = a(kcVar.a);
            a2.d = a2.a != null;
            aVar = a2;
            if (kcVar.b != null) {
                aVar = a2;
                if (kcVar.b.containsKey("lastModified")) {
                    List<String> list = kcVar.b.get("lastModified");
                    aVar = a2;
                    if (list != null) {
                        aVar = a2;
                        if (list.size() > 0) {
                            a2.c = list.get(0);
                            return a2;
                        }
                    }
                }
            }
        } else {
            aVar = null;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.hg
    /* renamed from: b */
    public a a(byte[] bArr) throws hf {
        a aVar = new a();
        aVar.a = bArr;
        if (this.n && bArr != null) {
            if (bArr.length == 0) {
                aVar.a = null;
                return aVar;
            } else if (aVar.a.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.a = null;
                        return aVar;
                    }
                } catch (Exception e) {
                    iw.c(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    public final void a(String str) {
        this.o = str;
    }

    public final void b(String str) {
        this.j = str;
    }

    @Override // com.amap.api.col.p0003sl.hg
    protected final String c() {
        return null;
    }

    public final void c(String str) {
        this.l = str;
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
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(d.a.b, ho.f(this.g));
        if (this.n) {
            hashtable.put("sdkType", this.o);
        } else {
            hashtable.put("output", "bin");
        }
        hashtable.put("styleid", this.j);
        hashtable.put("protocol", this.k);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.l);
        String a2 = hr.a();
        String a3 = hr.a(this.g, a2, ib.b(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.hg, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        ia a2 = dw.a();
        String b = a2 != null ? a2.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", w.c);
        hashtable.put("Accept-Encoding", Constants.CP_GZIP);
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("x-INFO", hr.a(this.g));
        hashtable.put(d.a.b, ho.f(this.g));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + this.h;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final boolean isSupportIPV6() {
        return true;
    }
}
