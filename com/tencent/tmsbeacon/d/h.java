package com.tencent.tmsbeacon.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.a.d.a;
import com.tencent.tmsbeacon.base.net.RequestType;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.module.StrategyModule;
import com.tencent.tmsbeacon.pack.CommonStrategy;
import com.tencent.tmsbeacon.pack.ModuleStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/h.class */
public class h implements Callback<byte[]>, Runnable {
    private final StrategyModule b;
    private boolean d;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f25859c = false;

    /* renamed from: a  reason: collision with root package name */
    private final Context f25858a = com.tencent.tmsbeacon.a.c.c.d().c();

    public h(StrategyModule strategyModule) {
        this.b = strategyModule;
    }

    private void a(d dVar, b bVar, ModuleStrategy moduleStrategy) {
        if (moduleStrategy.detail != null) {
            com.tencent.tmsbeacon.base.util.c.a("[strategy] mid: %d , detail changed...", Byte.valueOf(moduleStrategy.mId));
            dVar.a(moduleStrategy.detail);
            bVar.a(moduleStrategy.detail);
            this.d = true;
        }
    }

    private void a(d dVar, ModuleStrategy moduleStrategy) {
        boolean z = moduleStrategy.onOff == 1;
        if (dVar.c() != z) {
            com.tencent.tmsbeacon.base.util.c.a("[strategy] mid: %d , isUsable changed: %b ", Byte.valueOf(moduleStrategy.mId), Boolean.valueOf(z));
            dVar.a(z);
            this.d = true;
        }
    }

    private void a(ModuleStrategy moduleStrategy) {
        String a2 = com.tencent.tmsbeacon.base.net.b.b.a(moduleStrategy.url);
        if (com.tencent.tmsbeacon.base.net.b.b.a(true).equals(a2)) {
            return;
        }
        com.tencent.tmsbeacon.base.util.c.a("[strategy] mid: %d , url changed: %s", Byte.valueOf(moduleStrategy.mId), moduleStrategy.url);
        com.tencent.tmsbeacon.base.net.b.b.b(a2);
        this.d = true;
    }

    private boolean a(Map<String, String> map, a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (map != null) {
            aVar.a(map);
            z = true;
        }
        return z;
    }

    private void b(d dVar, b bVar, ModuleStrategy moduleStrategy) {
        ArrayList<String> arrayList = moduleStrategy.preventEventCode;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.tmsbeacon.base.util.c.a("[strategy] mid: %d , PreventEventCode changed...", Byte.valueOf(moduleStrategy.mId));
        this.d = true;
        dVar.a(com.tencent.tmsbeacon.base.util.b.a(moduleStrategy.preventEventCode));
        bVar.a(com.tencent.tmsbeacon.base.util.b.a(moduleStrategy.preventEventCode));
    }

    private void c() {
        f();
        this.f25859c = false;
    }

    private void c(d dVar, b bVar, ModuleStrategy moduleStrategy) {
        ArrayList<String> arrayList = moduleStrategy.sampleEvent;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.tmsbeacon.base.util.c.a("[strategy] mid: %d , SampleEventSet changed...", Byte.valueOf(moduleStrategy.mId));
        this.d = true;
        dVar.b(com.tencent.tmsbeacon.base.util.b.a(moduleStrategy.sampleEvent));
        bVar.b(com.tencent.tmsbeacon.base.util.b.a(moduleStrategy.sampleEvent));
    }

    private void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("s_e_e", Boolean.FALSE);
        com.tencent.tmsbeacon.a.a.b.a().a(new com.tencent.tmsbeacon.a.a.c(7, hashMap));
    }

    private void e() {
        com.tencent.tmsbeacon.base.util.c.a("local strategyQuery finish!", new Object[0]);
        com.tencent.tmsbeacon.a.a.b.a().a(new com.tencent.tmsbeacon.a.a.c(10));
    }

    private void f() {
        long b = this.b.a().b() * 60000;
        com.tencent.tmsbeacon.a.b.a.a().a(b, this);
        com.tencent.tmsbeacon.base.util.c.a("[strategy] next time: %d", Long.valueOf(b));
    }

    private void g() {
        if (j.b() || j.c()) {
            com.tencent.tmsbeacon.base.util.c.e("[strategy] query times or query success times arrive max, return!", new Object[0]);
            this.b.a(true);
            return;
        }
        e l = e.l();
        f e = f.e();
        com.tencent.tmsbeacon.base.net.c.c().b(JceRequestEntity.builder().a(RequestType.STRATEGY).a(100).b(101).a(com.tencent.tmsbeacon.a.c.c.d().f()).b(com.tencent.tmsbeacon.base.net.b.b.b(false)).a(com.tencent.tmsbeacon.base.net.b.b.b(true), 8081).b("A1", com.tencent.tmsbeacon.a.c.c.d().k()).b("A2", e.b()).b("A4", e.d()).b("A6", e.f()).b("A7", e.a()).b("A23", com.tencent.tmsbeacon.a.c.c.d().a()).b("A31", l.p()).b("A19", l.q()).b("A66", com.tencent.tmsbeacon.a.c.b.e(this.f25858a) ? "F" : "B").b("A67", com.tencent.tmsbeacon.a.c.b.c(this.f25858a)).b("A68", String.valueOf(com.tencent.tmsbeacon.a.c.b.b(this.f25858a))).b("A85", com.tencent.tmsbeacon.a.c.b.d ? "Y" : "N").a(com.tencent.tmsbeacon.qimei.a.a().b().getQimeiMap()).a()).b(this);
    }

    @Override // com.tencent.tmsbeacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        a(bArr, true);
        this.b.a(true);
        c();
    }

    public void a(byte[] bArr, boolean z) {
        try {
            CommonStrategy commonStrategy = new CommonStrategy();
            commonStrategy.readFrom(new com.tencent.tmsbeacon.pack.a(bArr));
            com.tencent.tmsbeacon.base.util.c.a("[strategy] -> common strategy: %s", commonStrategy);
            if (a(commonStrategy, a.a()) && z) {
                a.SharedPreferences$EditorC0861a edit = com.tencent.tmsbeacon.a.d.a.a().edit();
                if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("strategy_data", Base64.encodeToString(bArr, 0));
                }
            }
            if (z) {
                j.d();
            }
        } catch (Throwable th) {
            com.tencent.tmsbeacon.base.util.c.a(th);
            com.tencent.tmsbeacon.base.util.c.b("[strategy] error to common strategy!", new Object[0]);
        }
    }

    public boolean a() {
        return this.f25859c;
    }

    public boolean a(CommonStrategy commonStrategy, a aVar) {
        if (commonStrategy == null || aVar == null) {
            return false;
        }
        String a2 = com.tencent.tmsbeacon.base.net.b.b.a(commonStrategy.url);
        if (!a2.equals(com.tencent.tmsbeacon.base.net.b.b.b(true))) {
            com.tencent.tmsbeacon.base.util.c.a("[strategy] url changed to: %s", commonStrategy.url);
            this.d = true;
            com.tencent.tmsbeacon.base.net.b.b.d(a2);
        }
        if (commonStrategy.queryInterval != aVar.b()) {
            com.tencent.tmsbeacon.base.util.c.a("[strategy] QueryPeriod changed to: %d", Integer.valueOf(commonStrategy.queryInterval));
            this.d = true;
            aVar.a(commonStrategy.queryInterval);
        }
        if (a(commonStrategy.moduleList)) {
            this.d = true;
        }
        if (a(commonStrategy.cloudParas, aVar)) {
            this.d = true;
        }
        return this.d;
    }

    public boolean a(ArrayList<ModuleStrategy> arrayList) {
        d d = this.b.a().d();
        if (arrayList == null) {
            d.a(false);
            d();
            return false;
        }
        b b = this.b.b();
        Iterator<ModuleStrategy> it = arrayList.iterator();
        while (it.hasNext()) {
            ModuleStrategy next = it.next();
            if (next.mId == d.b()) {
                a(d, next);
                a(next);
                a(d, b, next);
                b(d, b, next);
                c(d, b, next);
            }
        }
        return this.d;
    }

    public void b() {
        byte[] bArr;
        try {
            try {
                String string = com.tencent.tmsbeacon.a.d.a.a().getString("strategy_data", "");
                if (TextUtils.isEmpty(string)) {
                    i a2 = j.a(this.f25858a, 101);
                    bArr = a2 != null ? a2.f25861c : null;
                } else {
                    bArr = Base64.decode(string, 0);
                }
                if (bArr != null) {
                    a(bArr, false);
                } else {
                    com.tencent.tmsbeacon.base.util.c.a("[strategy] local strategy is null!", new Object[0]);
                }
            } catch (Exception e) {
                com.tencent.tmsbeacon.base.util.c.a(e);
            }
        } finally {
            e();
        }
    }

    @Override // com.tencent.tmsbeacon.base.net.call.Callback
    public void onFailure(com.tencent.tmsbeacon.base.net.d dVar) {
        c();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f25859c = true;
        if (this.b.a().e()) {
            return;
        }
        g();
    }
}
