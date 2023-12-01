package android.os;

import android.app.ActivityThread;
import android.content.Context;
import android.media.AudioAttributes;
import android.os.IVibratorService;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/os/SystemVibrator.class */
public class SystemVibrator extends Vibrator {
    private static final String TAG = "Vibrator";
    private final IVibratorService mService;
    private final Binder mToken;

    public SystemVibrator() {
        this.mToken = new Binder();
        this.mService = IVibratorService.Stub.asInterface(ServiceManager.getService(Context.VIBRATOR_SERVICE));
    }

    public SystemVibrator(Context context) {
        super(context);
        this.mToken = new Binder();
        this.mService = IVibratorService.Stub.asInterface(ServiceManager.getService(Context.VIBRATOR_SERVICE));
    }

    private static int usageForAttributes(AudioAttributes audioAttributes) {
        if (audioAttributes != null) {
            return audioAttributes.getUsage();
        }
        return 0;
    }

    @Override // android.os.Vibrator
    public void cancel() {
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.cancelVibrate(this.mToken);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to cancel vibration.", e);
        }
    }

    @Override // android.os.Vibrator
    public boolean hasVibrator() {
        if (this.mService == null) {
            Log.w(TAG, "Failed to vibrate; no vibrator service.");
            return false;
        }
        try {
            return this.mService.hasVibrator();
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.os.Vibrator
    public void vibrate(int i, String str, long j, AudioAttributes audioAttributes) {
        if (this.mService == null) {
            Log.w(TAG, "Failed to vibrate; no vibrator service.");
            return;
        }
        try {
            this.mService.vibrate(i, str, j, usageForAttributes(audioAttributes), this.mToken);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to vibrate.", e);
        }
    }

    @Override // android.os.Vibrator
    public void vibrate(int i, String str, long[] jArr, int i2, AudioAttributes audioAttributes) {
        if (this.mService == null) {
            Log.w(TAG, "Failed to vibrate; no vibrator service.");
        } else if (i2 >= jArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            try {
                this.mService.vibratePattern(i, str, jArr, i2, usageForAttributes(audioAttributes), this.mToken);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to vibrate.", e);
            }
        }
    }

    public void vibrateLowPriority(int i, String str, long[] jArr, int i2, AudioAttributes audioAttributes) {
        if (this.mService == null) {
            Log.w(TAG, "Failed to vibrate; no vibrator service.");
        } else if (i2 >= jArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            try {
                this.mService.vibrateLowPriority(i, str, jArr, i2, usageForAttributes(audioAttributes), this.mToken);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to vibrate.", e);
            }
        }
    }

    public void vibrateLowPriority(long[] jArr, int i, AudioAttributes audioAttributes) {
        vibrateLowPriority(Process.myUid(), ActivityThread.currentPackageName(), jArr, i, audioAttributes);
    }
}
