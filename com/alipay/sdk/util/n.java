package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.data.a;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.telephony.PhoneConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/n.class */
public class n {
    static final String a = "com.eg.android.AlipayGphone";
    static final int b = 125;
    private static final String c = "com.alipay.android.app";
    private static final String d = "com.eg.android.AlipayGphoneRC";
    private static final int e = 99;
    private static final String[] f = {"10.1.5.1013151", "10.1.5.1013148"};

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/n$a.class */
    public static final class a {
        public final PackageInfo a;
        public final int b;
        public final String c;

        public a(PackageInfo packageInfo, int i, String str) {
            this.a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a() {
            return this.a.versionCode < this.b;
        }

        public boolean a(com.alipay.sdk.sys.a aVar) {
            Signature[] signatureArr = this.a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            int length = signatureArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                String a = n.a(aVar, signatureArr[i2].toByteArray());
                if (a != null && !TextUtils.equals(a, this.c)) {
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.w, String.format("Got %s, expected %s", a, this.c));
                    return true;
                }
                i = i2 + 1;
            }
        }
    }

    private static a a(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new a(packageInfo, i, str);
    }

    private static a a(com.alipay.sdk.sys.a aVar, Context context, String str, int i, String str2) {
        PackageInfo packageInfo;
        String str3 = str;
        if (EnvUtils.isSandBox()) {
            str3 = str;
            if (a.equals(str)) {
                str3 = d;
            }
        }
        try {
            packageInfo = b(context, str3);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.d, com.alipay.sdk.app.statistic.c.l, th.getMessage());
            packageInfo = null;
        }
        if (a(aVar, packageInfo)) {
            return a(packageInfo, i, str2);
        }
        return null;
    }

    public static a a(com.alipay.sdk.sys.a aVar, Context context, List<a.C0008a> list) {
        a a2;
        if (list == null) {
            return null;
        }
        for (a.C0008a c0008a : list) {
            if (c0008a != null && (a2 = a(aVar, context, c0008a.a, c0008a.b, c0008a.c)) != null && !a2.a(aVar) && !a2.a()) {
                return a2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        if (EnvUtils.isSandBox()) {
            return d;
        }
        try {
            return com.alipay.sdk.app.i.a.get(0).a;
        } catch (Throwable th) {
            return a;
        }
    }

    public static String a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return sb.toString();
            }
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        String str2;
        try {
            String str3 = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    str3 = str3 + "#M";
                } else {
                    if (runningAppProcessInfo.processName.startsWith(str + ":")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str3);
                        sb.append("#");
                        sb.append(runningAppProcessInfo.processName.replace(str + ":", ""));
                        str3 = sb.toString();
                    }
                }
            }
            str2 = str3;
        } catch (Throwable th) {
            str2 = "";
        }
        String str4 = str2;
        if (str2.length() > 0) {
            str4 = str2.substring(1);
        }
        String str5 = str4;
        if (str4.length() == 0) {
            str5 = "N";
        }
        return str5;
    }

    public static String a(com.alipay.sdk.sys.a aVar, Context context) {
        return a(aVar, context, context.getPackageName());
    }

    private static String a(com.alipay.sdk.sys.a aVar, Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.l, th);
            return "";
        }
    }

    public static String a(com.alipay.sdk.sys.a aVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.d, com.alipay.sdk.app.statistic.c.o, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return (EnvUtils.isSandBox() && TextUtils.equals(str, d)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static String a(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int i = 0;
            if (!TextUtils.isEmpty(str2)) {
                i = str3.indexOf(str2, indexOf);
            }
            return i < 1 ? str3.substring(indexOf) : str3.substring(indexOf, i);
        } catch (Throwable th) {
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            byte b2 = bArr[i2];
            sb.append(Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(Character.forDigit(b2 & 15, 16));
            i = i2 + 1;
        }
    }

    public static Map<String, String> a(com.alipay.sdk.sys.a aVar, String str) {
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            String[] split = str.substring(indexOf + 1).split(com.alipay.sdk.sys.a.b);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), b(aVar, str2.substring(indexOf2 + 1)));
                }
                i = i2 + 1;
            }
        }
        return hashMap;
    }

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(c, 128) != null;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            if (TextUtils.equals(str, f[0])) {
                return true;
            }
            return TextUtils.equals(str, f[1]);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(com.alipay.sdk.sys.a aVar, PackageInfo packageInfo) {
        String str;
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else if (packageInfo.signatures == null) {
            str = "info.signatures == null";
        } else if (packageInfo.signatures.length <= 0) {
            str = "info.signatures.length <= 0";
        } else {
            z = true;
            str = "";
        }
        if (!z) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.d, com.alipay.sdk.app.statistic.c.m, str);
        }
        return z;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, WebView webView, String str, Activity activity) {
        int parseInt;
        String substring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(com.alipay.sdk.cons.a.l.toLowerCase()) || str.toLowerCase().startsWith(com.alipay.sdk.cons.a.m.toLowerCase())) {
            try {
                a a2 = a(aVar, activity, com.alipay.sdk.app.i.a);
                if (a2 == null || a2.a() || a2.a(aVar)) {
                    return true;
                }
                String str2 = str;
                if (str.startsWith("intent://platformapi/startapp")) {
                    str2 = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.cons.a.l);
                }
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                return true;
            } catch (Throwable th) {
                return true;
            }
        } else if (TextUtils.equals(str, com.alipay.sdk.cons.a.o) || TextUtils.equals(str, com.alipay.sdk.cons.a.p)) {
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
            activity.finish();
            return true;
        } else if (str.startsWith(com.alipay.sdk.cons.a.n)) {
            try {
                String substring2 = str.substring(str.indexOf(com.alipay.sdk.cons.a.n) + 24);
                parseInt = Integer.parseInt(substring2.substring(substring2.lastIndexOf(com.alipay.sdk.cons.a.q) + 10));
            } catch (Exception e2) {
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.e());
            }
            if (parseInt != com.alipay.sdk.app.k.SUCCEEDED.a() && parseInt != com.alipay.sdk.app.k.PAY_WAITTING.a()) {
                com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.FAILED.a());
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b2.a(), b2.b(), ""));
                activity.runOnUiThread(new o(activity));
                return true;
            }
            if (com.alipay.sdk.cons.a.u) {
                StringBuilder sb = new StringBuilder();
                String decode = URLDecoder.decode(str);
                String decode2 = URLDecoder.decode(decode);
                String str3 = decode2.substring(decode2.indexOf(com.alipay.sdk.cons.a.n) + 24, decode2.lastIndexOf(com.alipay.sdk.cons.a.q)).split(com.alipay.sdk.cons.a.s)[0];
                int indexOf = decode.indexOf(com.alipay.sdk.cons.a.s) + 12;
                sb.append(str3);
                sb.append(com.alipay.sdk.cons.a.s);
                sb.append(decode.substring(indexOf, decode.indexOf(com.alipay.sdk.sys.a.b, indexOf)));
                sb.append(decode.substring(decode.indexOf(com.alipay.sdk.sys.a.b, indexOf)));
                substring = sb.toString();
            } else {
                String decode3 = URLDecoder.decode(str);
                substring = decode3.substring(decode3.indexOf(com.alipay.sdk.cons.a.n) + 24, decode3.lastIndexOf(com.alipay.sdk.cons.a.q));
            }
            com.alipay.sdk.app.k b3 = com.alipay.sdk.app.k.b(parseInt);
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b3.a(), b3.b(), substring));
            activity.runOnUiThread(new o(activity));
            return true;
        } else {
            return false;
        }
    }

    private static PackageInfo b(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static String b() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String b(com.alipay.sdk.sys.a aVar, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, e2);
            return "";
        }
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split(com.alipay.sdk.sys.a.b);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String str2 = split[i2];
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
            i = i2 + 1;
        }
    }

    public static boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a(), 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode < 99;
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static boolean b(com.alipay.sdk.sys.a aVar, Context context, List<a.C0008a> list) {
        try {
            for (a.C0008a c0008a : list) {
                if (c0008a != null) {
                    String str = c0008a.a;
                    String str2 = str;
                    if (EnvUtils.isSandBox()) {
                        str2 = str;
                        if (a.equals(str)) {
                            str2 = d;
                        }
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str2, 128) != null) {
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.W, th);
            return false;
        }
    }

    public static String c() {
        String d2 = d();
        int indexOf = d2.indexOf(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
        String str = d2;
        if (indexOf != -1) {
            str = d2.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("\n");
        String str2 = str;
        if (indexOf2 != -1) {
            str2 = str.substring(0, indexOf2);
        }
        return "Linux " + str2;
    }

    public static String c(Context context) {
        String b2 = b();
        String c2 = c();
        String d2 = d(context);
        String e2 = e(context);
        return " (" + b2 + i.b + c2 + i.b + d2 + i.b + i.b + e2 + ")(sdk android)";
    }

    public static JSONObject c(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    private static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (matcher.matches() && matcher.groupCount() >= 4) {
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            }
            return "Unavailable";
        } catch (IOException e2) {
            return "Unavailable";
        }
    }

    public static String d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static boolean d(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String e(Context context) {
        DisplayMetrics h = h(context);
        return h.widthPixels + PhoneConstants.APN_TYPE_ALL + h.heightPixels;
    }

    public static String e(String str) {
        try {
            Uri parse = Uri.parse(str);
            return String.format("%s%s", parse.getAuthority(), parse.getPath());
        } catch (Throwable th) {
            c.a(th);
            return NativeLibraryHelper.CLEAR_ABI_OVERRIDE;
        }
    }

    public static String f(Context context) {
        String a2 = m.a(context);
        return a2.substring(0, a2.indexOf("://"));
    }

    public static String f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.k.f.a);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            return "";
        }
    }

    public static String g(Context context) {
        return "-1;-1";
    }

    private static DisplayMetrics h(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
