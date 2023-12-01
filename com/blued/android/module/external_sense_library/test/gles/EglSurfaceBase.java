package com.blued.android.module.external_sense_library.test.gles;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import com.blued.android.module.external_sense_library.utils.HandlerUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/EglSurfaceBase.class */
public class EglSurfaceBase {
    protected EglCore a;
    private EGLSurface b = EGL14.EGL_NO_SURFACE;
    private int c = -1;
    private int d = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public EglSurfaceBase(EglCore eglCore) {
        this.a = eglCore;
    }

    public int a() {
        int i = this.c;
        int i2 = i;
        if (i < 0) {
            i2 = this.a.a(this.b, EGL10.EGL_WIDTH);
        }
        return i2;
    }

    public void a(int i, int i2) {
        if (this.b != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.b = this.a.a(i, i2);
        this.c = i;
        this.d = i2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x00c1 -> B:6:0x006d). Please submit an issue!!! */
    public void a(File file) throws IOException {
        if (!this.a.c(this.b)) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        String file2 = file.toString();
        int a = a();
        int b = b();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(a * b * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, a, b, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, allocateDirect);
        GlUtil.a("glReadPixels");
        allocateDirect.rewind();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            HandlerUtils.a(new File(file2), createBitmap);
            createBitmap.recycle();
        } catch (Exception e) {
        }
        Log.d("Grafika", "Saved " + a + "x" + b + " frame as '" + file2 + "'");
    }

    public int b() {
        int i = this.d;
        int i2 = i;
        if (i < 0) {
            i2 = this.a.a(this.b, EGL10.EGL_HEIGHT);
        }
        return i2;
    }

    public void c() {
        this.a.a(this.b);
        this.b = EGL14.EGL_NO_SURFACE;
        this.d = -1;
        this.c = -1;
    }

    public void d() {
        this.a.b(this.b);
    }
}
