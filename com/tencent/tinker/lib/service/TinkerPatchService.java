package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/service/TinkerPatchService.class */
public class TinkerPatchService extends IntentService {
    private static final String PATCH_PATH_EXTRA = "patch_path_extra";
    private static final String RESULT_CLASS_EXTRA = "patch_result_class";
    private static final String TAG = "Tinker.TinkerPatchService";
    private static int notificationId = -1119860829;
    private static Class<? extends AbstractResultService> resultServiceClass;
    private static AtomicBoolean sIsPatchApplying = new AtomicBoolean(false);
    private static AbstractPatch upgradePatchProcessor;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/service/TinkerPatchService$InnerService.class */
    public static class InnerService extends Service {
        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(TinkerPatchService.notificationId, new Notification());
            } catch (Throwable th) {
                ShareTinkerLog.e(TinkerPatchService.TAG, "InnerService set service for push exception:%s.", th);
            }
            stopSelf();
        }

        @Override // android.app.Service
        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }
    }

    public TinkerPatchService() {
        super("TinkerPatchService");
    }

    private static void doApplyPatch(Context context, Intent intent) {
        boolean z;
        if (!sIsPatchApplying.compareAndSet(false, true)) {
            ShareTinkerLog.w(TAG, "TinkerPatchService doApplyPatch is running by another runner.", new Object[0]);
            return;
        }
        Tinker with = Tinker.with(context);
        with.getPatchReporter().onPatchServiceStart(intent);
        if (intent == null) {
            ShareTinkerLog.e(TAG, "TinkerPatchService received a null intent, ignoring.", new Object[0]);
            return;
        }
        String patchPathExtra = getPatchPathExtra(intent);
        if (patchPathExtra == null) {
            ShareTinkerLog.e(TAG, "TinkerPatchService can't get the path extra, ignoring.", new Object[0]);
            return;
        }
        File file = new File(patchPathExtra);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Throwable th = null;
        PatchResult patchResult = new PatchResult();
        try {
        } catch (Throwable th2) {
            th = th2;
            with.getPatchReporter().onPatchException(file, th);
            z = false;
        }
        if (upgradePatchProcessor == null) {
            throw new TinkerRuntimeException("upgradePatchProcessor is null.");
        }
        z = upgradePatchProcessor.tryPatch(context, patchPathExtra, patchResult);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        with.getPatchReporter().onPatchResult(file, z, elapsedRealtime2);
        patchResult.isSuccess = z;
        patchResult.rawPatchFilePath = patchPathExtra;
        patchResult.costTime = elapsedRealtime2;
        patchResult.e = th;
        AbstractResultService.runResultService(context, patchResult, getPatchResultExtra(intent));
        sIsPatchApplying.set(false);
    }

    public static String getPatchPathExtra(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, PATCH_PATH_EXTRA);
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    public static String getPatchResultExtra(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.getStringExtra(intent, RESULT_CLASS_EXTRA);
        }
        throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
    }

    private void increasingPriority() {
        if (Build.VERSION.SDK_INT >= 26) {
            ShareTinkerLog.i(TAG, "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
        } else if ("ZUK".equals(Build.MANUFACTURER)) {
            ShareTinkerLog.i(TAG, "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
        } else {
            ShareTinkerLog.i(TAG, "try to increase patch process priority", new Object[0]);
            try {
                Notification notification = new Notification();
                if (Build.VERSION.SDK_INT < 18) {
                    startForeground(notificationId, notification);
                    return;
                }
                startForeground(notificationId, notification);
                startService(new Intent(this, InnerService.class));
            } catch (Throwable th) {
                ShareTinkerLog.i(TAG, "try to increase patch process priority error:" + th, new Object[0]);
            }
        }
    }

    public static void runPatchService(Context context, String str) {
        ShareTinkerLog.i(TAG, "run patch service...", new Object[0]);
        Intent intent = new Intent(context, TinkerPatchService.class);
        intent.putExtra(PATCH_PATH_EXTRA, str);
        intent.putExtra(RESULT_CLASS_EXTRA, resultServiceClass.getName());
        try {
            context.startService(intent);
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "run patch service fail, exception:" + th, new Object[0]);
        }
    }

    public static void setPatchProcessor(AbstractPatch abstractPatch, Class<? extends AbstractResultService> cls) {
        upgradePatchProcessor = abstractPatch;
        resultServiceClass = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e) {
            ShareTinkerLog.printErrStackTrace(TAG, e, "patch processor class not found.", new Object[0]);
        }
    }

    public static void setTinkerNotificationId(int i) {
        notificationId = i;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        increasingPriority();
        doApplyPatch(this, intent);
    }
}
