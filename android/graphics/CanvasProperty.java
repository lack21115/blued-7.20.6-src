package android.graphics;

import com.android.internal.util.VirtualRefBasePtr;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/CanvasProperty.class */
public final class CanvasProperty<T> {
    private VirtualRefBasePtr mProperty;

    private CanvasProperty(long j) {
        this.mProperty = new VirtualRefBasePtr(j);
    }

    public static CanvasProperty<Float> createFloat(float f) {
        return new CanvasProperty<>(nCreateFloat(f));
    }

    public static CanvasProperty<Paint> createPaint(Paint paint) {
        return new CanvasProperty<>(nCreatePaint(paint.mNativePaint));
    }

    private static native long nCreateFloat(float f);

    private static native long nCreatePaint(long j);

    public long getNativeContainer() {
        return this.mProperty.get();
    }
}
