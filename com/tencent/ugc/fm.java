package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fm.class */
public final /* synthetic */ class fm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f40388a;

    private fm(UGCThumbnailGenerator uGCThumbnailGenerator) {
        this.f40388a = uGCThumbnailGenerator;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator) {
        return new fm(uGCThumbnailGenerator);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40388a.getNextThumbnail();
    }
}
