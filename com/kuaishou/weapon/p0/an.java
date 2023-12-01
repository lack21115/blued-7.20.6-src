package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Camera;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/an.class */
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10117a = "de.robv.android.xposed.XposedHelpers";
    public static final String b = "de.robv.android.xposed.XposedBridge";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10118c = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";

    private boolean a(Context context, String str, Set set) {
        TelephonyManager telephonyManager;
        try {
            if (set.size() > 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                return a(telephonyManager.getClass(), str, set);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean a(Class cls, String str, Set set) {
        if (str != null) {
            try {
                if (set.size() <= 0 || !set.toString().contains(str)) {
                    return false;
                }
                return set.toString().contains(cls.getName());
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private boolean a(Method method) {
        return method != null && Modifier.isNative(method.getModifiers());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(android.content.Context r6, int r7, java.util.Set r8) {
        /*
            r5 = this;
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch: java.lang.Exception -> L65
            if (r0 == 0) goto L59
            r0 = r7
            switch(r0) {
                case 13: goto L52;
                case 14: goto Lae;
                case 15: goto La7;
                case 16: goto L9d;
                case 17: goto L93;
                case 18: goto L89;
                case 19: goto L7f;
                case 20: goto L75;
                case 21: goto L6b;
                default: goto L68;
            }
        L38:
            r0 = r5
            r1 = r6
            r2 = r10
            r3 = r8
            boolean r0 = r0.a(r1, r2, r3)     // Catch: java.lang.Exception -> L65
            r9 = r0
            goto L5c
        L45:
            r0 = r5
            r1 = r6
            r2 = r10
            r3 = r8
            boolean r0 = r0.a(r1, r2, r3)     // Catch: java.lang.Exception -> L65
            r9 = r0
            goto L5c
        L52:
            java.lang.String r0 = "getDeviceId"
            r10 = r0
            goto L45
        L59:
            r0 = 0
            r9 = r0
        L5c:
            r0 = r9
            if (r0 == 0) goto L63
            r0 = 1
            return r0
        L63:
            r0 = 0
            return r0
        L65:
            r6 = move-exception
            r0 = 0
            return r0
        L68:
            goto L59
        L6b:
            java.lang.Class<android.net.wifi.WifiInfo> r0 = android.net.wifi.WifiInfo.class
            r6 = r0
            java.lang.String r0 = "getBSSID"
            r10 = r0
            goto L38
        L75:
            java.lang.Class<android.net.wifi.WifiInfo> r0 = android.net.wifi.WifiInfo.class
            r6 = r0
            java.lang.String r0 = "getSSID"
            r10 = r0
            goto L38
        L7f:
            java.lang.Class<android.net.wifi.WifiInfo> r0 = android.net.wifi.WifiInfo.class
            r6 = r0
            java.lang.String r0 = "getMacAddress"
            r10 = r0
            goto L38
        L89:
            java.lang.Class<java.lang.reflect.Method> r0 = java.lang.reflect.Method.class
            r6 = r0
            java.lang.String r0 = "invoke"
            r10 = r0
            goto L38
        L93:
            java.lang.Class<java.lang.StringBuilder> r0 = java.lang.StringBuilder.class
            r6 = r0
            java.lang.String r0 = "toString"
            r10 = r0
            goto L38
        L9d:
            java.lang.Class<android.provider.Settings$Secure> r0 = android.provider.Settings.Secure.class
            r6 = r0
            java.lang.String r0 = "getString"
            r10 = r0
            goto L38
        La7:
            java.lang.String r0 = "getSimSerialNumber"
            r10 = r0
            goto L45
        Lae:
            java.lang.String r0 = "getSubscriberId"
            r10 = r0
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.an.a(android.content.Context, int, java.util.Set):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Set<java.lang.String> a() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.an.a():java.util.Set");
    }

    public Set a(Set set) {
        String str;
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            if (obj instanceof String) {
                str = obj;
                if (obj != null) {
                    String str2 = (String) obj;
                    if (!str2.startsWith("android.app.ResourcesManager#") && !str2.startsWith("android.view.LayoutInflater#")) {
                        str = obj;
                    }
                }
                hashSet.add(str);
            } else if (obj instanceof Method) {
                str = ((Method) obj).getName();
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public boolean a(Class cls, String str, Class<?>... clsArr) {
        try {
            return a(bg.a(cls, str, clsArr));
        } catch (Exception e) {
            return false;
        }
    }

    public Set<String> b() {
        Set keySet;
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(b);
            if (loadClass != null) {
                Field declaredField = loadClass.getDeclaredField("sHookedMethodCallbacks");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(loadClass);
                if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                    return null;
                }
                return a(keySet);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject b(Set set) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                jSONObject.put("0", a(Class.class, "forName", set) ? 1 : 0);
                jSONObject.put("1", a(ClassLoader.class, "loadClass", set) ? 1 : 0);
                jSONObject.put("2", a(Throwable.class, "getStackTrace", set) ? 1 : 0);
                jSONObject.put("3", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set) ? 1 : 0);
                jSONObject.put("4", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set) ? 1 : 0);
                jSONObject.put("5", a(ActivityManager.class, "getRunningServices", set) ? 1 : 0);
                jSONObject.put("6", a(JSONObject.class, "toString", set) ? 1 : 0);
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public Set<String> c() {
        Set keySet;
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(f10117a);
            if (loadClass != null) {
                Field declaredField = loadClass.getDeclaredField("methodCache");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(loadClass);
                if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                    return null;
                }
                return a(keySet);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a(TelephonyManager.class, "getDeviceId", new Class[0]) ? 1 : 0);
            jSONObject.put("1", a(TelephonyManager.class, "getSubscriberId", new Class[0]) ? 1 : 0);
            jSONObject.put("2", a(TelephonyManager.class, "getSimSerialNumber", new Class[0]) ? 1 : 0);
            jSONObject.put("3", a(Location.class, "getLatitude", new Class[0]) ? 1 : 0);
            jSONObject.put("4", a(Location.class, "getLongitude", new Class[0]) ? 1 : 0);
            if (Build.VERSION.SDK_INT >= 26) {
                jSONObject.put("5", a(Build.class, "getSerial", new Class[0]) ? 1 : 0);
            } else {
                jSONObject.put("5", 0);
            }
            jSONObject.put("6", a(WifiInfo.class, "getMacAddress", new Class[0]) ? 1 : 0);
            jSONObject.put("7", a(WifiInfo.class, "getBSSID", new Class[0]) ? 1 : 0);
            jSONObject.put("8", a(WifiInfo.class, "getRssi", new Class[0]) ? 1 : 0);
            jSONObject.put("9", a(Class.class, "forName", String.class) ? 1 : 0);
            int i = 0;
            if (a(ActivityManager.class, "getRunningServices", Integer.TYPE)) {
                i = 1;
            }
            jSONObject.put("10", i);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            boolean a2 = a(MediaRecorder.class, "setOutputFile", String.class);
            if (a2) {
                jSONObject.put("0", a2 ? 1 : 0);
            }
            boolean a3 = a(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
            if (a3) {
                jSONObject.put("1", a3 ? 1 : 0);
            }
            boolean a4 = a(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
            if (a4) {
                jSONObject.put("2", a4 ? 1 : 0);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject f() {
        try {
            JSONObject jSONObject = new JSONObject();
            boolean a2 = a(Cipher.class, "doFinal", byte[].class);
            jSONObject.put("0", a2 ? 1 : 0);
            boolean a3 = a(SecureRandom.class, "setSeed", byte[].class);
            jSONObject.put("1", a3 ? 1 : 0);
            if (a3) {
                a2 = true;
            }
            boolean a4 = a(MessageDigest.class, "update", byte[].class);
            jSONObject.put("2", a4 ? 1 : 0);
            if (a4) {
                a2 = true;
            }
            boolean a5 = a(MessageDigest.class, "getInstance", String.class);
            jSONObject.put("3", a5 ? 1 : 0);
            if (a5) {
                a2 = true;
            }
            boolean a6 = a(Uri.class, "parse", String.class);
            jSONObject.put("4", a6 ? 1 : 0);
            if (a6) {
                a2 = true;
            }
            boolean a7 = a(SQLiteDatabase.class, "execSQL", String.class);
            jSONObject.put("5", a7 ? 1 : 0);
            if (a7) {
                a2 = true;
            }
            boolean a8 = a(Activity.class, "finish", new Class[0]);
            int i = 0;
            if (a8) {
                i = 1;
            }
            jSONObject.put("6", i);
            if (a8) {
                a2 = true;
            }
            if (a2) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            boolean a2 = a(JSONObject.class, "toString", new Class[0]);
            if (a2) {
                jSONObject.put("0", a2 ? 1 : 0);
            }
            boolean a3 = a(TextUtils.class, "isEmpty", CharSequence.class);
            if (a3) {
                jSONObject.put("1", a3 ? 1 : 0);
            }
            boolean a4 = a(JSONArray.class, "toString", new Class[0]);
            if (a4) {
                jSONObject.put("2", a4 ? 1 : 0);
            }
            boolean a5 = a(Cipher.class, "doFinal", byte[].class);
            if (a5) {
                jSONObject.put("3", a5 ? 1 : 0);
            }
            boolean a6 = a(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
            if (a6) {
                jSONObject.put("4", a6 ? 1 : 0);
            }
            boolean a7 = a(FileOutputStream.class, "write", byte[].class);
            if (a7) {
                jSONObject.put("5", a7 ? 1 : 0);
            }
            boolean a8 = a(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
            if (a8) {
                int i = 0;
                if (a8) {
                    i = 1;
                }
                jSONObject.put("6", i);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
