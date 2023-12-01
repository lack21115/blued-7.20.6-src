package com.tencent.qimei.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qimei.i.f;
import com.tencent.qimei.n.c;
import com.tencent.qimei.n.e;
import com.tencent.qimei.n.i;
import com.tencent.qimei.o.l;
import com.tencent.qimei.o.m;
import com.tencent.qimei.r.b;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.u.d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/a/a.class */
public class a {
    public static Object a(String str, Object obj, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            return null;
        }
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | NullPointerException | SecurityException | InvocationTargetException e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(int r6) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.a.a.a(int):java.lang.String");
    }

    public static String a(Context context) {
        return String.format("file://%s/jsfile/tun-cos-1258344701.html", context.getFilesDir().getAbsolutePath());
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        while (true) {
            int i = length;
            if (i >= 16) {
                return sb.toString().substring(0, 16);
            }
            sb.append("0");
            length = i + 1;
        }
    }

    public static String a(String str, String str2) throws Exception {
        return new String(a(Base64.decode(str, 2), str2.getBytes("UTF-8"), 2), "UTF-8").trim();
    }

    public static String a(HttpURLConnection httpURLConnection) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        InputStream inputStream = httpURLConnection.getInputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                com.tencent.qimei.j.a.a(byteArrayOutputStream);
                com.tencent.qimei.j.a.a(inputStream);
                return byteArrayOutputStream2;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void a(String str, byte b) {
        c a2 = i.a().a(e.REPORT_CACHE.K, Byte.valueOf(b));
        a2.f24665a = str;
        a2.f24666c = "/report";
        a2.a("v6");
    }

    public static void a(String str, String str2, com.tencent.qimei.d.c cVar) {
        com.tencent.qimei.b.a.a().a(new com.tencent.qimei.d.b(str, str2, cVar));
    }

    public static boolean a() {
        ConnectivityManager connectivityManager;
        Context J = d.b().J();
        if (J == null || (connectivityManager = (ConnectivityManager) J.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean z = false;
                if (activeNetworkInfo != null) {
                    z = false;
                    if (activeNetworkInfo.isConnected()) {
                        z = true;
                    }
                }
                return z;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            boolean z2 = false;
            if (networkCapabilities != null) {
                if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0)) {
                    z2 = false;
                    if (networkCapabilities.hasTransport(3)) {
                    }
                }
                z2 = true;
            }
            return z2;
        } catch (SecurityException e) {
            e.printStackTrace();
            com.tencent.qimei.k.a.a("网络", "没有网络状态查询权限，请在AndroidManifest文件中添加 <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />", new Object[0]);
            return false;
        } catch (Exception e2) {
            com.tencent.qimei.k.a.a(e2);
            return false;
        }
    }

    public static boolean a(long j) {
        return j == 0 || System.currentTimeMillis() - j >= 86400000;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r5, byte[] r6, int r7) throws java.lang.Exception {
        /*
            boolean r0 = com.tencent.qimei.beaconid.U.f24624a
            if (r0 == 0) goto L16
            r0 = r7
            r1 = r6
            r2 = r6
            r3 = r5
            byte[] r0 = com.tencent.qimei.beaconid.U.a(r0, r1, r2, r3)     // Catch: java.lang.UnsatisfiedLinkError -> L11
            r8 = r0
            goto L18
        L11:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L16:
            r0 = 0
            r8 = r0
        L18:
            r0 = r8
            if (r0 == 0) goto L1e
            r0 = r8
            return r0
        L1e:
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec
            r1 = r0
            r2 = r6
            java.lang.String r3 = "AES"
            r1.<init>(r2, r3)
            r8 = r0
            javax.crypto.spec.IvParameterSpec r0 = new javax.crypto.spec.IvParameterSpec
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r6 = r0
            java.lang.String r0 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)
            r9 = r0
            r0 = r9
            r1 = r7
            r2 = r8
            r3 = r6
            r0.init(r1, r2, r3)
            r0 = r9
            r1 = r5
            byte[] r0 = r0.doFinal(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.a.a.a(byte[], byte[], int):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r0.equals("0") == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r0.equals(r0) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r7) {
        /*
            r0 = r7
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            return r0
        L7:
            java.lang.String r0 = com.tencent.qimei.c.a.d()
            r9 = r0
            r0 = r7
            java.io.File r0 = r0.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            r11 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 >= r1) goto L51
            r0 = r11
            int r0 = r0.length
            r1 = 4
            if (r0 >= r1) goto L2e
            goto L3b
        L2e:
            r0 = r11
            r1 = 3
            r0 = r0[r1]
            r10 = r0
            r0 = r10
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3e
        L3b:
            goto L89
        L3e:
            r0 = r10
            boolean r0 = h(r0)
            if (r0 == 0) goto L84
            r0 = r10
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L84
            goto L76
        L51:
            r0 = r11
            int r0 = r0.length
            r1 = 5
            if (r0 >= r1) goto L5b
            goto L89
        L5b:
            r0 = r11
            r1 = 3
            r0 = r0[r1]
            r10 = r0
            r0 = r11
            r1 = 4
            r0 = r0[r1]
            r11 = r0
            r0 = r10
            boolean r0 = h(r0)
            if (r0 == 0) goto L7b
            r0 = r10
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7b
        L76:
            r0 = 1
            r8 = r0
            goto L8b
        L7b:
            r0 = r11
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L89
        L84:
            r0 = 2
            r8 = r0
            goto L8b
        L89:
            r0 = 0
            r8 = r0
        L8b:
            java.lang.String r0 = "MultiUser"
            java.lang.String r1 = "userType: %s package: %s file: %s"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5
            r3 = r2
            r4 = 2
            r5 = r7
            r3[r4] = r5
            com.tencent.qimei.k.a.b(r0, r1, r2)
            r0 = r8
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.a.a.b(android.content.Context):java.lang.String");
    }

    public static String b(String str, String str2) throws Exception {
        return Base64.encodeToString(a(str.getBytes("UTF-8"), str2.getBytes("UTF-8"), 1), 2);
    }

    public static void b(String str) {
        synchronized (a.class) {
            try {
                if (com.tencent.qimei.c.a.i()) {
                    b.a.f24715a.a(str, "");
                }
            } finally {
            }
        }
    }

    public static int c(String str) {
        return l.a(str).f;
    }

    public static String c(String str, String str2) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 2)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, rSAPublicKey);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Qimei d(String str) {
        if (g(str)) {
            return null;
        }
        return l.a(str).f24690c;
    }

    public static String d(String str, String str2) {
        try {
            return a(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String e(String str) {
        JSONObject f = f(str);
        com.tencent.qimei.k.a.b("SDK_INIT ｜ 本地加密", " 获取存储Qm:%s ", f.toString());
        return f.optString(str);
    }

    public static void e(String str, String str2) {
        synchronized (a.class) {
            try {
                if (com.tencent.qimei.c.a.i()) {
                    JSONObject f = f(str);
                    try {
                        f.put(str, str2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String jSONObject = f.toString();
                    if (b.a.f24715a.a(str, jSONObject) == 0) {
                        f.a(str).a("q_s_t", System.currentTimeMillis());
                        com.tencent.qimei.k.a.b("QM", "Qm成功更新到本地: %s (appKey: %s)", jSONObject, str);
                        if (TextUtils.isEmpty(f.a(str).c("is_first"))) {
                            f.a(str).a("is_first", "false");
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(5:3|(4:41|42|6|(12:10|(2:16|(1:18)(1:19))|20|(2:22|(1:24))|25|26|27|(1:29)|31|(1:33)|34|35))|5|6|(13:8|10|(4:12|14|16|(0)(0))|20|(0)|25|26|27|(0)|31|(0)|34|35))|46|25|26|27|(0)|31|(0)|34|35) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ab, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b6, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
        r6.printStackTrace();
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e A[Catch: NullPointerException -> 0x00ab, JSONException -> 0x00b6, TRY_LEAVE, TryCatch #3 {NullPointerException -> 0x00ab, JSONException -> 0x00b6, blocks: (B:34:0x0096, B:36:0x009e), top: B:48:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject f(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.a.a.f(java.lang.String):org.json.JSONObject");
    }

    public static boolean g(String str) {
        return str == null || str.isEmpty() || d.b().J() == null;
    }

    public static boolean h(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Qimei i(String str) {
        String e = e(str);
        if (e == null || e.isEmpty()) {
            return null;
        }
        Qimei a2 = m.b.a(e);
        a2.setAppKey(str);
        return a2;
    }
}
