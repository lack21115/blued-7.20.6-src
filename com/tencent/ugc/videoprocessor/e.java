package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.n;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/e.class */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f40457a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final n f40458c;

    private e(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        this.f40457a = watermarkProcessor;
        this.b = list;
        this.f40458c = nVar;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        return new e(watermarkProcessor, list, nVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40457a.setPasterListInternal(this.b, this.f40458c);
    }
}
