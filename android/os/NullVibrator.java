package android.os;

import android.media.AudioAttributes;

/* loaded from: source-9557208-dex2jar.jar:android/os/NullVibrator.class */
public class NullVibrator extends Vibrator {
    private static final NullVibrator sInstance = new NullVibrator();

    private NullVibrator() {
    }

    public static NullVibrator getInstance() {
        return sInstance;
    }

    @Override // android.os.Vibrator
    public void cancel() {
    }

    @Override // android.os.Vibrator
    public boolean hasVibrator() {
        return false;
    }

    @Override // android.os.Vibrator
    public void vibrate(int i, String str, long j, AudioAttributes audioAttributes) {
        vibrate(j);
    }

    @Override // android.os.Vibrator
    public void vibrate(int i, String str, long[] jArr, int i2, AudioAttributes audioAttributes) {
        if (i2 >= jArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
