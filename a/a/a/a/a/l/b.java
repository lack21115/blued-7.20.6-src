package a.a.a.a.a.l;

import a.a.a.a.a.e.e;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.view.Surface;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f1443a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1444c;
    public MediaProjection d;
    public VirtualDisplay e;

    public b(int i, int i2, int i3, MediaProjection mediaProjection) {
        this.f1443a = i;
        this.b = i2;
        this.f1444c = i3;
        this.d = mediaProjection;
    }

    public void a() {
        VirtualDisplay virtualDisplay = this.e;
        if (virtualDisplay != null) {
            virtualDisplay.release();
            this.e = null;
        }
        MediaProjection mediaProjection = this.d;
        if (mediaProjection != null) {
            mediaProjection.stop();
        }
    }

    public void a(Surface surface) {
        this.e = this.d.createVirtualDisplay("ScreenRecorder-display", this.f1443a, this.b, this.f1444c, 16, surface, (VirtualDisplay.Callback) null, (Handler) null);
        e eVar = e.g;
        eVar.c("ScreenRecorder", "created virtual display: " + this.e);
    }
}
