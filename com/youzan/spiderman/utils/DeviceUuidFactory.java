package com.youzan.spiderman.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/DeviceUuidFactory.class */
public class DeviceUuidFactory {
    private static final String PREFS_DEVICE_ID = "device_id";
    private static final String PREFS_FILE = "com.youzan.spiderman.device_id.xml";
    private static UUID uuid;

    public DeviceUuidFactory(Context context) {
        if (uuid == null) {
            synchronized (DeviceUuidFactory.class) {
                try {
                    if (uuid == null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_FILE, 0);
                        String str = null;
                        String string = sharedPreferences.getString("device_id", null);
                        if (string != null) {
                            uuid = UUID.fromString(string);
                        } else {
                            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                            try {
                                if ("9774d56d682e549c".equals(string2)) {
                                    str = PermissionUtil.hasReadPhoneStatePermission(context) ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : str;
                                    uuid = str != null ? UUID.nameUUIDFromBytes(str.getBytes("utf8")) : UUID.randomUUID();
                                } else {
                                    uuid = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            sharedPreferences.edit().putString("device_id", uuid.toString()).apply();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public String getDeviceUuid() {
        return uuid.toString();
    }
}
