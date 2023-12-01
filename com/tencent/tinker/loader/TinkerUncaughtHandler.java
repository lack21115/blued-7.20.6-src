package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerUncaughtHandler.class */
public class TinkerUncaughtHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "Tinker.UncaughtHandler";
    private final Context context;
    private final File crashFile;
    private final Thread.UncaughtExceptionHandler ueh = Thread.getDefaultUncaughtExceptionHandler();

    public TinkerUncaughtHandler(Context context) {
        this.context = context;
        this.crashFile = SharePatchFileUtil.getPatchLastCrashFile(context);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        PrintWriter printWriter;
        PrintWriter printWriter2;
        ShareTinkerLog.e(TAG, "TinkerUncaughtHandler catch exception:" + Log.getStackTraceString(th), new Object[0]);
        this.ueh.uncaughtException(thread, th);
        if (this.crashFile == null || !(Thread.getDefaultUncaughtExceptionHandler() instanceof TinkerUncaughtHandler)) {
            return;
        }
        File parentFile = this.crashFile.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            ShareTinkerLog.e(TAG, "print crash file error: create directory fail!", new Object[0]);
            return;
        }
        try {
            printWriter2 = new PrintWriter(new FileWriter(this.crashFile, false));
            printWriter = printWriter2;
        } catch (IOException e) {
            e = e;
            printWriter2 = null;
        } catch (Throwable th2) {
            th = th2;
            printWriter = null;
            SharePatchFileUtil.closeQuietly(printWriter);
            throw th;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("process:");
                sb.append(ShareTinkerInternals.getProcessName(this.context));
                printWriter2.println(sb.toString());
                printWriter2.println(ShareTinkerInternals.getExceptionCauseString(th));
            } catch (Throwable th3) {
                th = th3;
                SharePatchFileUtil.closeQuietly(printWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            StringBuilder sb2 = new StringBuilder();
            PrintWriter printWriter3 = printWriter2;
            sb2.append("print crash file error:");
            PrintWriter printWriter4 = printWriter2;
            sb2.append(Log.getStackTraceString(e));
            printWriter = printWriter2;
            ShareTinkerLog.e(TAG, sb2.toString(), new Object[0]);
            SharePatchFileUtil.closeQuietly(printWriter2);
            Process.killProcess(Process.myPid());
        }
        SharePatchFileUtil.closeQuietly(printWriter2);
        Process.killProcess(Process.myPid());
    }
}
