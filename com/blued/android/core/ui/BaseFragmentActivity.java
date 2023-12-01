package com.blued.android.core.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.FixedBadParcelHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import skin.support.SkinCompatManager;
import skin.support.content.res.SkinCompatResources;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/BaseFragmentActivity.class */
public class BaseFragmentActivity extends AppCompatActivity implements PageTimeUtils.APMInterface, BluedSkinSupportable {
    public static String a = "";
    public String b;
    private ActivityFragmentActive c = new ActivityFragmentActive(getLifecycle());
    private IOnBackPressedListener d = null;
    private IOnKeyListener e = null;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/BaseFragmentActivity$IOnBackPressedListener.class */
    public interface IOnBackPressedListener {
        boolean onBackPressed();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/BaseFragmentActivity$IOnKeyListener.class */
    public interface IOnKeyListener {
        boolean onKeyDown(int i, KeyEvent keyEvent);

        boolean onKeyUp(int i, KeyEvent keyEvent);
    }

    private boolean f() {
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

    private boolean g() {
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

    private void h() {
        if (TextUtils.isEmpty(this.b)) {
            if (TextUtils.isEmpty(BaseActivity.a)) {
                this.b = i();
            } else {
                this.b = BaseActivity.a + "," + i();
            }
        }
        BaseActivity.a = this.b;
        Page d = BluedStatistics.d();
        String b = b();
        String hexString = Integer.toHexString(hashCode());
        d.a(b, hexString, "[" + this.b + "]");
        StringBuilder sb = new StringBuilder();
        sb.append("curPageRouterName: ");
        sb.append(this.b);
        Log.a("BaseFragmentActivity", sb.toString());
    }

    private String i() {
        return "[\"" + b() + "\"," + System.currentTimeMillis() + "]";
    }

    private String j() {
        return getClass().getSimpleName();
    }

    public ActivityFragmentActive a() {
        ActivityFragmentActive activityFragmentActive = this.c;
        ActivityFragmentActive activityFragmentActive2 = activityFragmentActive;
        if (activityFragmentActive == null) {
            Log.e("BaseFragmentActivity", "current activityActive is null, but someone want to use it");
            activityFragmentActive2 = ActivityFragmentActive.a;
        }
        return activityFragmentActive2;
    }

    public void a(IOnBackPressedListener iOnBackPressedListener) {
        this.d = iOnBackPressedListener;
    }

    public void a(IOnKeyListener iOnKeyListener) {
        this.e = iOnKeyListener;
    }

    public boolean a(Runnable runnable) {
        return UIRunnableManager.a(this.c, runnable, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        if (SkinCompatManager.a() != null) {
            StatusBarHelper.b(this, SkinCompatResources.a().d());
        }
    }

    public void attachBaseContext(Context context) {
        if (AppInfo.b() != null) {
            super.attachBaseContext(AppInfo.b().a(context));
        } else {
            super.attachBaseContext(context);
        }
    }

    protected String b() {
        return PageTimeUtils.d(j());
    }

    public IOnBackPressedListener c() {
        return this.d;
    }

    public IOnKeyListener d() {
        return this.e;
    }

    public boolean e() {
        return false;
    }

    public <T extends View> T findViewById(int i) {
        return (T) super.findViewById(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    @Override // com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return null;
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        a = fragment.getClass().getSimpleName();
    }

    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        a = fragment.getClass().getSimpleName();
    }

    public void onBackPressed() {
        IOnBackPressedListener iOnBackPressedListener = this.d;
        if (iOnBackPressedListener == null || !iOnBackPressedListener.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            FixedBadParcelHelper.a(this, bundle);
        }
        if (Build.VERSION.SDK_INT == 26 && f()) {
            boolean g = g();
            Log.c("BaseFragmentActivity", "onCreate fixOrientation when Oreo, result = " + g);
        }
        super.onCreate(bundle);
        Log.a("BaseFragmentActivity", getClass().getName() + " onCreate()");
        ImageLoaderHostManager.a(this.c, this);
        AppInfo.b((Activity) this);
        if (StatusBarHelper.a() && SkinCompatManager.a() != null) {
            StatusBarHelper.b(this, BluedSkinUtils.c());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.a("BaseFragmentActivity", getClass().getName() + " onDestroy()");
        ActivityFragmentActive activityFragmentActive = this.c;
        if (activityFragmentActive != null) {
            HttpManager.a(activityFragmentActive);
            UIRunnableManager.a(this.c);
            ImageLoaderHostManager.b(this.c);
            this.c.a();
            this.c = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IOnKeyListener iOnKeyListener = this.e;
        if (iOnKeyListener == null || !iOnKeyListener.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IOnKeyListener iOnKeyListener = this.e;
        if (iOnKeyListener == null || !iOnKeyListener.onKeyUp(i, keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        Log.a("BaseFragmentActivity", getClass().getName() + " onPause()");
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.a("BaseFragmentActivity", getClass().getName() + " onPostCreate()");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (AppInfo.b() != null) {
            AppInfo.b().a(this, i, strArr, iArr);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            FixedBadParcelHelper.a(this, bundle);
        }
        super.onRestoreInstanceState(bundle);
        Log.a("BaseFragmentActivity", getClass().getName() + " onRestoreInstanceState()");
        if (bundle != null) {
            this.b = bundle.getString("router_name");
        }
        if (AppInfo.b() != null) {
            AppInfo.b().a(this, bundle);
        }
    }

    public void onResume() {
        super.onResume();
        Log.a("BaseFragmentActivity", getClass().getName() + " onResume()");
        if (getSupportFragmentManager() == null) {
            h();
            return;
        }
        List fragments = getSupportFragmentManager().getFragments();
        if (fragments == null || fragments.size() == 0) {
            h();
        } else if (TextUtils.isEmpty(this.b)) {
            this.b = BaseActivity.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            FixedBadParcelHelper.a(this, bundle);
        }
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("router_name", this.b);
        super.onSaveInstanceState(bundle2);
        Log.a("BaseFragmentActivity", getClass().getName() + " onSaveInstanceState()");
        if (AppInfo.b() != null) {
            AppInfo.b().a(bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        Log.a("BaseFragmentActivity", getClass().getName() + " onStart()");
        if (e()) {
            return;
        }
        PageTimeUtils.a((PageTimeUtils.APMInterface) this);
    }

    public void onStop() {
        super.onStop();
        Log.a("BaseFragmentActivity", getClass().getName() + " onStop()");
        if (e()) {
            return;
        }
        PageTimeUtils.b(this);
    }
}
