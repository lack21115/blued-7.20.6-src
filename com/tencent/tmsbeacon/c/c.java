package com.tencent.tmsbeacon.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.a.d.a;
import com.tencent.tmsbeacon.base.net.b.d;
import com.tencent.tmsbeacon.base.util.b;
import com.tencent.tmsbeacon.module.ModuleName;
import com.tencent.tmsbeacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f39537a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39538c = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/c$a.class */
    public class a implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.tencent.tmsbeacon.a.d.a f39539c;

        public a(String str, com.tencent.tmsbeacon.a.d.a aVar) {
            this.b = str;
            this.f39539c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.d()) {
                boolean c2 = c.this.c();
                if (c.this.f39538c && c2) {
                    com.tencent.tmsbeacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success : " + this.b, new Object[0]);
                    a.SharedPreferences$EditorC1031a edit = this.f39539c.edit();
                    if (b.a((SharedPreferences.Editor) edit)) {
                        edit.putString("active_user_date", this.b).commit();
                        edit.putString("HEART_DENGTA", this.b).commit();
                    }
                }
            }
        }
    }

    public c(Context context) {
        this.f39537a = context;
        this.b = com.tencent.tmsbeacon.a.c.b.e(context);
    }

    private Map<String, String> b() {
        this.f39538c = com.tencent.tmsbeacon.a.c.b.d;
        HashMap hashMap = new HashMap(8);
        e l = e.l();
        f e = f.e();
        hashMap.put("A19", l.q());
        hashMap.put("A66", com.tencent.tmsbeacon.a.c.b.e(this.f39537a) ? "F" : "B");
        hashMap.put("A68", "" + com.tencent.tmsbeacon.a.c.b.b(this.f39537a));
        hashMap.put("A85", this.f39538c ? "Y" : "N");
        hashMap.put("A20", e.j());
        hashMap.put("A69", e.k());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return ((StatModule) com.tencent.tmsbeacon.a.c.c.d().a(ModuleName.STAT)).b(b());
    }

    public void a() {
        com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
        if (b.d().equals(a2.getString("active_user_date", ""))) {
            com.tencent.tmsbeacon.base.util.c.e("[event] active user event had upload.", new Object[0]);
            return;
        }
        com.tencent.tmsbeacon.base.util.c.a("[event] recover a heart beat for active user.", new Object[0]);
        if (c()) {
            com.tencent.tmsbeacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success", new Object[0]);
            a.SharedPreferences$EditorC1031a edit = a2.edit();
            if (b.a((SharedPreferences.Editor) edit)) {
                edit.putString("active_user_date", b.d()).apply();
            }
        }
    }

    public void a(com.tencent.tmsbeacon.d.b bVar) {
        String d = b.d();
        com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
        String string = a2.getString("HEART_DENGTA", "");
        String string2 = a2.getString("active_user_date", "");
        if (d.equals(string) || string2.equals(d)) {
            com.tencent.tmsbeacon.base.util.c.e("[event] heartbeat had upload!", new Object[0]);
        } else if (bVar.a("rqd_heartbeat")) {
            com.tencent.tmsbeacon.base.util.c.e("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
        } else if (bVar.b("rqd_heartbeat")) {
            com.tencent.tmsbeacon.a.b.a.a().a(new a(d, a2));
        } else {
            com.tencent.tmsbeacon.base.util.c.e("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
        }
    }
}
