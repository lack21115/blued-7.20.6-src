package com.igexin.push.core.a.a;

import android.os.Message;
import android.text.TextUtils;
import com.igexin.push.c.c;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b.t;
import com.igexin.push.core.d;
import com.igexin.push.core.e.f;
import com.igexin.push.core.k;
import com.igexin.push.core.l;
import com.igexin.push.e.b.d;
import com.igexin.push.f.j;
import com.igexin.sdk.main.FeedbackImpl;
import com.igexin.sdk.router.GTBoater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/a/c.class */
public final class c extends com.igexin.push.core.a.a {
    private static final String b = "LoginResult";

    /* renamed from: com.igexin.push.core.a.a.c$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/a/c$1.class */
    final class AnonymousClass1 extends com.igexin.push.e.d {
        AnonymousClass1() {
        }

        @Override // com.igexin.push.e.d
        public final void b() {
            try {
                com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis != com.igexin.push.core.e.R) {
                    com.igexin.push.core.e.R = currentTimeMillis;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass12(), false, true);
                }
                com.igexin.push.core.c.a a3 = com.igexin.push.core.c.a.a();
                ArrayList arrayList = new ArrayList();
                a3.a((List<t>) arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("action", "reportapplist");
                    jSONObject.put("session_last", com.igexin.push.core.e.z);
                    JSONArray jSONArray = new JSONArray();
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("appid", arrayList.get(i2).f23462c);
                        jSONObject2.put("name", arrayList.get(i2).f23461a);
                        jSONObject2.put("version", arrayList.get(i2).b);
                        jSONObject2.put("versionName", arrayList.get(i2).d);
                        jSONArray.put(jSONObject2);
                        i = i2 + 1;
                    }
                    jSONObject.put("applist", jSONArray);
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.a.a(new com.igexin.push.core.h.a(SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
                com.igexin.c.a.c.a.a("reportAL", new Object[0]);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.core.a.a.c$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/a/c$2.class */
    final class AnonymousClass2 extends com.igexin.push.e.d {
        AnonymousClass2() {
        }

        @Override // com.igexin.push.e.d
        public final void b() {
            try {
                com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                JSONObject a3 = a2.a();
                if (a3 == null) {
                    return;
                }
                Iterator<String> keys = a3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = a3.getJSONObject(next);
                    com.igexin.c.a.c.a.a("LoginResult|send unFeedback taskid = ".concat(String.valueOf(next)), new Object[0]);
                    jSONObject.put("appid", com.igexin.push.core.e.f23495a);
                    FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, jSONObject.getString("multaid"));
                    keys.remove();
                }
                a2.b();
            } catch (Throwable th) {
                com.igexin.c.a.c.a.b(c.b, "feedbackMultiBrandPushMessage exception :" + th.toString());
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private void d() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
        com.igexin.push.c.c cVar = c.b.f23335a;
        cVar.f23328c = System.currentTimeMillis();
        if (cVar.b) {
            com.igexin.c.a.c.a.a(com.igexin.push.c.c.f23327a, "loginRsp| enter polling");
            cVar.e = new com.igexin.push.c.e();
            d.a.f23611a.g();
            cVar.d = 0;
        } else {
            cVar.b();
        }
        String str = com.igexin.push.core.e.A;
        boolean z = com.igexin.push.core.e.v;
        com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new Object[0]);
        StringBuilder sb = new StringBuilder("isCidBroadcasted|");
        sb.append(com.igexin.push.core.e.v);
        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
        if (!com.igexin.push.core.e.v) {
            l.a().c();
            com.igexin.push.core.e.v = true;
        }
        com.igexin.push.core.e.u = true;
        j.g();
        l.a().b();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.g();
        if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.h();
        }
        if ((System.currentTimeMillis() - com.igexin.push.core.e.R) - 86400000 >= 0) {
            com.igexin.c.a.c.a.a("LoginResult, over 24h, start upload AL", new Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.igexin.push.core.e.Q;
        long j2 = com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new Object[0]);
        boolean z2 = (currentTimeMillis - j) - 86400000 > 0;
        boolean z3 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z4 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        com.igexin.c.a.c.a.a("LoginResult|isOverOneDay = " + z2 + ", isDeviceTokenDiff = " + z3 + ", isCidDiff = " + z4, new Object[0]);
        if (z2 || z3 || z4) {
            com.igexin.push.core.a.b.d().i();
        }
        com.igexin.push.core.c.a.a();
        com.igexin.push.core.c.a.b();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass1(), false, true);
        if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
        }
        Message obtain = Message.obtain();
        obtain.what = com.igexin.push.core.b.S;
        obtain.obj = new Object();
        d.a.f23474a.a(obtain);
        GTBoater.getInstance().initialize();
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass2(), false, true);
        }
    }

    private static void e() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.igexin.push.core.e.Q;
        long j2 = com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new Object[0]);
        boolean z = (currentTimeMillis - j) - 86400000 > 0;
        boolean z2 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean equals = true ^ com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        com.igexin.c.a.c.a.a("LoginResult|isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + equals, new Object[0]);
        if (z || z2 || equals) {
            com.igexin.push.core.a.b.d().i();
        }
    }

    private static void f() {
        com.igexin.c.a.c.a.d a2 = com.igexin.c.a.c.a.d.a();
        a2.a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
        com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
        com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new Object[0]);
        com.igexin.push.core.e.f.a().b();
        k.a();
        k.c();
    }

    private void g() {
        if ((System.currentTimeMillis() - com.igexin.push.core.e.R) - 86400000 < 0) {
            return;
        }
        com.igexin.c.a.c.a.a("LoginResult, over 24h, start upload AL", new Object[0]);
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
    }

    private static void h() {
        if (com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            return;
        }
        com.igexin.push.core.e.B = com.igexin.push.core.e.A;
    }

    private void i() {
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass2(), false, true);
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (obj instanceof com.igexin.push.c.c.k) {
            com.igexin.push.core.e.O = 0L;
            if (com.igexin.push.core.e.u) {
                return true;
            }
            com.igexin.push.b.c.a().d().e();
            if (!((com.igexin.push.c.c.k) obj).b) {
                com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
                com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
                com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new Object[0]);
                com.igexin.push.core.e.f.a().b();
                k.a();
                k.c();
                return true;
            }
            com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
            com.igexin.push.c.c cVar = c.b.f23335a;
            cVar.f23328c = System.currentTimeMillis();
            if (cVar.b) {
                com.igexin.c.a.c.a.a(com.igexin.push.c.c.f23327a, "loginRsp| enter polling");
                cVar.e = new com.igexin.push.c.e();
                d.a.f23611a.g();
                cVar.d = 0;
            } else {
                cVar.b();
            }
            String str = com.igexin.push.core.e.A;
            boolean z = com.igexin.push.core.e.v;
            com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new Object[0]);
            StringBuilder sb = new StringBuilder("isCidBroadcasted|");
            sb.append(com.igexin.push.core.e.v);
            com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
            if (!com.igexin.push.core.e.v) {
                l.a().c();
                com.igexin.push.core.e.v = true;
            }
            com.igexin.push.core.e.u = true;
            j.g();
            l.a().b();
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.g();
            if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new Object[0]);
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.h();
            }
            if ((System.currentTimeMillis() - com.igexin.push.core.e.R) - 86400000 >= 0) {
                com.igexin.c.a.c.a.a("LoginResult, over 24h, start upload AL", new Object[0]);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = com.igexin.push.core.e.Q;
            long j2 = com.igexin.push.core.e.Q;
            com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new Object[0]);
            boolean z2 = (currentTimeMillis - j) - 86400000 > 0;
            boolean z3 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
            boolean z4 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
            com.igexin.c.a.c.a.a("LoginResult|isOverOneDay = " + z2 + ", isDeviceTokenDiff = " + z3 + ", isCidDiff = " + z4, new Object[0]);
            if (z2 || z3 || z4) {
                com.igexin.push.core.a.b.d().i();
            }
            com.igexin.push.core.c.a.a();
            com.igexin.push.core.c.a.b();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass1(), false, true);
            if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
                com.igexin.push.core.e.B = com.igexin.push.core.e.A;
            }
            Message obtain = Message.obtain();
            obtain.what = com.igexin.push.core.b.S;
            obtain.obj = new Object();
            d.a.f23474a.a(obtain);
            GTBoater.getInstance().initialize();
            if (com.igexin.assist.sdk.a.a().c()) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass2(), false, true);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
