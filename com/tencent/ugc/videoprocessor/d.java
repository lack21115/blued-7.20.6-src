package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.n;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f40455a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final n f40456c;

    private d(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        this.f40455a = watermarkProcessor;
        this.b = list;
        this.f40456c = nVar;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        return new d(watermarkProcessor, list, nVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40455a.setAnimatedPasterListInternal(this.b, this.f40456c);
    }
}
