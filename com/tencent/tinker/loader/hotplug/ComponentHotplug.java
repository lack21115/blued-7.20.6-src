package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;
import com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/ComponentHotplug.class */
public final class ComponentHotplug {
    private static final String TAG = "Tinker.ComponentHotplug";
    private static ServiceBinderInterceptor sAMSInterceptor;
    private static volatile boolean sInstalled = false;
    private static HandlerMessageInterceptor sMHMessageInterceptor;
    private static ServiceBinderInterceptor sPMSInterceptor;
    private static TinkerHackInstrumentation sTinkerHackInstrumentation;

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }

    public static void ensureComponentHotplugInstalled(TinkerApplication tinkerApplication) throws UnsupportedEnvironmentException {
        synchronized (ComponentHotplug.class) {
            try {
                if (sInstalled) {
                    sAMSInterceptor.install();
                    sPMSInterceptor.install();
                    if (Build.VERSION.SDK_INT < 27) {
                        sMHMessageInterceptor.install();
                    } else {
                        sTinkerHackInstrumentation.install();
                    }
                } else {
                    ShareTinkerLog.i(TAG, "method install() is not invoked, ignore ensuring operations.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Handler fetchMHInstance(Context context) {
        Object activityThread = ShareReflectUtil.getActivityThread(context, null);
        if (activityThread != null) {
            try {
                return (Handler) ShareReflectUtil.findField(activityThread, "mH").get(activityThread);
            } catch (Throwable th) {
                throw new IllegalStateException(th);
            }
        }
        throw new IllegalStateException("failed to fetch instance of ActivityThread.");
    }

    public static void install(TinkerApplication tinkerApplication, ShareSecurityCheck shareSecurityCheck) throws UnsupportedEnvironmentException {
        synchronized (ComponentHotplug.class) {
            try {
                if (!sInstalled && IncrementComponentManager.init(tinkerApplication, shareSecurityCheck)) {
                    sAMSInterceptor = new ServiceBinderInterceptor(tinkerApplication, "activity", new AMSInterceptHandler(tinkerApplication));
                    sPMSInterceptor = new ServiceBinderInterceptor(tinkerApplication, "package", new PMSInterceptHandler());
                    sAMSInterceptor.install();
                    sPMSInterceptor.install();
                    if (Build.VERSION.SDK_INT < 27) {
                        HandlerMessageInterceptor handlerMessageInterceptor = new HandlerMessageInterceptor(fetchMHInstance(tinkerApplication), new MHMessageHandler(tinkerApplication));
                        sMHMessageInterceptor = handlerMessageInterceptor;
                        handlerMessageInterceptor.install();
                    } else {
                        TinkerHackInstrumentation create = TinkerHackInstrumentation.create(tinkerApplication);
                        sTinkerHackInstrumentation = create;
                        create.install();
                    }
                    sInstalled = true;
                    ShareTinkerLog.i(TAG, "installed successfully.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void uninstall() {
        synchronized (ComponentHotplug.class) {
            try {
                if (sInstalled) {
                    sAMSInterceptor.uninstall();
                    sPMSInterceptor.uninstall();
                    if (Build.VERSION.SDK_INT < 27) {
                        sMHMessageInterceptor.uninstall();
                    } else {
                        sTinkerHackInstrumentation.uninstall();
                    }
                    sInstalled = false;
                }
            } finally {
            }
        }
    }
}
