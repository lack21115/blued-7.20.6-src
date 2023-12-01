package com.android.internal.util.cm;

import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/QSConstants.class */
public class QSConstants {
    protected static final ArrayList<String> TILES_AVAILABLE = new ArrayList<>();
    public static final String TILE_ADB_NETWORK = "adb_network";
    public static final String TILE_AIRPLANE = "airplane";
    public static final String TILE_AMBIENT_DISPLAY = "ambient_display";
    public static final String TILE_APN = "apn";
    public static final String TILE_BATTERY_SAVER = "battery_saver";
    public static final String TILE_BLUETOOTH = "bt";
    public static final String TILE_CAST = "cast";
    public static final String TILE_CELLULAR = "cell";
    public static final String TILE_COMPASS = "compass";
    public static final String TILE_DATA = "data";
    public static final String TILE_DDS = "dds";
    public static final String TILE_FLASHLIGHT = "flashlight";
    public static final String TILE_HEADS_UP = "heads_up";
    public static final String TILE_HOTSPOT = "hotspot";
    public static final String TILE_INVERSION = "inversion";
    public static final String TILE_LIVE_DISPLAY = "live_display";
    public static final String TILE_LOCATION = "location";
    public static final String TILE_LOCKSCREEN = "lockscreen";
    public static final String TILE_LTE = "lte";
    public static final String TILE_NFC = "nfc";
    public static final String TILE_NOTIFICATIONS = "notifications";
    public static final String TILE_PERFORMANCE = "performance";
    public static final String TILE_PROFILES = "profiles";
    public static final String TILE_ROAMING = "roaming";
    public static final String TILE_ROTATION = "rotation";
    public static final String TILE_SCREEN_TIMEOUT = "screen_timeout";
    public static final String TILE_SYNC = "sync";
    public static final String TILE_USB_TETHER = "usb_tether";
    public static final String TILE_VISUALIZER = "visualizer";
    public static final String TILE_VOLUME = "volume_panel";
    public static final String TILE_WIFI = "wifi";

    static {
        TILES_AVAILABLE.add("wifi");
        TILES_AVAILABLE.add(TILE_BLUETOOTH);
        TILES_AVAILABLE.add("cell");
        TILES_AVAILABLE.add("airplane");
        TILES_AVAILABLE.add("rotation");
        TILES_AVAILABLE.add(TILE_FLASHLIGHT);
        TILES_AVAILABLE.add("location");
        TILES_AVAILABLE.add(TILE_CAST);
        TILES_AVAILABLE.add(TILE_INVERSION);
        TILES_AVAILABLE.add(TILE_HOTSPOT);
        TILES_AVAILABLE.add("notifications");
        TILES_AVAILABLE.add("data");
        TILES_AVAILABLE.add(TILE_ROAMING);
        TILES_AVAILABLE.add(TILE_DDS);
        TILES_AVAILABLE.add("apn");
        TILES_AVAILABLE.add(TILE_PROFILES);
        TILES_AVAILABLE.add(TILE_PERFORMANCE);
        TILES_AVAILABLE.add(TILE_ADB_NETWORK);
        TILES_AVAILABLE.add("nfc");
        TILES_AVAILABLE.add(TILE_COMPASS);
        TILES_AVAILABLE.add("lockscreen");
        TILES_AVAILABLE.add(TILE_LTE);
        TILES_AVAILABLE.add(TILE_VISUALIZER);
        TILES_AVAILABLE.add(TILE_VOLUME);
        TILES_AVAILABLE.add(TILE_SCREEN_TIMEOUT);
        TILES_AVAILABLE.add(TILE_LIVE_DISPLAY);
        TILES_AVAILABLE.add(TILE_USB_TETHER);
        TILES_AVAILABLE.add(TILE_HEADS_UP);
        TILES_AVAILABLE.add(TILE_AMBIENT_DISPLAY);
        TILES_AVAILABLE.add(TILE_SYNC);
        TILES_AVAILABLE.add(TILE_BATTERY_SAVER);
    }

    private QSConstants() {
    }
}
