package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditer;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ax.class */
public final /* synthetic */ class ax implements TXVideoEditer.TXThumbnailListener {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f40242a;
    private final List b;

    /* renamed from: c  reason: collision with root package name */
    private final UGCThumbnailGenerator f40243c;

    private ax(TXVideoEditer.TXThumbnailListener tXThumbnailListener, List list, UGCThumbnailGenerator uGCThumbnailGenerator) {
        this.f40242a = tXThumbnailListener;
        this.b = list;
        this.f40243c = uGCThumbnailGenerator;
    }

    public static TXVideoEditer.TXThumbnailListener a(TXVideoEditer.TXThumbnailListener tXThumbnailListener, List list, UGCThumbnailGenerator uGCThumbnailGenerator) {
        return new ax(tXThumbnailListener, list, uGCThumbnailGenerator);
    }

    @Override // com.tencent.ugc.TXVideoEditer.TXThumbnailListener
    public final void onThumbnail(int i, long j, Bitmap bitmap) {
        TXVideoEditer.lambda$doGetThumbnail$52(this.f40242a, this.b, this.f40243c, i, j, bitmap);
    }
}
