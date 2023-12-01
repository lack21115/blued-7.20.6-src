package com.tencent.qmsp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.d.d;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<d.b> f24890a = new ArrayList();
    private SharedPreferences b;

    public b() {
        Context context;
        this.b = null;
        context = com.tencent.qmsp.sdk.app.a.getContext();
        this.b = context.getSharedPreferences(com.tencent.qmsp.sdk.c.b.f24856a + a(d.b), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            r0 = r4
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L13
            goto L2d
        L13:
            r0 = r4
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L27
            android.content.Context r0 = com.tencent.qmsp.sdk.app.QmspSDK.getContext()
            r1 = 0
            java.io.File r0 = r0.getExternalFilesDir(r1)
            r4 = r0
            goto L34
        L27:
            java.lang.String r0 = ""
            r4 = r0
            goto L39
        L2d:
            android.content.Context r0 = com.tencent.qmsp.sdk.app.QmspSDK.getContext()
            java.io.File r0 = r0.getFilesDir()
            r4 = r0
        L34:
            r0 = r4
            java.lang.String r0 = r0.getParent()
            r4 = r0
        L39:
            r0 = r4
            r7 = r0
            r0 = r4
            java.lang.String r1 = java.io.File.separator
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L73
            r0 = r4
            r7 = r0
            r0 = r5
            java.lang.String r1 = java.io.File.separator
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L73
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = java.io.File.separator
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r0 = r0.toString()
            r7 = r0
        L73:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
            r0 = r5
            java.lang.String r1 = java.io.File.separator
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto La2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            goto Lb4
        La2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = java.io.File.separator
            r4 = r0
        Lb4:
            r0 = r5
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.d.b.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private String a(byte[] bArr) {
        return h.a(bArr);
    }

    private boolean a(String str, long j, long j2) {
        boolean z = false;
        if (str != null) {
            if (!str.equals("android")) {
                return false;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            z = false;
            if (i >= 0) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    return false;
                }
                long j3 = Build.VERSION.SDK_INT;
                if (i == 0 && i2 == 0) {
                    return true;
                }
                if (i == 0 && i2 > 0) {
                    boolean z2 = false;
                    if (j3 <= j2) {
                        z2 = true;
                    }
                    return z2;
                } else if (i > 0 && i2 == 0) {
                    boolean z3 = false;
                    if (j3 >= j) {
                        z3 = true;
                    }
                    return z3;
                } else {
                    z = false;
                    if (i > 0) {
                        z = false;
                        if (i2 > 0) {
                            z = false;
                            if (j3 >= j) {
                                z = false;
                                if (j3 <= j2) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    private boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String replace = str.replace(" ", "");
        String replace2 = str2.replace(" ", "");
        boolean equals = replace.equals("*");
        boolean equals2 = replace2.equals("*");
        if (equals && equals2) {
            return true;
        }
        String c2 = com.tencent.qmsp.sdk.a.c.c();
        if (TextUtils.isEmpty(c2)) {
            return false;
        }
        try {
            if (equals && !equals2) {
                return b(c2, replace2) <= 0;
            } else if (!equals && equals2) {
                return b(c2, replace) >= 0;
            } else if (equals || equals2) {
                return false;
            } else {
                boolean z = false;
                if (b(c2, replace2) <= 0) {
                    z = false;
                    if (b(c2, replace) >= 0) {
                        z = true;
                    }
                }
                return z;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private int b(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int parseInt = Integer.parseInt(split[i2]);
            int parseInt2 = Integer.parseInt(split2[i2]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
            i = i2 + 1;
        }
    }

    private String b() {
        return com.tencent.qmsp.sdk.a.b.c() + a(d.f24897a);
    }

    private boolean b(String str) {
        if (str == null) {
            return false;
        }
        String replace = str.replace(" ", "");
        if (replace.equals("*")) {
            return true;
        }
        String str2 = Build.CPU_ABI;
        String[] split = replace.split(",");
        if (split == null) {
            return false;
        }
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str2.contains(split[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private boolean c(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getLong(a(d.g[0]));
            jSONObject.getBoolean(a(d.g[1]));
            JSONArray jSONArray = jSONObject.getJSONArray(a(d.g[2]));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    this.f24890a = arrayList;
                    return true;
                }
                d.b bVar = new d.b();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                bVar.f24901a = jSONObject2.getLong(a(d.g[3]));
                bVar.b = jSONObject2.getLong(a(d.g[4]));
                jSONObject2.getLong(a(d.g[7]));
                bVar.f24902c = jSONObject2.getString(a(d.g[5]));
                bVar.d = jSONObject2.getString(a(d.g[6]));
                bVar.e = jSONObject2.getString(a(d.g[8]));
                bVar.f = jSONObject2.getLong(a(d.g[15]));
                bVar.g = jSONObject2.getLong(a(d.g[16]));
                bVar.j = jSONObject2.getString(a(d.g[18]));
                bVar.h = jSONObject2.getString(a(d.g[10]));
                bVar.i = jSONObject2.getString(a(d.g[11]));
                bVar.k = jSONObject2.getString(a(d.g[9]));
                bVar.m = a(bVar.k, bVar.f, bVar.g);
                bVar.n = b(bVar.j);
                bVar.l = a(bVar.h, bVar.i);
                if (jSONObject2.has(a(d.g[20]))) {
                    bVar.u = jSONObject2.getInt(a(d.g[20]));
                }
                JSONArray jSONArray2 = jSONObject2.getJSONArray(a(d.g[12]));
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= jSONArray2.length()) {
                        break;
                    }
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                    d.a aVar = new d.a();
                    jSONObject3.getLong(a(d.g[7]));
                    aVar.d = jSONObject3.getString(a(d.g[13]));
                    aVar.e = jSONObject3.getString(a(d.g[14]));
                    aVar.f24899a = jSONObject3.getString(a(d.g[5]));
                    aVar.f = a(aVar.d, aVar.e, aVar.f24899a);
                    aVar.b = jSONObject3.getString(a(d.g[6]));
                    aVar.h = jSONObject3.getLong(a(d.g[17]));
                    if (jSONObject3.has(a(d.g[19]))) {
                        aVar.i = jSONObject3.getString(a(d.g[19]));
                    }
                    bVar.o.add(aVar);
                    i3 = i4 + 1;
                }
                arrayList.add(bVar);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            g.a("Qp.QPUpdate", 1, "[SFU] parsing config error");
            return false;
        }
    }

    public List<d.b> a() {
        return this.f24890a;
    }

    public List<d.b> a(long j) {
        ArrayList arrayList = new ArrayList();
        if (a(b()) && !this.f24890a.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f24890a.size()) {
                    break;
                }
                d.b bVar = this.f24890a.get(i2);
                if (bVar.b == j) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= bVar.o.size()) {
                            break;
                        }
                        d.a aVar = bVar.o.get(i4);
                        aVar.g = this.b.getString(aVar.f, "");
                        i3 = i4 + 1;
                    }
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bVar.q.size()) {
                            break;
                        }
                        d.a aVar2 = bVar.q.get(i6);
                        aVar2.g = this.b.getString(aVar2.f, "");
                        i5 = i6 + 1;
                    }
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= bVar.p.size()) {
                            break;
                        }
                        d.a aVar3 = bVar.p.get(i8);
                        aVar3.g = this.b.getString(aVar3.f, "");
                        i7 = i8 + 1;
                    }
                    arrayList.add(bVar);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public boolean a(String str) {
        byte[] a2 = e.a(new File(str), null);
        if (a2 != null) {
            return c(new String(a2));
        }
        g.a("Qp.QPUpdate", 1, String.format("[SFU] invalid sig of config: %s", str));
        return false;
    }
}
