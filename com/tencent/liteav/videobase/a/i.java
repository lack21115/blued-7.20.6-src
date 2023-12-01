package com.tencent.liteav.videobase.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/i.class */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f36582a;

    private i(h hVar) {
        this.f36582a = hVar;
    }

    public static Runnable a(h hVar) {
        return new i(hVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36582a.initFiltersAndInterceptors();
    }
}
