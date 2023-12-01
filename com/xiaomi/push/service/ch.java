package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.iq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ch.class */
public final class ch implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Cif f41665a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(Cif cif) {
        this.f41665a = cif;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        byte[] a2 = iq.a(ah.a(this.f41665a.c(), this.f41665a.b(), this.f41665a, hg.Notification));
        context = cg.f41664a;
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("UNDatas UploadNotificationDatas failed because not xmsf");
            return;
        }
        context2 = cg.f41664a;
        ((XMPushService) context2).a(this.f41665a.c(), a2, true);
    }
}
