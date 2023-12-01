package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;
import com.bytedance.applog.tracker.Tracker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/BaseActivity.class */
public class BaseActivity extends Activity implements LifecycleOwner, PageTimeUtils.APMInterface {
    public static String a = "";
    public String b;
    protected Intent c = null;
    public LifecycleRegistry d = new LifecycleRegistry(this);
    private ActivityFragmentActive e = new ActivityFragmentActive(getLifecycle());

    private boolean c() {
        boolean z;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return z;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    private boolean d() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String e() {
        return "[\"" + a() + "\"," + System.currentTimeMillis() + "]";
    }

    private String f() {
        return getClass().getSimpleName();
    }

    protected String a() {
        return PageTimeUtils.d(f());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        if (AppInfo.b() != null) {
            super.attachBaseContext(AppInfo.b().a(context));
        } else {
            super.attachBaseContext(context);
        }
    }

    public boolean b() {
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public Lifecycle getLifecycle() {
        return this.d;
    }

    @Override // com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && c()) {
            boolean d = d();
            Log.c("BaseActivity", "onCreate fixOrientation when Oreo, result = " + d);
        }
        super.onCreate(bundle);
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Log.a("BaseActivity", getClass().getName() + " onCreate()");
        requestWindowFeature(1);
        ImageLoaderHostManager.a(this.e, this);
        AppInfo.b(this);
        this.c = getIntent();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        Log.a("BaseActivity", getClass().getName() + " onCreate()");
        ActivityFragmentActive activityFragmentActive = this.e;
        if (activityFragmentActive != null) {
            HttpManager.a(activityFragmentActive);
            UIRunnableManager.a(this.e);
            ImageLoaderHostManager.b(this.e);
            this.e.a();
            this.e = null;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.a("BaseActivity", getClass().getName() + " onNewIntent()");
        this.c = intent;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (AppInfo.b() != null) {
            AppInfo.b().a(this, i, strArr, iArr);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Log.a("BaseActivity", getClass().getName() + " onRestoreInstanceState()");
        if (bundle != null) {
            this.b = bundle.getString("router_name");
        }
        if (AppInfo.b() != null) {
            AppInfo.b().a(this, bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (TextUtils.isEmpty(this.b)) {
            if (TextUtils.isEmpty(a)) {
                this.b = e();
            } else {
                this.b = a + "," + e();
            }
        }
        a = this.b;
        Page d = BluedStatistics.d();
        String a2 = a();
        String hexString = Integer.toHexString(hashCode());
        d.a(a2, hexString, "[" + this.b + "]");
        StringBuilder sb = new StringBuilder();
        sb.append("curPageRouterName: ");
        sb.append(this.b);
        Log.a("BaseActivity", sb.toString());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("router_name", this.b);
        super.onSaveInstanceState(bundle2);
        Log.a("BaseActivity", getClass().getName() + " onSaveInstanceState()");
        if (AppInfo.b() != null) {
            AppInfo.b().a(bundle2);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_START);
        Log.a("BaseActivity", getClass().getName() + " onStart()");
        if (b()) {
            return;
        }
        PageTimeUtils.a((PageTimeUtils.APMInterface) this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        Log.a("BaseActivity", getClass().getName() + " onStop()");
        if (b()) {
            return;
        }
        PageTimeUtils.b(this);
    }
}
