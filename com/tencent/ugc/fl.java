package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.UGCThumbnailGenerator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fl.class */
public final /* synthetic */ class fl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f26695a;
    private final UGCThumbnailGenerator.UGCThumbnailGenerateParams b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f26696c;

    private fl(UGCThumbnailGenerator uGCThumbnailGenerator, UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f26695a = uGCThumbnailGenerator;
        this.b = uGCThumbnailGenerateParams;
        this.f26696c = tXThumbnailListener;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator, UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new fl(uGCThumbnailGenerator, uGCThumbnailGenerateParams, tXThumbnailListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCThumbnailGenerator.lambda$start$3(this.f26695a, this.b, this.f26696c);
    }
}
