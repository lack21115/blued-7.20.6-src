package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/j.class */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i f36388a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f36389c;
    private final float d;
    private final Bitmap e;
    private final Bitmap f;

    private j(i iVar, float f, float f2, float f3, Bitmap bitmap, Bitmap bitmap2) {
        this.f36388a = iVar;
        this.b = f;
        this.f36389c = f2;
        this.d = f3;
        this.e = bitmap;
        this.f = bitmap2;
    }

    public static Runnable a(i iVar, float f, float f2, float f3, Bitmap bitmap, Bitmap bitmap2) {
        return new j(iVar, f, f2, f3, bitmap, bitmap2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f36388a;
        float f = this.b;
        float f2 = this.f36389c;
        float f3 = this.d;
        Bitmap bitmap = this.e;
        Bitmap bitmap2 = this.f;
        iVar.e.put(0, f);
        iVar.e.put(1, f2);
        iVar.e.put(2, f3);
        if (bitmap == null) {
            OpenGlUtils.deleteTexture(iVar.b);
            iVar.b = -1;
            iVar.f.put(0, 0.0f);
        } else if (bitmap != iVar.f36386a) {
            iVar.b = OpenGlUtils.loadTexture(bitmap, iVar.b, false);
            iVar.f.put(0, 1.0f);
        }
        if (bitmap2 == null) {
            OpenGlUtils.deleteTexture(iVar.d);
            iVar.d = -1;
            iVar.f.put(1, 0.0f);
        } else if (bitmap2 != iVar.f36387c) {
            iVar.d = OpenGlUtils.loadTexture(bitmap2, iVar.d, false);
            iVar.f.put(1, 1.0f);
        }
        iVar.f36386a = bitmap;
        iVar.f36387c = bitmap2;
    }
}
