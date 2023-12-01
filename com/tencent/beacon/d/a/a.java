package com.tencent.beacon.d.a;

import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.module.StatModule;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/a/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f21313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f21313a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        StatModule statModule;
        Map<String, String> map5;
        e l = e.l();
        f e = f.e();
        map = this.f21313a.g;
        map.put("A19", l.q());
        map2 = this.f21313a.g;
        map2.put("A85", com.tencent.beacon.a.c.b.d ? "Y" : "N");
        map3 = this.f21313a.g;
        map3.put("A20", e.j());
        map4 = this.f21313a.g;
        map4.put("A69", e.k());
        statModule = this.f21313a.h;
        map5 = this.f21313a.g;
        statModule.b(map5);
    }
}
