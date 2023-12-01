package com.tencent.ugc;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fj.class */
public final /* synthetic */ class fj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f40383a;
    private final List b;

    private fj(UGCThumbnailGenerator uGCThumbnailGenerator, List list) {
        this.f40383a = uGCThumbnailGenerator;
        this.b = list;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator, List list) {
        return new fj(uGCThumbnailGenerator, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCThumbnailGenerator.lambda$setVideoSourceList$1(this.f40383a, this.b);
    }
}
