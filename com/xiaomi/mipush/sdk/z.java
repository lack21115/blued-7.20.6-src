package com.xiaomi.mipush.sdk;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/z.class */
public final class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27549a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context) {
        this.f27549a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageHandleService.c(this.f27549a);
    }
}
