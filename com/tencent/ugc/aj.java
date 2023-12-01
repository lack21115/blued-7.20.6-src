package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/aj.class */
public final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40225a;
    private final TXVideoEditConstants.TXPreviewParam b;

    private aj(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        this.f40225a = tXVideoEditer;
        this.b = tXPreviewParam;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        return new aj(tXVideoEditer, tXPreviewParam);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$initWithPreview$39(this.f40225a, this.b);
    }
}
