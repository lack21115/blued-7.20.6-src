package com.tencent.beacon.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.module.StrategyModule;
import com.tencent.beacon.pack.CommonStrategy;
import com.tencent.beacon.pack.ModuleStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/i.class */
public class i implements Callback<byte[]>, Runnable {
    private final StrategyModule b;
    private boolean d;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f35026c = false;

    /* renamed from: a  reason: collision with root package name */
    private final Context f35025a = com.tencent.beacon.a.c.c.d().c();

    public i(StrategyModule strategyModule) {
        this.b = strategyModule;
    }

    private void a(e eVar, b bVar, ModuleStrategy moduleStrategy) {
        if (moduleStrategy.detail != null) {
            com.tencent.beacon.base.util.c.a("[strategy] mid: %d , detail changed...", Byte.valueOf(moduleStrategy.mId));
            eVar.a(moduleStrategy.detail);
            bVar.a(moduleStrategy.detail);
            this.d = true;
        }
    }

    private void a(e eVar, ModuleStrategy moduleStrategy) {
        boolean z = moduleStrategy.onOff == 1;
        if (eVar.c() != z) {
            com.tencent.beacon.base.util.c.a("[strategy] mid: %d , isUsable changed: %b ", Byte.valueOf(moduleStrategy.mId), Boolean.valueOf(z));
            eVar.a(z);
            this.d = true;
        }
    }

    private void a(ModuleStrategy moduleStrategy) {
        String a2 = com.tencent.beacon.base.net.b.b.a(moduleStrategy.url);
        if (com.tencent.beacon.base.net.b.b.a(true).equals(a2)) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , url changed: %s", Byte.valueOf(moduleStrategy.mId), moduleStrategy.url);
        com.tencent.beacon.base.net.b.b.b(a2);
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

    private void b(e eVar, b bVar, ModuleStrategy moduleStrategy) {
        ArrayList<String> arrayList = moduleStrategy.preventEventCode;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , PreventEventCode changed...", Byte.valueOf(moduleStrategy.mId));
        this.d = true;
        eVar.a(com.tencent.beacon.base.util.b.a(moduleStrategy.preventEventCode));
        bVar.a(com.tencent.beacon.base.util.b.a(moduleStrategy.preventEventCode));
    }

    private void c() {
        f();
        this.f35026c = false;
    }

    private void c(e eVar, b bVar, ModuleStrategy moduleStrategy) {
        ArrayList<String> arrayList = moduleStrategy.sampleEvent;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[strategy] mid: %d , SampleEventSet changed...", Byte.valueOf(moduleStrategy.mId));
        this.d = true;
        eVar.b(com.tencent.beacon.base.util.b.a(moduleStrategy.sampleEvent));
        bVar.b(com.tencent.beacon.base.util.b.a(moduleStrategy.sampleEvent));
    }

    private void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("s_e_e", false);
        com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(7, hashMap));
    }

    private void e() {
        com.tencent.beacon.base.util.c.a("local strategyQuery finish!", new Object[0]);
        com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(10));
    }

    private void f() {
        long b = this.b.a().b() * 60000;
        com.tencent.beacon.a.b.a.a().a(b, this);
        com.tencent.beacon.base.util.c.a("[strategy] next time: %d", Long.valueOf(b));
    }

    private void g() {
        if (k.b() || k.c()) {
            com.tencent.beacon.base.util.c.e("[strategy] query times or query success times arrive max, return!", new Object[0]);
            this.b.a(true);
            return;
        }
        com.tencent.beacon.a.c.e l = com.tencent.beacon.a.c.e.l();
        com.tencent.beacon.a.c.f e = com.tencent.beacon.a.c.f.e();
        com.tencent.beacon.base.net.c.c().b(JceRequestEntity.builder().a(RequestType.STRATEGY).a(100).b(101).a(com.tencent.beacon.a.c.c.d().f()).b(com.tencent.beacon.base.net.b.b.b(false)).a(com.tencent.beacon.base.net.b.b.b(true), 8081).b("A1", com.tencent.beacon.a.c.c.d().l()).b("A2", e.b()).b("A4", e.d()).b("A6", e.f()).b("A7", e.a()).b("A23", com.tencent.beacon.a.c.c.d().a()).b("A31", l.p()).b("A19", l.q()).b("A66", com.tencent.beacon.a.c.b.f(this.f35025a) ? "F" : "B").b("A67", com.tencent.beacon.a.c.b.c(this.f35025a)).b("A68", String.valueOf(com.tencent.beacon.a.c.b.b(this.f35025a))).b("A85", com.tencent.beacon.a.c.b.d ? "Y" : "N").a(com.tencent.beacon.a.c.j.e()).a()).b(this);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(byte[] bArr) {
        a(bArr, true);
        this.b.a(true);
        c();
    }

    public void a(byte[] bArr, boolean z) {
        try {
            CommonStrategy commonStrategy = new CommonStrategy();
            commonStrategy.readFrom(new com.tencent.beacon.pack.a(bArr));
            com.tencent.beacon.base.util.c.a("[strategy] -> common strategy: %s", commonStrategy);
            if (a(commonStrategy, a.a()) && z) {
                a.SharedPreferences$EditorC0895a edit = com.tencent.beacon.a.d.a.a().edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("strategy_data", Base64.encodeToString(bArr, 0));
                }
            }
            if (z) {
                k.d();
            }
        } catch (Throwable th) {
            com.tencent.beacon.base.util.c.a(th);
            com.tencent.beacon.base.util.c.b("[strategy] error to common strategy!", new Object[0]);
        }
    }

    public boolean a() {
        return this.f35026c;
    }

    protected boolean a(CommonStrategy commonStrategy, a aVar) {
        if (commonStrategy == null || aVar == null) {
            return false;
        }
        String a2 = com.tencent.beacon.base.net.b.b.a(commonStrategy.url);
        if (!a2.equals(com.tencent.beacon.base.net.b.b.b(true))) {
            com.tencent.beacon.base.util.c.a("[strategy] url changed to: %s", commonStrategy.url);
            this.d = true;
            com.tencent.beacon.base.net.b.b.d(a2);
        }
        if (commonStrategy.queryInterval != aVar.b()) {
            com.tencent.beacon.base.util.c.a("[strategy] QueryPeriod changed to: %d", Integer.valueOf(commonStrategy.queryInterval));
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

    boolean a(ArrayList<ModuleStrategy> arrayList) {
        e d = this.b.a().d();
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
                String string = com.tencent.beacon.a.d.a.a().getString("strategy_data", "");
                if (TextUtils.isEmpty(string)) {
                    j a2 = k.a(this.f35025a, 101);
                    bArr = a2 != null ? a2.f35028c : null;
                } else {
                    bArr = Base64.decode(string, 0);
                }
                if (bArr != null) {
                    a(bArr, false);
                } else {
                    com.tencent.beacon.base.util.c.a("[strategy] local strategy is null!", new Object[0]);
                }
            } catch (Exception e) {
                com.tencent.beacon.base.util.c.a(e);
            }
        } finally {
            e();
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        c();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f35026c = true;
        if (this.b.a().e()) {
            return;
        }
        g();
    }
}
