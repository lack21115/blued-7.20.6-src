package android.view;

import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceHolder.class */
public interface SurfaceHolder {
    @Deprecated
    public static final int SURFACE_TYPE_GPU = 2;
    @Deprecated
    public static final int SURFACE_TYPE_HARDWARE = 1;
    @Deprecated
    public static final int SURFACE_TYPE_NORMAL = 0;
    @Deprecated
    public static final int SURFACE_TYPE_PUSH_BUFFERS = 3;

    /* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceHolder$BadSurfaceTypeException.class */
    public static class BadSurfaceTypeException extends RuntimeException {
        public BadSurfaceTypeException() {
        }

        public BadSurfaceTypeException(String str) {
            super(str);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceHolder$Callback.class */
    public interface Callback {
        void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

        void surfaceCreated(SurfaceHolder surfaceHolder);

        void surfaceDestroyed(SurfaceHolder surfaceHolder);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceHolder$Callback2.class */
    public interface Callback2 extends Callback {
        void surfaceRedrawNeeded(SurfaceHolder surfaceHolder);
    }

    void addCallback(Callback callback);

    Surface getSurface();

    Rect getSurfaceFrame();

    boolean isCreating();

    Canvas lockCanvas();

    Canvas lockCanvas(Rect rect);

    void removeCallback(Callback callback);

    void setFixedSize(int i, int i2);

    void setFormat(int i);

    void setKeepScreenOn(boolean z);

    void setSizeFromLayout();

    @Deprecated
    void setType(int i);

    void unlockCanvasAndPost(Canvas canvas);
}
