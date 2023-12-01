package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/AppInfoChangedBlocker.class */
public final class AppInfoChangedBlocker {
    private static final String TAG = "Tinker.AppInfoChangedBlocker";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/AppInfoChangedBlocker$HackerCallback.class */
    public static class HackerCallback implements Handler.Callback {
        private final int APPLICATION_INFO_CHANGED;
        private Handler.Callback origin;

        HackerCallback(Handler.Callback callback, Class cls) {
            int i;
            this.origin = callback;
            try {
                i = ShareReflectUtil.findField((Class<?>) cls, "APPLICATION_INFO_CHANGED").getInt(null);
            } catch (Throwable th) {
                i = 156;
            }
            this.APPLICATION_INFO_CHANGED = i;
        }

        private boolean hackMessage(Message message) {
            if (message.what == this.APPLICATION_INFO_CHANGED) {
                ShareTinkerLog.w(AppInfoChangedBlocker.TAG, "Suicide now.", new Object[0]);
                Process.killProcess(Process.myPid());
                return true;
            }
            return false;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (hackMessage(message)) {
                return true;
            }
            Handler.Callback callback = this.origin;
            if (callback != null) {
                return callback.handleMessage(message);
            }
            return false;
        }
    }

    private static Handler fetchMHObject(Context context) throws Exception {
        Object activityThread = ShareReflectUtil.getActivityThread(context, null);
        return (Handler) ShareReflectUtil.findField(activityThread, "mH").get(activityThread);
    }

    private static void interceptHandler(Handler handler) throws Exception {
        Field findField = ShareReflectUtil.findField((Class<?>) Handler.class, "mCallback");
        Handler.Callback callback = (Handler.Callback) findField.get(handler);
        if (callback instanceof HackerCallback) {
            ShareTinkerLog.w(TAG, "Already intercepted, skip rest logic.", new Object[0]);
        } else {
            findField.set(handler, new HackerCallback(callback, handler.getClass()));
        }
    }

    public static boolean tryStart(Application application) {
        if (Build.VERSION.SDK_INT < 26) {
            Log.i(TAG, "tryStart: SDK_INT is less than 26, skip rest logic.");
            return true;
        }
        try {
            ShareTinkerLog.i(TAG, "tryStart called.", new Object[0]);
            interceptHandler(fetchMHObject(application));
            ShareTinkerLog.i(TAG, "tryStart done.", new Object[0]);
            return true;
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "AppInfoChangedBlocker start failed, simply ignore.", th);
            return false;
        }
    }
}
