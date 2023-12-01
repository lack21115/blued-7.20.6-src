package com.amap.api.col.p0003sl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.amap.api.col.3sl.bn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bn.class */
final class bn {
    RandomAccessFile a;

    public bn() throws IOException {
        this("", 0L);
    }

    public bn(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                iw.c(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.a = randomAccessFile;
        randomAccessFile.seek(j);
    }

    public final int a(byte[] bArr) throws IOException {
        int length;
        synchronized (this) {
            this.a.write(bArr);
            length = bArr.length;
        }
        return length;
    }

    public final void a() {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
    }
}
