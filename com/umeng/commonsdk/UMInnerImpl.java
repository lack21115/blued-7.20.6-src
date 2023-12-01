package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.c;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.d;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/UMInnerImpl.class */
public class UMInnerImpl {
    private static boolean isInternal = false;

    public static void initAndSendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(Context.this);
                                    String packageName = Context.this.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                        return;
                                    }
                                    if (FieldManager.allow(d.ao) && !c.a(Context.this).a()) {
                                        c.a(Context.this).b();
                                    }
                                    k.b(Context.this);
                                } catch (Throwable th) {
                                    UMCrashManager.reportCrash(Context.this, th);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } catch (Throwable th) {
                    try {
                        ULog.e(UMModuleRegister.INNER, "e is " + th.getMessage());
                        UMCrashManager.reportCrash(context, th);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    private static void sendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(Context.this);
                                String packageName = Context.this.getPackageName();
                                if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                    return;
                                }
                                com.umeng.commonsdk.internal.d.b(Context.this);
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(Context.this, th);
                            }
                        }
                    }).start();
                    isInternal = true;
                } catch (Throwable th) {
                    try {
                        ULog.e(UMModuleRegister.INNER, "e is " + th.getMessage());
                        UMCrashManager.reportCrash(context, th);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }
}
