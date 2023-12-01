package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/BatteryManagerInternal.class */
public abstract class BatteryManagerInternal {
    public abstract int getBatteryLevel();

    public abstract boolean getBatteryLevelLow();

    public abstract int getDockBatteryLevel();

    public abstract boolean getDockBatteryLevelLow();

    public abstract int getDockPlugType();

    public abstract int getInvalidCharger();

    public abstract int getPlugType();

    public abstract boolean isDockBatterySupported();

    public abstract boolean isPowered(int i);
}
