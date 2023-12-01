package com.kwad.sdk.core.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/b/a.class */
public final class a implements Application.ActivityLifecycleCallbacks {
    private final List<WeakReference<Activity>> afO;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mEnable;
    private boolean mIsInBackground;
    private final List<c> mListeners;

    /* renamed from: com.kwad.sdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/b/a$a.class */
    static final class C0384a {
        static final a afP = new a((byte) 0);
    }

    private a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.afO = new ArrayList();
        this.mEnable = false;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private void e(Activity activity) {
        for (WeakReference<Activity> weakReference : this.afO) {
            if (weakReference.get() == activity) {
                return;
            }
        }
        this.afO.add(new WeakReference<>(activity));
    }

    private void f(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.afO.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    public static a vQ() {
        return C0384a.afP;
    }

    private boolean vR() {
        return b.vT() || !this.mEnable;
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(Context context) {
        try {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (vR()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.onActivityCreated(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (vR()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.onActivityDestroyed(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (vR()) {
            return;
        }
        try {
            for (c cVar : this.mListeners) {
                cVar.onActivityPaused(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (vR()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            for (c cVar : this.mListeners) {
                cVar.onActivityResumed(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (vR()) {
            return;
        }
        try {
            e(activity);
            if (this.afO.size() == 1) {
                this.mIsInBackground = false;
                for (c cVar : this.mListeners) {
                    cVar.onBackToForeground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (vR()) {
            return;
        }
        try {
            f(activity);
            if (this.afO.size() == 0) {
                this.mIsInBackground = true;
                for (c cVar : this.mListeners) {
                    cVar.onBackToBackground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
