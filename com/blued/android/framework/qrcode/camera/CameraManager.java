package com.blued.android.framework.qrcode.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/camera/CameraManager.class */
public final class CameraManager {

    /* renamed from: a  reason: collision with root package name */
    static final int f6656a;
    private static final String b = CameraManager.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static CameraManager f6657c;
    private final Context d;
    private final CameraConfigurationManager e;
    private Camera f;
    private boolean g;
    private boolean h;
    private final boolean i;
    private final PreviewCallback j;
    private final AutoFocusCallback k;
    private Camera.Parameters l;

    static {
        int i;
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            i = 10000;
        }
        f6656a = i;
    }

    private CameraManager(Context context) {
        this.d = context;
        this.e = new CameraConfigurationManager(context);
        boolean z = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.i = z;
        this.j = new PreviewCallback(this.e, z);
        this.k = new AutoFocusCallback();
    }

    public static CameraManager a() {
        return f6657c;
    }

    public static void a(Context context) {
        if (f6657c == null) {
            f6657c = new CameraManager(context);
        }
    }

    public PlanarYUVLuminanceSource a(byte[] bArr, int i, int i2, Rect rect) {
        if (rect == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, rect.left, rect.top, rect.width(), rect.height(), false);
    }

    public void a(Handler handler, int i) {
        if (this.f == null || !this.h) {
            return;
        }
        this.j.a(handler, i);
        if (this.i) {
            this.f.setOneShotPreviewCallback(this.j);
        } else {
            this.f.setPreviewCallback(this.j);
        }
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f == null) {
            Camera open = Camera.open();
            this.f = open;
            if (open == null) {
                throw new IOException();
            }
            open.setPreviewDisplay(surfaceHolder);
            if (!this.g) {
                this.g = true;
                this.e.a(this.f);
            }
            this.e.b(this.f);
            FlashlightManager.a();
        }
    }

    public void b() {
        if (this.f != null) {
            FlashlightManager.b();
            this.f.release();
            this.f = null;
        }
    }

    public void b(Handler handler, int i) {
        if (this.f == null || !this.h) {
            return;
        }
        this.k.a(handler, i);
        try {
            this.f.autoFocus(this.k);
        } catch (Exception e) {
            Log.i(b, "Requested auto-focus callback fail.");
        }
    }

    public Point c() {
        return this.e.a();
    }

    public void d() {
        Camera camera = this.f;
        if (camera == null || this.h) {
            return;
        }
        camera.startPreview();
        this.h = true;
    }

    public void e() {
        Camera camera = this.f;
        if (camera == null || !this.h) {
            return;
        }
        if (!this.i) {
            camera.setPreviewCallback(null);
        }
        this.f.stopPreview();
        this.j.a(null, 0);
        this.k.a(null, 0);
        this.h = false;
    }

    public void f() {
        Camera camera = this.f;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.l = parameters;
            parameters.setFlashMode("torch");
            this.f.setParameters(this.l);
        }
    }

    public void g() {
        Camera camera = this.f;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.l = parameters;
            parameters.setFlashMode("off");
            this.f.setParameters(this.l);
        }
    }
}
