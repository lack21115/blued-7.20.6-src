package com.tencent.cloud.huiyansdkface.okio;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/Utf8.class */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i, int i2) {
        long j;
        long j2;
        long j3;
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                long j4 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        j = j4;
                        j2 = 1;
                    } else {
                        if (charAt < 2048) {
                            j3 = 2;
                        } else if (charAt < 55296 || charAt > 57343) {
                            j3 = 3;
                        } else {
                            int i3 = i + 1;
                            char charAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                            if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                j4++;
                                i = i3;
                            } else {
                                j4 += 4;
                                i += 2;
                            }
                        }
                        j = j4;
                        j2 = j3;
                    }
                    j4 = j + j2;
                    i++;
                }
                return j4;
            }
        }
        throw new IllegalArgumentException("string == null");
    }
}
