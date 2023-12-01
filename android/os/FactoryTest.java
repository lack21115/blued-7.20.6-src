package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/FactoryTest.class */
public final class FactoryTest {
    public static final int FACTORY_TEST_HIGH_LEVEL = 2;
    public static final int FACTORY_TEST_LOW_LEVEL = 1;
    public static final int FACTORY_TEST_OFF = 0;

    public static int getMode() {
        return SystemProperties.getInt("ro.factorytest", 0);
    }

    public static boolean isLongPressOnPowerOffEnabled() {
        boolean z = false;
        if (SystemProperties.getInt("factory.long_press_power_off", 0) != 0) {
            z = true;
        }
        return z;
    }
}
