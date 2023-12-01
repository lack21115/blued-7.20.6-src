package com.amap.api.col.p0003sl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.amap.api.col.3sl.bo  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bo.class */
public final class bo {

    /* renamed from: com.amap.api.col.3sl.bo$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bo$a.class */
    public interface a {
        void a();

        void a(float f);

        void b();
    }

    private static float a(long j, long j2) {
        return (((float) j) / ((float) j2)) * 100.0f;
    }

    public final long a(File file, File file2, long j, long j2, a aVar) {
        long j3;
        long j4;
        if (j == 0) {
            if (aVar != null) {
                aVar.b();
                return 0L;
            }
            return 0L;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
        try {
        } catch (Exception e) {
            e = e;
        }
        if (file.isDirectory()) {
            if (!file2.exists() && !file2.mkdirs()) {
                throw new IOException("Cannot create dir " + file2.getAbsolutePath());
            }
            String[] list = file.list();
            j3 = j;
            if (list != null) {
                int i = 0;
                while (true) {
                    j3 = j;
                    try {
                        if (i >= list.length) {
                            break;
                        }
                        long a2 = a(new File(file, list[i]), new File(new File(file2, file.getName()), list[i]), j, j2, aVar);
                        i++;
                        j = a2;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            }
            return j3;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            j4 = j;
            try {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                long j5 = j + read;
                j = j5;
                if (aVar != null) {
                    aVar.a(a(j5, j2));
                    j = j5;
                }
            } catch (Exception e3) {
                e = e3;
                j = j4;
            }
        }
        fileInputStream.close();
        long j6 = j;
        fileOutputStream.flush();
        long j7 = j;
        fileOutputStream.close();
        if (aVar != null && j >= j2 - 1) {
            j4 = j;
            aVar.a();
        }
        return j;
        e.printStackTrace();
        j3 = j;
        if (aVar != null) {
            aVar.b();
            j3 = j;
        }
        return j3;
    }
}
