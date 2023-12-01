package com.youzan.spiderman.cache;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/c.class */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f41802a;
    private /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f41803c;
    private /* synthetic */ d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, String str, String str2, d dVar) {
        this.f41802a = context;
        this.b = str;
        this.f41803c = str2;
        this.d = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f41802a, this.b, this.f41803c, this.d);
    }
}
