package com.tencent.tinker.lib.tinker;

import android.content.Context;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/tinker/TinkerInstaller.class */
public class TinkerInstaller {
    private static final String TAG = "Tinker.TinkerInstaller";

    public static void cleanPatch(Context context) {
        Tinker.with(context).cleanPatch();
    }

    public static Tinker install(ApplicationLike applicationLike) {
        Tinker build = new Tinker.Builder(applicationLike.getApplication()).build();
        Tinker.create(build);
        build.install(applicationLike.getTinkerResultIntent());
        return build;
    }

    public static Tinker install(ApplicationLike applicationLike, LoadReporter loadReporter, PatchReporter patchReporter, PatchListener patchListener, Class<? extends AbstractResultService> cls, AbstractPatch abstractPatch) {
        Tinker build = new Tinker.Builder(applicationLike.getApplication()).tinkerFlags(applicationLike.getTinkerFlags()).loadReport(loadReporter).listener(patchListener).patchReporter(patchReporter).tinkerLoadVerifyFlag(Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag())).build();
        Tinker.create(build);
        build.install(applicationLike.getTinkerResultIntent(), cls, abstractPatch);
        return build;
    }

    public static void onReceiveUpgradePatch(Context context, String str) {
        Tinker.with(context).getPatchListener().onPatchReceived(str);
    }

    public static void setLogIml(ShareTinkerLog.TinkerLogImp tinkerLogImp) {
        ShareTinkerLog.setTinkerLogImp(tinkerLogImp);
    }
}
