package com.tencent.cos.xml.model.tag.eventstreaming;

import com.sensetime.stmobile.STMobileHumanActionNative;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/Prelude.class */
final class Prelude {
    static final int LENGTH = 8;
    static final int LENGTH_WITH_CRC = 12;
    private final long headersLength;
    private final int totalLength;

    private Prelude(int i, long j) {
        this.totalLength = i;
        this.headersLength = j;
    }

    private static long computePreludeCrc(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[8];
        byteBuffer.duplicate().get(bArr);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, 8);
        return crc32.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Prelude decode(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        long computePreludeCrc = computePreludeCrc(duplicate);
        long intToUnsignedLong = intToUnsignedLong(duplicate.getInt());
        long intToUnsignedLong2 = intToUnsignedLong(duplicate.getInt());
        long intToUnsignedLong3 = intToUnsignedLong(duplicate.getInt());
        if (computePreludeCrc == intToUnsignedLong3) {
            if (intToUnsignedLong2 < 0 || intToUnsignedLong2 > 131072) {
                throw new IllegalArgumentException("Illegal headers_length value: " + intToUnsignedLong2);
            }
            long j = (intToUnsignedLong - intToUnsignedLong2) - 16;
            if (j < 0 || j > STMobileHumanActionNative.ST_MOBILE_DETECT_EXTRA_FACE_POINTS) {
                throw new IllegalArgumentException("Illegal payload size: " + j);
            }
            return new Prelude(toIntExact(intToUnsignedLong), intToUnsignedLong2);
        }
        throw new IllegalArgumentException(String.format("Prelude checksum failure: expected 0x%x, computed 0x%x", Long.valueOf(intToUnsignedLong3), Long.valueOf(computePreludeCrc)));
    }

    private static long intToUnsignedLong(int i) {
        return i & 4294967295L;
    }

    private static int toIntExact(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getHeadersLength() {
        return this.headersLength;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTotalLength() {
        return this.totalLength;
    }
}
