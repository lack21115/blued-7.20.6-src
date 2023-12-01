package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.n;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f40453a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final n f40454c;

    private c(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        this.f40453a = watermarkProcessor;
        this.b = list;
        this.f40454c = nVar;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, n nVar) {
        return new c(watermarkProcessor, list, nVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40453a.setSubtitleListInternal(this.b, this.f40454c);
    }
}
