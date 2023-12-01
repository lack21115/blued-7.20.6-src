package com.ss.android.ttmd5;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/ttmd5/TTMd5.class */
public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String PROTOCOL = "ttmd5";
    private static final String TAG = "TTMd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/ttmd5/TTMd5$CHECK_MD5_STATUS.class */
    public @interface CHECK_MD5_STATUS {
        public static final int FILE_NOT_EXIST = 5;
        public static final int GET_FILE_MD5_ERROR = 6;
        public static final int MD5_EMPTY = 2;
        public static final int MD5_MATCH = 0;
        public static final int MD5_NOT_MATCH = 1;
        public static final int TTMD5_TAG_PARSER_ERROR = 4;
        public static final int TTMD5_VERSION_NOT_SUPPORT = 3;
        public static final int UNKNOWN_ERROR = 99;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/ttmd5/TTMd5$TTMd5Args.class */
    public static class TTMd5Args {
        private String realMd5;
        private int sampleCount;
        private long sampleSize;
        private int versionMain;
        private int versionSub;

        private TTMd5Args() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #1 {all -> 0x00f1, blocks: (B:6:0x000f, B:10:0x0021, B:13:0x0036, B:15:0x0040, B:19:0x0058, B:24:0x0078, B:28:0x0091, B:30:0x00a0, B:37:0x00bd), top: B:57:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String _ttmd5(com.ss.android.ttmd5.IRandomAccess r8, int r9, long r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.ttmd5.TTMd5._ttmd5(com.ss.android.ttmd5.IRandomAccess, int, long):java.lang.String");
    }

    private static String _ttmd5(File file, int i, long j) throws Exception {
        return _ttmd5(new FileRandomAccess(file), i, j);
    }

    public static int checkMd5(File file, File file2) {
        if (file == null || file2 == null) {
            return 5;
        }
        try {
            if (file.exists() && file2.exists()) {
                if (file == file2) {
                    return 0;
                }
                return _ttmd5(file, 9, 8192L).equals(_ttmd5(file2, 9, 8192L)) ? 0 : 1;
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 99;
        }
    }

    public static int checkMd5(String str, File file) {
        return checkMd5(str, file, null);
    }

    public static int checkMd5(String str, File file, IRandomAccess iRandomAccess) {
        TTMd5Args tTMd5Args;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (iRandomAccess != null) {
                if (iRandomAccess.length() <= 0) {
                    try {
                        iRandomAccess.close();
                        return 5;
                    } catch (Throwable th) {
                        return 5;
                    }
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i = -1;
            long j = -1;
            try {
                TTMd5Args parserTTMd5Args = parserTTMd5Args(str);
                if (parserTTMd5Args != null) {
                    if (parserTTMd5Args.versionMain > 1) {
                        return 3;
                    }
                    i = parserTTMd5Args.sampleCount;
                    j = parserTTMd5Args.sampleSize;
                }
                String _ttmd5 = iRandomAccess != null ? _ttmd5(iRandomAccess, i, j) : _ttmd5(file, i, j);
                if (_ttmd5 != null && _ttmd5.length() != 0) {
                    if (parserTTMd5Args != null && (parserTTMd5Args.versionMain != 1 || parserTTMd5Args.versionSub != 1)) {
                        if (parserTTMd5Args.realMd5 != null) {
                            try {
                                tTMd5Args = parserTTMd5Args(_ttmd5);
                            } catch (Throwable th2) {
                                tTMd5Args = null;
                            }
                            return (tTMd5Args != null && parserTTMd5Args.sampleCount == tTMd5Args.sampleCount && parserTTMd5Args.sampleSize == tTMd5Args.sampleSize && parserTTMd5Args.realMd5.equals(tTMd5Args.realMd5)) ? 0 : 1;
                        }
                        return 1;
                    }
                    return _ttmd5.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable th3) {
                return 4;
            }
        } catch (Throwable th4) {
            return 99;
        }
    }

    private static long decryptNum(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable th) {
            throw new RuntimeException("ttmd5 decryptNum error, num = " + str);
        }
    }

    private static String encryptionNum(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static String generateTTMd5Tag(int i, long j) {
        return "ttmd5:1:1:" + encryptionNum(i) + "g" + encryptionNum(j);
    }

    public static String md5(File file) {
        return ttmd5(file, -1, -1L);
    }

    private static TTMd5Args parserTTMd5Args(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(";");
            String[] split2 = split[0].split(":");
            TTMd5Args tTMd5Args = new TTMd5Args();
            tTMd5Args.versionMain = Integer.parseInt(split2[1]);
            if (tTMd5Args.versionMain > 1) {
                return tTMd5Args;
            }
            tTMd5Args.versionSub = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            tTMd5Args.sampleCount = (int) decryptNum(split3[0]);
            tTMd5Args.sampleSize = decryptNum(split3[1]);
            tTMd5Args.realMd5 = split[1];
            return tTMd5Args;
        }
        return null;
    }

    private static String toHexString(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & 255;
                int i5 = i2 + 1;
                char[] cArr2 = HEX_CHARS;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String ttmd5(IRandomAccess iRandomAccess) {
        return ttmd5(iRandomAccess, 9, 8192L);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i) {
        return ttmd5(iRandomAccess, i, 8192L);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i, long j) {
        if (iRandomAccess == null) {
            return "";
        }
        try {
            return _ttmd5(iRandomAccess, i, j);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String ttmd5(File file) {
        return ttmd5(file, 9, 8192L);
    }

    public static String ttmd5(File file, int i) {
        return ttmd5(file, i, 8192L);
    }

    public static String ttmd5(File file, int i, long j) {
        if (file != null) {
            try {
                return !file.exists() ? "" : _ttmd5(file, i, j);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    private static void updateSample(IRandomAccess iRandomAccess, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        iRandomAccess.seek(j, j2);
        long j3 = 0;
        while (true) {
            long j4 = j3;
            if (j4 >= j2) {
                return;
            }
            int read = iRandomAccess.read(bArr, 0, (int) Math.min(j2 - j4, bArr.length));
            if (read <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + read + ", readTotalCount = " + j4 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, read);
            j3 = j4 + read;
        }
    }
}
