package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dy.class */
public final class dy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41366a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f377a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f378a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(Context context, String str, int i, String str2) {
        this.f377a = context;
        this.f378a = str;
        this.f41366a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        dx.c(this.f377a, this.f378a, this.f41366a, this.b);
    }
}
