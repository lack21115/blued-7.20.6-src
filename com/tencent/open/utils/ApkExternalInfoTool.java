package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ApkExternalInfoTool.class */
public final class ApkExternalInfoTool {
    public static final String CHANNELID = "channelNo";

    /* renamed from: a  reason: collision with root package name */
    private static final ZipLong f38268a = new ZipLong(101010256);
    private static final ZipShort b = new ZipShort(38651);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ApkExternalInfoTool$ApkExternalInfo.class */
    public static class ApkExternalInfo {

        /* renamed from: a  reason: collision with root package name */
        Properties f38269a;
        byte[] b;

        private ApkExternalInfo() {
            this.f38269a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = ApkExternalInfoTool.b.getBytes().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!ApkExternalInfoTool.b.equals(new ZipShort(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            } else if (bArr.length - length <= 2) {
            } else {
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int value = new ZipShort(bArr3).getValue();
                if ((bArr.length - length) - 2 < value) {
                    return;
                }
                byte[] bArr4 = new byte[value];
                wrap.get(bArr4);
                this.f38269a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - value) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.b = bArr5;
                    wrap.get(bArr5);
                }
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f38269a + ", otherData=" + Arrays.toString(this.b) + "]";
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = f38268a.getBytes();
        int read = randomAccessFile.read();
        while (true) {
            int i = read;
            if (i == -1) {
                z = false;
                break;
            } else if (i == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                z = true;
                break;
            } else {
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            }
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int value = new ZipShort(bArr).getValue();
            if (value == 0) {
                return null;
            }
            byte[] bArr2 = new byte[value];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }

    public static String read(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            byte[] a2 = a(randomAccessFile);
            if (a2 == null) {
                randomAccessFile.close();
                return null;
            }
            ApkExternalInfo apkExternalInfo = new ApkExternalInfo();
            apkExternalInfo.a(a2);
            String property = apkExternalInfo.f38269a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String readChannelId(File file) throws IOException {
        return read(file, CHANNELID);
    }
}
