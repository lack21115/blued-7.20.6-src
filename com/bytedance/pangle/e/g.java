package com.bytedance.pangle.e;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/g.class */
public final class g {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/g$a.class */
    public static final class a extends File {
        public a(File file, String str) {
            super(file, str);
        }
    }

    private static int a(String str) {
        return a().getInt(str, 0);
    }

    public static SharedPreferences a() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    public static String a(String str, int i) {
        String str2;
        int b = b(str, i);
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > b) {
                break;
            }
            if (i3 == 1) {
                str2 = "classes" + ShareConstants.DEX_SUFFIX;
            } else {
                str2 = "classes" + i3 + ShareConstants.DEX_SUFFIX;
            }
            sb.append(new a(new File(com.bytedance.pangle.d.c.i(str, i)), str2).getAbsolutePath());
            sb.append(":");
            i2 = i3 + 1;
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    public static void a(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
            i = i2 + 1;
        }
    }

    public static void a(ZipFile zipFile, ZipEntry zipEntry, a aVar, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ShareConstants.DEX_SUFFIX, aVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile));
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            if (!createTempFile.setReadOnly()) {
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + aVar.getAbsolutePath() + "\")");
            } else if (createTempFile.renameTo(aVar)) {
            } else {
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + aVar.getAbsolutePath() + "\"");
            }
        } finally {
            a(inputStream);
            createTempFile.delete();
        }
    }

    private static int b(String str, int i) {
        return a((str + "-" + i) + ".dex.number");
    }
}
