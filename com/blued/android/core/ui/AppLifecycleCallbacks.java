package com.blued.android.core.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.core.utils.skin.BluedSkinPreferences;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/AppLifecycleCallbacks.class */
public class AppLifecycleCallbacks implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9715c = false;
    private static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private Activity f9716a;

    public AppLifecycleCallbacks(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    private void a(Activity activity) {
        boolean a2;
        if (activity != null && BluedSkinUtils.a()) {
            Log.e("AppLifecycleCallbacks", "changeSkin ... ");
            if (Build.VERSION.SDK_INT >= 29 && BluedSkinPreferences.a() && BluedSkinPreferences.b() != (a2 = BluedSkinUtils.a(activity))) {
                BluedSkinPreferences.b(a2);
                if (a2) {
                    b(activity);
                } else {
                    BluedSkinUtils.b();
                }
            }
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
        f9715c = false;
    }

    private void b(final Activity activity) {
        BluedSkinUtils.a("night.skin", new BluedSkinLoaderListener() { // from class: com.blued.android.core.ui.AppLifecycleCallbacks.1
            @Override // com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener
            public void a() {
            }

            @Override // com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener
            public void a(String str) {
            }

            @Override // com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener
            public void b() {
                StatusBarHelper.a(activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        ActivityStack.a().a(activity);
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        ActivityStack.a().b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f9716a = activity;
        RecyclingImageLoader.c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Log.e("AppLifecycleCallbacks", "onActivityStarted:" + activity.getClass().getName());
        this.f9716a = activity;
        if (activity.getClass().getName().equals(b) || f9715c) {
            onAppStart();
            return;
        }
        f9715c = true;
        onAppStart();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        boolean z = !UiUtils.a((Context) activity);
        Log.e("AppLifecycleCallbacks", "onActivityStopped appOnBackground = " + z);
        if (z) {
            onAppStop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppStart() {
        Log.e("AppLifecycleCallbacks", "-- onAppStart : " + d);
        Activity activity = this.f9716a;
        if ((activity == null || !activity.getClass().getName().equals(b)) && !d) {
            d = true;
            Log.e("AppLifecycleCallbacks", "-- setAppInForeground");
            AppInfo.a(this.f9716a);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppStop() {
        Log.e("AppLifecycleCallbacks", "-- onAppStop : " + d);
        if (d) {
            d = false;
            Log.e("AppLifecycleCallbacks", "-- setAppInBackground");
            AppInfo.h();
        }
        this.f9716a = null;
    }
}
