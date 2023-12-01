package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import com.anythink.core.common.b.g;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifInfoHandle.class */
public final class GifInfoHandle {
    private volatile long a;

    static {
        LibraryLoader.a(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.a = openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset());
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.a = openFd(fileDescriptor, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream does not support marking");
        }
        this.a = openStream(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(String str) throws GifIOException {
        this.a = openFile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.a = openDirectByteBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.a = openByteArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle a(ContentResolver contentResolver, Uri uri) throws IOException {
        return "file".equals(uri.getScheme()) ? new GifInfoHandle(uri.getPath()) : new GifInfoHandle(contentResolver.openAssetFileDescriptor(uri, g.o.o));
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFd(FileDescriptor fileDescriptor, long j) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(long[] jArr, Bitmap bitmap) {
        int restoreSavedState;
        synchronized (this) {
            restoreSavedState = restoreSavedState(this.a, jArr, bitmap);
        }
        return restoreSavedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(Bitmap bitmap) {
        long renderFrame;
        synchronized (this) {
            renderFrame = renderFrame(this.a, bitmap);
        }
        return renderFrame;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this) {
            free(this.a);
            this.a = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(char c, boolean z) {
        setOptions(this.a, c, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        float f2 = f;
        if (f < 4.656613E-10f) {
            f2 = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.a, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Bitmap bitmap) {
        synchronized (this) {
            seekToTime(this.a, i, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Surface surface, long[] jArr) {
        bindSurface(this.a, surface, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        long restoreRemainder;
        synchronized (this) {
            restoreRemainder = restoreRemainder(this.a);
        }
        return restoreRemainder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, Bitmap bitmap) {
        synchronized (this) {
            seekToFrame(this.a, i, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        boolean reset;
        synchronized (this) {
            reset = reset(this.a);
        }
        return reset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        synchronized (this) {
            saveRemainder(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        int loopCount;
        synchronized (this) {
            loopCount = getLoopCount(this.a);
        }
        return loopCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        int nativeErrorCode;
        synchronized (this) {
            nativeErrorCode = getNativeErrorCode(this.a);
        }
        return nativeErrorCode;
    }

    protected void finalize() throws Throwable {
        try {
            a();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        int duration;
        synchronized (this) {
            duration = getDuration(this.a);
        }
        return duration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        int currentPosition;
        synchronized (this) {
            currentPosition = getCurrentPosition(this.a);
        }
        return currentPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        int currentFrameIndex;
        synchronized (this) {
            currentFrameIndex = getCurrentFrameIndex(this.a);
        }
        return currentFrameIndex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        int currentLoop;
        synchronized (this) {
            currentLoop = getCurrentLoop(this.a);
        }
        return currentLoop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        boolean z;
        synchronized (this) {
            z = this.a == 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        synchronized (this) {
            postUnbindSurface(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long[] m() {
        long[] savedState;
        synchronized (this) {
            savedState = getSavedState(this.a);
        }
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        int width;
        synchronized (this) {
            width = getWidth(this.a);
        }
        return width;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        int height;
        synchronized (this) {
            height = getHeight(this.a);
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        int numberOfFrames;
        synchronized (this) {
            numberOfFrames = getNumberOfFrames(this.a);
        }
        return numberOfFrames;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        boolean isOpaque;
        synchronized (this) {
            isOpaque = isOpaque(this.a);
        }
        return isOpaque;
    }
}
