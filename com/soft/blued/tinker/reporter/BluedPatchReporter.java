package com.soft.blued.tinker.reporter;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/reporter/BluedPatchReporter.class */
public class BluedPatchReporter extends DefaultPatchReporter {
    public BluedPatchReporter(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchDexOptFail(File file, List<File> list, Throwable th) {
        super.onPatchDexOptFail(file, list, th);
        BluedTinkerReport.a(th);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchException(File file, Throwable th) {
        super.onPatchException(file, th);
        BluedTinkerReport.b(th);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchInfoCorrupted(File file, String str, String str2) {
        super.onPatchInfoCorrupted(file, str, str2);
        BluedTinkerReport.c();
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchPackageCheckFail(File file, int i) {
        super.onPatchPackageCheckFail(file, i);
        BluedTinkerReport.f(i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchResult(File file, boolean z, long j) {
        super.onPatchResult(file, z, j);
        BluedTinkerReport.a(j, z);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchServiceStart(Intent intent) {
        super.onPatchServiceStart(intent);
        BluedTinkerReport.b();
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchTypeExtractFail(File file, File file2, String str, int i) {
        super.onPatchTypeExtractFail(file, file2, str, i);
        BluedTinkerReport.e(i);
    }

    @Override // com.tencent.tinker.lib.reporter.DefaultPatchReporter, com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str) {
        super.onPatchVersionCheckFail(file, sharePatchInfo, str);
        BluedTinkerReport.d();
    }
}
