package android.os;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/os/PowerManager.class */
public final class PowerManager {
    public static final int ACQUIRE_CAUSES_WAKEUP = 268435456;
    public static final String ACTION_POWER_SAVE_MODE_CHANGED = "android.os.action.POWER_SAVE_MODE_CHANGED";
    public static final String ACTION_POWER_SAVE_MODE_CHANGING = "android.os.action.POWER_SAVE_MODE_CHANGING";
    public static final int BRIGHTNESS_DEFAULT = -1;
    public static final int BRIGHTNESS_OFF = 0;
    public static final int BRIGHTNESS_ON = 255;
    public static final int DOZE_WAKE_LOCK = 64;
    public static final String EXTRA_POWER_SAVE_MODE = "mode";
    @Deprecated
    public static final int FULL_WAKE_LOCK = 26;
    public static final int GO_TO_SLEEP_FLAG_NO_DOZE = 1;
    public static final int GO_TO_SLEEP_REASON_APPLICATION = 0;
    public static final int GO_TO_SLEEP_REASON_DEVICE_ADMIN = 1;
    public static final int GO_TO_SLEEP_REASON_HDMI = 5;
    public static final int GO_TO_SLEEP_REASON_LID_SWITCH = 3;
    public static final int GO_TO_SLEEP_REASON_POWER_BUTTON = 4;
    public static final int GO_TO_SLEEP_REASON_TIMEOUT = 2;
    public static final int ON_AFTER_RELEASE = 536870912;
    public static final int PARTIAL_WAKE_LOCK = 1;
    public static final String POWER_PROFILE_CHANGED = "com.mokee.power.PROFILE_CHANGED";
    public static final String PROFILE_BALANCED = "1";
    public static final String PROFILE_HIGH_PERFORMANCE = "2";
    public static final String PROFILE_POWER_SAVE = "0";
    public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32;
    public static final String REBOOT_RECOVERY = "recovery";
    public static final int RELEASE_FLAG_WAIT_FOR_NO_PROXIMITY = 1;
    @Deprecated
    public static final int SCREEN_BRIGHT_WAKE_LOCK = 10;
    @Deprecated
    public static final int SCREEN_DIM_WAKE_LOCK = 6;
    private static final String TAG = "PowerManager";
    public static final int UNIMPORTANT_FOR_LOGGING = 1073741824;
    public static final int USER_ACTIVITY_EVENT_BUTTON = 1;
    public static final int USER_ACTIVITY_EVENT_OTHER = 0;
    public static final int USER_ACTIVITY_EVENT_TOUCH = 2;
    public static final int USER_ACTIVITY_FLAG_INDIRECT = 2;
    public static final int USER_ACTIVITY_FLAG_NO_CHANGE_LIGHTS = 1;
    public static final int WAKE_LOCK_LEVEL_MASK = 65535;
    final Context mContext;
    final Handler mHandler;
    private final boolean mHasPowerProfilesSupport;
    final IPowerManager mService;

    /* loaded from: source-9557208-dex2jar.jar:android/os/PowerManager$WakeLock.class */
    public final class WakeLock {
        private int mCount;
        private int mFlags;
        private boolean mHeld;
        private String mHistoryTag;
        private final String mPackageName;
        private String mTag;
        private final String mTraceName;
        private WorkSource mWorkSource;
        private boolean mRefCounted = true;
        private final Runnable mReleaser = new Runnable() { // from class: android.os.PowerManager.WakeLock.1
            @Override // java.lang.Runnable
            public void run() {
                WakeLock.this.release();
            }
        };
        private final IBinder mToken = new Binder();

        WakeLock(int i, String str, String str2) {
            this.mFlags = i;
            this.mTag = str;
            this.mPackageName = str2;
            this.mTraceName = "WakeLock (" + this.mTag + ")";
        }

        private void acquireLocked() {
            if (this.mRefCounted) {
                int i = this.mCount;
                this.mCount = i + 1;
                if (i != 0) {
                    return;
                }
            }
            PowerManager.this.mHandler.removeCallbacks(this.mReleaser);
            Trace.asyncTraceBegin(131072L, this.mTraceName, 0);
            try {
                PowerManager.this.mService.acquireWakeLock(this.mToken, this.mFlags, this.mTag, this.mPackageName, this.mWorkSource, this.mHistoryTag);
            } catch (RemoteException e) {
            }
            this.mHeld = true;
        }

        public void acquire() {
            synchronized (this.mToken) {
                acquireLocked();
            }
        }

        public void acquire(long j) {
            synchronized (this.mToken) {
                acquireLocked();
                PowerManager.this.mHandler.postDelayed(this.mReleaser, j);
            }
        }

        protected void finalize() throws Throwable {
            synchronized (this.mToken) {
                if (this.mHeld) {
                    Log.wtf(PowerManager.TAG, "WakeLock finalized while still held: " + this.mTag);
                    Trace.asyncTraceEnd(131072L, this.mTraceName, 0);
                    try {
                        PowerManager.this.mService.releaseWakeLock(this.mToken, 0);
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        public boolean isHeld() {
            boolean z;
            synchronized (this.mToken) {
                z = this.mHeld;
            }
            return z;
        }

        public void release() {
            release(0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
            if (r0 == 0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void release(int r6) {
            /*
                r5 = this;
                r0 = r5
                android.os.IBinder r0 = r0.mToken
                r8 = r0
                r0 = r8
                monitor-enter(r0)
                r0 = r5
                boolean r0 = r0.mRefCounted     // Catch: java.lang.Throwable -> L79
                if (r0 == 0) goto L1e
                r0 = r5
                int r0 = r0.mCount     // Catch: java.lang.Throwable -> L79
                r1 = 1
                int r0 = r0 - r1
                r7 = r0
                r0 = r5
                r1 = r7
                r0.mCount = r1     // Catch: java.lang.Throwable -> L79
                r0 = r7
                if (r0 != 0) goto L54
            L1e:
                r0 = r5
                android.os.PowerManager r0 = android.os.PowerManager.this     // Catch: java.lang.Throwable -> L79
                android.os.Handler r0 = r0.mHandler     // Catch: java.lang.Throwable -> L79
                r1 = r5
                java.lang.Runnable r1 = r1.mReleaser     // Catch: java.lang.Throwable -> L79
                r0.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L79
                r0 = r5
                boolean r0 = r0.mHeld     // Catch: java.lang.Throwable -> L79
                if (r0 == 0) goto L54
                r0 = 131072(0x20000, double:6.47582E-319)
                r1 = r5
                java.lang.String r1 = r1.mTraceName     // Catch: java.lang.Throwable -> L79
                r2 = 0
                android.os.Trace.asyncTraceEnd(r0, r1, r2)     // Catch: java.lang.Throwable -> L79
                r0 = r5
                android.os.PowerManager r0 = android.os.PowerManager.this     // Catch: java.lang.Throwable -> L79 android.os.RemoteException -> L83
                android.os.IPowerManager r0 = r0.mService     // Catch: java.lang.Throwable -> L79 android.os.RemoteException -> L83
                r1 = r5
                android.os.IBinder r1 = r1.mToken     // Catch: java.lang.Throwable -> L79 android.os.RemoteException -> L83
                r2 = r6
                r0.releaseWakeLock(r1, r2)     // Catch: java.lang.Throwable -> L79 android.os.RemoteException -> L83
            L4f:
                r0 = r5
                r1 = 0
                r0.mHeld = r1     // Catch: java.lang.Throwable -> L79
            L54:
                r0 = r5
                int r0 = r0.mCount     // Catch: java.lang.Throwable -> L79
                if (r0 >= 0) goto L80
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L79
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
                r3 = r2
                r3.<init>()     // Catch: java.lang.Throwable -> L79
                java.lang.String r3 = "WakeLock under-locked "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L79
                r3 = r5
                java.lang.String r3 = r3.mTag     // Catch: java.lang.Throwable -> L79
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L79
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L79
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L79
                throw r0     // Catch: java.lang.Throwable -> L79
            L79:
                r9 = move-exception
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                r0 = r9
                throw r0
            L80:
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                return
            L83:
                r9 = move-exception
                goto L4f
            */
            throw new UnsupportedOperationException("Method not decompiled: android.os.PowerManager.WakeLock.release(int):void");
        }

        public void setHistoryTag(String str) {
            this.mHistoryTag = str;
        }

        public void setReferenceCounted(boolean z) {
            synchronized (this.mToken) {
                this.mRefCounted = z;
            }
        }

        public void setTag(String str) {
            this.mTag = str;
        }

        public void setUnimportantForLogging(boolean z) {
            if (z) {
                this.mFlags |= 1073741824;
            } else {
                this.mFlags &= -1073741825;
            }
        }

        public void setWorkSource(WorkSource workSource) {
            boolean z;
            synchronized (this.mToken) {
                WorkSource workSource2 = workSource;
                if (workSource != null) {
                    workSource2 = workSource;
                    if (workSource.size() == 0) {
                        workSource2 = null;
                    }
                }
                if (workSource2 == null) {
                    z = this.mWorkSource != null;
                    this.mWorkSource = null;
                } else if (this.mWorkSource == null) {
                    z = true;
                    this.mWorkSource = new WorkSource(workSource2);
                } else {
                    boolean diff = this.mWorkSource.diff(workSource2);
                    z = diff;
                    if (diff) {
                        this.mWorkSource.set(workSource2);
                        z = diff;
                    }
                }
                if (z && this.mHeld) {
                    try {
                        PowerManager.this.mService.updateWakeLockWorkSource(this.mToken, this.mWorkSource, this.mHistoryTag);
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        public String toString() {
            String str;
            synchronized (this.mToken) {
                str = "WakeLock{" + Integer.toHexString(System.identityHashCode(this)) + " held=" + this.mHeld + ", refCount=" + this.mCount + "}";
            }
            return str;
        }
    }

    public PowerManager(Context context, IPowerManager iPowerManager, Handler handler) {
        this.mContext = context;
        this.mService = iPowerManager;
        this.mHandler = handler;
        this.mHasPowerProfilesSupport = (TextUtils.isEmpty(getDefaultPowerProfile()) || TextUtils.isEmpty(this.mContext.getResources().getString(17039639))) ? false : true;
    }

    public static boolean useTwilightAdjustmentFeature() {
        return SystemProperties.getBoolean("persist.power.usetwilightadj", false);
    }

    public static void validateWakeLockParameters(int i, String str) {
        switch (65535 & i) {
            case 1:
            case 6:
            case 10:
            case 26:
            case 32:
            case 64:
                if (str == null) {
                    throw new IllegalArgumentException("The tag must not be null.");
                }
                return;
            default:
                throw new IllegalArgumentException("Must specify a valid wake lock level.");
        }
    }

    public void activityResumed(Intent intent) {
        ComponentName component;
        if (!hasPowerProfiles() || intent == null) {
            return;
        }
        try {
            if (this.mService == null || (component = intent.getComponent()) == null) {
                return;
            }
            this.mService.activityResumed(component.flattenToString());
        } catch (RemoteException e) {
        }
    }

    public void boostScreenBrightness(long j) {
        try {
            this.mService.boostScreenBrightness(j);
        } catch (RemoteException e) {
        }
    }

    public void cpuBoost(int i) {
        try {
            if (this.mService != null) {
                this.mService.cpuBoost(i);
            }
        } catch (RemoteException e) {
        }
    }

    public int getDefaultButtonBrightness() {
        return this.mContext.getResources().getInteger(17694817);
    }

    public int getDefaultKeyboardBrightness() {
        return this.mContext.getResources().getInteger(17694818);
    }

    public String getDefaultPowerProfile() {
        return this.mContext.getResources().getString(17039640);
    }

    public int getDefaultScreenBrightnessSetting() {
        return this.mContext.getResources().getInteger(17694809);
    }

    public int getMaximumScreenBrightnessSetting() {
        return this.mContext.getResources().getInteger(17694808);
    }

    public int getMinimumScreenBrightnessSetting() {
        return this.mContext.getResources().getInteger(17694807);
    }

    public String getPowerProfile() {
        String str = null;
        if (hasPowerProfiles()) {
            str = null;
            try {
                if (this.mService != null) {
                    str = this.mService.getPowerProfile();
                }
            } catch (RemoteException e) {
                return null;
            }
        }
        return str;
    }

    public String getSeenWakeLocks() {
        try {
            if (this.mService != null) {
                return this.mService.getSeenWakeLocks();
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    public void goToSleep(long j) {
        goToSleep(j, 0, 0);
    }

    public void goToSleep(long j, int i, int i2) {
        try {
            this.mService.goToSleep(j, i, i2);
        } catch (RemoteException e) {
        }
    }

    public boolean hasPowerProfiles() {
        return this.mHasPowerProfilesSupport;
    }

    public boolean isInteractive() {
        try {
            return this.mService.isInteractive();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isPowerSaveMode() {
        try {
            return this.mService.isPowerSaveMode();
        } catch (RemoteException e) {
            return false;
        }
    }

    @Deprecated
    public boolean isScreenOn() {
        return isInteractive();
    }

    public boolean isWakeLockLevelSupported(int i) {
        try {
            return this.mService.isWakeLockLevelSupported(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void launchBoost() {
        try {
            if (this.mService != null) {
                this.mService.launchBoost();
            }
        } catch (RemoteException e) {
        }
    }

    public void nap(long j) {
        try {
            this.mService.nap(j);
        } catch (RemoteException e) {
        }
    }

    public WakeLock newWakeLock(int i, String str) {
        validateWakeLockParameters(i, str);
        return new WakeLock(i, str, this.mContext.getOpPackageName());
    }

    public void reboot(String str) {
        try {
            this.mService.reboot(false, str, true);
        } catch (RemoteException e) {
        }
    }

    public void setBacklightBrightness(int i) {
        try {
            this.mService.setTemporaryScreenBrightnessSettingOverride(i);
        } catch (RemoteException e) {
        }
    }

    public void setKeyboardLight(boolean z, int i) {
        try {
            this.mService.setKeyboardLight(z, i);
        } catch (RemoteException e) {
        }
    }

    public void setKeyboardVisibility(boolean z) {
        try {
            if (this.mService != null) {
                this.mService.setKeyboardVisibility(z);
            }
        } catch (RemoteException e) {
        }
    }

    public boolean setPowerProfile(String str) {
        if (hasPowerProfiles()) {
            boolean z = false;
            try {
                if (this.mService != null) {
                    z = this.mService.setPowerProfile(str);
                }
                return z;
            } catch (RemoteException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new IllegalArgumentException("Power profiles not enabled on this system!");
    }

    public boolean setPowerSaveMode(boolean z) {
        try {
            return this.mService.setPowerSaveMode(z);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void userActivity(long j, int i, int i2) {
        try {
            this.mService.userActivity(j, i, i2);
        } catch (RemoteException e) {
        }
    }

    @Deprecated
    public void userActivity(long j, boolean z) {
        userActivity(j, 0, z ? 1 : 0);
    }

    public void wakeUp(long j) {
        try {
            this.mService.wakeUp(j);
        } catch (RemoteException e) {
        }
    }

    public void wakeUpWithProximityCheck(long j) {
        try {
            this.mService.wakeUpWithProximityCheck(j);
        } catch (RemoteException e) {
        }
    }
}
