package com.tencent.open.utils;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.BrowserContract;
import android.speech.tts.TextToSpeech;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.anythink.expressad.foundation.g.f.g.c;
import com.huawei.hms.ads.fw;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.a;
import com.tencent.open.utils.HttpUtils;
import com.tencent.qcloud.core.util.IOUtils;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/Util.class */
public class Util {

    /* renamed from: a  reason: collision with root package name */
    private static String f24596a = "";
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f24597c = "";
    private static String d = "";
    private static int e = -1;
    private static String f;
    private static String g = "0123456789ABCDEF";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/Util$Statistic.class */
    public static class Statistic {
        public long reqSize;
        public String response;
        public long rspSize;

        public Statistic(String str, int i) {
            this.response = str;
            this.reqSize = i;
            if (str != null) {
                this.rspSize = str.length();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/Util$TBufferedOutputStream.class */
    static class TBufferedOutputStream extends BufferedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f24599a;

        public TBufferedOutputStream(OutputStream outputStream) {
            super(outputStream);
            this.f24599a = 0;
        }

        public int getLength() {
            return this.f24599a;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            super.write(bArr);
            this.f24599a += bArr.length;
        }
    }

    private static char a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        GZIPInputStream gZIPInputStream = content;
        if (firstHeader != null) {
            gZIPInputStream = content;
            if (firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
                gZIPInputStream = new GZIPInputStream(content);
            }
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read == -1) {
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    private static boolean a(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(TbsConfig.APP_QB, 64);
            String str = packageInfo.versionName;
            if (SystemUtils.compareVersion(str, "4.3") < 0 || str.startsWith("4.4") || (signatureArr = packageInfo.signatures) == null) {
                return false;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(signatureArr[0].toByteArray());
                String hexString = toHexString(messageDigest.digest());
                messageDigest.reset();
                return hexString.equals("d8391a394d4a179e6fe7bdb8a301258b");
            } catch (NoSuchAlgorithmException e2) {
                f.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                return false;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            return false;
        }
    }

    public static boolean checkNetWork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= allNetworkInfo.length) {
                return false;
            }
            if (allNetworkInfo[i2].isConnectedOrConnecting()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static Bundle composeHaboCgiReportParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString(TextToSpeech.Engine.KEY_PARAM_RATE, str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", Build.VERSION.RELEASE);
        bundle.putString("network", a.a(Global.getContext()));
        bundle.putString(TelephonyManager.EXTRA_DATA_APN, a.b(Global.getContext()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString(HiAnalyticsConstant.BI_KEY_SDK_VER, Constants.SDK_VERSION);
        bundle.putString("packagename", Global.getPackageName());
        bundle.putString("app_ver", getAppVersionName(Global.getContext(), Global.getPackageName()));
        return bundle;
    }

    public static Bundle composeViaReportParams(String str, String str2, String str3, String str4, String str5, String str6) {
        return composeViaReportParams(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle composeViaReportParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = bundle;
        if (str != null) {
            try {
                String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    bundle2 = bundle;
                    if (i2 >= length) {
                        break;
                    }
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                    }
                    i = i2 + 1;
                }
            } catch (Exception e2) {
                bundle2 = null;
            }
        }
        return bundle2;
    }

    public static JSONObject decodeUrlToJson(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (str != null) {
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String[] split2 = split[i2].split("=");
                if (split2.length == 2) {
                    try {
                        jSONObject2.put(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                    } catch (JSONException e2) {
                        f.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
                i = i2 + 1;
            }
        }
        return jSONObject2;
    }

    public static String encodePostBody(Bundle bundle, String str) {
        Object obj;
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int size = bundle.size();
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            if (bundle.get(str2) instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + IOUtils.LINE_SEPARATOR_WINDOWS + IOUtils.LINE_SEPARATOR_WINDOWS + ((String) obj));
                i = i2;
                if (i2 < size - 1) {
                    sb.append("\r\n--" + str + IOUtils.LINE_SEPARATOR_WINDOWS);
                    i = i2;
                }
            } else {
                i = i2;
            }
        }
        return sb.toString();
    }

    public static String encodeUrl(Bundle bundle) {
        boolean z;
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                int i = 0;
                if (obj instanceof String[]) {
                    if (z2) {
                        z = false;
                    } else {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                        z = z2;
                    }
                    sb.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    z2 = z;
                    if (stringArray != null) {
                        while (true) {
                            z2 = z;
                            if (i < stringArray.length) {
                                if (i == 0) {
                                    sb.append(URLEncoder.encode(stringArray[i]));
                                } else {
                                    sb.append(URLEncoder.encode("," + stringArray[i]));
                                }
                                i++;
                            }
                        }
                    }
                } else {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb.toString();
    }

    public static String encrypt(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(getBytesUTF8(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb = new StringBuilder();
                int length = digest.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return sb.toString();
                    }
                    byte b2 = digest[i2];
                    sb.append(a(b2 >>> 4));
                    sb.append(a(b2));
                    i = i2 + 1;
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            f.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
        }
        return str;
    }

    public static boolean fileExists(String str) {
        return str != null && new File(str).exists();
    }

    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            f.e("openSDK_LOG.Util", "getAppVersion error" + e2.getMessage());
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (context == null) {
            return "";
        }
        getPackageInfo(context, str);
        return f24596a;
    }

    public static final String getApplicationLable(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static byte[] getBytesUTF8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    public static String getLocation(Context context) {
        Location lastKnownLocation;
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = locationManager.getLastKnownLocation(bestProvider)) == null) {
                return "";
            }
            String str = lastKnownLocation.getLatitude() + "*" + lastKnownLocation.getLongitude();
            f = str;
            return str;
        } catch (Exception e2) {
            f.b("openSDK_LOG.Util", "getLocation>>>", e2);
            return "";
        }
    }

    public static void getPackageInfo(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            b = str2;
            f24596a = str2.substring(0, str2.lastIndexOf(46));
            d = b.substring(b.lastIndexOf(46) + 1, b.length());
            e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (Exception e3) {
            f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    public static String getQUA3(Context context, String str) {
        if (context == null) {
            return "";
        }
        String appVersionName = getAppVersionName(context, str);
        f24597c = appVersionName;
        return appVersionName;
    }

    public static String getUserIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            f.a("openSDK_LOG.Util", "getUserIp SocketException ", e2);
            return "";
        }
    }

    public static String getVersionName(Context context, String str) {
        if (context == null) {
            return "";
        }
        getPackageInfo(context, str);
        return b;
    }

    public static boolean hasSDCard() {
        return (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String hexToString(String str) {
        String str2 = str;
        if ("0x".equals(str.substring(0, 2))) {
            str2 = str.substring(2);
        }
        int length = str2.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (Integer.parseInt(str2.substring(i2, i2 + 2), 16) & 255);
            } catch (Exception e2) {
                f.e("openSDK_LOG.Util", "hexToString has exception: " + e2.getMessage());
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            f.e("openSDK_LOG.Util", "hexToString has exception: " + e3.getMessage());
            return str2;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isMobileQQSupportShare(Context context) {
        boolean z = false;
        try {
            if (SystemUtils.compareVersion(context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName, "4.1") >= 0) {
                z = true;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e2) {
            f.b("openSDK_LOG.Util", "NameNotFoundException", e2);
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isTablet(Context context) {
        double d2;
        boolean z;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable th) {
            d2 = 0.0d;
        }
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0) {
            z = false;
            return d2 > 6.5d && !z;
        }
        z = true;
        if (d2 > 6.5d) {
            return false;
        }
    }

    public static final boolean isValidPath(String str) {
        return str != null && new File(str).exists();
    }

    public static final boolean isValidUrl(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            z = true;
        }
        return z;
    }

    public static boolean openBrowser(Context context, String str) {
        boolean z;
        try {
            z = a(context);
            try {
                if (z) {
                    a(context, TbsConfig.APP_QB, "com.tencent.mtt.MainActivity", str);
                } else {
                    a(context, BrowserContract.AUTHORITY, "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception e2) {
                if (!z) {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception e3) {
                        try {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        } catch (Exception e4) {
                            return false;
                        }
                    }
                }
                try {
                    a(context, BrowserContract.AUTHORITY, "com.android.browser.BrowserActivity", str);
                    return true;
                } catch (Exception e5) {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception e6) {
                        try {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                            return true;
                        } catch (Exception e7) {
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e8) {
            z = false;
        }
    }

    public static int parseIntValue(String str) {
        return parseIntValue(str, 0);
    }

    public static int parseIntValue(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            return i;
        }
    }

    public static JSONObject parseJson(String str) throws JSONException {
        String str2 = str;
        if (str.equals("false")) {
            str2 = "{value : false}";
        }
        String str3 = str2;
        if (str2.equals(fw.Code)) {
            str3 = "{value : true}";
        }
        String str4 = str3;
        if (str3.contains("allback(")) {
            str4 = str3.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        String str5 = str4;
        if (str4.contains("online[0]=")) {
            str5 = "{online:" + str4.charAt(str4.length() - 2) + "}";
        }
        return new JSONObject(str5);
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e2) {
            return new Bundle();
        }
    }

    public static JSONObject parseUrlToJson(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject decodeUrlToJson = decodeUrlToJson(null, url.getQuery());
            decodeUrlToJson(decodeUrlToJson, url.getRef());
            return decodeUrlToJson;
        } catch (MalformedURLException e2) {
            return new JSONObject();
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.open.utils.Util$1] */
    public static void reportBernoulli(final Context context, String str, long j, String str2) {
        final Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", Constants.SDK_VERSION);
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new Thread() { // from class: com.tencent.open.utils.Util.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    HttpUtils.openUrl2(Context.this, "http://cgi.qplus.com/report/report", "GET", bundle);
                } catch (Exception e2) {
                    f.e("openSDK_LOG.Util", "reportBernoulli has exception: " + e2.getMessage());
                }
            }
        }.start();
    }

    public static void showAlert(Context context, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }

    public static final String subString(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str4 = !TextUtils.isEmpty(str2) ? str2 : "UTF-8";
        String str5 = str;
        try {
            if (str.getBytes(str4).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str4).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    String str6 = substring;
                    if (!TextUtils.isEmpty(str3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(substring);
                        sb.append(str3);
                        str5 = substring;
                        str6 = sb.toString();
                    }
                    return str6;
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e2) {
            System.out.println("StructMsg sSubString error : " + e2.getMessage());
            return str5;
        }
    }

    public static String toHexString(String str) {
        byte[] bytesUTF8 = getBytesUTF8(str);
        StringBuilder sb = new StringBuilder(bytesUTF8.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bytesUTF8.length) {
                return sb.toString();
            }
            sb.append(g.charAt((bytesUTF8[i2] & 240) >> 4));
            sb.append(g.charAt((bytesUTF8[i2] & 15) >> 0));
            i = i2 + 1;
        }
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String num = Integer.toString(bArr[i2] & 255, 16);
            String str = num;
            if (num.length() == 1) {
                str = "0" + num;
            }
            sb.append(str);
            i = i2 + 1;
        }
    }

    public static Statistic upload(Context context, String str, Bundle bundle) throws MalformedURLException, IOException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null || ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable())) {
            Bundle bundle2 = new Bundle(bundle);
            String string = bundle2.getString("appid_for_getting_config");
            bundle2.remove("appid_for_getting_config");
            HttpClient httpClient = HttpUtils.getHttpClient(context, string, str);
            HttpPost httpPost = new HttpPost(str);
            Bundle bundle3 = new Bundle();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str2, (byte[]) obj);
                }
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader("Connection", c.f5066c);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(getBytesUTF8("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(getBytesUTF8(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                int i = -1;
                byteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (String str3 : bundle3.keySet()) {
                    int i2 = i + 1;
                    byteArrayOutputStream.write(getBytesUTF8("Content-Disposition: form-data; name=\"" + str3 + "\"; filename=\"value.file\"" + IOUtils.LINE_SEPARATOR_WINDOWS));
                    byteArrayOutputStream.write(getBytesUTF8("Content-Type: application/octet-stream\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str3);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    i = i2;
                    if (i2 < size - 1) {
                        byteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                        i = i2;
                    }
                }
            }
            byteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            int length = byteArray2.length;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(byteArray2));
            HttpResponse execute = httpClient.execute(httpPost);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return new Statistic(a(execute), 0 + length);
            }
            throw new HttpUtils.HttpStatusException(HttpUtils.HttpStatusException.ERROR_INFO + statusCode);
        }
        throw new HttpUtils.NetworkUnavailableException(HttpUtils.NetworkUnavailableException.ERROR_INFO);
    }
}
