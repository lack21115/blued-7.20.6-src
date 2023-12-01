package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.video.signal.a.c;
import com.anythink.expressad.video.signal.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/j.class */
public class j extends c {
    private static final String t = j.class.getSimpleName();
    private static final String u = "正在下载中,请稍后...";
    private static final String z = "camp_position";
    private com.anythink.expressad.foundation.d.c A;
    private List<com.anythink.expressad.foundation.d.c> B;
    private int C;
    private String D = "";
    private String E = "";
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    private Activity v;
    private String w;
    private String x;
    private Context y;

    public j(Activity activity, com.anythink.expressad.foundation.d.c cVar) {
        this.v = activity;
        this.A = cVar;
    }

    public j(Activity activity, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list) {
        this.v = activity;
        this.A = cVar;
        this.B = list;
    }

    private static JSONObject A() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.n.a().g()).a());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.s);
            jSONObject2.put("instanceId", this.D);
            jSONObject.put("sdkSetting", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        if (this.o != null) {
            jSONObject = this.o.R();
        }
        return jSONObject;
    }

    private static JSONObject D() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
        if (b != null) {
            jSONObject = b.k();
        }
        return jSONObject;
    }

    private static boolean E() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e9, code lost:
        if (com.anythink.expressad.foundation.g.a.cd.equals(r0) != false) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.expressad.foundation.d.c a(java.lang.String r6, com.anythink.expressad.foundation.d.c r7) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.a.j.a(java.lang.String, com.anythink.expressad.foundation.d.c):com.anythink.expressad.foundation.d.c");
    }

    private void a(JSONObject jSONObject) {
        try {
            Context d = com.anythink.expressad.foundation.b.a.b().d();
            String obj = v.b(d, "Anythink_ConfirmTitle" + this.n, "").toString();
            String obj2 = v.b(d, "Anythink_ConfirmContent" + this.n, "").toString();
            String obj3 = v.b(d, "Anythink_CancelText" + this.n, "").toString();
            String obj4 = v.b(d, "Anythink_ConfirmText" + this.n, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put(com.anythink.expressad.d.a.b.ct, obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cu, obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cv, obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cx, obj4);
            }
            if (TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put(com.anythink.expressad.d.a.b.cw, obj4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(JSONObject jSONObject, com.anythink.expressad.foundation.d.c cVar) {
        try {
            String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            cVar.l(optString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.anythink.expressad.foundation.d.c r5) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r0 = r0.ah()
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r8
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L26
            java.lang.String r1 = com.anythink.expressad.foundation.g.a.cf     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = r0.getQueryParameter(r1)     // Catch: java.lang.Throwable -> L26
            r8 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L33
            r0 = r8
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L26
            r6 = r0
            goto L35
        L26:
            r8 = move-exception
            java.lang.String r0 = com.anythink.expressad.video.signal.a.j.t
            java.lang.String r1 = "INSTALL"
            r2 = r8
            com.anythink.expressad.foundation.h.o.b(r0, r1, r2)
        L33:
            r0 = 0
            r6 = r0
        L35:
            r0 = r4
            com.anythink.expressad.video.signal.c$a r0 = r0.r
            r8 = r0
            r0 = r6
            r1 = 2
            if (r0 != r1) goto L42
            r0 = 1
            r7 = r0
        L42:
            r0 = r8
            r1 = r5
            r2 = r7
            r0.a(r1, r2)
            r0 = r4
            com.anythink.expressad.a.a r0 = r0.u()
            r1 = r4
            com.anythink.expressad.video.signal.c$a r1 = r1.r
            r0.a(r1)
            r0 = r4
            com.anythink.expressad.a.a r0 = r0.u()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.a.j.b(com.anythink.expressad.foundation.d.c):void");
    }

    private void c(boolean z2) {
        this.H = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039 A[Catch: Exception -> 0x0050, TRY_ENTER, TryCatch #0 {Exception -> 0x0050, blocks: (B:2:0x0000, B:5:0x0011, B:7:0x001f, B:8:0x002c, B:10:0x0039, B:13:0x0044), top: B:20:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[Catch: Exception -> 0x0050, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:2:0x0000, B:5:0x0011, B:7:0x001f, B:8:0x002c, B:10:0x0039, B:13:0x0044), top: B:20:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(com.anythink.expressad.foundation.d.c r6) {
        /*
            com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = r0.e()     // Catch: java.lang.Exception -> L50
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L50
            r7 = r0
            r0 = 0
            r10 = r0
            r0 = r7
            if (r0 != 0) goto L54
            com.anythink.expressad.d.b r0 = com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> L50
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.b()     // Catch: java.lang.Exception -> L50
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L54
            r0 = r12
            long r0 = r0.l()     // Catch: java.lang.Exception -> L50
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r1
            r8 = r0
            goto L2c
        L2c:
            com.anythink.expressad.videocommon.e.c r0 = com.anythink.expressad.videocommon.e.c.a()     // Catch: java.lang.Exception -> L50
            com.anythink.expressad.videocommon.e.a r0 = r0.b()     // Catch: java.lang.Exception -> L50
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L40
            r0 = r12
            long r0 = r0.c()     // Catch: java.lang.Exception -> L50
            r10 = r0
        L40:
            r0 = r6
            if (r0 == 0) goto L4e
            r0 = r6
            r1 = r10
            r2 = r8
            boolean r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L50
            r7 = r0
            r0 = r7
            return r0
        L4e:
            r0 = 0
            return r0
        L50:
            r6 = move-exception
            goto L4e
        L54:
            r0 = 0
            r8 = r0
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.a.j.c(com.anythink.expressad.foundation.d.c):boolean");
    }

    private void e(String str) {
        List<com.anythink.expressad.foundation.d.c> list;
        if (this.A == null || (list = this.B) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(z)) {
                this.A = this.B.get(jSONObject.getInt(z));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean s() {
        return this.H;
    }

    private String t() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.n.a().g());
        try {
            jSONObject.put("unit_id", this.n);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.D);
            jSONObject2.put("rootViewInstanceId", this.E);
            jSONObject2.put("isRootTemplateWebView", this.F);
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.out.b.f8067a + ",3.0.1");
            jSONObject2.put("playVideoMute", this.s);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", cVar.a());
            JSONArray jSONArray = new JSONArray();
            if (this.B == null || this.B.size() <= 0) {
                jSONArray.put(com.anythink.expressad.foundation.d.c.a(this.A));
            } else {
                for (com.anythink.expressad.foundation.d.c cVar2 : this.B) {
                    jSONArray.put(com.anythink.expressad.foundation.d.c.a(cVar2, cVar2.at(), c(cVar2)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", C());
            String e = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            String a2 = com.anythink.expressad.d.b.a(e);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                a(jSONObject3);
                com.anythink.expressad.d.b.a();
                String b = com.anythink.expressad.d.b.b(this.n);
                if (!TextUtils.isEmpty(b)) {
                    jSONObject3.put("ivreward", new JSONObject(b));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", D());
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("unit_id", this.n);
            }
            jSONObject.put("rw_plus", this.G ? "1" : "0");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private com.anythink.expressad.a.a u() {
        if (this.q == null) {
            this.q = new com.anythink.expressad.a.a(com.anythink.core.common.b.n.a().g(), this.n);
        }
        return this.q;
    }

    private JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.n.a().g());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.s);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", cVar.a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(com.anythink.expressad.foundation.d.c.a(this.A));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", C());
            String e = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            String a2 = com.anythink.expressad.d.b.a(e);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                a(jSONObject3);
                com.anythink.expressad.d.b.a();
                String b = com.anythink.expressad.d.b.b(this.n);
                if (!TextUtils.isEmpty(b)) {
                    jSONObject3.put("ivreward", b);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", D());
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    private static JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.out.b.f8067a + ",3.0.1");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("unit_id", this.n);
                return jSONObject;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            String e = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            String a2 = com.anythink.expressad.d.b.a(e);
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("appSetting", new JSONObject(a2));
                return jSONObject;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            return jSONObject;
        }
        return jSONObject;
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.o != null) {
                jSONObject.put("unitSetting", this.o.R());
                return jSONObject;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(int i, String str) {
        super.a(i, str);
        if (i != 2) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("event", "event");
            String optString2 = jSONObject.optString("template", "-1");
            String optString3 = jSONObject.optString("layout", "-1");
            String optString4 = jSONObject.optString("unit_id", this.n);
            this.v.getApplication();
            int a2 = com.anythink.expressad.foundation.h.k.a();
            new r(r.j, optString, optString2, optString3, optString4, this.A.aZ(), a2, com.anythink.expressad.foundation.h.k.a(this.v.getApplication(), a2));
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(t, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(Activity activity) {
        this.v = activity;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(Context context) {
        this.y = context;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.A = cVar;
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.B = list;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.x = str;
    }

    public final void b(boolean z2) {
        this.G = z2;
    }

    public final void c(String str) {
        this.D = str;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.d
    public void click(int i, String str) {
        List<com.anythink.expressad.foundation.d.c> list;
        super.click(i, str);
        com.anythink.expressad.foundation.d.c cVar = this.A;
        if (cVar != null && cVar.k() == 5 && this.A != null && (list = this.B) != null && list.size() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(z)) {
                    this.A = this.B.get(jSONObject.getInt(z));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        boolean z2 = true;
        try {
            if (i != 1) {
                if (i != 3) {
                    return;
                }
                if (((this.A == null || this.A.g() <= -2) ? this.o != null ? this.o.p() : 1 : this.A.g()) == -1) {
                    a(new c.b(this, this.r));
                }
                click(1, str);
                return;
            }
            if (this.A == null && this.B != null && this.B.size() > 0) {
                this.A = this.B.get(0);
            }
            if (this.A == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c a2 = a(str, this.A);
            String queryParameter = Uri.parse(a2.ah()).getQueryParameter(com.anythink.expressad.foundation.g.a.cf);
            int parseInt = !TextUtils.isEmpty(queryParameter) ? Integer.parseInt(queryParameter) : 0;
            c.a aVar = this.r;
            if (parseInt != 2) {
                z2 = false;
            }
            aVar.a(a2, z2);
            u().a(this.r);
            u();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(t, th.getMessage(), th);
        }
    }

    public final void d(String str) {
        this.E = str;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final String h(int i) {
        switch (i) {
            case 1:
                return w().toString();
            case 2:
                return x().toString();
            case 3:
                return y().toString();
            case 4:
                return z().toString();
            case 5:
                return A().toString();
            case 6:
                return B().toString();
            default:
                return v().toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i, String str) {
        super.handlerH5Exception(i, str);
        try {
            this.r.a(i, str);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(t, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final String i() {
        this.r.b();
        this.e = true;
        if (TextUtils.isEmpty(this.w)) {
            this.w = t();
        }
        return this.w;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void j() {
        super.j();
        try {
            if (this.v != null) {
                this.v.finish();
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(t, th.getMessage(), th);
        }
    }

    public final void j(int i) {
        this.C = i;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void l() {
        super.l();
        if (this.r != null) {
            this.r.c();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final String o() {
        com.anythink.expressad.foundation.h.o.a(t, "getNotchArea");
        return this.x;
    }

    public final void p() {
        this.F = true;
    }

    public final void q() {
        this.w = "";
    }

    public final int r() {
        return this.C;
    }
}
