package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dk.class */
public class dk {
    public static int a() {
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = (FileInputStream) Class.forName("java.io.FileInputStream").getConstructor(String.class).newInstance("/sys/class/power_supply/usb/online");
            if (fileInputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 1000);
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        if (TextUtils.equals(readLine, "1")) {
                            try {
                                bufferedReader.close();
                                return 1;
                            } catch (Throwable th) {
                                return 1;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return 0;
                        } catch (Throwable th3) {
                            return 0;
                        }
                    }
                    return 0;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return 0;
                } catch (Throwable th4) {
                    return 0;
                }
            }
            return 0;
        } catch (Throwable th5) {
            bufferedReader = null;
        }
    }

    private static int a(Context context, String str) {
        try {
            return Settings.System.getInt(context.getContentResolver(), str, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(String str) {
        String str2 = str;
        if (str.contains("http")) {
            str2 = str.replace("https://", "").replace("http://", "");
        }
        String str3 = str2;
        if (str2.contains("/")) {
            str3 = str2.substring(0, str2.indexOf("/"));
        }
        return str3;
    }

    public static Set a(Context context) {
        try {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE)).getInstalledAccessibilityServiceList();
            HashSet hashSet = new HashSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                if (accessibilityServiceInfo != null && !TextUtils.isEmpty(accessibilityServiceInfo.getId())) {
                    hashSet.add(accessibilityServiceInfo.getId());
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Set a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            HashSet hashSet = new HashSet();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return hashSet;
                }
                hashSet.add(jSONArray.get(i2));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Set b(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).getInputMethodList();
            HashSet hashSet = new HashSet();
            for (InputMethodInfo inputMethodInfo : inputMethodList) {
                hashSet.add(inputMethodInfo.getId().split("/")[0]);
            }
            if (hashSet.size() <= 0) {
                return null;
            }
            return hashSet;
        } catch (Exception e) {
            return null;
        }
    }

    public static int c(Context context) {
        try {
            return a(context, Settings.System.SHOW_TOUCHES);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int d(Context context) {
        try {
            return a(context, Settings.System.POINTER_LOCATION);
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int e(android.content.Context r3) {
        /*
            r0 = r3
            android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.Throwable -> L2e
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L2e
            r3 = r0
            r0 = r3
            int r0 = r0.keyboard     // Catch: java.lang.Throwable -> L2e
            r1 = 1
            if (r0 == r1) goto L22
            r0 = r3
            int r0 = r0.hardKeyboardHidden     // Catch: java.lang.Throwable -> L2e
            r4 = r0
            r0 = r4
            r1 = 2
            if (r0 != r1) goto L1d
            goto L22
        L1d:
            r0 = 0
            r4 = r0
            goto L24
        L22:
            r0 = 1
            r4 = r0
        L24:
            r0 = r4
            if (r0 == 0) goto L2a
            r0 = 0
            return r0
        L2a:
            r0 = 1
            return r0
        L2c:
            r0 = -1
            return r0
        L2e:
            r3 = move-exception
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dk.e(android.content.Context):int");
    }
}
