package com.tencent.liteav.videoproducer.capture;

import android.graphics.Bitmap;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/aj.class */
final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f36870a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36871c;
    private final int d;
    private final int e;

    private aj(ah ahVar, Bitmap bitmap, int i, int i2, int i3) {
        this.f36870a = ahVar;
        this.b = bitmap;
        this.f36871c = i;
        this.d = i2;
        this.e = i3;
    }

    public static Runnable a(ah ahVar, Bitmap bitmap, int i, int i2, int i3) {
        return new aj(ahVar, bitmap, i, i2, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f36870a;
        Bitmap bitmap = this.b;
        int i = this.f36871c;
        int i2 = this.d;
        int i3 = this.e;
        ahVar.b = new VirtualCamera.VirtualCameraParams();
        ahVar.b.f36851a = bitmap;
        ahVar.b.b = i;
        ahVar.b.d = i2;
        ahVar.b.f36846c = i3;
        if (ahVar.f36864a != null) {
            ahVar.f36864a.stop();
        }
        ahVar.f36864a = new VirtualCamera(ahVar.f, ahVar.h);
        ahVar.j = true;
    }
}
