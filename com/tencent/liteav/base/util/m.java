package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.j;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/m.class */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f22648a;

    private m(j.a aVar) {
        this.f22648a = aVar;
    }

    public static Runnable a(j.a aVar) {
        return new m(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a aVar = this.f22648a;
        j.this.f22642a.execute(aVar.f22644a);
    }
}
