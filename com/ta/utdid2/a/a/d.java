package com.ta.utdid2.a.a;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/d.class */
public class d {
    public static byte[] getBytes(int i) {
        int i2 = i >> 8;
        byte b = (byte) (i2 % 256);
        int i3 = i2 >> 8;
        return new byte[]{(byte) ((i3 >> 8) % 256), (byte) (i3 % 256), b, (byte) (i % 256)};
    }
}
