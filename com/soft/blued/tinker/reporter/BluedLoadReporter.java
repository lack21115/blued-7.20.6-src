package com.soft.blued.tinker.reporter;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/reporter/BluedLoadReporter.class */
public class BluedLoadReporter extends DefaultLoadReporter {
    public BluedLoadReporter(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadException(Throwable th, int i) {
        super.onLoadException(th, i);
        BluedTinkerReport.a(th, i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadFileMd5Mismatch(File file, int i) {
        super.onLoadFileMd5Mismatch(file, i);
        BluedTinkerReport.d(i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadFileNotFound(File file, int i, boolean z) {
        super.onLoadFileNotFound(file, i, z);
        BluedTinkerReport.c(i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadInterpret(int i, Throwable th) {
        super.onLoadInterpret(i, th);
        BluedTinkerReport.a(i, th);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPackageCheckFail(File file, int i) {
        super.onLoadPackageCheckFail(file, i);
        BluedTinkerReport.b(i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        super.onLoadPatchInfoCorrupted(str, str2, file);
        BluedTinkerReport.a();
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPatchListenerReceiveFail(File file, int i) {
        super.onLoadPatchListenerReceiveFail(file, i);
        BluedTinkerReport.a(i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        super.onLoadPatchVersionChanged(str, str2, file, str3);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultLoadReporter, com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadResult(File file, int i, long j) {
        super.onLoadResult(file, i, j);
        if (i == 0) {
            BluedTinkerReport.a(j);
        }
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.soft.blued.tinker.reporter.BluedLoadReporter.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (UpgradePatchRetry.getInstance(BluedLoadReporter.this.context).onPatchRetryLoad()) {
                    BluedTinkerReport.g();
                    return false;
                }
                return false;
            }
        });
    }
}
