package com.cdo.oaps.ad;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/i.class */
public class i {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return a(f.d(new c().b(b(str), h.a(h.a("7U727ALEWH8".getBytes())))));
    }

    private static String a(byte[] bArr) {
        return bArr == null ? "" : a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static byte[] b(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeUTF(str);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                    int length = byteArray.length - 2;
                    byte[] bArr = new byte[length];
                    System.arraycopy(byteArray, 2, bArr, 0, length);
                    return bArr;
                } catch (IOException e2) {
                }
            }
        }
        return new byte[0];
    }
}
