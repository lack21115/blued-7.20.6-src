package com.android.internal.util.cm;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.R;
import com.android.internal.telephony.PhoneConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/QSUtils.class */
public class QSUtils {
    private static boolean sAvailableTilesFiltered;

    private QSUtils() {
    }

    public static boolean deviceSupportsBluetooth() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }

    public static boolean deviceSupportsCompass(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        return (sensorManager.getDefaultSensor(1) == null || sensorManager.getDefaultSensor(2) == null) ? false : true;
    }

    public static boolean deviceSupportsDdsSupported(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
        return telephonyManager.isMultiSimEnabled() && telephonyManager.getMultiSimConfiguration() == TelephonyManager.MultiSimVariants.DSDA;
    }

    public static boolean deviceSupportsDoze(Context context) {
        return !TextUtils.isEmpty(context.getResources().getString(R.string.config_dozeComponent));
    }

    public static boolean deviceSupportsFlashLight(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            int length = cameraIdList.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[i2]);
                Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (bool != null && bool.booleanValue() && num != null && num.intValue() == 1) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (CameraAccessException e) {
            return false;
        } catch (AssertionError e2) {
            return false;
        }
    }

    public static boolean deviceSupportsLte(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
        return telephonyManager.getLteOnCdmaMode() == 1 || telephonyManager.getLteOnGsmMode() != 0;
    }

    public static boolean deviceSupportsMobileData(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).isNetworkSupported(0);
    }

    public static boolean deviceSupportsNfc(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public static boolean deviceSupportsPowerProfiles(Context context) {
        return ((PowerManager) context.getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER)).hasPowerProfiles();
    }

    private static void filterTiles(Context context) {
        if (sAvailableTilesFiltered) {
            return;
        }
        filterTiles(context, QSConstants.TILES_AVAILABLE);
        sAvailableTilesFiltered = true;
    }

    private static void filterTiles(Context context, List<String> list) {
        boolean deviceSupportsMobileData = deviceSupportsMobileData(context);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean z = false;
            boolean z2 = true;
            switch (next.hashCode()) {
                case -2103993829:
                    if (next.equals(QSConstants.TILE_AMBIENT_DISPLAY)) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1480388560:
                    if (next.equals(QSConstants.TILE_PERFORMANCE)) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1183073498:
                    if (next.equals(QSConstants.TILE_FLASHLIGHT)) {
                        z2 = true;
                        break;
                    }
                    break;
                case -870907421:
                    if (next.equals(QSConstants.TILE_BATTERY_SAVER)) {
                        z2 = true;
                        break;
                    }
                    break;
                case GL10.GL_LINE_SMOOTH_HINT /* 3154 */:
                    if (next.equals(QSConstants.TILE_BLUETOOTH)) {
                        z2 = true;
                        break;
                    }
                    break;
                case 96799:
                    if (next.equals("apn")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 99315:
                    if (next.equals(QSConstants.TILE_DDS)) {
                        z2 = true;
                        break;
                    }
                    break;
                case 108971:
                    if (next.equals(QSConstants.TILE_NFC)) {
                        z2 = true;
                        break;
                    }
                    break;
                case 3049826:
                    if (next.equals(QSConstants.TILE_CELLULAR)) {
                        z2 = false;
                        break;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        z2 = true;
                        break;
                    }
                    break;
                case 950484242:
                    if (next.equals(QSConstants.TILE_COMPASS)) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1099603663:
                    if (next.equals(QSConstants.TILE_HOTSPOT)) {
                        z2 = true;
                        break;
                    }
                    break;
                case 1366973465:
                    if (next.equals(QSConstants.TILE_ROAMING)) {
                        z2 = true;
                        break;
                    }
                    break;
            }
            switch (z2) {
                case false:
                case true:
                case true:
                case true:
                case true:
                    if (!deviceSupportsMobileData) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsDdsSupported(context)) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsFlashLight(context)) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsBluetooth()) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsNfc(context)) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsCompass(context)) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsDoze(context)) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    if (!deviceSupportsPowerProfiles(context)) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case true:
                    z = deviceSupportsPowerProfiles(context);
                    break;
            }
            if (z) {
                it.remove();
            }
        }
    }

    public static List<String> getAvailableTiles(Context context) {
        filterTiles(context);
        return QSConstants.TILES_AVAILABLE;
    }

    public static List<String> getDefaultTiles(Context context) {
        ArrayList arrayList = new ArrayList();
        String string = context.getString(R.string.config_defaultQuickSettingsTiles);
        if (!TextUtils.isEmpty(string)) {
            String[] split = TextUtils.split(string, Pattern.quote(","));
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
                i = i2 + 1;
            }
            filterTiles(context, arrayList);
        }
        return arrayList;
    }

    public static String getDefaultTilesAsString(Context context) {
        return TextUtils.join(",", getDefaultTiles(context));
    }
}
