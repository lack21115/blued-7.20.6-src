package com.qiniu.android.http;

import android.os.Build;
import android.text.TextUtils;
import com.qiniu.android.common.Constants;
import com.qiniu.android.utils.StringUtils;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/UserAgent.class */
public final class UserAgent {
    private static UserAgent _instance = new UserAgent();
    public final String id;
    public final String ua;

    private UserAgent() {
        String genId = genId();
        this.id = genId;
        this.ua = getUserAgent(genId);
    }

    public static String device() {
        try {
            String trim = Build.MODEL.trim();
            String deviceName = deviceName(Build.MANUFACTURER.trim(), trim);
            String str = deviceName;
            if (TextUtils.isEmpty(deviceName)) {
                str = deviceName(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            String str2 = str;
            if (str == null) {
                str2 = "-";
            }
            sb.append(str2);
            sb.append("-");
            sb.append(trim);
            return StringUtils.strip(sb.toString());
        } catch (Throwable th) {
            return "-";
        }
    }

    private static String deviceName(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    private static String genId() {
        Random random = new Random();
        return System.currentTimeMillis() + "" + random.nextInt(999);
    }

    static String getUserAgent(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", Constants.VERSION, osVersion(), device(), str);
    }

    public static UserAgent instance() {
        return _instance;
    }

    public static String osVersion() {
        try {
            String str = Build.VERSION.RELEASE;
            return str == null ? "-" : StringUtils.strip(str.trim());
        } catch (Throwable th) {
            return "-";
        }
    }

    public String getUa(String str) {
        String trim = ("" + str).trim();
        String substring = trim.substring(0, Math.min(16, trim.length()));
        return new String((this.ua + "; " + substring + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}
