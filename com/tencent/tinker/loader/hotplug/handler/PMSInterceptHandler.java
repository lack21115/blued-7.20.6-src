package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler.class */
public class PMSInterceptHandler implements ServiceBinderInterceptor.BinderInvocationHandler {
    private static final String TAG = "Tinker.PMSIntrcptHndlr";

    private Object handleGetActivityInfo(Object obj, Method method, Object[] objArr) throws Throwable {
        ComponentName componentName;
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        try {
            Object invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= objArr.length) {
                    componentName = null;
                    break;
                } else if (objArr[i2] instanceof ComponentName) {
                    ShareTinkerLog.i(TAG, "locate componentName field of " + method.getName() + " done at idx: " + i2, new Object[0]);
                    componentName = (ComponentName) objArr[i2];
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (componentName != null) {
                return IncrementComponentManager.queryActivityInfo(componentName.getClassName());
            }
            ShareTinkerLog.w(TAG, "failed to locate componentName field of " + method.getName() + ", notice any crashes or mistakes after resolve works.", new Object[0]);
            return null;
        } catch (InvocationTargetException e) {
            e = e;
            Throwable targetException = e.getTargetException();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                if (targetException != null) {
                    e = targetException;
                }
                throw e;
            }
            if (targetException != null) {
                e = targetException;
            }
            ShareTinkerLog.e(TAG, "unexpected exception.", e);
            return null;
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "unexpected exception.", th);
            return null;
        }
    }

    private Object handleResolveIntent(Object obj, Method method, Object[] objArr) throws Throwable {
        Intent intent;
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        try {
            Object invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            ShareTinkerLog.w(TAG, "failed to resolve activity in base package, try again in patch package.", new Object[0]);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= objArr.length) {
                    intent = null;
                    break;
                } else if (objArr[i2] instanceof Intent) {
                    ShareTinkerLog.i(TAG, "locate intent field of " + method.getName() + " done at idx: " + i2, new Object[0]);
                    intent = (Intent) objArr[i2];
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (intent != null) {
                return IncrementComponentManager.resolveIntent(intent);
            }
            ShareTinkerLog.w(TAG, "failed to locate intent field of " + method.getName() + ", notice any crashes or mistakes after resolve works.", new Object[0]);
            return null;
        } catch (InvocationTargetException e) {
            e = e;
            Throwable targetException = e.getTargetException();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                if (targetException != null) {
                    e = targetException;
                }
                throw e;
            }
            if (targetException != null) {
                e = targetException;
            }
            ShareTinkerLog.e(TAG, "unexpected exception.", e);
            return null;
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "unexpected exception.", th);
            return null;
        }
    }

    @Override // com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        return "getActivityInfo".equals(name) ? handleGetActivityInfo(obj, method, objArr) : "resolveIntent".equals(name) ? handleResolveIntent(obj, method, objArr) : method.invoke(obj, objArr);
    }
}
