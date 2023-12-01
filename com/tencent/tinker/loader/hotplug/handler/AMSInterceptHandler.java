package com.tencent.tinker.loader.hotplug.handler;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import com.tencent.tinker.loader.hotplug.ActivityStubManager;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler.class */
public class AMSInterceptHandler implements ServiceBinderInterceptor.BinderInvocationHandler {
    private static final int INTENT_SENDER_ACTIVITY;
    private static final String TAG = "Tinker.AMSIntrcptHndlr";
    private static final int[] TRANSLUCENT_ATTR_ID = {16842840};
    private final Context mContext;

    static {
        int i = 2;
        if (Build.VERSION.SDK_INT < 27) {
            try {
                i = ((Integer) ShareReflectUtil.findField((Class<?>) ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
                i = 2;
            }
        }
        INTENT_SENDER_ACTIVITY = i;
    }

    public AMSInterceptHandler(Context context) {
        Context baseContext;
        while ((context instanceof ContextWrapper) && (baseContext = ((ContextWrapper) context).getBaseContext()) != null) {
            context = baseContext;
        }
        this.mContext = context;
    }

    private Object handleGetIntentSender(Object obj, Method method, Object[] objArr) throws Throwable {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= objArr.length) {
                i = -1;
                break;
            } else if (objArr[i] instanceof Intent[]) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i != -1 && ((Integer) objArr[0]).intValue() == INTENT_SENDER_ACTIVITY) {
            Intent[] intentArr = (Intent[]) objArr[i];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= intentArr.length) {
                    break;
                }
                Intent intent = new Intent(intentArr[i4]);
                processActivityIntent(intent);
                intentArr[i4] = intent;
                i3 = i4 + 1;
            }
        }
        return method.invoke(obj, objArr);
    }

    private Object handleStartActivities(Object obj, Method method, Object[] objArr) throws Throwable {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= objArr.length) {
                i = -1;
                break;
            } else if (objArr[i] instanceof Intent[]) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i != -1) {
            Intent[] intentArr = (Intent[]) objArr[i];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= intentArr.length) {
                    break;
                }
                Intent intent = new Intent(intentArr[i4]);
                processActivityIntent(intent);
                intentArr[i4] = intent;
                i3 = i4 + 1;
            }
        }
        return method.invoke(obj, objArr);
    }

    private Object handleStartActivity(Object obj, Method method, Object[] objArr) throws Throwable {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= objArr.length) {
                i = -1;
                break;
            } else if (objArr[i] instanceof Intent) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i != -1) {
            Intent intent = new Intent((Intent) objArr[i]);
            processActivityIntent(intent);
            objArr[i] = intent;
        }
        return method.invoke(obj, objArr);
    }

    private boolean hasTransparentTheme(ActivityInfo activityInfo) {
        int themeResource = activityInfo.getThemeResource();
        Resources.Theme newTheme = this.mContext.getResources().newTheme();
        newTheme.applyStyle(themeResource, true);
        TypedArray typedArray = null;
        try {
            TypedArray obtainStyledAttributes = newTheme.obtainStyledAttributes(TRANSLUCENT_ATTR_ID);
            typedArray = obtainStyledAttributes;
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
            return z;
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
                return false;
            }
            return false;
        }
    }

    private void processActivityIntent(Intent intent) {
        String str;
        String str2 = null;
        if (intent.getComponent() != null) {
            str = intent.getComponent().getPackageName();
            str2 = intent.getComponent().getClassName();
        } else {
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            ResolveInfo resolveInfo = resolveActivity;
            if (resolveActivity == null) {
                resolveInfo = IncrementComponentManager.resolveIntent(intent);
            }
            if (resolveInfo == null || resolveInfo.filter == null || !resolveInfo.filter.hasCategory(Intent.CATEGORY_DEFAULT)) {
                str = null;
            } else {
                String str3 = resolveInfo.activityInfo.packageName;
                str2 = resolveInfo.activityInfo.name;
                str = str3;
            }
        }
        if (IncrementComponentManager.isIncrementActivity(str2)) {
            ActivityInfo queryActivityInfo = IncrementComponentManager.queryActivityInfo(str2);
            storeAndReplaceOriginalComponentName(intent, str, str2, ActivityStubManager.assignStub(str2, queryActivityInfo.launchMode, hasTransparentTheme(queryActivityInfo)));
        }
    }

    private void storeAndReplaceOriginalComponentName(Intent intent, String str, String str2, String str3) {
        ComponentName componentName = new ComponentName(str, str2);
        ShareIntentUtil.fixIntentClassLoader(intent, this.mContext.getClassLoader());
        intent.putExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT, componentName);
        intent.setComponent(new ComponentName(str, str3));
    }

    @Override // com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        if ("startActivity".equals(name)) {
            return handleStartActivity(obj, method, objArr);
        }
        if ("startActivities".equals(name)) {
            return handleStartActivities(obj, method, objArr);
        }
        if (!"startActivityAndWait".equals(name) && !"startActivityWithConfig".equals(name) && !"startActivityAsUser".equals(name)) {
            return "getIntentSender".equals(name) ? handleGetIntentSender(obj, method, objArr) : method.invoke(obj, objArr);
        }
        return handleStartActivity(obj, method, objArr);
    }
}
