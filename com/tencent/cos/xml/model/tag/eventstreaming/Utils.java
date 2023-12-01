package com.tencent.cos.xml.model.tag.eventstreaming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/Utils.class */
final class Utils {
    private static final String UTF8 = "UTF-8";

    private Utils() {
    }

    private static void checkByteArrayBounds(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Byte arrays may not be empty");
        }
        if (i <= 32767) {
            return;
        }
        throw new IllegalArgumentException("Illegal byte array length: " + i);
    }

    private static void checkStringBounds(int i, int i2) {
        if (i == 0) {
            throw new IllegalArgumentException("Strings may not be empty");
        }
        if (i <= i2) {
            return;
        }
        throw new IllegalArgumentException("Illegal string length: " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] readBytes(ByteBuffer byteBuffer) {
        int i = byteBuffer.getShort() & 65535;
        checkByteArrayBounds(i);
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readShortString(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        int i = byteBuffer.get() & 255;
        checkStringBounds(i, 255);
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new String(bArr, "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readString(ByteBuffer byteBuffer) throws UnsupportedEncodingException {
        int i = byteBuffer.getShort() & 65535;
        checkStringBounds(i, 32767);
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new String(bArr, "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toIntExact(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long toUnsignedLong(int i) {
        return i & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeBytes(DataOutputStream dataOutputStream, byte[] bArr) throws IOException {
        checkByteArrayBounds(bArr.length);
        dataOutputStream.writeShort((short) bArr.length);
        dataOutputStream.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeShortString(DataOutputStream dataOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        checkStringBounds(bytes.length, 255);
        dataOutputStream.writeByte(bytes.length);
        dataOutputStream.write(bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeString(DataOutputStream dataOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        checkStringBounds(bytes.length, 32767);
        writeBytes(dataOutputStream, bytes);
    }
}
