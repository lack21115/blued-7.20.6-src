package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/o.class */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f37080a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37081c;

    private o(h hVar, String str, boolean z) {
        this.f37080a = hVar;
        this.b = str;
        this.f37081c = z;
    }

    public static Runnable a(h hVar, String str, boolean z) {
        return new o(hVar, str, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
