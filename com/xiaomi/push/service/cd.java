package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cd.class */
public final class cd extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f27971a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Notification f995a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f996a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f997a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(int i, String str, Context context, String str2, Notification notification) {
        this.f27971a = i;
        this.f997a = str;
        this.f996a = context;
        this.b = str2;
        this.f995a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public final String mo8500a() {
        String b;
        b = cc.b(this.f27971a, this.f997a);
        return b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cc.c(this.f996a, this.b, this.f27971a, this.f997a, this.f995a);
    }
}
