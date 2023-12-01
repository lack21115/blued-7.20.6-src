package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/eg.class */
final /* synthetic */ class eg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRotateScaleFilter f26660a;
    private final float b;

    private eg(UGCRotateScaleFilter uGCRotateScaleFilter, float f) {
        this.f26660a = uGCRotateScaleFilter;
        this.b = f;
    }

    public static Runnable a(UGCRotateScaleFilter uGCRotateScaleFilter, float f) {
        return new eg(uGCRotateScaleFilter, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26660a.setRotateInternal(null, this.b);
    }
}
