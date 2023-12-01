package android.graphics;

import android.content.res.AssetManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Movie.class */
public class Movie {
    private final long mNativeMovie;

    private Movie(long j) {
        if (j == 0) {
            throw new RuntimeException("native movie creation failed");
        }
        this.mNativeMovie = j;
    }

    public static native Movie decodeByteArray(byte[] bArr, int i, int i2);

    public static Movie decodeFile(String str) {
        try {
            return decodeTempStream(new FileInputStream(str));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static Movie decodeStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return inputStream instanceof AssetManager.AssetInputStream ? nativeDecodeAsset(((AssetManager.AssetInputStream) inputStream).getNativeAsset()) : nativeDecodeStream(inputStream);
    }

    private static Movie decodeTempStream(InputStream inputStream) {
        Movie movie = null;
        try {
            Movie decodeStream = decodeStream(inputStream);
            movie = decodeStream;
            inputStream.close();
            return decodeStream;
        } catch (IOException e) {
            return movie;
        }
    }

    private static native Movie nativeDecodeAsset(long j);

    private static native Movie nativeDecodeStream(InputStream inputStream);

    private static native void nativeDestructor(long j);

    public void draw(Canvas canvas, float f, float f2) {
        draw(canvas, f, f2, null);
    }

    public native void draw(Canvas canvas, float f, float f2, Paint paint);

    public native int duration();

    protected void finalize() throws Throwable {
        try {
            nativeDestructor(this.mNativeMovie);
        } finally {
            super.finalize();
        }
    }

    public native int height();

    public native boolean isOpaque();

    public native boolean setTime(int i);

    public native int width();
}
