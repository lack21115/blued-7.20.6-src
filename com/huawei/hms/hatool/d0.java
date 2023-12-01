package com.huawei.hms.hatool;

import android.nfc.cardemulation.CardEmulation;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/d0.class */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public String f9129a = b.i().getFilesDir().getPath();

    public static boolean b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    z.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean d() {
        return b(new File(b.i().getFilesDir().getPath() + "/hms"));
    }

    public String a() {
        String b;
        String b2;
        String b3;
        String b4;
        String c2 = c();
        if (b()) {
            z.c("hmsSdk", "refresh components");
            b = EncryptUtil.generateSecureRandomStr(128);
            a("aprpap", b);
            b2 = EncryptUtil.generateSecureRandomStr(128);
            a("febdoc", b2);
            b3 = EncryptUtil.generateSecureRandomStr(128);
            a("marfil", b3);
            b4 = EncryptUtil.generateSecureRandomStr(128);
            a("maywnj", b4);
            h0.b(b.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            b = b("aprpap");
            b2 = b("febdoc");
            b3 = b("marfil");
            b4 = b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(a(b, b2, b3, c2), HexUtil.hexStr2ByteArray(b4), 10000, 16));
    }

    public final String a(String str) {
        return this.f9129a + "/hms/component/".replace(CardEmulation.EXTRA_SERVICE_COMPONENT, str);
    }

    public final void a(String str, String str2) {
        File file = new File(a(str));
        String a2 = a(str);
        File file2 = new File(a2, "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            z.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            u0.a(file2, str2);
        } else {
            z.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    public final boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            z.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    public final char[] a(String str, String str2, String str3, String str4) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        int i = length;
        if (length > hexStr2ByteArray2.length) {
            i = hexStr2ByteArray2.length;
        }
        int i2 = i;
        if (i > hexStr2ByteArray3.length) {
            i2 = hexStr2ByteArray3.length;
        }
        int i3 = i2;
        if (i2 > hexStr2ByteArray4.length) {
            i3 = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[i3];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return cArr;
            }
            cArr[i5] = (char) (((hexStr2ByteArray[i5] ^ hexStr2ByteArray2[i5]) ^ hexStr2ByteArray3[i5]) ^ hexStr2ByteArray4[i5]);
            i4 = i5 + 1;
        }
    }

    public final String b(String str) {
        String a2 = a(str);
        File file = new File(a2, "hianalytics_" + str);
        if (a(file)) {
            return u0.a(file);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        u0.a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    public final boolean b() {
        long a2 = h0.a(b.i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != a2) {
            return System.currentTimeMillis() - a2 > 31536000000L;
        }
        z.c("hmsSdk", "First init components");
        return true;
    }

    public final String c() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }
}
