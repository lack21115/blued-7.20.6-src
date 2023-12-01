package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/DBFileTraversalUtil.class */
public class DBFileTraversalUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f40791a = Executors.newSingleThreadExecutor();
    private static FileLockUtil b = new FileLockUtil();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/DBFileTraversalUtil$a.class */
    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final a aVar) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f40791a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File[] listFiles = File.this.listFiles();
                        int length = listFiles.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            File file2 = listFiles[i2];
                            if (file2.getName().endsWith(com.umeng.analytics.process.a.d)) {
                                DBFileTraversalUtil.b.doFileOperateion(file2, fileLockCallback);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                            }
                            i = i2 + 1;
                        }
                        if (aVar != null) {
                            aVar.a();
                        }
                    } catch (Throwable th) {
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}
