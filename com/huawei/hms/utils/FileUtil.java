package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.utils.p;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/FileUtil.class */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22909a = false;
    public static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/FileUtil$a.class */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f22910a;
        public final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22911c;

        public a(File file, long j, String str) {
            this.f22910a = file;
            this.b = j;
            this.f22911c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RandomAccessFile randomAccessFile;
            IOException e;
            File file = this.f22910a;
            if (file == null) {
                HMSLog.e(p.Code, "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                HMSLog.e(p.Code, "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile2 = null;
            RandomAccessFile randomAccessFile3 = null;
            try {
                try {
                    long length = this.f22910a.length();
                    if (length > this.b) {
                        String canonicalPath = this.f22910a.getCanonicalPath();
                        if (!this.f22910a.delete()) {
                            HMSLog.e(p.Code, "last file delete failed.");
                        }
                        randomAccessFile = new RandomAccessFile(new File(canonicalPath), "rw");
                    } else {
                        randomAccessFile = new RandomAccessFile(this.f22910a, "rw");
                        try {
                            randomAccessFile.seek(length);
                        } catch (IOException e2) {
                            e = e2;
                            HMSLog.e(p.Code, "writeFile exception:", e);
                            IOUtils.closeQuietly(randomAccessFile);
                        } catch (Throwable th) {
                            randomAccessFile3 = randomAccessFile;
                            th = th;
                            IOUtils.closeQuietly(randomAccessFile3);
                            throw th;
                        }
                    }
                    RandomAccessFile randomAccessFile4 = randomAccessFile;
                    StringBuilder sb = new StringBuilder();
                    RandomAccessFile randomAccessFile5 = randomAccessFile;
                    sb.append(this.f22911c);
                    RandomAccessFile randomAccessFile6 = randomAccessFile;
                    sb.append(System.getProperty("line.separator"));
                    randomAccessFile2 = randomAccessFile;
                    randomAccessFile.writeBytes(sb.toString());
                } catch (IOException e3) {
                    randomAccessFile = randomAccessFile2;
                    e = e3;
                }
                IOUtils.closeQuietly(randomAccessFile);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        return digest != null && HEX.encodeHexString(digest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j) {
        b.execute(new a(file, j, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f22909a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e(p.Code, "file delete failed.");
                }
                f22909a = true;
            }
            writeFile(file2, str + "|" + j + "|" + i, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
