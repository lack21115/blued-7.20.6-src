package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/e.class */
public final class e {
    private static HashMap<String, ArrayList<String>> ayR = new HashMap<>();
    private static String ayS;

    private static ArrayList<String> D(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (ayR.get(str) != null) {
            return ayR.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Signature[] E = E(context, packageName);
            int length = E.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Signature signature = E[i2];
                String str2 = "error!";
                if ("MD5".equals(str)) {
                    str2 = a(signature, "MD5");
                } else if (AppSigning.SHA1.equals(str)) {
                    str2 = a(signature, AppSigning.SHA1);
                } else if (AppSigning.SHA256.equals(str)) {
                    str2 = a(signature, AppSigning.SHA256);
                }
                arrayList.add(str2);
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", "签名信息列表获取失败 " + e.getMessage());
        }
        ayR.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] E(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", e.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.substring(0, sb.length() - 1);
                }
                sb.append(Integer.toHexString((digest[i2] & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.e("AppSigningUtil", e.getMessage());
            return "error!";
        }
    }

    public static String bx(Context context) {
        if (TextUtils.isEmpty(ayS)) {
            ArrayList<String> D = D(context, AppSigning.SHA1);
            if (D != null && D.size() != 0) {
                ayS = D.get(0);
            }
            return ayS;
        }
        return ayS;
    }
}
