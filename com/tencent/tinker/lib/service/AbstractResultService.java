package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/service/AbstractResultService.class */
public abstract class AbstractResultService extends IntentService {
    private static final String RESULT_EXTRA = "result_extra";
    private static final String TAG = "Tinker.AbstractResultService";

    public AbstractResultService() {
        super("TinkerResultService");
    }

    public static void runResultService(Context context, PatchResult patchResult, String str) {
        if (str == null) {
            throw new TinkerRuntimeException("resultServiceClass is null.");
        }
        try {
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.putExtra(RESULT_EXTRA, patchResult);
            context.startService(intent);
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "run result service fail, exception:" + th, new Object[0]);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            ShareTinkerLog.e(TAG, "AbstractResultService received a null intent, ignoring.", new Object[0]);
        } else {
            onPatchResult((PatchResult) ShareIntentUtil.getSerializableExtra(intent, RESULT_EXTRA));
        }
    }

    public abstract void onPatchResult(PatchResult patchResult);
}
