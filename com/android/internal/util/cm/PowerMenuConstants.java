package com.android.internal.util.cm;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/PowerMenuConstants.class */
public class PowerMenuConstants {
    public static final String GLOBAL_ACTION_KEY_AIRPLANE = "airplane";
    public static final String GLOBAL_ACTION_KEY_POWER = "power";
    public static final String GLOBAL_ACTION_KEY_SCREENSHOT = "screenshot";
    public static final String GLOBAL_ACTION_KEY_SETTINGS = "settings";
    public static final String GLOBAL_ACTION_KEY_SILENT = "silent";
    public static final String GLOBAL_ACTION_KEY_REBOOT = "reboot";
    public static final String GLOBAL_ACTION_KEY_USERS = "users";
    public static final String GLOBAL_ACTION_KEY_LOCKDOWN = "lockdown";
    public static final String GLOBAL_ACTION_KEY_BUGREPORT = "bugreport";
    private static String[] ALL_ACTIONS = {"power", GLOBAL_ACTION_KEY_REBOOT, "screenshot", "airplane", GLOBAL_ACTION_KEY_USERS, "settings", GLOBAL_ACTION_KEY_LOCKDOWN, GLOBAL_ACTION_KEY_BUGREPORT, "silent"};

    public static String[] getAllActions() {
        return ALL_ACTIONS;
    }
}
