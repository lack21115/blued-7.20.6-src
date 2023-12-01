package com.getui.gtc.dim.c;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiSsid;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sobot.chat.widget.zxing.util.Intents;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/e.class */
public final class e {
    private static Object a(Parcel parcel) {
        try {
            int dataPosition = parcel.dataPosition();
            int readInt = parcel.readInt();
            parcel.setDataPosition(dataPosition);
            if (readInt > 100) {
                return null;
            }
            Class<?> cls = Class.forName("android.net.wifi.WifiSsid");
            return ((Parcelable.Creator) cls.getDeclaredField("CREATOR").get(cls)).createFromParcel(parcel);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("getWifiSsid", th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        r0 = new org.json.JSONObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
        r0.put("BSSID", r0.readString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
        r0.put(com.sobot.chat.widget.zxing.util.Intents.WifiConnect.SSID, a(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b1, code lost:
        r0.recycle();
        r7 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.net.wifi.WifiInfo r4) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.c.e.a(android.net.wifi.WifiInfo):java.lang.String");
    }

    private static String a(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            if (TextUtils.isEmpty(obj2)) {
                String b = b(obj);
                return b != null ? b : WifiSsid.NONE;
            }
            return "\"" + obj2 + "\"";
        }
        return WifiSsid.NONE;
    }

    private static String b(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Method declaredMethod = cls.getDeclaredMethod("getHexString", new Class[0]);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(obj, new Object[0]);
            }
            Method declaredMethod2 = cls.getDeclaredMethod("getOctets", new Class[0]);
            declaredMethod2.setAccessible(true);
            byte[] bArr = (byte[]) declaredMethod2.invoke(obj, new Object[0]);
            String str = "0x";
            int length = bArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                byte b = bArr[i2];
                str = str + String.format(Locale.US, "%02x", Byte.valueOf(b));
                i = i2 + 1;
            }
            return bArr.length > 0 ? str : WifiSsid.NONE;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("getHexString ", th);
            return WifiSsid.NONE;
        }
    }

    private static JSONObject b(WifiInfo wifiInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            Field declaredField = WifiInfo.class.getDeclaredField("mBSSID");
            declaredField.setAccessible(true);
            Field declaredField2 = WifiInfo.class.getDeclaredField("mWifiSsid");
            declaredField2.setAccessible(true);
            jSONObject.put("BSSID", declaredField.get(wifiInfo));
            jSONObject.put(Intents.WifiConnect.SSID, a(declaredField2.get(wifiInfo)));
            return jSONObject;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("wifiInfo getBelow28", th);
            return jSONObject;
        }
    }
}
