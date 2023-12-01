package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/TransportFrameUtil.class */
public final class TransportFrameUtil {
    private static final Logger logger = Logger.getLogger(TransportFrameUtil.class.getName());
    private static final byte[] binaryHeaderSuffixBytes = "-bin".getBytes(Charsets.US_ASCII);

    private TransportFrameUtil() {
    }

    private static boolean endsWith(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        int i = length;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2 - length]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static boolean isSpecCompliantAscii(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            byte b = bArr[i2];
            if (b < 32 || b > 126) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static byte[][] serializeHeadersWithCommasInBin(byte[][] bArr, int i) {
        int i2;
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            arrayList.add(bArr[i4]);
            i3 = i4 + 1;
        }
        for (i2 = i; i2 < bArr.length; i2 += 2) {
            byte[] bArr2 = bArr[i2];
            byte[] bArr3 = bArr[i2 + 1];
            if (endsWith(bArr2, binaryHeaderSuffixBytes)) {
                int i5 = 0;
                for (int i6 = 0; i6 <= bArr3.length; i6++) {
                    if (i6 == bArr3.length || bArr3[i6] == 44) {
                        byte[] decode = BaseEncoding.base64().decode(new String(bArr3, i5, i6 - i5, Charsets.US_ASCII));
                        arrayList.add(bArr2);
                        arrayList.add(decode);
                        i5 = i6 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
        }
        return (byte[][]) arrayList.toArray(new byte[0]);
    }

    /* JADX WARN: Type inference failed for: r0v42, types: [byte[], byte[][]] */
    public static byte[][] toHttp2Headers(Metadata metadata) {
        byte[][] serialize = InternalMetadata.serialize(metadata);
        if (serialize == null) {
            return new byte[0];
        }
        int i = 0;
        for (int i2 = 0; i2 < serialize.length; i2 += 2) {
            byte[] bArr = serialize[i2];
            byte[] bArr2 = serialize[i2 + 1];
            if (endsWith(bArr, binaryHeaderSuffixBytes)) {
                serialize[i] = bArr;
                serialize[i + 1] = InternalMetadata.BASE64_ENCODING_OMIT_PADDING.encode(bArr2).getBytes(Charsets.US_ASCII);
            } else if (isSpecCompliantAscii(bArr2)) {
                serialize[i] = bArr;
                serialize[i + 1] = bArr2;
            } else {
                String str = new String(bArr, Charsets.US_ASCII);
                logger.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i += 2;
        }
        return i == serialize.length ? serialize : (byte[][]) Arrays.copyOfRange(serialize, 0, i);
    }

    @CheckReturnValue
    public static byte[][] toRawSerializedHeaders(byte[][] bArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return bArr;
            }
            byte[] bArr2 = bArr[i2];
            int i3 = i2 + 1;
            byte[] bArr3 = bArr[i3];
            if (endsWith(bArr2, binaryHeaderSuffixBytes)) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= bArr3.length) {
                        bArr[i3] = BaseEncoding.base64().decode(new String(bArr3, Charsets.US_ASCII));
                        break;
                    } else if (bArr3[i5] == 44) {
                        return serializeHeadersWithCommasInBin(bArr, i2);
                    } else {
                        i4 = i5 + 1;
                    }
                }
            }
            i = i2 + 2;
        }
    }
}
