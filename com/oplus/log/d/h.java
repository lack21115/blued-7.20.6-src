package com.oplus.log.d;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/h.class */
public final class h {
    public static File a(String str) {
        File file = new File(str);
        File file2 = file;
        if (!file.exists()) {
            file2 = file;
            if (!file.mkdirs()) {
                file2 = null;
            }
        }
        return file2;
    }

    public static byte[] a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
                return null;
            }
            return null;
        } catch (IOException e2) {
            if (com.oplus.log.b.a()) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static File b(String str) {
        File file = new File(str);
        File file2 = file;
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                file2 = null;
            }
        }
        return file2;
    }
}
