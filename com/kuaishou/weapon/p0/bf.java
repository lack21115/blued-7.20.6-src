package com.kuaishou.weapon.p0;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.List;
import java.util.logging.Logger;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bf.class */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    private int f23746a = -1;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
        if (r7 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0088, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
        if (r7 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject a(android.content.Context r7, java.lang.String r8) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r1 = r0
            r1.<init>()
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r1 = r0
            java.lang.String r2 = "content://settings/"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9b
            r10 = r0
            r0 = r10
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9b
            r0 = r10
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9b
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L9b
            r8 = r0
            r0 = r7
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L9b
            r1 = r8
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L9b
            r7 = r0
        L2d:
            r0 = r7
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L9f
            if (r0 == 0) goto L7e
            r0 = r7
            r1 = r7
            java.lang.String r2 = "name"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L9f
            r8 = r0
            r0 = r7
            r1 = r7
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L9f
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L9f
            r10 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L9f
            if (r0 != 0) goto L2d
            r0 = r8
            java.lang.String r1 = "android_id"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L9f
            if (r0 != 0) goto L2d
            r0 = r10
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L9f
            if (r0 != 0) goto L2d
            r0 = r10
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L9f
            r1 = 20
            if (r0 >= r1) goto L2d
            r0 = r9
            r1 = r8
            r2 = r10
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L9f
            goto L2d
        L7e:
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L9f
            r0 = r7
            if (r0 == 0) goto L99
        L88:
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> La3
            r0 = r9
            return r0
        L90:
            r0 = 0
            r7 = r0
        L92:
            r0 = r7
            if (r0 == 0) goto L99
            goto L88
        L99:
            r0 = r9
            return r0
        L9b:
            r7 = move-exception
            goto L90
        L9f:
            r8 = move-exception
            goto L92
        La3:
            r7 = move-exception
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bf.a(android.content.Context, java.lang.String):org.json.JSONObject");
    }

    public static int d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
        } catch (Exception e) {
            return 0;
        }
    }

    public static JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return jSONObject;
            }
            try {
                String str = new String[]{"system", Logger.GLOBAL_LOGGER_NAME, "secure"}[i2];
                JSONObject a2 = a(context, str);
                if (a2 != null && a2.length() > 0) {
                    jSONObject.put(str, a2);
                }
                i = i2 + 1;
            } catch (Exception e) {
                return jSONObject;
            }
        }
    }

    private boolean h(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Boolean) cls.getMethod("isSecure", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public String a(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return bh.b;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(0);
            int streamVolume = audioManager.getStreamVolume(0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", streamMaxVolume + ":" + streamVolume);
            int streamMaxVolume2 = audioManager.getStreamMaxVolume(1);
            int streamVolume2 = audioManager.getStreamVolume(1);
            jSONObject.put("1", streamMaxVolume2 + ":" + streamVolume2);
            int streamMaxVolume3 = audioManager.getStreamMaxVolume(2);
            int streamVolume3 = audioManager.getStreamVolume(2);
            jSONObject.put("2", streamMaxVolume3 + ":" + streamVolume3);
            int streamMaxVolume4 = audioManager.getStreamMaxVolume(3);
            int streamVolume4 = audioManager.getStreamVolume(3);
            jSONObject.put("3", streamMaxVolume4 + ":" + streamVolume4);
            int streamMaxVolume5 = audioManager.getStreamMaxVolume(4);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("4", streamMaxVolume5 + ":" + streamVolume5);
            String jSONObject2 = jSONObject.toString();
            String str = jSONObject2;
            if (TextUtils.isEmpty(jSONObject2)) {
                str = bh.f23749c;
            }
            return str;
        } catch (Throwable th) {
            return bh.d;
        }
    }

    public boolean a() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public int b() {
        return this.f23746a;
    }

    public boolean b(Context context) {
        return ((KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE)).inKeyguardRestrictedInputMode();
    }

    public boolean c(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
            return Build.VERSION.SDK_INT >= 28 ? keyguardManager.isKeyguardLocked() : keyguardManager.inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean e(Context context) {
        return Build.VERSION.SDK_INT >= 16 ? ((KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE)).isKeyguardSecure() : h(context);
    }

    public JSONObject f(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (Sensor sensor : sensorList) {
                jSONObject.put(sensor.getName(), sensor.getVendor());
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }
}
