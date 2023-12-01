package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bx.class */
public class bx extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bv f27603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bv bvVar) {
        this.f27603a = bvVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo8500a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        String c2;
        Context context;
        Context context2;
        com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
        c2 = this.f27603a.c();
        context = this.f27603a.f180a;
        ca caVar = new ca(c2, new WeakReference(context));
        context2 = this.f27603a.f180a;
        ch.a(context2).a(caVar);
        this.f27603a.b("check_time");
    }
}
