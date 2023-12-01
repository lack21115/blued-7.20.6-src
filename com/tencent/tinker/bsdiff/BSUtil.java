package com.tencent.tinker.bsdiff;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/bsdiff/BSUtil.class */
public class BSUtil {
    public static final int BUFFER_SIZE = 8192;
    public static final int HEADER_SIZE = 32;

    public static byte[] inputStreamToByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static final boolean readFromStream(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return true;
            }
            int read = inputStream.read(bArr, i + i4, i2 - i4);
            if (read < 0) {
                return false;
            }
            i3 = i4 + read;
        }
    }
}
