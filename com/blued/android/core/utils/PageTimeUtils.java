package com.blued.android.core.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.statistics.BluedStatistics;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/PageTimeUtils.class */
public class PageTimeUtils {
    private static final String a = PageTimeUtils.class.getSimpleName();
    private static final Map<String, Long> b = new HashMap();
    private static Map<String, String> c = new HashMap();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/PageTimeUtils$APMInterface.class */
    public interface APMInterface {
        String getPageBizName();
    }

    public static void a(APMInterface aPMInterface) {
        if (a((Object) aPMInterface)) {
            try {
                String hexString = Integer.toHexString(aPMInterface.hashCode());
                if (b.containsKey(hexString)) {
                    return;
                }
                b.put(hexString, Long.valueOf(System.currentTimeMillis()));
                if (AppInfo.m()) {
                    String pageBizName = aPMInterface.getPageBizName();
                    String str = pageBizName;
                    if (TextUtils.isEmpty(pageBizName)) {
                        str = d(aPMInterface.getClass().getSimpleName());
                    }
                    a(str, hexString, "start");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        c = c(str);
    }

    private static void a(Object... objArr) {
        if (!AppInfo.m()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Log.b(a, sb.toString());
                return;
            }
            sb.append(objArr[i2]);
            sb.append("  ");
            i = i2 + 1;
        }
    }

    private static boolean a(Object obj) {
        if (obj == null || TextUtils.isEmpty(obj.getClass().getSimpleName())) {
            a("object or getSimpleName() is null");
            return false;
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00b3: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:42:0x00b3 */
    public static String b(String str) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2;
        try {
            try {
                inputStream = AppInfo.d().getAssets().open(str);
            } catch (IOException e) {
                e = e;
                bufferedReader2 = null;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                inputStream = null;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            } catch (IOException e2) {
                e = e2;
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return sb2;
                    }
                }
                bufferedReader2.close();
                return sb2;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return "";
                    }
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                    return "";
                }
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStream2;
        }
    }

    public static void b(APMInterface aPMInterface) {
        if (a((Object) aPMInterface)) {
            String hexString = Integer.toHexString(aPMInterface.hashCode());
            if (!b.containsKey(hexString)) {
                a(aPMInterface.getClass().getSimpleName(), hexString, "mObjectRecord Don't contain");
                return;
            }
            Long l = b.get(hexString);
            if (l.longValue() > 0) {
                b.remove(hexString);
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                if (currentTimeMillis >= 86400000) {
                    return;
                }
                try {
                    String pageBizName = aPMInterface.getPageBizName();
                    String str = pageBizName;
                    if (TextUtils.isEmpty(pageBizName)) {
                        str = d(aPMInterface.getClass().getSimpleName());
                    }
                    BluedStatistics.d().a(str, hexString, currentTimeMillis);
                    if (AppInfo.m()) {
                        a(str, hexString, "end", Long.valueOf(currentTimeMillis));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Map<String, String> c(String str) {
        return (Map) new Gson().fromJson(b(str), Map.class);
    }

    public static String d(String str) {
        Map<String, String> map = c;
        String str2 = str;
        if (map != null) {
            str2 = str;
            if (!map.isEmpty()) {
                str2 = str;
                if (c.containsKey(str)) {
                    str2 = str;
                    if (c.get(str) != null) {
                        if (TextUtils.isEmpty(c.get(str))) {
                            return str;
                        }
                        str2 = c.get(str);
                    }
                }
            }
        }
        return str2;
    }
}
