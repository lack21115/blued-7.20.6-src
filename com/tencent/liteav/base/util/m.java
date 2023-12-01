package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/m.class */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f36339a;

    private m(j.a aVar) {
        this.f36339a = aVar;
    }

    public static Runnable a(j.a aVar) {
        return new m(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a aVar = this.f36339a;
        j.this.f36333a.execute(aVar.f36335a);
    }
}
