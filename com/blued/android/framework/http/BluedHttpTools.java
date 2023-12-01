package com.blued.android.framework.http;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.utils.LocaleUtils;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/BluedHttpTools.class */
public class BluedHttpTools {
    public static String a(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        String json = AppInfo.f().toJson(map);
        if (HttpManager.c()) {
            Log.v("HttpManager", "params string:" + json);
        }
        return json;
    }

    public static String a(byte[] bArr) {
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

    public static Map<String, String> a() {
        return new ArrayMap();
    }

    public static Map<String, String> a(String str) {
        Map<String, String> a = a(false);
        a.put("Authorization", "Blued " + str);
        return a;
    }

    public static Map<String, String> a(String str, String str2, String str3, String str4) {
        String str5;
        Map<String, String> a = a(false);
        try {
            String str6 = str3 + new StringBuilder(str4).reverse().toString();
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            str5 = Base64.encodeToString((str + ":" + Base64.encodeToString(mac.doFinal(str6.getBytes()), 2)).getBytes(), 2);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            str5 = "";
            a.put("Authorization", "Blued " + str5);
            Log.v("tempTest", "sign:" + str5 + ", t:" + str4);
            return a;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            str5 = "";
            a.put("Authorization", "Blued " + str5);
            Log.v("tempTest", "sign:" + str5 + ", t:" + str4);
            return a;
        } catch (Throwable th) {
            th.printStackTrace();
            str5 = "";
            a.put("Authorization", "Blued " + str5);
            Log.v("tempTest", "sign:" + str5 + ", t:" + str4);
            return a;
        }
        a.put("Authorization", "Blued " + str5);
        Log.v("tempTest", "sign:" + str5 + ", t:" + str4);
        return a;
    }

    public static Map<String, String> a(boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("Accept", "*/*");
        arrayMap.put("Connection", "keep-alive");
        arrayMap.put("Content-Type", FastJsonJsonView.DEFAULT_CONTENT_TYPE);
        arrayMap.put("Accept-Language", LocaleUtils.b());
        arrayMap.put("User-Agent", AppInfo.b);
        arrayMap.put("channel", AppInfo.c);
        arrayMap.put("ua", WebSettings.getDefaultUserAgent(AppInfo.d()));
        String b = ProviderHolder.a().e().b();
        if (!TextUtils.isEmpty(b)) {
            arrayMap.put("X-CLIENT-COLOR", b);
        }
        if (z) {
            arrayMap.put("Authorization", "Basic " + d());
        }
        return arrayMap;
    }

    public static String b(String str) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(str.getBytes());
        return a(messageDigest.digest());
    }

    public static Map<String, Object> b() {
        return new ArrayMap();
    }

    public static Map<String, String> b(boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("Accept", "*/*");
        arrayMap.put("Connection", "keep-alive");
        arrayMap.put("Accept-Language", LocaleUtils.b());
        arrayMap.put("User-Agent", AppInfo.b);
        if (z) {
            arrayMap.put("Authorization", "Basic " + d());
        }
        return arrayMap;
    }

    public static Map<String, String[]> c() {
        return new ArrayMap();
    }

    public static Map<String, String> c(boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("Accept", "*/*");
        arrayMap.put("Connection", "keep-alive");
        arrayMap.put("Accept-Language", LocaleUtils.b());
        arrayMap.put("User-Agent", AppInfo.b);
        if (z) {
            arrayMap.put("Authorization", "Basic " + d());
        }
        return arrayMap;
    }

    public static String d() {
        String a = ProviderHolder.a().b().a();
        String b = ProviderHolder.a().b().b();
        String str = b;
        try {
            if (TextUtils.isEmpty(b)) {
                str = "0";
            }
            return Base64.encodeToString((a + ":" + str).getBytes(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
