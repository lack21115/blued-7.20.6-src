package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dy.class */
public final class dy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f27675a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f330a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f331a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(Context context, String str, int i, String str2) {
        this.f330a = context;
        this.f331a = str;
        this.f27675a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        dx.c(this.f330a, this.f331a, this.f27675a, this.b);
    }
}
