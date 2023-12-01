package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.preprocessor.h;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/k.class */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37075a;
    private final List b;

    private k(h hVar, List list) {
        this.f37075a = hVar;
        this.b = list;
    }

    public static Runnable a(h hVar, List list) {
        return new k(hVar, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f37075a;
        List<com.tencent.liteav.beauty.b.o> list = this.b;
        if (list == null || list.isEmpty()) {
            hVar.c(h.b.e);
            return;
        }
        com.tencent.liteav.beauty.b.n nVar = (com.tencent.liteav.beauty.b.n) hVar.a(h.b.e);
        nVar.enableWatermark(true);
        nVar.setWaterMarkList(list);
        com.tencent.liteav.beauty.a.h(hVar.f37065a);
    }
}
