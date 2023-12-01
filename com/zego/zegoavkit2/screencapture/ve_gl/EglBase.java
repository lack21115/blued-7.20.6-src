package com.zego.zegoavkit2.screencapture.ve_gl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import com.zego.zegoavkit2.screencapture.ve_gl.EglBase10;
import com.zego.zegoavkit2.screencapture.ve_gl.EglBase14;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/screencapture/ve_gl/EglBase.class */
public abstract class EglBase {
    private static final int EGL_OPENGL_ES2_BIT = 4;
    public static final Object lock = new Object();
    public static final int[] CONFIG_PLAIN = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE};
    public static final int[] CONFIG_RGBA = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE};
    public static final int[] CONFIG_PIXEL_BUFFER = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_SURFACE_TYPE, 1, EGL14.EGL_NONE};
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_SURFACE_TYPE, 1, EGL14.EGL_NONE};
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int[] CONFIG_RECORDABLE = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL_RECORDABLE_ANDROID, 1, EGL14.EGL_NONE};

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/screencapture/ve_gl/EglBase$Context.class */
    public static class Context {
    }

    public static EglBase create() {
        return create(null, CONFIG_PLAIN);
    }

    public static EglBase create(Context context) {
        return create(context, CONFIG_PLAIN);
    }

    public static EglBase create(Context context, int[] iArr) {
        return (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, iArr) : new EglBase10((EglBase10.Context) context, iArr);
    }

    public abstract void createDummyPbufferSurface();

    public abstract void createPbufferSurface(int i, int i2);

    public abstract void createSurface(SurfaceTexture surfaceTexture);

    public abstract void createSurface(Surface surface);

    public abstract void detachCurrent();

    public abstract Context getEglBaseContext();

    public abstract boolean hasSurface();

    public abstract void makeCurrent();

    public abstract void release();

    public abstract void releaseSurface();

    public abstract int surfaceHeight();

    public abstract int surfaceWidth();

    public abstract void swapBuffers();
}
