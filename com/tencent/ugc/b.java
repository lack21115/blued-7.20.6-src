package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/b.class */
public final /* synthetic */ class b implements TXVideoEditer.TXThumbnailListener {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40247a;

    private b(TXVideoEditer tXVideoEditer) {
        this.f40247a = tXVideoEditer;
    }

    public static TXVideoEditer.TXThumbnailListener a(TXVideoEditer tXVideoEditer) {
        return new b(tXVideoEditer);
    }

    @Override // com.tencent.ugc.TXVideoEditer.TXThumbnailListener
    public final void onThumbnail(int i, long j, Bitmap bitmap) {
        TXVideoEditer.lambda$new$1(this.f40247a, i, j, bitmap);
    }
}
