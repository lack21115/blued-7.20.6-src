package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bl.class */
public class bl {
    public static int a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            TimeZone timeZone = Calendar.getInstance().getTimeZone();
            if (timeZone != null) {
                jSONObject.put("0", String.valueOf(timeZone.getOffset(System.currentTimeMillis()) / 1000));
                jSONObject.put("1", timeZone.getID());
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String b() {
        long j = 0;
        try {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = statFs.getBlockSize() * statFs.getBlockCount();
            }
        } catch (Throwable th) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String c() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable th) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static JSONObject d() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        JSONObject jSONObject = new JSONObject();
        try {
            dataInputStream = new DataInputStream(Runtime.getRuntime().exec("lsmod").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        } else if (!TextUtils.isEmpty(readLine)) {
                            String a2 = bn.a(readLine);
                            if (a2.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && a2.contains(com.huawei.openalliance.ad.constant.t.aE)) {
                                String[] split = a2.replace(";;;", com.huawei.openalliance.ad.constant.t.aE).split(com.huawei.openalliance.ad.constant.t.aE);
                                if (split.length > 1) {
                                    jSONObject.put(split[0], split[1]);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (bufferedReader == null) {
                            return jSONObject;
                        }
                        bufferedReader.close();
                        return jSONObject;
                    }
                }
                dataInputStream.close();
            } catch (Throwable th2) {
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            dataInputStream = null;
        }
        try {
            bufferedReader.close();
            return jSONObject;
        } catch (IOException e3) {
            return jSONObject;
        }
    }
}
