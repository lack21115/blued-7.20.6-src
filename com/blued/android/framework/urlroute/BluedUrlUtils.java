package com.blued.android.framework.urlroute;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alipay.sdk.sys.a;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlroute/BluedUrlUtils.class */
public class BluedUrlUtils {
    public static String a(String str, String str2) {
        Map<String, String> a = a(str);
        if (a == null || a.size() <= 0) {
            return null;
        }
        return a.get(str2);
    }

    public static Map<String, String> a(String str) {
        int indexOf = str.indexOf("?");
        String substring = (indexOf <= 0 || indexOf >= str.length() - 1) ? null : str.substring(indexOf + 1);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        String[] split = substring.split(a.b);
        if (split.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    break;
                }
                String[] split2 = split[i2].split("=");
                if (split2.length == 2) {
                    String str2 = split2[1];
                    try {
                        str2 = URLDecoder.decode(split2[1], "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    arrayMap.put(split2[0].toLowerCase(), str2);
                }
                i = i2 + 1;
            }
        }
        return arrayMap;
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        Map<String, String> a = a(str);
        if (a != null) {
            String str2 = a.get("blued_mode");
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("blued_mode", str2);
            }
        }
        return hashMap;
    }
}
