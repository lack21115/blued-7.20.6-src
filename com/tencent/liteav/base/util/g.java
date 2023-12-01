package com.tencent.liteav.base.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/g.class */
public final class g {
    public static long a(File file, int i) {
        long length;
        long j = 0;
        if (i <= 0) {
            return 0L;
        }
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            int length2 = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                j2 = j;
                if (i3 >= length2) {
                    break;
                }
                File file2 = listFiles[i3];
                j2 = j;
                if (file2.isDirectory()) {
                    long j3 = j;
                    length = a(file2, i - 1);
                } else {
                    length = file2.length();
                }
                j += length;
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            LiteavLog.i(com.huawei.openalliance.ad.utils.p.Code, "getFolderSize exception " + e.toString());
        }
        return j2;
    }

    public static File a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        File file = new File(absolutePath + File.separator + str);
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
                return file;
            }
        } catch (Exception e) {
            LiteavLog.e(com.huawei.openalliance.ad.utils.p.Code, "mkdirs failed.", e);
        }
        return file;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }
}
