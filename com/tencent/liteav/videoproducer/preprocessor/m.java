package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.preprocessor.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/m.class */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37077a;
    private final float b;

    private m(h hVar, float f) {
        this.f37077a = hVar;
        this.b = f;
    }

    public static Runnable a(h hVar, float f) {
        return new m(hVar, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f37077a;
        final float f = this.b;
        final com.tencent.liteav.beauty.b.i iVar = (com.tencent.liteav.beauty.b.i) hVar.b(h.b.f37069c);
        if (iVar != null) {
            iVar.runOnDraw(new Runnable(iVar, f) { // from class: com.tencent.liteav.beauty.b.k

                /* renamed from: a  reason: collision with root package name */
                private final i f36390a;
                private final float b;

                {
                    this.f36390a = iVar;
                    this.b = f;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    i iVar2 = this.f36390a;
                    iVar2.e.put(1, this.b);
                    iVar2.e.put(2, 0.0f);
                }
            });
        }
    }
}
