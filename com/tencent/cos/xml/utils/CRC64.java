package com.tencent.cos.xml.utils;

import java.util.zip.Checksum;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/CRC64.class */
public class CRC64 implements Checksum {
    private static final int GF2_DIM = 64;
    private static final long POLY = -3932672073523589310L;
    private static final long[] table = new long[256];
    private long value;

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                return;
            }
            long j = i2;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < 8) {
                    j = (j & 1) == 1 ? (j >>> 1) ^ POLY : j >>> 1;
                    i3 = i4 + 1;
                }
            }
            table[i2] = j;
            i = i2 + 1;
        }
    }

    public CRC64() {
        this.value = 0L;
    }

    public CRC64(long j) {
        this.value = j;
    }

    public CRC64(byte[] bArr, int i) {
        this.value = 0L;
        update(bArr, i);
    }

    public static long combine(long j, long j2, long j3) {
        long j4;
        if (j3 == 0) {
            return j;
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j5 = 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 64) {
                break;
            }
            jArr2[i2] = j5;
            j5 <<= 1;
            i = i2 + 1;
        }
        gf2MatrixSquare(jArr, jArr2);
        gf2MatrixSquare(jArr2, jArr);
        long j6 = j3;
        long j7 = j;
        while (true) {
            gf2MatrixSquare(jArr, jArr2);
            long j8 = j7;
            if ((j6 & 1) == 1) {
                j8 = gf2MatrixTimes(jArr, j7);
            }
            long j9 = j6 >>> 1;
            if (j9 != 0) {
                gf2MatrixSquare(jArr2, jArr);
                j4 = j8;
                if ((j9 & 1) == 1) {
                    j4 = gf2MatrixTimes(jArr2, j8);
                }
                long j10 = j9 >>> 1;
                j7 = j4;
                j6 = j10;
                if (j10 == 0) {
                    break;
                }
            } else {
                j4 = j8;
                break;
            }
        }
        return j4 ^ j2;
    }

    public static CRC64 combine(CRC64 crc64, CRC64 crc642, long j) {
        long j2;
        if (j == 0) {
            return new CRC64(crc64.getValue());
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j3 = 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 64) {
                break;
            }
            jArr2[i2] = j3;
            j3 <<= 1;
            i = i2 + 1;
        }
        gf2MatrixSquare(jArr, jArr2);
        gf2MatrixSquare(jArr2, jArr);
        long value = crc64.getValue();
        long value2 = crc642.getValue();
        long j4 = j;
        while (true) {
            gf2MatrixSquare(jArr, jArr2);
            long j5 = value;
            if ((j4 & 1) == 1) {
                j5 = gf2MatrixTimes(jArr, value);
            }
            long j6 = j4 >>> 1;
            if (j6 != 0) {
                gf2MatrixSquare(jArr2, jArr);
                j2 = j5;
                if ((j6 & 1) == 1) {
                    j2 = gf2MatrixTimes(jArr2, j5);
                }
                long j7 = j6 >>> 1;
                value = j2;
                j4 = j7;
                if (j7 == 0) {
                    break;
                }
            } else {
                j2 = j5;
                break;
            }
        }
        return new CRC64(value2 ^ j2);
    }

    public static CRC64 fromBytes(byte[] bArr) {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return new CRC64(j);
            }
            j = (j << 8) ^ (bArr[i2] & 255);
            i = i2 + 1;
        }
    }

    private static void gf2MatrixSquare(long[] jArr, long[] jArr2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 64) {
                return;
            }
            jArr[i2] = gf2MatrixTimes(jArr2, jArr2[i2]);
            i = i2 + 1;
        }
    }

    private static long gf2MatrixTimes(long[] jArr, long j) {
        int i = 0;
        long j2 = 0;
        while (true) {
            long j3 = j2;
            if (j == 0) {
                return j3;
            }
            long j4 = j3;
            if ((j & 1) == 1) {
                j4 = j3 ^ jArr[i];
            }
            j >>>= 1;
            i++;
            j2 = j4;
        }
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[8];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return bArr;
            }
            bArr[7 - i2] = (byte) (this.value >>> (i2 * 8));
            i = i2 + 1;
        }
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.value;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.value = 0L;
    }

    public void update(byte b) {
        long j = this.value;
        this.value = j;
        long j2 = (j >>> 8) ^ table[((int) (b ^ j)) & 255];
        this.value = j2;
        this.value = j2;
    }

    @Override // java.util.zip.Checksum
    public void update(int i) {
        update((byte) (i & 255));
    }

    public void update(byte[] bArr, int i) {
        this.value = this.value;
        int i2 = 0;
        while (i > 0) {
            long[] jArr = table;
            long j = this.value;
            this.value = (j >>> 8) ^ jArr[((int) (bArr[i2] ^ j)) & 255];
            i2++;
            i--;
        }
        this.value = this.value;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            update(bArr[i]);
            i2--;
            i++;
        }
    }
}
