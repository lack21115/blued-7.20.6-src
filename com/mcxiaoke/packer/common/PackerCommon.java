package com.mcxiaoke.packer.common;

import com.mcxiaoke.packer.support.walle.Support;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/common/PackerCommon.class */
public class PackerCommon {
    public static String a(File file) throws IOException {
        return a(file, "CHANNEL", 2054712097);
    }

    static String a(File file, String str, int i) throws IOException {
        Map<String, String> a2 = a(file, i);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a2.get(str);
    }

    public static Map<String, String> a(File file, int i) throws IOException {
        return a(b(file, i));
    }

    public static Map<String, String> a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("∙");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String[] split2 = split[i2].split("∘");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
            i = i2 + 1;
        }
    }

    public static String b(File file, int i) throws IOException {
        byte[] c2 = c(file, i);
        if (c2 == null || c2.length == 0) {
            return null;
        }
        return new String(c2, "UTF-8");
    }

    public static byte[] c(File file, int i) throws IOException {
        return d(file, i);
    }

    static byte[] d(File file, int i) throws IOException {
        int i2;
        ByteBuffer a2 = Support.a(file, i);
        if (a2 == null) {
            return null;
        }
        byte[] bytes = "Packer Ng Sig V2".getBytes("UTF-8");
        byte[] bArr = new byte[bytes.length];
        a2.get(bArr);
        if (!Arrays.equals(bytes, bArr) || (i2 = a2.getInt()) <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i2];
        a2.get(bArr2);
        if (a2.getInt() == i2) {
            return bArr2;
        }
        return null;
    }
}
