package com.jeremyliao.liveeventbus.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.FileProvider;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/utils/AppUtils.class */
public final class AppUtils {
    private static final ActivityLifecycleImpl ACTIVITY_LIFECYCLE = new ActivityLifecycleImpl();
    private static final String PERMISSION_ACTIVITY_CLASS_NAME = "com.blankj.utilcode.util.PermissionUtils$PermissionActivity";
    private static Application sApplication;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/utils/AppUtils$ActivityLifecycleImpl.class */
    public static class ActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {
        final LinkedList<Activity> mActivityList = new LinkedList<>();
        final Map<Object, OnAppStatusChangedListener> mStatusListenerMap = new HashMap();
        final Map<Activity, Set<OnActivityDestroyedListener>> mDestroyedListenerMap = new HashMap();
        private int mForegroundCount = 0;
        private int mConfigCount = 0;
        private boolean mIsBackground = false;

        ActivityLifecycleImpl() {
        }

        private void consumeOnActivityDestroyedListener(Activity activity) {
            Iterator<Map.Entry<Activity, Set<OnActivityDestroyedListener>>> it = this.mDestroyedListenerMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Activity, Set<OnActivityDestroyedListener>> next = it.next();
                if (next.getKey() == activity) {
                    for (OnActivityDestroyedListener onActivityDestroyedListener : next.getValue()) {
                        onActivityDestroyedListener.onActivityDestroyed(activity);
                    }
                    it.remove();
                }
            }
        }

        private static void fixSoftInputLeaks(Activity activity) {
            InputMethodManager inputMethodManager;
            if (activity == null || (inputMethodManager = (InputMethodManager) AppUtils.getApp().getSystemService(Context.INPUT_METHOD_SERVICE)) == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    return;
                }
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(new String[]{"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"}[i2]);
                    if (declaredField != null) {
                        if (!declaredField.isAccessible()) {
                            declaredField.setAccessible(true);
                        }
                        Object obj = declaredField.get(inputMethodManager);
                        if ((obj instanceof View) && ((View) obj).getRootView() == activity.getWindow().getDecorView().getRootView()) {
                            declaredField.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable th) {
                }
                i = i2 + 1;
            }
        }

        private Activity getTopActivityByReflect() {
            Object next;
            Class<?> cls;
            Field declaredField;
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object invoke = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField2 = cls2.getDeclaredField("mActivityList");
                declaredField2.setAccessible(true);
                Map map = (Map) declaredField2.get(invoke);
                if (map == null) {
                    return null;
                }
                Iterator it = map.values().iterator();
                do {
                    if (!it.hasNext()) {
                        return null;
                    }
                    next = it.next();
                    cls = next.getClass();
                    declaredField = cls.getDeclaredField("paused");
                    declaredField.setAccessible(true);
                } while (declaredField.getBoolean(next));
                Field declaredField3 = cls.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                return (Activity) declaredField3.get(next);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }

        private void postStatus(boolean z) {
            OnAppStatusChangedListener next;
            if (this.mStatusListenerMap.isEmpty()) {
                return;
            }
            Iterator<OnAppStatusChangedListener> it = this.mStatusListenerMap.values().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (z) {
                    next.onForeground();
                } else {
                    next.onBackground();
                }
            }
        }

        private void setTopActivity(Activity activity) {
            if (AppUtils.PERMISSION_ACTIVITY_CLASS_NAME.equals(activity.getClass().getName())) {
                return;
            }
            if (!this.mActivityList.contains(activity)) {
                this.mActivityList.addLast(activity);
            } else if (this.mActivityList.getLast().equals(activity)) {
            } else {
                this.mActivityList.remove(activity);
                this.mActivityList.addLast(activity);
            }
        }

        void addOnActivityDestroyedListener(Activity activity, OnActivityDestroyedListener onActivityDestroyedListener) {
            HashSet hashSet;
            if (activity == null || onActivityDestroyedListener == null) {
                return;
            }
            if (this.mDestroyedListenerMap.containsKey(activity)) {
                Set<OnActivityDestroyedListener> set = this.mDestroyedListenerMap.get(activity);
                hashSet = set;
                if (set.contains(onActivityDestroyedListener)) {
                    return;
                }
            } else {
                HashSet hashSet2 = new HashSet();
                this.mDestroyedListenerMap.put(activity, hashSet2);
                hashSet = hashSet2;
            }
            hashSet.add(onActivityDestroyedListener);
        }

        void addOnAppStatusChangedListener(Object obj, OnAppStatusChangedListener onAppStatusChangedListener) {
            this.mStatusListenerMap.put(obj, onAppStatusChangedListener);
        }

        Activity getTopActivity() {
            Activity last;
            if (this.mActivityList.isEmpty() || (last = this.mActivityList.getLast()) == null) {
                Activity topActivityByReflect = getTopActivityByReflect();
                if (topActivityByReflect != null) {
                    setTopActivity(topActivityByReflect);
                }
                return topActivityByReflect;
            }
            return last;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            setTopActivity(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            this.mActivityList.remove(activity);
            consumeOnActivityDestroyedListener(activity);
            fixSoftInputLeaks(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            setTopActivity(activity);
            if (this.mIsBackground) {
                this.mIsBackground = false;
                postStatus(true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (!this.mIsBackground) {
                setTopActivity(activity);
            }
            int i = this.mConfigCount;
            if (i < 0) {
                this.mConfigCount = i + 1;
            } else {
                this.mForegroundCount++;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity.isChangingConfigurations()) {
                this.mConfigCount--;
                return;
            }
            int i = this.mForegroundCount - 1;
            this.mForegroundCount = i;
            if (i <= 0) {
                this.mIsBackground = true;
                postStatus(false);
            }
        }

        void removeOnActivityDestroyedListener(Activity activity) {
            if (activity == null) {
                return;
            }
            this.mDestroyedListenerMap.remove(activity);
        }

        void removeOnAppStatusChangedListener(Object obj) {
            this.mStatusListenerMap.remove(obj);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/utils/AppUtils$FileProvider4UtilCode.class */
    public static final class FileProvider4UtilCode extends FileProvider {
        @Override // androidx.core.content.FileProvider, android.content.ContentProvider
        public boolean onCreate() {
            AppUtils.init(getContext());
            return true;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/utils/AppUtils$OnActivityDestroyedListener.class */
    public interface OnActivityDestroyedListener {
        void onActivityDestroyed(Activity activity);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/utils/AppUtils$OnAppStatusChangedListener.class */
    public interface OnAppStatusChangedListener {
        void onBackground();

        void onForeground();
    }

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    static ActivityLifecycleImpl getActivityLifecycle() {
        return ACTIVITY_LIFECYCLE;
    }

    static LinkedList<Activity> getActivityList() {
        return ACTIVITY_LIFECYCLE.mActivityList;
    }

    public static Application getApp() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        Application applicationByReflect = getApplicationByReflect();
        init(applicationByReflect);
        return applicationByReflect;
    }

    private static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    static Context getTopActivityOrApp() {
        if (isAppForeground()) {
            Context topActivity = ACTIVITY_LIFECYCLE.getTopActivity();
            Context context = topActivity;
            if (topActivity == null) {
                context = getApp();
            }
            return context;
        }
        return getApp();
    }

    public static void init(Application application) {
        if (sApplication == null) {
            if (application == null) {
                sApplication = getApplicationByReflect();
            } else {
                sApplication = application;
            }
            sApplication.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE);
        } else if (application == null || application.getClass() == sApplication.getClass()) {
        } else {
            sApplication.unregisterActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE);
            ACTIVITY_LIFECYCLE.mActivityList.clear();
            sApplication = application;
            application.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE);
        }
    }

    public static void init(Context context) {
        if (context == null) {
            init(getApplicationByReflect());
        } else {
            init((Application) context.getApplicationContext());
        }
    }

    static boolean isAppForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) getApp().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100) {
                return runningAppProcessInfo.processName.equals(getApp().getPackageName());
            }
        }
        return false;
    }
}
