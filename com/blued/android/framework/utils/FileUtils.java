package com.blued.android.framework.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/FileUtils.class */
public class FileUtils {
    private FileUtils() {
    }

    private static String a() {
        try {
            return AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean a(InputStream inputStream, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                try {
                                    bufferedOutputStream.close();
                                    bufferedInputStream.close();
                                    return true;
                                } catch (Exception e) {
                                    LogUtils.a("closeFile", e);
                                    return true;
                                }
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        LogUtils.d(e.toString());
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e3) {
                                LogUtils.a("closeFile", e3);
                                return false;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        th = th;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (Exception e4) {
                                LogUtils.a("closeFile", e4);
                                throw th;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedOutputStream = null;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    private static boolean a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        LogUtils.c("targetPath: " + str);
        if (StringUtils.b(str) || inputStream == null || !a(str, true)) {
            return false;
        }
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    a(inputStream, fileOutputStream3);
                    try {
                        fileOutputStream3.close();
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream3;
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.isFile() ? b(str) : c(str);
        }
        return false;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x01ed: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:71:0x01e9 */
    public static boolean a(String str, String str2) {
        boolean z;
        boolean z2;
        Uri uri;
        Cursor query;
        LogUtils.c("oldPath: " + str + ", newPath: " + str2);
        if (str == null || str2 == null || !a(str2, true)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        if (Build.VERSION.SDK_INT >= 29) {
            fileInputStream2 = null;
            if (!Environment.isExternalStorageLegacy()) {
                fileInputStream2 = null;
                if (!e(str)) {
                    ContentResolver contentResolver = AppInfo.d().getContentResolver();
                    if (str.toLowerCase().startsWith("content://")) {
                        try {
                            fileInputStream2 = contentResolver.openInputStream(Uri.parse(str));
                        } catch (Exception e) {
                            e.printStackTrace();
                            fileInputStream2 = null;
                        }
                    } else {
                        if (str.toLowerCase().endsWith(".jpg") || str.toLowerCase().endsWith(".jpeg") || str.toLowerCase().endsWith(".gif") || str.toLowerCase().endsWith(".webp") || str.toLowerCase().endsWith(".png")) {
                            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            query = contentResolver.query(uri, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
                        } else if (str.toLowerCase().endsWith(".mp4") || str.toLowerCase().endsWith(".m4v")) {
                            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            query = contentResolver.query(uri, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
                        } else {
                            query = null;
                            uri = null;
                        }
                        Uri withAppendedPath = (query == null || !query.moveToFirst()) ? null : Uri.withAppendedPath(uri, String.valueOf(query.getInt(query.getColumnIndex("_id"))));
                        if (query != null) {
                            query.close();
                        }
                        Uri uri2 = withAppendedPath;
                        if (withAppendedPath == null) {
                            uri2 = UriUtils.a(str);
                        }
                        try {
                            fileInputStream2 = contentResolver.openInputStream(uri2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            fileInputStream2 = null;
                        }
                    }
                }
            }
        }
        FileInputStream fileInputStream3 = fileInputStream2;
        try {
            try {
                if (fileInputStream2 == null) {
                    fileInputStream = fileInputStream2;
                    try {
                        fileInputStream3 = new FileInputStream(str);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        z2 = false;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            z2 = false;
                        }
                    }
                }
                fileInputStream = fileInputStream3;
                fileInputStream2 = fileInputStream3;
                boolean a = a(fileInputStream3, str2);
                z2 = a;
                if (fileInputStream3 != null) {
                    fileInputStream3.close();
                    return a;
                }
                return z2;
            } catch (Exception e4) {
                e4.printStackTrace();
                return z;
            }
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean a(String str, String str2, String str3) {
        return a(str, str2, str3, 0);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:10|11|(9:24|(7:31|32|33|34|35|(1:37)|104)|107|32|33|34|35|(0)|104)|108|(8:113|(2:115|116)(2:117|(2:119|120)(3:121|122|(2:124|125)))|32|33|34|35|(0)|104)|126|127|32|33|34|35|(0)|104) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a8, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a9, code lost:
        r5.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028b A[Catch: Exception -> 0x02af, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x02af, blocks: (B:107:0x027f, B:110:0x028b), top: B:124:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x027f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019e A[Catch: Exception -> 0x01a8, all -> 0x023f, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x01a8, blocks: (B:55:0x0193, B:57:0x019e), top: B:130:0x0193 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0260 A[Catch: Exception -> 0x02ab, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x02ab, blocks: (B:95:0x0255, B:98:0x0260), top: B:128:0x0255 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.FileUtils.a(java.lang.String, java.lang.String, java.lang.String, int):boolean");
    }

    public static boolean a(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            LogUtils.c("filePath is empty");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            if (!z) {
                return true;
            }
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            z2 = file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            z2 = false;
        }
        boolean z3 = false;
        if (z2) {
            z3 = false;
            if (file.exists()) {
                z3 = true;
            }
        }
        return z3;
    }

    private static String b() {
        try {
            return AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile() && file.delete()) {
            LogUtils.c("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + str + "成功！");
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        boolean z;
        boolean z2;
        String str2 = str;
        if (!str.endsWith(File.separator)) {
            str2 = str + File.separator;
        }
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            File[] fileArr = null;
            try {
                fileArr = file.listFiles();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fileArr != null && fileArr.length > 0) {
                int length = fileArr.length;
                int i = 0;
                boolean z3 = true;
                while (true) {
                    boolean z4 = z3;
                    z = z4;
                    if (i >= length) {
                        break;
                    }
                    File file2 = fileArr[i];
                    if (file2.isFile()) {
                        boolean b = b(file2.getAbsolutePath());
                        z2 = b;
                        if (!b) {
                            z = b;
                            break;
                        }
                        i++;
                        z3 = z2;
                    } else {
                        z2 = z4;
                        if (file2.isDirectory()) {
                            boolean c = c(file2.getAbsolutePath());
                            z2 = c;
                            if (!c) {
                                z = c;
                                break;
                            }
                        } else {
                            continue;
                        }
                        i++;
                        z3 = z2;
                    }
                }
            } else {
                z = true;
            }
            if (z && file.delete()) {
                LogUtils.c("--Method--", "Copy_Delete.deleteDirectory: 删除目录" + str2 + "成功！");
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean d(String str) {
        return a(str, true);
    }

    private static boolean e(String str) {
        if (str == null) {
            return false;
        }
        if (TextUtils.isEmpty(b()) || !str.startsWith(b())) {
            return !TextUtils.isEmpty(a()) && str.startsWith(a());
        }
        return true;
    }
}
