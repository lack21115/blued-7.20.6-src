package com.youzan.spiderman.cache;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/c.class */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f28111a;
    private /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f28112c;
    private /* synthetic */ d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, String str, String str2, d dVar) {
        this.f28111a = context;
        this.b = str;
        this.f28112c = str2;
        this.d = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f28111a, this.b, this.f28112c, this.d);
    }
}
