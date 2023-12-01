package com.qiniu.pili.droid.shortvideo.a.c;

import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.f.e;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f13834a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f13835c;
    private MediaProjection d;
    private VirtualDisplay e;

    public a(int i, int i2, int i3, MediaProjection mediaProjection) {
        this.f13834a = i;
        this.b = i2;
        this.f13835c = i3;
        this.d = mediaProjection;
    }

    public void a() {
        VirtualDisplay virtualDisplay = this.e;
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
        MediaProjection mediaProjection = this.d;
        if (mediaProjection != null) {
            mediaProjection.stop();
        }
    }

    public void a(Surface surface) {
        this.e = this.d.createVirtualDisplay("ScreenRecorder-display", this.f13834a, this.b, this.f13835c, 16, surface, (VirtualDisplay.Callback) null, (Handler) null);
        e eVar = e.f;
        eVar.c("ScreenRecorder", "created virtual display: " + this.e);
    }
}
