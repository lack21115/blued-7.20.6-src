package android.os;

import android.app.ActivityThread;
import android.content.Context;
import android.media.AudioAttributes;

/* loaded from: source-9557208-dex2jar.jar:android/os/Vibrator.class */
public abstract class Vibrator {
    private final String mPackageName;

    public Vibrator() {
        this.mPackageName = ActivityThread.currentPackageName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Vibrator(Context context) {
        this.mPackageName = context.getOpPackageName();
    }

    public abstract void cancel();

    public abstract boolean hasVibrator();

    public abstract void vibrate(int i, String str, long j, AudioAttributes audioAttributes);

    public abstract void vibrate(int i, String str, long[] jArr, int i2, AudioAttributes audioAttributes);

    public void vibrate(long j) {
        vibrate(j, (AudioAttributes) null);
    }

    public void vibrate(long j, AudioAttributes audioAttributes) {
        vibrate(Process.myUid(), this.mPackageName, j, audioAttributes);
    }

    public void vibrate(long[] jArr, int i) {
        vibrate(jArr, i, null);
    }

    public void vibrate(long[] jArr, int i, AudioAttributes audioAttributes) {
        vibrate(Process.myUid(), this.mPackageName, jArr, i, audioAttributes);
    }
}
