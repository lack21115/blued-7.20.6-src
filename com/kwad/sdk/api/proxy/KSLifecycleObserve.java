package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/proxy/KSLifecycleObserve.class */
public class KSLifecycleObserve {
    private static final String TAG = "KSLifecycleObserve";
    private static KSLifecycleObserve sKSLifecycleObserve;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mIsInBackground = true;
    private int startedActivityCount = 0;
    private final List<KSLifecycleListener> mListeners = new CopyOnWriteArrayList();
    private boolean mHasInit = false;

    private KSLifecycleObserve() {
    }

    static /* synthetic */ int access$108(KSLifecycleObserve kSLifecycleObserve) {
        int i = kSLifecycleObserve.startedActivityCount;
        kSLifecycleObserve.startedActivityCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$110(KSLifecycleObserve kSLifecycleObserve) {
        int i = kSLifecycleObserve.startedActivityCount;
        kSLifecycleObserve.startedActivityCount = i - 1;
        return i;
    }

    public static KSLifecycleObserve getInstance() {
        if (sKSLifecycleObserve == null) {
            synchronized (KSLifecycleObserve.class) {
                try {
                    if (sKSLifecycleObserve == null) {
                        sKSLifecycleObserve = new KSLifecycleObserve();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sKSLifecycleObserve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackToForeground() {
        try {
            Log.i(TAG, "App switch to foreground");
            this.mIsInBackground = false;
            for (KSLifecycleListener kSLifecycleListener : this.mListeners) {
                kSLifecycleListener.onBackToForeground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppGoToBackground() {
        try {
            Log.i(TAG, "App switch to background");
            this.mIsInBackground = true;
            for (KSLifecycleListener kSLifecycleListener : this.mListeners) {
                kSLifecycleListener.onBackToBackground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void init(Context context) {
        try {
            if (!(context instanceof Application) || this.mHasInit) {
                return;
            }
            this.mHasInit = true;
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.api.proxy.KSLifecycleObserve.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    try {
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserve.this.mListeners) {
                            kSLifecycleListener.onActivityCreated(activity, bundle);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    try {
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserve.this.mListeners) {
                            kSLifecycleListener.onActivityDestroyed(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    try {
                        if (KSLifecycleObserve.this.currentActivity != null && KSLifecycleObserve.this.currentActivity.get() != null && ((Activity) KSLifecycleObserve.this.currentActivity.get()).equals(activity)) {
                            KSLifecycleObserve.this.currentActivity = null;
                        }
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserve.this.mListeners) {
                            kSLifecycleListener.onActivityPaused(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    try {
                        KSLifecycleObserve.this.currentActivity = new WeakReference(activity);
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserve.this.mListeners) {
                            kSLifecycleListener.onActivityResumed(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    try {
                        KSLifecycleObserve.access$108(KSLifecycleObserve.this);
                        if (KSLifecycleObserve.this.startedActivityCount == 1) {
                            KSLifecycleObserve.this.onAppBackToForeground();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        KSLifecycleObserve.access$110(KSLifecycleObserve.this);
                        if (KSLifecycleObserve.this.startedActivityCount == 0) {
                            KSLifecycleObserve.this.onAppGoToBackground();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public void registerLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.add(kSLifecycleListener);
    }

    public void unRegisterLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.remove(kSLifecycleListener);
    }
}
