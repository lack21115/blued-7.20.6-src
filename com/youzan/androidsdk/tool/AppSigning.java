package com.youzan.androidsdk.tool;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/AppSigning.class */
public class AppSigning {
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String SHA256 = "SHA256";

    public static String getSignatureString(Signature signature, String str) {
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
                    return sb.toString();
                }
                sb.append(Integer.toHexString((digest[i2] & 255) | 256).substring(1, 3));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "error!";
        }
    }

    public static Signature[] getSignatures(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> getSingInfo(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Signature[] signatures = getSignatures(context, str);
            int length = signatures.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Signature signature = signatures[i2];
                String str3 = "error!";
                if ("MD5".equals(str2)) {
                    str3 = getSignatureString(signature, "MD5");
                } else if (SHA1.equals(str2)) {
                    str3 = getSignatureString(signature, SHA1);
                } else if (SHA256.equals(str2)) {
                    str3 = getSignatureString(signature, SHA256);
                }
                arrayList.add(str3);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
