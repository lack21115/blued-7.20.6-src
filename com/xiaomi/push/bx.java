package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bx.class */
public class bx extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f41294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bv bvVar) {
        this.f41294a = bvVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        String c2;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c2 = this.f41294a.c();
        context = this.f41294a.f227a;
        ca caVar = new ca(c2, new WeakReference(context));
        context2 = this.f41294a.f227a;
        ch.a(context2).a(caVar);
        this.f41294a.b("check_time");
    }
}
