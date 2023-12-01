package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/eh.class */
public final /* synthetic */ class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRotateScaleFilter f26661a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f26662c;

    private eh(UGCRotateScaleFilter uGCRotateScaleFilter, float f, float f2) {
        this.f26661a = uGCRotateScaleFilter;
        this.b = f;
        this.f26662c = f2;
    }

    public static Runnable a(UGCRotateScaleFilter uGCRotateScaleFilter, float f, float f2) {
        return new eh(uGCRotateScaleFilter, f, f2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.setScaleInternal(this.f26661a.setRotateInternal(null, this.b), this.f26662c);
    }
}
