package android.media;

import android.graphics.Rect;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/media/Image.class */
public abstract class Image implements AutoCloseable {
    private Rect mCropRect;

    /* loaded from: source-9557208-dex2jar.jar:android/media/Image$Plane.class */
    public static abstract class Plane {
        public abstract ByteBuffer getBuffer();

        public abstract int getPixelStride();

        public abstract int getRowStride();
    }

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public Rect getCropRect() {
        return this.mCropRect == null ? new Rect(0, 0, getWidth(), getHeight()) : new Rect(this.mCropRect);
    }

    public abstract int getFormat();

    public abstract int getHeight();

    public abstract Plane[] getPlanes();

    public abstract long getTimestamp();

    public abstract int getWidth();

    public void setCropRect(Rect rect) {
        Rect rect2 = rect;
        if (rect != null) {
            rect2 = new Rect(rect);
            rect2.intersect(0, 0, getWidth(), getHeight());
        }
        this.mCropRect = rect2;
    }
}
