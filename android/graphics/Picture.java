package android.graphics;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Picture.class */
public class Picture {
    private static final int WORKING_STREAM_STORAGE = 16384;
    private final long mNativePicture;
    private Canvas mRecordingCanvas;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Picture$RecordingCanvas.class */
    private static class RecordingCanvas extends Canvas {
        private final Picture mPicture;

        public RecordingCanvas(Picture picture, long j) {
            super(j);
            this.mPicture = picture;
        }

        @Override // android.graphics.Canvas
        public void drawPicture(Picture picture) {
            if (this.mPicture == picture) {
                throw new RuntimeException("Cannot draw a picture into its recording canvas");
            }
            super.drawPicture(picture);
        }

        @Override // android.graphics.Canvas
        public void setBitmap(Bitmap bitmap) {
            throw new RuntimeException("Cannot call setBitmap on a picture canvas");
        }
    }

    public Picture() {
        this(nativeConstructor(0L));
    }

    private Picture(long j) {
        if (j == 0) {
            throw new RuntimeException();
        }
        this.mNativePicture = j;
    }

    public Picture(Picture picture) {
        this(nativeConstructor(picture != null ? picture.mNativePicture : 0L));
    }

    @Deprecated
    public static Picture createFromStream(InputStream inputStream) {
        return new Picture(nativeCreateFromStream(inputStream, new byte[16384]));
    }

    private static native long nativeBeginRecording(long j, int i, int i2);

    private static native long nativeConstructor(long j);

    private static native long nativeCreateFromStream(InputStream inputStream, byte[] bArr);

    private static native void nativeDestructor(long j);

    private static native void nativeDraw(long j, long j2);

    private static native void nativeEndRecording(long j);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetWidth(long j);

    private static native boolean nativeWriteToStream(long j, OutputStream outputStream, byte[] bArr);

    public Canvas beginRecording(int i, int i2) {
        this.mRecordingCanvas = new RecordingCanvas(this, nativeBeginRecording(this.mNativePicture, i, i2));
        return this.mRecordingCanvas;
    }

    public void draw(Canvas canvas) {
        if (canvas.isHardwareAccelerated()) {
            throw new IllegalArgumentException("Picture playback is only supported on software canvas.");
        }
        if (this.mRecordingCanvas != null) {
            endRecording();
        }
        nativeDraw(canvas.getNativeCanvasWrapper(), this.mNativePicture);
    }

    public void endRecording() {
        if (this.mRecordingCanvas != null) {
            this.mRecordingCanvas = null;
            nativeEndRecording(this.mNativePicture);
        }
    }

    protected void finalize() throws Throwable {
        try {
            nativeDestructor(this.mNativePicture);
        } finally {
            super.finalize();
        }
    }

    public int getHeight() {
        return nativeGetHeight(this.mNativePicture);
    }

    public int getWidth() {
        return nativeGetWidth(this.mNativePicture);
    }

    @Deprecated
    public void writeToStream(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException();
        }
        if (!nativeWriteToStream(this.mNativePicture, outputStream, new byte[16384])) {
            throw new RuntimeException();
        }
    }
}
