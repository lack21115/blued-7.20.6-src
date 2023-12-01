package com.tencent.map.b;

import android.bluetooth.BluetoothClass;
import android.location.Location;
import android.mtp.MtpConstants;
import android.net.wifi.ScanResult;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import android.telephony.NeighboringCellInfo;
import android.text.format.DateUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.map.b.d;
import com.tencent.map.b.e;
import com.tencent.map.b.g;
import com.uc.crashsdk.export.LogType;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f37238a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    public static int[] b = {0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, WBConstants.SDK_NEW_PAY_VERSION, 51009, 1280, 50625, 50305, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, DateUtils.FORMAT_NO_NOON_MIDNIGHT, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, MtpConstants.PROPERTY_PERSISTENT_UID, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, MtpConstants.FORMAT_WMV, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, GLES31.GL_ATOMIC_COUNTER_BUFFER_INDEX, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, GLES20.GL_STENCIL_BACK_FAIL, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, GLES30.GL_SRGB8, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, LogType.UNEXP_RESTART, 33217, 32897, 16448};

    public static double a(double d, int i) {
        try {
            if (Double.isNaN(d)) {
                return 0.0d;
            }
            return BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static int a(char c2) {
        int i = (c2 < 'A' || c2 > 'Z') ? 256 : c2 - 'A';
        int i2 = i;
        if (c2 >= 'a') {
            i2 = i;
            if (c2 <= 'z') {
                i2 = (c2 - 'a') + 64;
            }
        }
        int i3 = i2;
        if (c2 >= '0') {
            i3 = i2;
            if (c2 <= '9') {
                i3 = (c2 + 128) - 48;
            }
        }
        return i3;
    }

    private static String a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"mcc\":");
        sb.append(i);
        sb.append(",\"mnc\":");
        sb.append(i2);
        sb.append(",\"lac\":");
        sb.append(i3);
        sb.append(",\"cellid\":");
        sb.append(i4);
        sb.append(",\"rss\":");
        sb.append(i5);
        if (i6 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
            sb.append(",\"stationLat\":");
            sb.append(String.format("%.6f", Float.valueOf(i6 / 14400.0f)));
            sb.append(",\"stationLng\":");
            sb.append(String.format("%.6f", Float.valueOf(i7 / 14400.0f)));
        }
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    public static String a(d.b bVar, List<NeighboringCellInfo> list) {
        int i;
        if (bVar == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = bVar.b;
        int i3 = bVar.f37216c;
        if (a(bVar.f37215a, i2, i3, bVar.d, bVar.e)) {
            sb.append(a(i2, i3, bVar.d, bVar.e, bVar.f, bVar.g, bVar.h));
            i = 1;
        } else {
            i = 0;
        }
        if (list != null) {
            try {
                Method method = Class.forName("android.telephony.NeighboringCellInfo").getMethod("getLac", new Class[0]);
                for (NeighboringCellInfo neighboringCellInfo : list) {
                    int parseInt = Integer.parseInt(method.invoke(neighboringCellInfo, new Object[0]).toString());
                    if (a(bVar.f37215a, i2, i3, parseInt, neighboringCellInfo.getCid())) {
                        if (i > 0) {
                            sb.append(",");
                        }
                        sb.append(a(i2, i3, parseInt, neighboringCellInfo.getCid(), (neighboringCellInfo.getRssi() << 1) - 113, Integer.MAX_VALUE, Integer.MAX_VALUE));
                        i++;
                    }
                }
            } catch (Exception e) {
            }
            list.clear();
        }
        sb.append("]");
        return sb.toString();
    }

    public static String a(e.b bVar) {
        if (bVar.b() == null) {
            return "{}";
        }
        Location b2 = bVar.b();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"latitude\":");
        sb.append(b2.getLatitude());
        sb.append(",\"longitude\":");
        sb.append(b2.getLongitude());
        sb.append(",\"additional\":");
        sb.append("\"" + b2.getAltitude() + "," + b2.getAccuracy() + "," + b2.getBearing() + "," + b2.getSpeed() + "," + b2.getTime() + "\"");
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    public static String a(g.b bVar) {
        if (bVar == null || bVar.a() == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (bVar.a() != null && bVar.a().size() > 0) {
            List<ScanResult> a2 = bVar.a();
            int i = 0;
            for (ScanResult scanResult : a2) {
                if (scanResult.level >= (a2.size() < 6 ? -95 : -90)) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append("{\"mac\":\"");
                    sb.append(scanResult.BSSID);
                    sb.append("\",");
                    sb.append("\"rssi\":");
                    sb.append(scanResult.level);
                    sb.append(com.alipay.sdk.util.i.d);
                    i++;
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String a(String str, String str2, String str3, String str4, boolean z) {
        return "{\"imei\":\"" + str + "\",\"imsi\":\"" + str2 + "\",\"phonenum\":\"" + str3 + "\",\"roaming\":\"" + z + "\",\"qq\":\"" + str4 + "\"" + com.alipay.sdk.util.i.d;
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        if (i != 2) {
            return (i2 < 0 || i3 < 0 || i4 <= 0 || i4 >= 65535 || i5 == 268435455 || i5 == Integer.MAX_VALUE || i5 == 50594049 || i5 == 65535 || i5 == 8 || i5 == 10 || i5 == 33 || i5 <= 0) ? false : true;
        } else if (i2 < 0 || i3 < 0 || i4 < 0 || i4 > 65535 || i5 < 0 || i5 > 65535) {
            return false;
        } else {
            return (i3 == 0 && i4 == 0 && i5 == 0) ? false : true;
        }
    }

    public static boolean a(String str) {
        return str != null && str.length() <= 32 && str.length() >= 6 && Pattern.compile("[a-zA-Z0-9_]{6,32}").matcher(str).matches();
    }

    public static boolean b(String str) {
        return str != null && str.length() == 29 && Pattern.compile("([A-Z2-7]{5}){1}(-[A-Z2-7]{5}){4}").matcher(str).matches();
    }

    public static boolean c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return str.contains("latitude") || (jSONObject.getJSONArray("cells").length() > 0) || (jSONObject.getJSONArray("wifis").length() > 0);
        } catch (Exception e) {
            return false;
        }
    }
}
