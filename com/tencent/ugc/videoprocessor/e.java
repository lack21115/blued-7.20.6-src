package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.n;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/e.class */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f26766a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final n f26767c;

    private e(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        this.f26766a = watermarkProcessor;
        this.b = list;
        this.f26767c = nVar;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        return new e(watermarkProcessor, list, nVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26766a.setPasterListInternal(this.b, this.f26767c);
    }
}
