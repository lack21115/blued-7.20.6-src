package com.tencent.mapsdk.internal;

import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ng.class */
public class ng implements DiskCache.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f23980a = 128;
    private String b;

    public ng(String str) {
        this.b = str;
    }

    private int a(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & Spanned.SPAN_PRIORITY);
    }

    private long a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    private String a(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i / 128;
        int i5 = i2 / 128;
        sb.append(File.separatorChar);
        sb.append("glGrid");
        sb.append(File.separatorChar);
        sb.append(i3);
        sb.append(File.separatorChar);
        sb.append(i4 / 10);
        sb.append(File.separatorChar);
        sb.append(i5 / 10);
        sb.append(File.separatorChar);
        sb.append(i3);
        sb.append("_");
        sb.append(i4);
        sb.append("_");
        sb.append(i5);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r7, int r8, int r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ng.a(java.lang.String, int, int, byte[]):boolean");
    }

    private byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    private int[] a(String str) {
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length < 3) {
            return null;
        }
        int[] iArr = new int[3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return iArr;
            }
            try {
                iArr[i2] = Integer.parseInt(split[i2]);
                i = i2 + 1;
            } catch (NumberFormatException e) {
                na.c(Log.getStackTraceString(e));
                return null;
            }
        }
    }

    private void b(byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            return;
        }
        byte b = bArr[0];
        bArr[0] = bArr[3];
        bArr[3] = b;
        byte b2 = bArr[1];
        bArr[1] = bArr[2];
        bArr[2] = b2;
    }

    @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.b
    public File a(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        String str3 = str;
        String str4 = str2;
        if (lastIndexOf > -1) {
            String substring = str.substring(0, lastIndexOf);
            str4 = str2;
            if (!TextUtils.isEmpty(substring)) {
                str4 = str2 + File.separator + substring;
            }
            str3 = str.substring(lastIndexOf + 1);
        }
        int[] a2 = a(str3);
        if (a2 == null) {
            return new File(str4, str3);
        }
        String str5 = str4 + a(a2[0], a2[1], a2[2]);
        if (a(str5, a2[0], a2[1], bArr)) {
            return new File(str5 + ".dat");
        }
        return new File(str4, str3);
    }

    public byte[] a(String str, int i, int i2) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        String[] strArr = {str + ".idx", str + ".dat"};
        File file = new File(strArr[0]);
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        long a2 = a(i, i2);
        if (a2 < 0) {
            return null;
        }
        byte[] bArr = new byte[4];
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.seek(a2 * 4);
                randomAccessFile.read(bArr, 0, 4);
                ha.a(randomAccessFile);
                b(bArr);
                int a3 = a(bArr);
                if (a3 < 0) {
                    return null;
                }
                File file2 = new File(strArr[1]);
                if (file2.exists()) {
                    try {
                        randomAccessFile2 = new RandomAccessFile(file2, "r");
                    } catch (Exception e) {
                        randomAccessFile2 = null;
                    }
                    try {
                        randomAccessFile2.seek(a3);
                        randomAccessFile2.read(bArr, 0, 4);
                        b(bArr);
                        int a4 = a(bArr);
                        if (a4 <= 0) {
                            ha.a(randomAccessFile2);
                            return null;
                        }
                        try {
                            byte[] bArr2 = new byte[a4];
                            randomAccessFile2.read(bArr2, 0, a4);
                            return bArr2;
                        } catch (Throwable th) {
                            try {
                                na.b("读取瓦片缓存的大小异常", th);
                                ha.a(randomAccessFile2);
                                return null;
                            } finally {
                                ha.a(randomAccessFile2);
                            }
                        }
                    } catch (Exception e2) {
                        ha.a(randomAccessFile2);
                        return null;
                    }
                }
                return null;
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile;
                return null;
            } catch (Throwable th2) {
                th = th2;
                ha.a(randomAccessFile);
                throw th;
            }
        } catch (Exception e4) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.b
    public byte[] a(String str, File file) {
        String str2 = this.b;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        String str3 = str;
        String str4 = str2;
        if (lastIndexOf > -1) {
            String substring = str.substring(0, lastIndexOf);
            str4 = str2;
            if (!TextUtils.isEmpty(substring)) {
                str4 = str2 + File.separator + substring;
            }
            str3 = str.substring(lastIndexOf + 1);
        }
        int[] a2 = a(str3);
        if (a2 == null) {
            return null;
        }
        return a(str4 + a(a2[0], a2[1], a2[2]), a2[0], a2[1]);
    }

    @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.b
    public boolean b(String str, File file) {
        return ga.d(new File(this.b));
    }
}
