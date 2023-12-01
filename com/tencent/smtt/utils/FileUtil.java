package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/FileUtil.class */
public class FileUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f38922a;
    public static final a b = new a() { // from class: com.tencent.smtt.utils.FileUtil.2
        @Override // com.tencent.smtt.utils.FileUtil.a
        public boolean a(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final int f38923c = 4;
    private static RandomAccessFile d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/FileUtil$a.class */
    public interface a {
        boolean a(File file, File file2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/FileUtil$b.class */
    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            long j2 = j;
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j = j2 + read;
        }
    }

    public static File a(Context context, String str) {
        String str2;
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return file2;
            }
            try {
                file2.createNewFile();
                return file2;
            } catch (IOException e) {
                str2 = "getPermanentTbsFile -- exception: " + e;
            }
        } else {
            str2 = "getPermanentTbsFile -- no permission!";
        }
        TbsLog.e("FileHelper", str2);
        return null;
    }

    public static File a(Context context, boolean z, String str) {
        String d2 = z ? d(context) : c(context);
        if (d2 == null) {
            return null;
        }
        File file = new File(d2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return file2;
            }
            try {
                file2.createNewFile();
                return file2;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String a(Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a8, code lost:
        if (r0.canWrite() == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, java.lang.String r5, int r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.FileUtil.a(android.content.Context, java.lang.String, int, boolean):java.lang.String");
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock.isValid()) {
                return tryLock;
            }
            return null;
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, FileLock fileLock) {
        synchronized (FileUtil.class) {
            try {
                TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(File file, boolean z) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            a(listFiles[i2], z);
            i = i2 + 1;
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static void a(File file, boolean z, String str) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            File file2 = listFiles[i2];
            if (!file2.getName().equals(str)) {
                a(file2, z);
            }
            i = i2 + 1;
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean z = false;
        if (context != null) {
            z = context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return z;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static boolean a(File file, File file2) throws Exception {
        return a(file.getPath(), file2.getPath());
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) throws Exception {
        return a(file, file2, fileFilter, b);
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) throws Exception {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return b(file, file2, fileFilter, aVar);
        }
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles == null) {
            return false;
        }
        int length = listFiles.length;
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return z;
            }
            File file3 = listFiles[i2];
            if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
            i = i2 + 1;
        }
    }

    private static boolean a(String str, long j, long j2, long j3) throws Exception {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                crc32.update(bArr, 0, read);
            }
            long value = crc32.getValue();
            TbsLog.i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
            fileInputStream.close();
            return value != j3;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(String str, String str2) throws Exception {
        return a(str, str2, Build.CPU_ABI, Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }

    private static boolean a(String str, String str2, String str3, String str4, b bVar) throws Exception {
        ZipFile zipFile;
        Enumeration<? extends ZipEntry> entries;
        boolean z;
        boolean z2;
        try {
            zipFile = new ZipFile(str);
            try {
                entries = zipFile.entries();
                z = false;
                z2 = false;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
        }
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (name != null && !name.contains("../") && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                String substring = name.substring(name.lastIndexOf(47));
                boolean z3 = z;
                boolean z4 = z2;
                if (substring.endsWith(".so")) {
                    if (!name.regionMatches(f38923c, str2, 0, str2.length()) || name.charAt(f38923c + str2.length()) != '/') {
                        if (str3 != null && name.regionMatches(f38923c, str3, 0, str3.length()) && name.charAt(f38923c + str3.length()) == '/') {
                            z4 = true;
                            z2 = true;
                            z3 = z;
                            if (z) {
                                continue;
                            }
                        } else if (str4 != null && name.regionMatches(f38923c, str4, 0, str4.length()) && name.charAt(f38923c + str4.length()) == '/' && !z) {
                            z3 = z;
                            z4 = z2;
                            if (z2) {
                                continue;
                            }
                        }
                        th = th;
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        throw th;
                    }
                    z3 = true;
                    z4 = z2;
                }
                InputStream inputStream = zipFile.getInputStream(nextElement);
                if (!bVar.a(inputStream, nextElement, substring.substring(1))) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    zipFile.close();
                    return false;
                }
                z = z3;
                z2 = z4;
                if (inputStream != null) {
                    inputStream.close();
                    z = z3;
                    z2 = z4;
                }
            }
        }
        zipFile.close();
        return true;
    }

    private static boolean a(String str, final String str2, String str3, String str4, String str5) throws Exception {
        return a(str, str3, str4, str5, new b() { // from class: com.tencent.smtt.utils.FileUtil.1
            @Override // com.tencent.smtt.utils.FileUtil.b
            public boolean a(InputStream inputStream, ZipEntry zipEntry, String str6) throws Exception {
                try {
                    return FileUtil.b(inputStream, zipEntry, String.this, str6);
                } catch (Exception e) {
                    throw new Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        File a2 = a(context, z, str);
        if (a2 != null) {
            try {
                return new FileOutputStream(a2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static String b(Context context, String str) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            return context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            TbsLog.i(th);
            try {
                return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void b(File file) {
        a(file, false);
    }

    public static boolean b(Context context) {
        long a2 = p.a();
        boolean z = a2 >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + a2);
        }
        return z;
    }

    public static boolean b(File file, File file2) throws Exception {
        return a(file, file2, (FileFilter) null);
    }

    private static boolean b(File file, File file2, FileFilter fileFilter, a aVar) throws Exception {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (aVar != null && aVar.a(file, file2)) {
                        return true;
                    }
                    b(file2);
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    b(parentFile);
                }
                if (parentFile.exists() || parentFile.mkdirs()) {
                    FileChannel channel = new FileInputStream(file).getChannel();
                    FileChannel fileChannel3 = null;
                    try {
                        FileChannel channel2 = new FileOutputStream(file2).getChannel();
                        long size = channel.size();
                        if (channel2.transferFrom(channel, 0L, size) == size) {
                            if (channel != null) {
                                channel.close();
                            }
                            if (channel2 != null) {
                                channel2.close();
                                return true;
                            }
                            return true;
                        }
                        fileChannel3 = channel2;
                        b(file2);
                        if (channel != null) {
                            channel.close();
                        }
                        if (channel2 != null) {
                            channel2.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        fileChannel = channel;
                        FileChannel fileChannel4 = fileChannel3;
                        th = th;
                        fileChannel2 = fileChannel4;
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        throw th;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            fileChannel2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        FileOutputStream fileOutputStream;
        a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream3.write(bArr, 0, read);
                    }
                    fileOutputStream3.close();
                    if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                        TbsLog.e("FileHelper", "file is different: " + str3);
                        return false;
                    } else if (file.setLastModified(zipEntry.getTime())) {
                        return true;
                    } else {
                        TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
                        return true;
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream3;
                    b(file);
                    FileOutputStream fileOutputStream4 = fileOutputStream;
                    StringBuilder sb = new StringBuilder();
                    FileOutputStream fileOutputStream5 = fileOutputStream;
                    sb.append("Couldn't write dst file ");
                    FileOutputStream fileOutputStream6 = fileOutputStream;
                    sb.append(file);
                    fileOutputStream2 = fileOutputStream;
                    throw new IOException(sb.toString(), e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        }
    }

    public static String c(Context context) {
        return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        long a2 = a(inputStream, outputStream);
        if (a2 > 2147483647L) {
            return -1;
        }
        return (int) a2;
    }

    public static FileOutputStream d(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file);
    }

    static String d(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static FileLock e(Context context) {
        boolean z;
        StringBuilder sb;
        String str;
        FileLock a2;
        String str2;
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            z = true;
        }
        FileLock fileLock = null;
        if (!z) {
            FileOutputStream b2 = b(context, true, "tbs_rename_lock");
            if (b2 == null) {
                str2 = "init -- failed to get rename fileLock#1!";
                a2 = null;
            } else {
                a2 = a(context, b2);
                str2 = a2 == null ? "init -- failed to get rename fileLock#2!" : "init -- get rename fileLock success!";
            }
            TbsLog.i("FileHelper", str2);
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is " + a2);
            return a2;
        }
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
        File a3 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + a3);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a3.getAbsolutePath(), "r");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
        } catch (Throwable th2) {
            TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th2);
        }
        FileLock fileLock2 = fileLock;
        if (fileLock == null) {
            fileLock2 = g(context);
        }
        if (fileLock2 == null) {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.i("FileHelper", sb.toString());
        return fileLock2;
    }

    public static FileLock f(Context context) {
        FileLock fileLock;
        StringBuilder sb;
        String str;
        File a2 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + a2);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "rw");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, false);
        } catch (Throwable th) {
            TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLock = null;
        }
        if (fileLock == null) {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.i("FileHelper", sb.toString());
        return fileLock;
    }

    private static FileLock g(Context context) {
        int i;
        FileLock fileLock = null;
        FileLock fileLock2 = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a2 = a(context, "tbs_rename_lock");
            fileLock2 = null;
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= 20 || fileLock != null) {
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
                    d = randomAccessFile;
                    fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                    i2 = i + 1;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                FileLock fileLock3 = fileLock;
                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                FileLock fileLock4 = fileLock;
                StringBuilder sb = new StringBuilder();
                FileLock fileLock5 = fileLock;
                sb.append("getTbsCoreLoadFileLock,retry num=");
                FileLock fileLock6 = fileLock;
                sb.append(i);
                FileLock fileLock7 = fileLock;
                sb.append("success=");
                if (fileLock == null) {
                    z = true;
                }
                sb.append(z);
                fileLock2 = fileLock;
                TbsLog.i("FileHelper", sb.toString());
                return fileLock;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fileLock2;
    }
}
