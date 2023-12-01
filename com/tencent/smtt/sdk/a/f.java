package com.tencent.smtt.sdk.a;

import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f25142a = "EmergencyManager";
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final FileOutputStream f25143c;
    private final FileLock d;

    private f(File file, FileOutputStream fileOutputStream, FileLock fileLock) {
        this.b = file;
        this.f25143c = fileOutputStream;
        this.d = fileLock;
    }

    /* JADX WARN: Finally extract failed */
    public static f a(File file) {
        FileOutputStream fileOutputStream;
        String str;
        StringBuilder sb;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock == null) {
                try {
                    fileOutputStream.close();
                    return null;
                } catch (IOException e) {
                    e = e;
                    str = f25142a;
                    sb = new StringBuilder();
                    sb.append("Failed to close: ");
                    sb.append(e.getMessage());
                    TbsLog.e(str, sb.toString());
                    return null;
                }
            }
            TbsLog.i(f25142a, "Created lock file: " + file.getAbsolutePath());
            f fVar = new f(file, fileOutputStream, tryLock);
            try {
                fileOutputStream.close();
                return fVar;
            } catch (IOException e2) {
                TbsLog.e(f25142a, "Failed to close: " + e2.getMessage());
                return fVar;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                TbsLog.e(f25142a, "Failed to try to acquire lock: " + file.getAbsolutePath() + " error: " + th.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        str = f25142a;
                        sb = new StringBuilder();
                        sb.append("Failed to close: ");
                        sb.append(e.getMessage());
                        TbsLog.e(str, sb.toString());
                        return null;
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        TbsLog.e(f25142a, "Failed to close: " + e4.getMessage());
                    }
                }
                throw th3;
            }
        }
    }

    public void a() throws IOException {
        String str = f25142a;
        TbsLog.i(str, "Deleting lock file: " + this.b.getAbsolutePath());
        this.d.release();
        this.f25143c.close();
        if (this.b.delete()) {
            return;
        }
        throw new IOException("Failed to delete lock file: " + this.b.getAbsolutePath());
    }

    public void b() {
        try {
            a();
        } catch (IOException e) {
            String str = f25142a;
            TbsLog.e(str, "Failed to release process lock file: " + this.b.getAbsolutePath() + " error: " + e);
        }
    }
}
