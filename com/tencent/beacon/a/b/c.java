package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.HttpMethod;
import com.tencent.beacon.base.net.call.Callback;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f34925a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Throwable f34926c;
    final /* synthetic */ boolean d;
    final /* synthetic */ Callback e;
    final /* synthetic */ e f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar, String str, String str2, Throwable th, boolean z, Callback callback) {
        this.f = eVar;
        this.f34925a = str;
        this.b = str2;
        this.f34926c = th;
        this.d = z;
        this.e = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        synchronized (this.f) {
            map = e.f34928a;
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            linkedHashMap.put("error_code", this.f34925a);
            linkedHashMap.put("error_msg", this.b);
            linkedHashMap.put("error_stack_full", com.tencent.beacon.base.util.b.a(this.f34926c));
            linkedHashMap.put("_dc", String.valueOf(Math.random()));
            com.tencent.beacon.base.net.c.c().a(com.tencent.beacon.base.net.call.e.b().b(this.d ? "https://htrace.wetvinfo.com/kv" : "https://h.trace.qq.com/kv").a("atta").a(linkedHashMap).a(HttpMethod.POST).a()).a(this.e);
            com.tencent.beacon.base.util.c.d("[atta] upload a new error, errorCode: %s, message: %s, stack: %s", this.f34925a, this.b, com.tencent.beacon.base.util.b.a(this.f34926c));
        }
    }
}
