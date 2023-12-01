package com.opos.cmn.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.at;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f24979a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final String a(String str) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(at.aq);
        messageDigest.update(str.getBytes());
        return a(messageDigest.digest());
    }

    public static final String a(String str, Signature signature) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(signature.toByteArray());
        return a(messageDigest.digest());
    }

    public static final String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr);
            }
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f24979a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
            i = i2 + 1;
        }
    }

    public static final Signature[] a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 134217856);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signingInfo.getApkContentsSigners();
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(context.getPackageName(), 192);
            if (packageInfo2 != null) {
                return packageInfo2.signatures;
            }
            return null;
        } catch (PackageManager.NameNotFoundException | Exception e) {
            return null;
        }
    }
}
