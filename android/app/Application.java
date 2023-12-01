package android.app;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/app/Application.class */
public class Application extends ContextWrapper implements ComponentCallbacks2 {
    private ArrayList<ActivityLifecycleCallbacks> mActivityLifecycleCallbacks;
    private ArrayList<OnProvideAssistDataListener> mAssistCallbacks;
    private ArrayList<ComponentCallbacks> mComponentCallbacks;
    public LoadedApk mLoadedApk;

    /* loaded from: source-9557208-dex2jar.jar:android/app/Application$ActivityLifecycleCallbacks.class */
    public interface ActivityLifecycleCallbacks {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Application$OnProvideAssistDataListener.class */
    public interface OnProvideAssistDataListener {
        void onProvideAssistData(Activity activity, Bundle bundle);
    }

    public Application() {
        super(null);
        this.mComponentCallbacks = new ArrayList<>();
        this.mActivityLifecycleCallbacks = new ArrayList<>();
        this.mAssistCallbacks = null;
    }

    private Object[] collectActivityLifecycleCallbacks() {
        Object[] objArr = null;
        synchronized (this.mActivityLifecycleCallbacks) {
            if (this.mActivityLifecycleCallbacks.size() > 0) {
                objArr = this.mActivityLifecycleCallbacks.toArray();
            }
        }
        return objArr;
    }

    private Object[] collectComponentCallbacks() {
        Object[] objArr = null;
        synchronized (this.mComponentCallbacks) {
            if (this.mComponentCallbacks.size() > 0) {
                objArr = this.mComponentCallbacks.toArray();
            }
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void attach(Context context) {
        attachBaseContext(context);
        this.mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityCreated(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivityCreated(activity, bundle);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityDestroyed(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivityDestroyed(activity);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityPaused(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivityPaused(activity);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityResumed(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivityResumed(activity);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivitySaveInstanceState(activity, bundle);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityStarted(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivityStarted(activity);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityStopped(Activity activity) {
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectActivityLifecycleCallbacks.length) {
                return;
            }
            ((ActivityLifecycleCallbacks) collectActivityLifecycleCallbacks[i2]).onActivityStopped(activity);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchOnProvideAssistData(Activity activity, Bundle bundle) {
        synchronized (this) {
            if (this.mAssistCallbacks == null) {
                return;
            }
            Object[] array = this.mAssistCallbacks.toArray();
            if (array == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= array.length) {
                    return;
                }
                ((OnProvideAssistDataListener) array[i2]).onProvideAssistData(activity, bundle);
                i = i2 + 1;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Object[] collectComponentCallbacks = collectComponentCallbacks();
        if (collectComponentCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectComponentCallbacks.length) {
                return;
            }
            ((ComponentCallbacks) collectComponentCallbacks[i2]).onConfigurationChanged(configuration);
            i = i2 + 1;
        }
    }

    public void onCreate() {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Object[] collectComponentCallbacks = collectComponentCallbacks();
        if (collectComponentCallbacks == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= collectComponentCallbacks.length) {
                return;
            }
            ((ComponentCallbacks) collectComponentCallbacks[i2]).onLowMemory();
            i = i2 + 1;
        }
    }

    public void onTerminate() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        Object[] collectComponentCallbacks = collectComponentCallbacks();
        if (collectComponentCallbacks == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= collectComponentCallbacks.length) {
                return;
            }
            Object obj = collectComponentCallbacks[i3];
            if (obj instanceof ComponentCallbacks2) {
                ((ComponentCallbacks2) obj).onTrimMemory(i);
            }
            i2 = i3 + 1;
        }
    }

    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.add(activityLifecycleCallbacks);
        }
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        synchronized (this.mComponentCallbacks) {
            this.mComponentCallbacks.add(componentCallbacks);
        }
    }

    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        synchronized (this) {
            if (this.mAssistCallbacks == null) {
                this.mAssistCallbacks = new ArrayList<>();
            }
            this.mAssistCallbacks.add(onProvideAssistDataListener);
        }
    }

    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.remove(activityLifecycleCallbacks);
        }
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        synchronized (this.mComponentCallbacks) {
            this.mComponentCallbacks.remove(componentCallbacks);
        }
    }

    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        synchronized (this) {
            if (this.mAssistCallbacks != null) {
                this.mAssistCallbacks.remove(onProvideAssistDataListener);
            }
        }
    }
}
