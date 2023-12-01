package android.hardware.camera2.legacy;

import android.util.AndroidException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyExceptionUtils.class */
public class LegacyExceptionUtils {
    private static final String TAG = "LegacyExceptionUtils";

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyExceptionUtils$BufferQueueAbandonedException.class */
    public static class BufferQueueAbandonedException extends AndroidException {
        public BufferQueueAbandonedException() {
        }

        public BufferQueueAbandonedException(Exception exc) {
            super(exc);
        }

        public BufferQueueAbandonedException(String str) {
            super(str);
        }

        public BufferQueueAbandonedException(String str, Throwable th) {
            super(str, th);
        }
    }

    private LegacyExceptionUtils() {
        throw new AssertionError();
    }

    public static int throwOnError(int i) throws BufferQueueAbandonedException {
        int i2;
        switch (i) {
            case -19:
                throw new BufferQueueAbandonedException();
            case 0:
                i2 = 0;
                break;
            default:
                i2 = i;
                if (i < 0) {
                    throw new UnsupportedOperationException("Unknown error " + i);
                }
                break;
        }
        return i2;
    }
}
