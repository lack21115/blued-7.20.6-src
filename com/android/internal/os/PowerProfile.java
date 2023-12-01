package com.android.internal.os;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.android.internal.R;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/PowerProfile.class */
public class PowerProfile {
    private static final String ATTR_NAME = "name";
    public static final String POWER_AUDIO = "dsp.audio";
    public static final String POWER_BATTERY_CAPACITY = "battery.capacity";
    public static final String POWER_BLUETOOTH_ACTIVE = "bluetooth.active";
    public static final String POWER_BLUETOOTH_AT_CMD = "bluetooth.at";
    public static final String POWER_BLUETOOTH_ON = "bluetooth.on";
    public static final String POWER_CPU_ACTIVE = "cpu.active";
    public static final String POWER_CPU_AWAKE = "cpu.awake";
    public static final String POWER_CPU_IDLE = "cpu.idle";
    public static final String POWER_CPU_SPEEDS = "cpu.speeds";
    public static final String POWER_FLASHLIGHT = "camera.flashlight";
    public static final String POWER_GPS_ON = "gps.on";
    public static final String POWER_NONE = "none";
    public static final String POWER_RADIO_ACTIVE = "radio.active";
    public static final String POWER_RADIO_ON = "radio.on";
    public static final String POWER_RADIO_SCANNING = "radio.scanning";
    public static final String POWER_SCREEN_FULL = "screen.full";
    public static final String POWER_SCREEN_ON = "screen.on";
    public static final String POWER_VIDEO = "dsp.video";
    public static final String POWER_WIFI_ACTIVE = "wifi.active";
    public static final String POWER_WIFI_BATCHED_SCAN = "wifi.batchedscan";
    public static final String POWER_WIFI_ON = "wifi.on";
    public static final String POWER_WIFI_SCAN = "wifi.scan";
    private static final String TAG_ARRAY = "array";
    private static final String TAG_ARRAYITEM = "value";
    private static final String TAG_DEVICE = "device";
    private static final String TAG_ITEM = "item";
    static final HashMap<String, Object> sPowerMap = new HashMap<>();

    public PowerProfile(Context context) {
        if (sPowerMap.size() == 0) {
            readPowerValuesFromXml(context);
        }
    }

    private void readPowerValuesFromXml(Context context) {
        XmlResourceParser xml = context.getResources().getXml(R.xml.power_profile);
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        String str = null;
        try {
            try {
                XmlUtils.beginDocument(xml, "device");
                while (true) {
                    XmlUtils.nextElement(xml);
                    String name = xml.getName();
                    if (name == null) {
                        break;
                    }
                    boolean z2 = z;
                    if (z) {
                        z2 = z;
                        if (!name.equals("value")) {
                            sPowerMap.put(str, arrayList.toArray(new Double[arrayList.size()]));
                            z2 = false;
                        }
                    }
                    if (name.equals(TAG_ARRAY)) {
                        z = true;
                        arrayList.clear();
                        str = xml.getAttributeValue(null, "name");
                    } else {
                        if (!name.equals(TAG_ITEM)) {
                            z = z2;
                            if (name.equals("value")) {
                            }
                        }
                        String str2 = null;
                        if (!z2) {
                            str2 = xml.getAttributeValue(null, "name");
                        }
                        z = z2;
                        if (xml.next() == 4) {
                            double d = 0.0d;
                            try {
                                d = Double.valueOf(xml.getText()).doubleValue();
                            } catch (NumberFormatException e) {
                            }
                            if (name.equals(TAG_ITEM)) {
                                sPowerMap.put(str2, Double.valueOf(d));
                                z = z2;
                            } else {
                                z = z2;
                                if (z2) {
                                    arrayList.add(Double.valueOf(d));
                                    z = z2;
                                }
                            }
                        }
                    }
                }
                if (z) {
                    sPowerMap.put(str, arrayList.toArray(new Double[arrayList.size()]));
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (XmlPullParserException e3) {
                throw new RuntimeException(e3);
            }
        } finally {
            xml.close();
        }
    }

    public double getAveragePower(String str) {
        if (sPowerMap.containsKey(str)) {
            Object obj = sPowerMap.get(str);
            return obj instanceof Double[] ? ((Double[]) obj)[0].doubleValue() : ((Double) sPowerMap.get(str)).doubleValue();
        }
        return 0.0d;
    }

    public double getAveragePower(String str, int i) {
        double d = 0.0d;
        if (sPowerMap.containsKey(str)) {
            Object obj = sPowerMap.get(str);
            if (!(obj instanceof Double[])) {
                return ((Double) obj).doubleValue();
            }
            Double[] dArr = (Double[]) obj;
            if (dArr.length <= i || i < 0) {
                d = 0.0d;
                if (i >= 0) {
                    return dArr[dArr.length - 1].doubleValue();
                }
            } else {
                d = dArr[i].doubleValue();
            }
        }
        return d;
    }

    public double getBatteryCapacity() {
        return getAveragePower(POWER_BATTERY_CAPACITY);
    }

    public int getNumSpeedSteps() {
        Object obj = sPowerMap.get(POWER_CPU_SPEEDS);
        if (obj == null || !(obj instanceof Double[])) {
            return 1;
        }
        return ((Double[]) obj).length;
    }
}
