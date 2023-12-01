package com.kwad.sdk.api.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/KSLifecycleObserver.class */
public class KSLifecycleObserver {
    private static volatile KSLifecycleObserver sKSLifecycleObserver;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mIsInBackground = true;
    private int startedActivityCount = 0;
    private final List<KSLifecycleListener> mListeners = new CopyOnWriteArrayList();
    private boolean mHasInit = false;
    private boolean mEnable = false;

    private KSLifecycleObserver() {
    }

    static /* synthetic */ int access$208(KSLifecycleObserver kSLifecycleObserver) {
        int i = kSLifecycleObserver.startedActivityCount;
        kSLifecycleObserver.startedActivityCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$210(KSLifecycleObserver kSLifecycleObserver) {
        int i = kSLifecycleObserver.startedActivityCount;
        kSLifecycleObserver.startedActivityCount = i - 1;
        return i;
    }

    public static KSLifecycleObserver getInstance() {
        if (sKSLifecycleObserver == null) {
            synchronized (KSLifecycleObserver.class) {
                try {
                    if (sKSLifecycleObserver == null) {
                        sKSLifecycleObserver = new KSLifecycleObserver();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sKSLifecycleObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackToForeground() {
        try {
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
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.api.core.KSLifecycleObserver.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    KSLifecycleObserver.this.mEnable = true;
                    try {
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                            kSLifecycleListener.onActivityCreated(activity, bundle);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    try {
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                            kSLifecycleListener.onActivityDestroyed(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    try {
                        if (KSLifecycleObserver.this.currentActivity != null && KSLifecycleObserver.this.currentActivity.get() != null && ((Activity) KSLifecycleObserver.this.currentActivity.get()).equals(activity)) {
                            KSLifecycleObserver.this.currentActivity = null;
                        }
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
                            kSLifecycleListener.onActivityPaused(activity);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    try {
                        KSLifecycleObserver.this.currentActivity = new WeakReference(activity);
                        for (KSLifecycleListener kSLifecycleListener : KSLifecycleObserver.this.mListeners) {
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
                        KSLifecycleObserver.access$208(KSLifecycleObserver.this);
                        if (KSLifecycleObserver.this.startedActivityCount == 1) {
                            KSLifecycleObserver.this.onAppBackToForeground();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        KSLifecycleObserver.access$210(KSLifecycleObserver.this);
                        if (KSLifecycleObserver.this.startedActivityCount == 0) {
                            KSLifecycleObserver.this.onAppGoToBackground();
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

    public boolean isEnable() {
        return this.mEnable;
    }

    public void registerLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.add(kSLifecycleListener);
    }

    public void unRegisterLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.remove(kSLifecycleListener);
    }
}
