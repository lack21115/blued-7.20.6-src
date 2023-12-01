package com.tencent.beacon.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f35012a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35013c = false;

    public c(Context context) {
        this.f35012a = context;
        this.b = com.tencent.beacon.a.c.b.f(context);
    }

    private Map<String, String> b() {
        this.f35013c = com.tencent.beacon.a.c.b.d;
        HashMap hashMap = new HashMap(8);
        e l = e.l();
        f e = f.e();
        hashMap.put("A19", l.q());
        hashMap.put("A66", com.tencent.beacon.a.c.b.f(this.f35012a) ? "F" : "B");
        hashMap.put("A68", "" + com.tencent.beacon.a.c.b.b(this.f35012a));
        hashMap.put("A85", this.f35013c ? "Y" : "N");
        hashMap.put("A20", e.j());
        hashMap.put("A69", e.k());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return ((StatModule) com.tencent.beacon.a.c.c.d().a(ModuleName.STAT)).c(b());
    }

    public void a() {
        com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
        if (com.tencent.beacon.base.util.b.d().equals(a2.getString("active_user_date", ""))) {
            com.tencent.beacon.base.util.c.e("[event] active user event had upload.", new Object[0]);
            return;
        }
        com.tencent.beacon.base.util.c.a("[event] recover a heart beat for active user.", new Object[0]);
        if (c()) {
            com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success", new Object[0]);
            a.SharedPreferences$EditorC0895a edit = a2.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("active_user_date", com.tencent.beacon.base.util.b.d()).apply();
            }
        }
    }

    public void a(com.tencent.beacon.e.b bVar) {
        String d = com.tencent.beacon.base.util.b.d();
        com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
        String string = a2.getString("HEART_DENGTA", "");
        String string2 = a2.getString("active_user_date", "");
        if (d.equals(string) || string2.equals(d)) {
            com.tencent.beacon.base.util.c.e("[event] heartbeat had upload!", new Object[0]);
        } else if (bVar.a("rqd_heartbeat")) {
            com.tencent.beacon.base.util.c.e("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
        } else if (bVar.b("rqd_heartbeat")) {
            com.tencent.beacon.a.b.a.a().a(new b(this, d, a2));
        } else {
            com.tencent.beacon.base.util.c.e("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
        }
    }
}
