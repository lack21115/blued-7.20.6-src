package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ha.class */
public class ha {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23830a = 4096;

    public static int a(byte[] bArr, File file, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (bArr == null || bArr.length == 0 || file == null || file.isDirectory()) {
            return 0;
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                int length = bArr.length;
                a(fileOutputStream2);
                return length;
            } catch (IOException e) {
                a(fileOutputStream2);
                return 0;
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                a(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            fileOutputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static int a(byte[] bArr, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return a(bArr, new File(str), z);
    }

    public static final long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return -1L;
        }
        try {
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                long j2 = j;
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return j2;
                }
                outputStream.write(bArr, 0, read);
                j = j2 + read;
            }
        } catch (IOException e) {
            return -1L;
        }
    }

    public static final InputStream a(File file) {
        if (file == null) {
            return null;
        }
        try {
            if (file.exists() && file.isFile() && file.canRead()) {
                return new FileInputStream(file);
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        if (bArr == null || bArr.length == 0 || outputStream == null) {
            return;
        }
        try {
            outputStream.write(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void a(Bitmap... bitmapArr) {
        if (bitmapArr == null) {
            return;
        }
        int length = bitmapArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Bitmap bitmap = bitmapArr[i2];
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
    }

    public static boolean a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return inputStream.available() > 0;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (!file.exists()) {
                stack.pop();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length == 0) {
                        file.delete();
                        stack.pop();
                    } else {
                        int length = listFiles.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < length) {
                                File file2 = listFiles[i2];
                                if (file2.isDirectory()) {
                                    stack.push(file2.getAbsolutePath());
                                } else {
                                    file2.delete();
                                }
                                i = i2 + 1;
                            }
                        }
                    }
                }
            } else {
                file.delete();
                stack.pop();
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.renameTo(new File(str2));
        }
        return false;
    }

    public static byte[] a(InputStream inputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[i];
            do {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream2.write(bArr, 0, read);
            } while (byteArrayOutputStream2.size() < i);
            byteArrayOutputStream2.flush();
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            a(byteArrayOutputStream2);
            return byteArray;
        } catch (Throwable th2) {
            byteArrayOutputStream = byteArrayOutputStream2;
            th = th2;
            try {
                th.printStackTrace();
                a(byteArrayOutputStream);
                return null;
            } catch (Throwable th3) {
                a(byteArrayOutputStream);
                throw th3;
            }
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        byteArrayOutputStream2.flush();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        a(byteArrayOutputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th;
                try {
                    th.printStackTrace();
                    a(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    a(byteArrayOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static final InputStream c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(new File(str));
        } catch (Exception e) {
            return null;
        }
    }
}
