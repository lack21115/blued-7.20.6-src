package android.filterpacks.videosink;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/videosink/MediaRecorderStopException.class */
public class MediaRecorderStopException extends RuntimeException {
    private static final String TAG = "MediaRecorderStopException";

    public MediaRecorderStopException() {
    }

    public MediaRecorderStopException(String str) {
        super(str);
    }

    public MediaRecorderStopException(String str, Throwable th) {
        super(str, th);
    }

    public MediaRecorderStopException(Throwable th) {
        super(th);
    }
}
