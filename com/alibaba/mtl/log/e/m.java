package com.alibaba.mtl.log.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/m.class */
public class m {
    private static final Random a = new Random();

    public static String getImei(Context context) {
        String str = null;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_ie", "");
                if (!TextUtils.isEmpty(string)) {
                    String str2 = new String(c.decode(string.getBytes(), 2), "UTF-8");
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } catch (Exception e) {
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
                str = null;
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception e2) {
                str = null;
            }
        }
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = getUniqueID();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_ie", new String(c.encode(str3.getBytes("UTF-8"), 2)));
                edit.commit();
                return str3;
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        return str3;
    }

    public static String getImsi(Context context) {
        String str = null;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_is", "");
                if (!TextUtils.isEmpty(string)) {
                    String str2 = new String(c.decode(string.getBytes(), 2), "UTF-8");
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } catch (Exception e) {
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PhoneConstants.PHONE_KEY);
                str = null;
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Exception e2) {
                str = null;
            }
        }
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = getUniqueID();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_is", new String(c.encode(str3.getBytes("UTF-8"), 2)));
                edit.commit();
                return str3;
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        return str3;
    }

    public static final String getUniqueID() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = a.nextInt();
        int nextInt2 = a.nextInt();
        byte[] bytes = f.getBytes(currentTimeMillis);
        byte[] bytes2 = f.getBytes(nanoTime);
        byte[] bytes3 = f.getBytes(nextInt);
        byte[] bytes4 = f.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy((Object) bytes, 0, (Object) bArr, 0, 4);
        System.arraycopy((Object) bytes2, 0, (Object) bArr, 4, 4);
        System.arraycopy((Object) bytes3, 0, (Object) bArr, 8, 4);
        System.arraycopy((Object) bytes4, 0, (Object) bArr, 12, 4);
        return c.encodeToString(bArr, 2);
    }
}
