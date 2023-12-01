package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.s  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/s.class */
public final class s extends hg<String, a> {
    private boolean j;
    private int[] k;

    /* renamed from: com.amap.api.col.3sl.s$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/s$a.class */
    public static final class a {
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f5421c;

        /* renamed from: a  reason: collision with root package name */
        public int f5420a = -1;
        public boolean d = false;
    }

    public s(Context context, String str) {
        super(context, str);
        this.j = true;
        this.k = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.h = "/feedback";
        this.isPostFlag = false;
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003sl.hg
    /* renamed from: a */
    public a d(String str) throws hf {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = -1;
            String str3 = "";
            if (jSONObject.has("errcode")) {
                i = jSONObject.optInt("errcode");
                str3 = jSONObject.optString("errmsg");
                str2 = jSONObject.optString("errdetail");
            } else {
                str2 = "";
            }
            a aVar = new a();
            aVar.f5420a = i;
            aVar.b = str3;
            aVar.f5421c = str2;
            aVar.d = false;
            for (int i2 : this.k) {
                if (i2 == i) {
                    aVar.d = true;
                    return aVar;
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.hg
    protected final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getIPV6URL() {
        return dw.a(getURL());
    }

    @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", ho.f(this.g));
        if (this.j) {
            hashtable.put("pname", "3dmap");
        }
        String a2 = hr.a();
        String a3 = hr.a(this.g, a2, ib.b(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
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
