package com.blued.android.framework.utils;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.provider.ProviderHolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/FileCache.class */
public class FileCache {
    String a;
    String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/FileCache$SingletonCreator.class */
    public static class SingletonCreator {
        private static final FileCache a = new FileCache();

        private SingletonCreator() {
        }
    }

    private FileCache() {
        this.a = null;
        this.b = null;
        c();
    }

    public static String a(String str) {
        String a = ProviderHolder.a().b().a();
        FileCache b = b();
        return b.b(a + str);
    }

    public static void a(String str, String str2) {
        String a = ProviderHolder.a().b().a();
        FileCache b = b();
        b.b(a + str, str2);
    }

    public static boolean a() {
        return b().a(b().d());
    }

    private static FileCache b() {
        return SingletonCreator.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.FileInputStream] */
    private String b(String str) {
        File file;
        Throwable th;
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File d = d();
        if (d == null) {
            Log.e("FileCache", "缓存路径获取失败");
            return null;
        }
        File file2 = new File(d, Md5.a(str));
        try {
            try {
                try {
                    if (file2.exists()) {
                        fileInputStream = new FileInputStream(file2);
                        try {
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            String str2 = new String(bArr, "UTF-8");
                            try {
                                fileInputStream.close();
                                return str2;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return str2;
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return null;
                            }
                            return null;
                        } catch (UnsupportedEncodingException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return null;
                            }
                            return null;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return null;
                            }
                            return null;
                        }
                    }
                    return null;
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileInputStream = null;
                } catch (UnsupportedEncodingException e6) {
                    e = e6;
                    fileInputStream = null;
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    file = null;
                    if (file != null) {
                        try {
                            file.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                return null;
            }
        } catch (Throwable th3) {
            file = file2;
            th = th3;
        }
    }

    private boolean b(String str, String str2) {
        FileWriter fileWriter;
        if (TextUtils.isEmpty(str) || str2 == null) {
            return false;
        }
        File d = d();
        if (d == null) {
            Log.e("FileCache", "缓存路径获取失败");
            return false;
        }
        File file = new File(d, Md5.a(str));
        FileWriter fileWriter2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter3 = new FileWriter(file);
                try {
                    fileWriter3.write(str2);
                    fileWriter3.flush();
                    try {
                        fileWriter3.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (IOException e2) {
                    fileWriter = fileWriter3;
                    e = e2;
                    fileWriter2 = fileWriter;
                    e.printStackTrace();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                            return false;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileWriter2 = fileWriter3;
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            fileWriter = null;
        }
    }

    private void c() {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "filecache");
            if (file.exists() || file.mkdirs()) {
                this.a = file.getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file2 = new File(filesDir, "filecache");
            if (file2.exists() || file2.mkdirs()) {
                if (TextUtils.isEmpty(this.a)) {
                    this.a = file2.getAbsolutePath();
                } else {
                    this.b = file2.getAbsolutePath();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        if (r0.canWrite() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r0.canWrite() == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File d() {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lc
            r0 = 0
            return r0
        Lc:
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            java.lang.String r2 = r2.a
            r1.<init>(r2)
            r6 = r0
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 == 0) goto L2d
            r0 = r6
            r5 = r0
            r0 = r6
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L2b
            goto L2d
        L2b:
            r0 = r5
            return r0
        L2d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "主缓存路径获取失败, cachePath:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.a
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "FileCache"
            r1 = r5
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.e(r0, r1)
            r0 = r4
            java.lang.String r0 = r0.b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L97
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            java.lang.String r2 = r2.a
            r1.<init>(r2)
            r6 = r0
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 == 0) goto L75
            r0 = r6
            r5 = r0
            r0 = r6
            boolean r0 = r0.canWrite()
            if (r0 != 0) goto L2b
        L75:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "从缓存路径获取失败, otherCachePath:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.b
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "FileCache"
            r1 = r5
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.e(r0, r1)
        L97:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.FileCache.d():java.io.File");
    }

    public boolean a(File file) {
        File[] listFiles;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                file.delete();
                return true;
            } else if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return true;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listFiles.length) {
                        return true;
                    }
                    a(listFiles[i2]);
                    i = i2 + 1;
                }
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return false;
        }
    }
}
