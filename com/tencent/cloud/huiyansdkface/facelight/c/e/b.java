package com.tencent.cloud.huiyansdkface.facelight.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35581a = b.class.getSimpleName();

    public static String a(Context context, byte[] bArr) {
        if (context == null) {
            WLogger.e(f35581a, "byteToProguardVideo context is null!");
            return "";
        }
        File file = new File(context.getCacheDir().getAbsolutePath());
        if (!file.exists() && !file.mkdirs()) {
            WLogger.i(f35581a, "failed to createAdapter media dir!");
        }
        String str = file.getPath() + File.separator + ("proguard_" + ("" + System.currentTimeMillis()) + ".mp4");
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.flush();
            fileOutputStream.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    protected static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            int i3 = (bArr[i2] & 255) / 16;
            byte b = bArr[i2];
            stringBuffer.append("0123456789abcdef".charAt(i3));
            stringBuffer.append("0123456789abcdef".charAt(b & 15));
            i = i2 + 1;
        }
    }

    public static String a(byte[] bArr, String str) throws Exception {
        return a(b(bArr, str));
    }

    public static String a(byte[] bArr, byte[] bArr2, String str) throws Exception {
        byte[] bArr3;
        byte[] bArr4;
        WLogger.d(f35581a, "salt=" + str);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (bArr == null || bArr.length == 0) {
            WLogger.e(f35581a, "generateFileMd5 video is null!");
            bArr3 = null;
        } else {
            bArr3 = Base64.encode(bArr, 2);
        }
        if (bArr2 == null || bArr2.length == 0) {
            WLogger.e(f35581a, "generateFileMd5 wbVideo is null!");
            bArr4 = null;
        } else {
            bArr4 = Base64.encode(bArr2, 2);
        }
        if (bArr3 == null && bArr4 == null) {
            return "";
        }
        byte[] a2 = a(bArr3, bArr4);
        WLogger.d(f35581a, "after arrayBytes=" + a2.length);
        if (a2 == null || a2.length == 0) {
            return "";
        }
        String a3 = a(a2, str);
        WLogger.d(f35581a, "md5=" + a3);
        return a3;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            WLogger.d(f35581a, "old video exist!");
            if (file.delete()) {
                WLogger.d(f35581a, "old video detele!");
            } else {
                WLogger.i("video file detele failed!");
            }
        }
    }

    public static byte[] a(File file) {
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return c(bArr2);
        }
        if (bArr2 == null) {
            return c(bArr);
        }
        String str = f35581a;
        WLogger.d(str, "array1=" + bArr.length + ",array2=" + bArr2.length);
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            WLogger.e(f35581a, "proguardMp4Byte video length is 0!");
            return null;
        }
        String str = f35581a;
        WLogger.d(str, "proguardMp4Byte videoByte=" + bArr.length);
        if (bArr.length < 200) {
            WLogger.e(f35581a, "proguardMp4Byte video length < 200!no proguard!");
            return bArr;
        }
        String a2 = f.a(1);
        String a3 = f.a(1);
        String a4 = f.a(1);
        String str2 = f35581a;
        WLogger.d(str2, "first=" + a2 + ",len=" + a2.getBytes().length + ";second=" + a3 + ",len=" + a3.getBytes().length + ";third=" + a4 + ",len=" + a4.getBytes().length);
        int length = bArr.length + a2.getBytes().length + a3.getBytes().length + a4.getBytes().length;
        byte[] bArr2 = new byte[length];
        System.arraycopy((Object) a2.getBytes(), 0, (Object) bArr2, 0, a2.getBytes().length);
        int length2 = a2.getBytes().length + 0;
        System.arraycopy((Object) bArr, 0, (Object) bArr2, length2, 99);
        int i = length2 + 99;
        String str3 = f35581a;
        StringBuilder sb = new StringBuilder();
        sb.append("after1 destPos=");
        sb.append(i);
        WLogger.d(str3, sb.toString());
        System.arraycopy((Object) a3.getBytes(), 0, (Object) bArr2, i, a3.getBytes().length);
        int length3 = i + a3.getBytes().length;
        String str4 = f35581a;
        WLogger.d(str4, "after2 destPos=" + length3);
        System.arraycopy((Object) bArr, 99, (Object) bArr2, length3, 99);
        int i2 = length3 + 99;
        String str5 = f35581a;
        WLogger.d(str5, "after3 destPos=" + i2);
        System.arraycopy((Object) a4.getBytes(), 0, (Object) bArr2, i2, a4.getBytes().length);
        int length4 = i2 + a4.getBytes().length;
        String str6 = f35581a;
        WLogger.d(str6, "after4 destPos=" + length4);
        System.arraycopy((Object) bArr, 198, (Object) bArr2, length4, bArr.length - 198);
        String str7 = f35581a;
        WLogger.d(str7, "after5 destPos=" + length4);
        String str8 = f35581a;
        WLogger.d(str8, "after RESULT=" + length);
        return bArr2;
    }

    public static byte[] b(byte[] bArr, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
        mac.init(secretKeySpec);
        return mac.doFinal(bArr);
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }
}
