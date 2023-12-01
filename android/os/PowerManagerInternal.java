package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/PowerManagerInternal.class */
public abstract class PowerManagerInternal {
    public static final int WAKEFULNESS_ASLEEP = 0;
    public static final int WAKEFULNESS_AWAKE = 1;
    public static final int WAKEFULNESS_DOZING = 3;
    public static final int WAKEFULNESS_DREAMING = 2;

    /* loaded from: source-9557208-dex2jar.jar:android/os/PowerManagerInternal$LowPowerModeListener.class */
    public interface LowPowerModeListener {
        void onLowPowerModeChanged(boolean z);
    }

    public static boolean isInteractive(int i) {
        return i == 1 || i == 2;
    }

    public static String wakefulnessToString(int i) {
        switch (i) {
            case 0:
                return "Asleep";
            case 1:
                return "Awake";
            case 2:
                return "Dreaming";
            case 3:
                return "Dozing";
            default:
                return Integer.toString(i);
        }
    }

    public abstract boolean getLowPowerModeEnabled();

    public abstract void registerLowPowerModeObserver(LowPowerModeListener lowPowerModeListener);

    public abstract void setButtonBrightnessOverrideFromWindowManager(int i);

    public abstract void setDozeOverrideFromDreamManager(int i, int i2);

    public abstract void setMaximumScreenOffTimeoutFromDeviceAdmin(int i);

    public abstract void setScreenBrightnessOverrideFromWindowManager(int i);

    public abstract void setUserActivityTimeoutOverrideFromWindowManager(long j);
}
