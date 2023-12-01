package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/f.class */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f37062a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37063c;

    private f(BeautyProcessor beautyProcessor, String str, int i) {
        this.f37062a = beautyProcessor;
        this.b = str;
        this.f37063c = i;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, String str, int i) {
        return new f(beautyProcessor, str, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37062a.updateStatsInternal(this.b, this.f37063c);
    }
}
