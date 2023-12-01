package com.tencent.tinker.loader.hotplug.interceptor;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation.class */
public class TinkerHackInstrumentation extends Instrumentation {
    private static final String TAG = "Tinker.Instrumentation";
    private final Object mActivityThread;
    private final Field mInstrumentationField;
    private final Instrumentation mOriginal;

    private TinkerHackInstrumentation(Instrumentation instrumentation, Object obj, Field field) throws TinkerRuntimeException {
        this.mOriginal = instrumentation;
        this.mActivityThread = obj;
        this.mInstrumentationField = field;
        try {
            copyAllFields(instrumentation);
        } catch (Throwable th) {
            throw new TinkerRuntimeException(th.getMessage(), th);
        }
    }

    private void copyAllFields(Instrumentation instrumentation) throws IllegalAccessException {
        Field[] declaredFields = Instrumentation.class.getDeclaredFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= declaredFields.length) {
                return;
            }
            declaredFields[i2].setAccessible(true);
            declaredFields[i2].set(this, declaredFields[i2].get(instrumentation));
            i = i2 + 1;
        }
    }

    public static TinkerHackInstrumentation create(Context context) {
        try {
            Object activityThread = ShareReflectUtil.getActivityThread(context, null);
            Field findField = ShareReflectUtil.findField(activityThread, "mInstrumentation");
            Instrumentation instrumentation = (Instrumentation) findField.get(activityThread);
            return instrumentation instanceof TinkerHackInstrumentation ? (TinkerHackInstrumentation) instrumentation : new TinkerHackInstrumentation(instrumentation, activityThread, findField);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("see next stacktrace", th);
        }
    }

    private void fixActivityParams(Activity activity, ActivityInfo activityInfo) {
        activity.setRequestedOrientation(activityInfo.screenOrientation);
        activity.setTheme(activityInfo.theme);
        try {
            ShareReflectUtil.findField(activity, "mActivityInfo").set(activity, activityInfo);
        } catch (Throwable th) {
            throw new TinkerRuntimeException("see next stacktrace.", th);
        }
    }

    private boolean processIntent(ClassLoader classLoader, Intent intent) {
        if (intent == null) {
            return false;
        }
        ShareIntentUtil.fixIntentClassLoader(intent, classLoader);
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT);
        if (componentName == null) {
            ShareTinkerLog.w(TAG, "oldComponent was null, start " + intent.getComponent() + " next.", new Object[0]);
            return false;
        }
        String className = componentName.getClassName();
        if (IncrementComponentManager.queryActivityInfo(className) != null) {
            intent.setComponent(componentName);
            intent.removeExtra(EnvConsts.INTENT_EXTRA_OLD_COMPONENT);
            return true;
        }
        ShareTinkerLog.e(TAG, "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: " + className, new Object[0]);
        return false;
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        ActivityInfo queryActivityInfo;
        if (activity != null && (queryActivityInfo = IncrementComponentManager.queryActivityInfo(activity.getClass().getName())) != null) {
            fixActivityParams(activity, queryActivityInfo);
        }
        super.callActivityOnCreate(activity, bundle);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        ActivityInfo queryActivityInfo;
        if (activity != null && (queryActivityInfo = IncrementComponentManager.queryActivityInfo(activity.getClass().getName())) != null) {
            fixActivityParams(activity, queryActivityInfo);
        }
        super.callActivityOnCreate(activity, bundle, persistableBundle);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        if (activity != null) {
            processIntent(activity.getClass().getClassLoader(), intent);
        }
        super.callActivityOnNewIntent(activity, intent);
    }

    public void install() throws IllegalAccessException {
        if (this.mInstrumentationField.get(this.mActivityThread) instanceof TinkerHackInstrumentation) {
            ShareTinkerLog.w(TAG, "already installed, skip rest logic.", new Object[0]);
        } else {
            this.mInstrumentationField.set(this.mActivityThread, this);
        }
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) throws InstantiationException, IllegalAccessException {
        processIntent(context.getClassLoader(), intent);
        return super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return processIntent(classLoader, intent) ? super.newActivity(classLoader, intent.getComponent().getClassName(), intent) : super.newActivity(classLoader, str, intent);
    }

    public void uninstall() throws IllegalAccessException {
        this.mInstrumentationField.set(this.mActivityThread, this.mOriginal);
    }
}
