package com.tencent.liteav.videoproducer.capture;

import android.graphics.Bitmap;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/aj.class */
final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f23179a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23180c;
    private final int d;
    private final int e;

    private aj(ah ahVar, Bitmap bitmap, int i, int i2, int i3) {
        this.f23179a = ahVar;
        this.b = bitmap;
        this.f23180c = i;
        this.d = i2;
        this.e = i3;
    }

    public static Runnable a(ah ahVar, Bitmap bitmap, int i, int i2, int i3) {
        return new aj(ahVar, bitmap, i, i2, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar = this.f23179a;
        Bitmap bitmap = this.b;
        int i = this.f23180c;
        int i2 = this.d;
        int i3 = this.e;
        ahVar.b = new VirtualCamera.VirtualCameraParams();
        ahVar.b.f23160a = bitmap;
        ahVar.b.b = i;
        ahVar.b.d = i2;
        ahVar.b.f23155c = i3;
        if (ahVar.f23173a != null) {
            ahVar.f23173a.stop();
        }
        ahVar.f23173a = new VirtualCamera(ahVar.f, ahVar.h);
        ahVar.j = true;
    }
}
