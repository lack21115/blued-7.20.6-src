package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/eh.class */
public final /* synthetic */ class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRotateScaleFilter f40352a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f40353c;

    private eh(UGCRotateScaleFilter uGCRotateScaleFilter, float f, float f2) {
        this.f40352a = uGCRotateScaleFilter;
        this.b = f;
        this.f40353c = f2;
    }

    public static Runnable a(UGCRotateScaleFilter uGCRotateScaleFilter, float f, float f2) {
        return new eh(uGCRotateScaleFilter, f, f2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.setScaleInternal(this.f40352a.setRotateInternal(null, this.b), this.f40353c);
    }
}
