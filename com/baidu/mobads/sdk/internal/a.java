package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6451a = "none";
    public static final String b = "text";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6452c = "static_image";
    public static final String d = "gif";
    public static final String e = "rich_media";
    public static final String f = "html";
    public static final String g = "hybrid";
    public static final String h = "video";
    private static final long i = 1750000;
    private String A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private String K;
    private List<String> M;
    private JSONObject N;
    private long O;
    private long P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private JSONObject X;
    private int Y;
    private int Z;
    private int aa;
    private List<String> ab;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int s = 1;
    private String L = "none";
    private int ac = 0;

    private static int a(JSONObject jSONObject, int i2, int i3) {
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                i4 = 0;
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    i4 = 0;
                    if (!TextUtils.isEmpty(optString)) {
                        i4 = 0;
                        if (optString.startsWith("opt_style_")) {
                            String[] split = optString.substring(10).split("_");
                            i4 = 0;
                            if (split != null) {
                                i4 = 0;
                                if (split.length > 0) {
                                    i4 = Integer.parseInt(split[0]);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                bq.a().d(th.getMessage());
                i4 = 0;
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        int i5 = i2;
        if (i2 == 42) {
            i5 = 41;
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0209 A[Catch: all -> 0x025e, JSONException -> 0x0268, TRY_ENTER, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0268, all -> 0x025e, blocks: (B:5:0x00a0, B:7:0x00b2, B:9:0x00ca, B:11:0x00fa, B:13:0x0109, B:15:0x011e, B:17:0x0129, B:19:0x0132, B:21:0x013a, B:24:0x0148, B:26:0x0156, B:32:0x0165, B:34:0x0175, B:37:0x01ba, B:39:0x01d1, B:41:0x01de, B:43:0x01e6, B:45:0x01f6, B:48:0x0209, B:50:0x0226, B:52:0x022f, B:54:0x023d, B:56:0x0246), top: B:112:0x00a0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r6) {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    break;
                }
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i3)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                i2 = i3 + 1;
            }
        }
        return arrayList;
    }

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public String A() {
        return this.z;
    }

    public String B() {
        return this.y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public long E() {
        return this.P;
    }

    public List<String> F() {
        return this.M;
    }

    public String G() {
        return this.Q;
    }

    public JSONObject H() {
        return this.N;
    }

    public String I() {
        return this.T;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        String str = this.W;
        return (str == null || str.length() <= 4) ? this.W : "";
    }

    public int M() {
        return this.aa;
    }

    public List<String> N() {
        return this.ab;
    }

    public JSONObject O() {
        return this.X;
    }

    public int P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public int R() {
        return this.ac;
    }

    public JSONObject S() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.Q);
            jSONObject.put("tit", this.j);
            jSONObject.put("desc", this.k);
            jSONObject.put("pk", this.v);
            jSONObject.put("appname", this.p);
            jSONObject.put(SocialConstants.PARAM_ACT, this.C);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.R;
    }

    public String i() {
        return this.S;
    }

    public long j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.s;
    }

    public String m() {
        return this.v;
    }

    public String n() {
        return this.w;
    }

    public String o() {
        return this.x;
    }

    public int p() {
        return this.C;
    }

    public String q() {
        return this.D;
    }

    public int r() {
        return this.E;
    }

    public int s() {
        return this.F;
    }

    public int t() {
        return this.G;
    }

    public int u() {
        return this.H;
    }

    public int v() {
        return this.I;
    }

    public int w() {
        return this.J;
    }

    public String x() {
        return this.L;
    }

    public long y() {
        return this.O;
    }

    public String z() {
        return !TextUtils.isEmpty(this.u) ? this.u : this.t;
    }
}
