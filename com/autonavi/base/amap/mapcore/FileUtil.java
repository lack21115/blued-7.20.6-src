package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.amap.api.col.3sl.dw;
import com.amap.api.col.3sl.dx;
import com.amap.api.col.3sl.dy;
import com.amap.api.col.3sl.iw;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/FileUtil.class */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/FileUtil$UnZipFileBrake.class */
    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/FileUtil$ZipCompressProgressListener.class */
    public interface ZipCompressProgressListener {
        void onFinishProgress(long j);
    }

    public static boolean checkCanWrite(File file) {
        if (file != null && file.canWrite()) {
            File file2 = new File(file, "amap.tmp");
            try {
                file2.createNewFile();
                if (file2.exists()) {
                    try {
                        file2.delete();
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static byte[] compress(String str, String str2) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream3.write(str.getBytes(str2));
                    gZIPOutputStream3.close();
                    safelyCloseFile(gZIPOutputStream3);
                } catch (IOException e) {
                    e = e;
                    gZIPOutputStream = gZIPOutputStream3;
                    gZIPOutputStream2 = gZIPOutputStream;
                    Log.e("gzip compress error.", e.getMessage());
                    safelyCloseFile(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream2 = gZIPOutputStream3;
                    safelyCloseFile(gZIPOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            gZIPOutputStream = null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream3.write(bArr);
                    gZIPOutputStream3.close();
                    safelyCloseFile(gZIPOutputStream3);
                } catch (IOException e) {
                    gZIPOutputStream = gZIPOutputStream3;
                    e = e;
                    gZIPOutputStream2 = gZIPOutputStream;
                    Log.e("gzip compress error.", e.getMessage());
                    safelyCloseFile(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream2 = gZIPOutputStream3;
                    safelyCloseFile(gZIPOutputStream2);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = null;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a3, code lost:
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        if (r18 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
        if (r10 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        r10.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decompress(java.io.File r10, java.io.File r11, java.util.zip.ZipInputStream r12, long r13, com.autonavi.base.amap.mapcore.FileUtil.ZipCompressProgressListener r15, com.autonavi.base.amap.mapcore.FileUtil.UnZipFileBrake r16) throws java.lang.Exception {
        /*
            r0 = 0
            r19 = r0
            r0 = 0
            r17 = r0
        L6:
            r0 = r12
            java.util.zip.ZipEntry r0 = r0.getNextEntry()
            r20 = r0
            r0 = r19
            r18 = r0
            r0 = r20
            if (r0 == 0) goto La6
            r0 = r16
            if (r0 == 0) goto L27
            r0 = r16
            boolean r0 = r0.mIsAborted
            if (r0 == 0) goto L27
            r0 = r12
            r0.closeEntry()
            return
        L27:
            r0 = r20
            java.lang.String r0 = r0.getName()
            r21 = r0
            r0 = r21
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La3
            r0 = r21
            boolean r0 = isSafeEntryName(r0)
            if (r0 != 0) goto L41
            goto La3
        L41:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r22 = r0
            r0 = r22
            r1 = r11
            java.lang.String r1 = r1.getPath()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r22
            java.lang.String r1 = java.io.File.separator
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r22
            r1 = r21
            java.lang.StringBuilder r0 = r0.append(r1)
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r22
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r21 = r0
            r0 = r21
            fileProber(r0)
            r0 = r20
            boolean r0 = r0.isDirectory()
            if (r0 == 0) goto L89
            r0 = r21
            boolean r0 = r0.mkdirs()
            goto L9c
        L89:
            r0 = r17
            r1 = r21
            r2 = r12
            r3 = r17
            long r3 = (long) r3
            r4 = r13
            r5 = r15
            r6 = r16
            int r1 = decompressFile(r1, r2, r3, r4, r5, r6)
            int r0 = r0 + r1
            r17 = r0
        L9c:
            r0 = r12
            r0.closeEntry()
            goto L6
        La3:
            r0 = 1
            r18 = r0
        La6:
            r0 = r18
            if (r0 == 0) goto Lb4
            r0 = r10
            if (r0 == 0) goto Lb4
            r0 = r10
            boolean r0 = r0.delete()     // Catch: java.lang.Exception -> Lb5
        Lb4:
            return
        Lb5:
            r10 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.FileUtil.decompress(java.io.File, java.io.File, java.util.zip.ZipInputStream, long, com.autonavi.base.amap.mapcore.FileUtil$ZipCompressProgressListener, com.autonavi.base.amap.mapcore.FileUtil$UnZipFileBrake):void");
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0L, null);
    }

    private static void decompress(InputStream inputStream, String str, long j, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j, long j2, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                bufferedOutputStream.close();
                return i;
            } else {
                bufferedOutputStream.write(bArr, 0, read);
                int i2 = i + read;
                i = i2;
                if (j2 > 0) {
                    i = i2;
                    if (zipCompressProgressListener != null) {
                        long j3 = ((i2 + j) * 100) / j2;
                        if (unZipFileBrake != null) {
                            i = i2;
                            if (!unZipFileBrake.mIsAborted) {
                            }
                        }
                        zipCompressProgressListener.onFinishProgress(j3);
                        i = i2;
                    }
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= listFiles.length) {
                    break;
                }
                if (listFiles[i2].isFile()) {
                    if (!listFiles[i2].delete()) {
                        return false;
                    }
                } else if (!deleteFile(listFiles[i2])) {
                    return false;
                } else {
                    listFiles[i2].delete();
                }
                i = i2 + 1;
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        fileProber(parentFile);
        parentFile.mkdir();
    }

    public static String getExternalStroragePath(Context context) {
        if (context != null) {
            return context.getExternalFilesDir("").getAbsolutePath() + File.separatorChar;
        }
        return null;
    }

    public static String getMapBaseStorage(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        String str2 = Build.VERSION.SDK_INT > 18 ? "map_base_path_v44" : "map_base_path";
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.trim().length() <= 0) {
            String string = sharedPreferences.getString(str2, "");
            String externalStroragePath = getExternalStroragePath(context);
            if (string == null || string.contains(externalStroragePath)) {
                str = string;
            }
        } else {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str3 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        String str4 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str2, str4);
                edit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        String str5 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file4 = new File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            if (file4.isDirectory()) {
            }
        }
        return str5;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return isGzip(bArr) ? new GZIPInputStream(byteArrayInputStream) : new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains(FILE_PATH_ENTRY_SEPARATOR1) || str.contains(FILE_PATH_ENTRY_SEPARATOR2)) ? false : true;
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        safelyCloseFile(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    throw e;
                }
            } catch (Throwable th) {
                safelyCloseFile(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static byte[] readFileContents(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                safelyCloseFile((OutputStream) null);
                safelyCloseFile((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            iw.c(th, "FileUtil", "readFileContents");
                            dw.a(th);
                            dy.b(dx.f, "read file from disk failed " + th.getMessage());
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                            return null;
                        } catch (Throwable th2) {
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] readFileContentsFromAssets(Context context, String str) {
        InputStream inputStream;
        try {
            try {
                inputStream = context.getAssets().open(str);
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (OutOfMemoryError e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                safelyCloseFile((InputStream) null);
                throw th;
            }
            try {
                int available = inputStream.available();
                if (available == 0) {
                    safelyCloseFile(inputStream);
                    return null;
                }
                byte[] bArr = new byte[available];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= available) {
                        safelyCloseFile(inputStream);
                        return bArr;
                    }
                    i = i2 + inputStream.read(bArr, i2, available - i2);
                }
            } catch (IOException e3) {
                e = e3;
                String str2 = dx.f;
                InputStream inputStream2 = inputStream;
                StringBuilder sb = new StringBuilder("read file from assets failed ");
                InputStream inputStream3 = inputStream;
                sb.append(e.getMessage());
                InputStream inputStream4 = inputStream;
                dy.b(str2, sb.toString());
                safelyCloseFile(inputStream);
                return null;
            } catch (OutOfMemoryError e4) {
                e = e4;
                String str3 = dx.f;
                InputStream inputStream5 = inputStream;
                StringBuilder sb2 = new StringBuilder("read file from assets failed ");
                InputStream inputStream6 = inputStream;
                sb2.append(e.getMessage());
                InputStream inputStream7 = inputStream;
                dy.b(str3, sb2.toString());
                safelyCloseFile(inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            safelyCloseFile((InputStream) null);
            throw th;
        }
    }

    public static byte[] readFileContentsFromAssetsByPreName(Context context, String str, String str2) {
        if (context == null || str == null || str2 == null) {
            return null;
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list == null) {
                return null;
            }
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                String str3 = list[i2];
                if (str3 != null && str3.contains(str2)) {
                    return readFileContentsFromAssets(context, str + "/" + str3);
                }
                i = i2 + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable th) {
            }
        }
    }

    private static void safelyCloseFile(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void saveFileContents(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                fileOutputStream.write(bArr);
                safelyCloseFile(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    iw.c(th, "FileUtil", "saveFileContents");
                    dw.a(th);
                    dy.b(dx.f, "save file from disk failed " + th.getMessage());
                    safelyCloseFile(fileOutputStream);
                } catch (Throwable th2) {
                    safelyCloseFile(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            inputStream2 = inputStream;
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read < 0) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            safelyCloseFile(inputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.e("gzip compress error.", th.getMessage());
                        inputStream2 = inputStream;
                        safelyCloseFile(inputStream2);
                        return null;
                    } catch (Throwable th2) {
                        safelyCloseFile(inputStream);
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        safelyCloseFile(inputStream2);
        return null;
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2;
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (inputStream instanceof ZipInputStream) {
                String name = ((ZipInputStream) inputStream).getNextEntry().getName();
                str = name;
                if (!isSafeEntryName(name)) {
                    Log.e("gzip compress error.", "gzip name contains ../ ".concat(String.valueOf(name)));
                    safelyCloseFile(inputStream);
                    return null;
                }
            } else {
                str = "";
            }
            inputStream2 = inputStream;
            if (inputStream != null) {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = inputStream.read(bArr2);
                    if (read < 0) {
                        Pair<String, byte[]> pair = new Pair<>(str, byteArrayOutputStream.toByteArray());
                        safelyCloseFile(inputStream);
                        return pair;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                Log.e("gzip compress error.", th.getMessage());
                inputStream2 = inputStream;
                safelyCloseFile(inputStream2);
                return null;
            } catch (Throwable th3) {
                safelyCloseFile(inputStream);
                throw th3;
            }
        }
        safelyCloseFile(inputStream2);
        return null;
    }

    public static byte[] uncompressToByteArray(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                dw.a(th);
                th.printStackTrace();
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
                return null;
            } catch (Throwable th3) {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
                throw th3;
            }
        }
    }

    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] bArr, String[] strArr) {
        InputStream inputStream;
        HashMap hashMap = new HashMap();
        if (bArr != null && bArr.length != 0) {
            try {
                inputStream = getZipInputStream(bArr);
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                if (inputStream instanceof ZipInputStream) {
                    ZipInputStream zipInputStream = (ZipInputStream) inputStream;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            try {
                                String name = nextEntry.getName();
                                if (!isSafeEntryName(name)) {
                                    Log.e("gzip compress error.", "gzip name contains ../ ".concat(String.valueOf(name)));
                                    safelyCloseFile(inputStream);
                                    return null;
                                } else if (strArr != null) {
                                    int length = strArr.length;
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= length) {
                                            break;
                                        }
                                        String str = strArr[i2];
                                        if (name.equals(str)) {
                                            byte[] readByteByStream = readByteByStream(zipInputStream);
                                            if (readByteByStream != null) {
                                                hashMap.put(str, readByteByStream);
                                            }
                                        } else {
                                            i = i2 + 1;
                                        }
                                    }
                                } else {
                                    byte[] readByteByStream2 = readByteByStream(zipInputStream);
                                    if (readByteByStream2 != null) {
                                        hashMap.put(name, readByteByStream2);
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        zipInputStream.closeEntry();
                    }
                }
                safelyCloseFile(inputStream);
                return hashMap;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                    safelyCloseFile(inputStream);
                    return hashMap;
                } catch (Throwable th3) {
                    safelyCloseFile(inputStream);
                    throw th3;
                }
            }
        }
        return hashMap;
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static String uncompressToString(byte[] bArr, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                inputStream = getZipInputStream(bArr);
                inputStream2 = inputStream;
                if (inputStream != null) {
                    try {
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read < 0) {
                                String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                                safelyCloseFile(inputStream);
                                return byteArrayOutputStream2;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    } catch (IOException e) {
                        e = e;
                        Log.e("gzip compress error.", e.getMessage());
                        inputStream2 = inputStream;
                        safelyCloseFile(inputStream2);
                        return null;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                safelyCloseFile((InputStream) null);
                throw th;
            }
            safelyCloseFile(inputStream2);
            return null;
        } catch (Throwable th2) {
            th = th2;
            safelyCloseFile((InputStream) null);
            throw th;
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        if (bArr != null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (bArr.length != 0) {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            return;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream2);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        writeLock.unlock();
        safelyCloseFile((OutputStream) null);
    }
}
