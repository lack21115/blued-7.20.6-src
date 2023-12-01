package com.bumptech.glide.disklrucache;

import com.anythink.expressad.exoplayer.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/Util.class */
final class Util {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f7078a = Charset.forName(b.i);
    static final Charset b = Charset.forName("UTF-8");

    private Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
            i = i2 + 1;
        }
    }
}
