package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/FileLockUtil.class */
public class FileLockUtil {
    private final Object lockObject = new Object();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.channels.FileLock getFileLock(java.lang.String r5) {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> L1d java.io.FileNotFoundException -> L27
            r1 = r0
            r2 = r5
            java.lang.String r3 = "rw"
            r1.<init>(r2, r3)     // Catch: java.io.IOException -> L1d java.io.FileNotFoundException -> L27
            java.nio.channels.FileChannel r0 = r0.getChannel()     // Catch: java.io.IOException -> L1d java.io.FileNotFoundException -> L27
            r5 = r0
            r0 = r5
            java.nio.channels.FileLock r0 = r0.lock()     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L19
            r6 = r0
            r0 = r6
            return r0
        L15:
            r6 = move-exception
            goto L20
        L19:
            r6 = move-exception
            goto L2a
        L1d:
            r6 = move-exception
            r0 = 0
            r5 = r0
        L20:
            r0 = r6
            r0.printStackTrace()
            goto L2e
        L27:
            r6 = move-exception
            r0 = 0
            r5 = r0
        L2a:
            r0 = r6
            r0.printStackTrace()
        L2e:
            r0 = r5
            if (r0 == 0) goto L3d
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L38
            r0 = 0
            return r0
        L38:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
        L3d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.FileLockUtil.getFileLock(java.lang.String):java.nio.channels.FileLock");
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file, i);
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file.getName(), obj);
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(str);
                if (fileLock != null) {
                    try {
                        fileLockCallback.onFileLock(file.getName());
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
