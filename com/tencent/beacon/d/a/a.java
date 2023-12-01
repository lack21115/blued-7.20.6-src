package com.tencent.beacon.d.a;

import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.module.StatModule;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/a/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f35004a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f35004a = cVar;
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
        map = this.f35004a.g;
        map.put("A19", l.q());
        map2 = this.f35004a.g;
        map2.put("A85", com.tencent.beacon.a.c.b.d ? "Y" : "N");
        map3 = this.f35004a.g;
        map3.put("A20", e.j());
        map4 = this.f35004a.g;
        map4.put("A69", e.k());
        statModule = this.f35004a.h;
        map5 = this.f35004a.g;
        statModule.b(map5);
    }
}
