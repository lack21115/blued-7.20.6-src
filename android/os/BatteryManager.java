package android.os;

import android.app.IBatteryService;
import android.os.IBatteryPropertiesRegistrar;

/* loaded from: source-9557208-dex2jar.jar:android/os/BatteryManager.class */
public class BatteryManager {
    public static final int BATTERY_DOCK_PLUGGED_AC = 1;
    public static final int BATTERY_DOCK_PLUGGED_ANY = 3;
    public static final int BATTERY_DOCK_PLUGGED_USB = 2;
    public static final int BATTERY_HEALTH_COLD = 7;
    public static final int BATTERY_HEALTH_DEAD = 4;
    public static final int BATTERY_HEALTH_GOOD = 2;
    public static final int BATTERY_HEALTH_OVERHEAT = 3;
    public static final int BATTERY_HEALTH_OVER_VOLTAGE = 5;
    public static final int BATTERY_HEALTH_UNKNOWN = 1;
    public static final int BATTERY_HEALTH_UNSPECIFIED_FAILURE = 6;
    public static final int BATTERY_PLUGGED_AC = 1;
    public static final int BATTERY_PLUGGED_ANY = 7;
    public static final int BATTERY_PLUGGED_USB = 2;
    public static final int BATTERY_PLUGGED_WIRELESS = 4;
    public static final int BATTERY_PROPERTY_CAPACITY = 4;
    public static final int BATTERY_PROPERTY_CHARGE_COUNTER = 1;
    public static final int BATTERY_PROPERTY_CURRENT_AVERAGE = 3;
    public static final int BATTERY_PROPERTY_CURRENT_NOW = 2;
    public static final int BATTERY_PROPERTY_ENERGY_COUNTER = 5;
    public static final int BATTERY_STATUS_CHARGING = 2;
    public static final int BATTERY_STATUS_DISCHARGING = 3;
    public static final int BATTERY_STATUS_FULL = 5;
    public static final int BATTERY_STATUS_NOT_CHARGING = 4;
    public static final int BATTERY_STATUS_UNKNOWN = 1;
    public static final String EXTRA_DOCK_HEALTH = "dock_health";
    public static final String EXTRA_DOCK_ICON_SMALL = "dock_icon-small";
    public static final String EXTRA_DOCK_LEVEL = "dock_level";
    public static final String EXTRA_DOCK_PLUGGED = "dock_plugged";
    public static final String EXTRA_DOCK_PRESENT = "dock_present";
    public static final String EXTRA_DOCK_SCALE = "dock_scale";
    public static final String EXTRA_DOCK_STATUS = "dock_status";
    public static final String EXTRA_DOCK_TECHNOLOGY = "dock_technology";
    public static final String EXTRA_DOCK_TEMPERATURE = "dock_temperature";
    public static final String EXTRA_DOCK_VOLTAGE = "dock_voltage";
    public static final String EXTRA_HEALTH = "health";
    public static final String EXTRA_ICON_SMALL = "icon-small";
    public static final String EXTRA_INVALID_CHARGER = "invalid_charger";
    public static final String EXTRA_LEVEL = "level";
    public static final String EXTRA_PLUGGED = "plugged";
    public static final String EXTRA_PRESENT = "present";
    public static final String EXTRA_SCALE = "scale";
    public static final String EXTRA_STATUS = "status";
    public static final String EXTRA_TECHNOLOGY = "technology";
    public static final String EXTRA_TEMPERATURE = "temperature";
    public static final String EXTRA_VOLTAGE = "voltage";
    private IBatteryPropertiesRegistrar mBatteryPropertiesRegistrar;
    private final IBatteryService mBatteryService;

    public BatteryManager() {
        this(null);
    }

    public BatteryManager(IBatteryService iBatteryService) {
        this.mBatteryService = iBatteryService;
    }

    private long queryProperty(int i, boolean z) {
        if (this.mBatteryPropertiesRegistrar == null) {
            this.mBatteryPropertiesRegistrar = IBatteryPropertiesRegistrar.Stub.asInterface(ServiceManager.getService("batteryproperties"));
            if (this.mBatteryPropertiesRegistrar == null) {
                return Long.MIN_VALUE;
            }
        }
        try {
            BatteryProperty batteryProperty = new BatteryProperty();
            if ((!z ? this.mBatteryPropertiesRegistrar.getProperty(i, batteryProperty) : this.mBatteryPropertiesRegistrar.getDockProperty(i, batteryProperty)) == 0) {
                return batteryProperty.getLong();
            }
            return Long.MIN_VALUE;
        } catch (RemoteException e) {
            return Long.MIN_VALUE;
        }
    }

    public int getIntDockProperty(int i) {
        if (isDockBatterySupported()) {
            return (int) queryProperty(i, true);
        }
        return Integer.MIN_VALUE;
    }

    public int getIntProperty(int i) {
        return (int) queryProperty(i, false);
    }

    public long getLongDockProperty(int i) {
        if (isDockBatterySupported()) {
            return queryProperty(i, true);
        }
        return Long.MIN_VALUE;
    }

    public long getLongProperty(int i) {
        return queryProperty(i, false);
    }

    public boolean isDockBatterySupported() {
        boolean z = false;
        try {
            if (this.mBatteryService != null) {
                z = false;
                if (this.mBatteryService.isDockBatterySupported()) {
                    z = true;
                }
            }
            return z;
        } catch (RemoteException e) {
            return false;
        }
    }
}
