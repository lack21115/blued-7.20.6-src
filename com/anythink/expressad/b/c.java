package com.anythink.expressad.b;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7120a = "UnzipUtility";
    private static final int b = 4096;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v48, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v80, types: [java.io.InputStream] */
    public static int a(String str, String str2) {
        FileOutputStream fileOutputStream;
        String str3;
        if (str == null || str2 == null) {
            return -1;
        }
        String str4 = str2;
        if (!str2.endsWith(BridgeUtil.SPLIT_MARK)) {
            str4 = str2 + BridgeUtil.SPLIT_MARK;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        InputStream inputStream = null;
        File file2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                fileOutputStream = null;
                inputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    o.d(f7120a, e.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return 2;
                                } catch (IOException e2) {
                                    o.d(f7120a, e2.getMessage());
                                    return 2;
                                }
                            }
                            return 2;
                        }
                        String name = nextElement.getName();
                        FileOutputStream fileOutputStream4 = fileOutputStream;
                        if (!TextUtils.isEmpty(name)) {
                            FileOutputStream fileOutputStream5 = fileOutputStream;
                            if (!name.startsWith("..")) {
                                FileOutputStream fileOutputStream6 = fileOutputStream;
                                if (!name.startsWith("../")) {
                                    StringBuilder sb = new StringBuilder();
                                    FileOutputStream fileOutputStream7 = fileOutputStream;
                                    sb.append(str4);
                                    FileOutputStream fileOutputStream8 = fileOutputStream;
                                    sb.append(name);
                                    FileOutputStream fileOutputStream9 = fileOutputStream;
                                    File file3 = new File(sb.toString());
                                    FileOutputStream fileOutputStream10 = fileOutputStream;
                                    try {
                                        str3 = file3.getCanonicalPath();
                                    } catch (IOException e3) {
                                        str3 = "";
                                    }
                                    if (!TextUtils.isEmpty(str3)) {
                                        FileOutputStream fileOutputStream11 = fileOutputStream;
                                        if (!str3.startsWith("..")) {
                                            FileOutputStream fileOutputStream12 = fileOutputStream;
                                            if (!str3.startsWith("../")) {
                                                FileOutputStream fileOutputStream13 = fileOutputStream;
                                                if (str3.startsWith(str4)) {
                                                    FileOutputStream fileOutputStream14 = fileOutputStream;
                                                    if (nextElement.isDirectory()) {
                                                        FileOutputStream fileOutputStream15 = fileOutputStream;
                                                        file3.mkdirs();
                                                    } else {
                                                        if (!file3.getParentFile().exists()) {
                                                            FileOutputStream fileOutputStream16 = fileOutputStream;
                                                            file3.getParentFile().mkdirs();
                                                        }
                                                        FileOutputStream fileOutputStream17 = fileOutputStream;
                                                        FileOutputStream fileOutputStream18 = new FileOutputStream(file3);
                                                        file2 = inputStream;
                                                        try {
                                                            InputStream inputStream2 = zipFile.getInputStream(nextElement);
                                                            byte[] bArr = new byte[1024];
                                                            while (true) {
                                                                int read = inputStream2.read(bArr, 0, 1024);
                                                                if (read == -1) {
                                                                    break;
                                                                }
                                                                fileOutputStream18.write(bArr, 0, read);
                                                                fileOutputStream18.flush();
                                                            }
                                                            fileOutputStream = fileOutputStream18;
                                                            inputStream = inputStream2;
                                                        } catch (IOException e4) {
                                                            fileOutputStream = fileOutputStream18;
                                                            e = e4;
                                                            o.d(f7120a, e.getMessage());
                                                            if (inputStream != null) {
                                                                try {
                                                                    inputStream.close();
                                                                } catch (IOException e5) {
                                                                    o.d(f7120a, e5.getMessage());
                                                                }
                                                            }
                                                            if (fileOutputStream != null) {
                                                                try {
                                                                    fileOutputStream.close();
                                                                    return 3;
                                                                } catch (IOException e6) {
                                                                    o.d(f7120a, e6.getMessage());
                                                                    return 3;
                                                                }
                                                            }
                                                            return 3;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            fileOutputStream2 = fileOutputStream18;
                                                            if (file2 != null) {
                                                                try {
                                                                    file2.close();
                                                                } catch (IOException e7) {
                                                                    o.d(f7120a, e7.getMessage());
                                                                }
                                                            }
                                                            if (fileOutputStream2 != null) {
                                                                try {
                                                                    fileOutputStream2.close();
                                                                } catch (IOException e8) {
                                                                    o.d(f7120a, e8.getMessage());
                                                                }
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e9) {
                                            o.d(f7120a, e9.getMessage());
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return 2;
                                        } catch (IOException e10) {
                                            o.d(f7120a, e10.getMessage());
                                            return 2;
                                        }
                                    }
                                    return 2;
                                }
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e11) {
                                o.d(f7120a, e11.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return 2;
                            } catch (IOException e12) {
                                o.d(f7120a, e12.getMessage());
                                return 2;
                            }
                        }
                        return 2;
                    } catch (IOException e13) {
                        e = e13;
                    }
                }
                zipFile.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e14) {
                        o.d(f7120a, e14.getMessage());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return 0;
                    } catch (IOException e15) {
                        o.d(f7120a, e15.getMessage());
                        return 0;
                    }
                }
                return 0;
            } catch (IOException e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            file2 = file;
        }
    }

    private static void a(ZipInputStream zipInputStream, String str) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            bufferedOutputStream2.close();
                            return;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedOutputStream = null;
        }
    }
}
