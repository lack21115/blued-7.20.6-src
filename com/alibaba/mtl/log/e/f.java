package com.alibaba.mtl.log.e;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/f.class */
public class f {
    public static byte[] getBytes(int i) {
        int i2 = i >> 8;
        byte b = (byte) (i2 % 256);
        int i3 = i2 >> 8;
        return new byte[]{(byte) ((i3 >> 8) % 256), (byte) (i3 % 256), b, (byte) (i % 256)};
    }
}
