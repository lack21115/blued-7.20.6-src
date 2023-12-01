package com.tencent.beacon.event;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/e.class */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f35052a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, long j) {
        this.b = fVar;
        this.f35052a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set<Long> set;
        com.tencent.beacon.event.a.a aVar;
        String str;
        String str2;
        g gVar;
        Set<Long> set2;
        g gVar2;
        StringBuilder sb = new StringBuilder();
        set = this.b.f35053a;
        for (Long l : set) {
            sb.append(l);
            sb.append(",");
        }
        String substring = sb.substring(0, sb.lastIndexOf(","));
        aVar = this.b.g;
        str = this.b.f;
        boolean a2 = aVar.a(str, substring);
        str2 = this.b.b;
        com.tencent.beacon.base.util.c.a(str2, 4, "delete: %s", Boolean.valueOf(a2));
        gVar = this.b.e;
        set2 = this.b.f35053a;
        gVar.a(set2);
        gVar2 = this.b.e;
        gVar2.a(this.f35052a);
    }
}
