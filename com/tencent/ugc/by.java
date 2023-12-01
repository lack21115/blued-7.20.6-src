package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/by.class */
final /* synthetic */ class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f26589a;
    private final TXVideoEditConstants.TXPreviewParam b;

    private by(TXVideoJoiner tXVideoJoiner, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        this.f26589a = tXVideoJoiner;
        this.b = tXPreviewParam;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        return new by(tXVideoJoiner, tXPreviewParam);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26589a.mTXVideoEditer.initWithPreview(this.b);
    }
}
