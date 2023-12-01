package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/BaseFragment.class */
public class BaseFragment extends Fragment implements BaseFragmentActivity.IOnBackPressedListener, BaseFragmentActivity.IOnKeyListener, PageTimeUtils.APMInterface {
    private static final String TAG = "BaseFragment";
    public String curPageRouterName;
    protected boolean isViewPagerFragment;
    private ActivityFragmentActive fragmentActive = new ActivityFragmentActive(getLifecycle());
    protected boolean isUserVisibleHint = false;
    private boolean isCreated = false;

    private String getRouterName() {
        return "[\"" + getSimpleRouterName() + "\"," + System.currentTimeMillis() + "]";
    }

    protected void generateRouterName() {
        if (isGenerateRouterName()) {
            try {
                if (getParentFragment() != null) {
                    BaseFragment baseFragment = (BaseFragment) getParentFragment();
                    if (TextUtils.isEmpty(baseFragment.curPageRouterName)) {
                        this.curPageRouterName = getRouterName();
                    } else {
                        this.curPageRouterName = baseFragment.curPageRouterName + "," + getRouterName();
                    }
                } else {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) getActivity();
                    if (UiUtils.a((Activity) baseFragmentActivity)) {
                        if (TextUtils.isEmpty(baseFragmentActivity.b)) {
                            this.curPageRouterName = getRouterName();
                        } else {
                            this.curPageRouterName = baseFragmentActivity.b + "," + getRouterName();
                        }
                    }
                }
                BaseActivity.f9718a = this.curPageRouterName;
                Page d = BluedStatistics.d();
                String simpleRouterName = getSimpleRouterName();
                String hexString = Integer.toHexString(hashCode());
                d.a(simpleRouterName, hexString, "[" + this.curPageRouterName + "]");
                StringBuilder sb = new StringBuilder();
                sb.append("curPageRouterName: ");
                sb.append(this.curPageRouterName);
                Log.a(TAG, sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ActivityFragmentActive getFragmentActive() {
        ActivityFragmentActive activityFragmentActive = this.fragmentActive;
        ActivityFragmentActive activityFragmentActive2 = activityFragmentActive;
        if (activityFragmentActive == null) {
            Log.e(TAG, "current fragmentActive is null, but someone want to use it");
            activityFragmentActive2 = ActivityFragmentActive.f9713a;
        }
        return activityFragmentActive2;
    }

    @Override // com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return null;
    }

    public String getSimpleName() {
        return getClass().getSimpleName();
    }

    protected String getSimpleRouterName() {
        return PageTimeUtils.d(getSimpleName());
    }

    public boolean isActivityListenerEnable() {
        return true;
    }

    public boolean isActivitySwipeBackEnable() {
        return true;
    }

    public boolean isClosePageAPM() {
        return false;
    }

    protected boolean isGenerateRouterName() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Log.a(TAG, getClass().getName() + this + " onAttach()");
        super.onAttach(activity);
        if (this.fragmentActive == null) {
            this.fragmentActive = new ActivityFragmentActive(getLifecycle());
        }
        ImageLoaderHostManager.a(this.fragmentActive, this);
        if (isActivityListenerEnable() && (activity instanceof BaseFragmentActivity)) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
            baseFragmentActivity.a((BaseFragmentActivity.IOnBackPressedListener) this);
            baseFragmentActivity.a((BaseFragmentActivity.IOnKeyListener) this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Log.a(TAG, getClass().getName() + this + " onAttach()");
        super.onAttach(context);
        if (this.fragmentActive == null) {
            this.fragmentActive = new ActivityFragmentActive(getLifecycle());
        }
        ImageLoaderHostManager.a(this.fragmentActive, this);
        if ((context instanceof BaseFragmentActivity) && isActivityListenerEnable()) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            baseFragmentActivity.a((BaseFragmentActivity.IOnBackPressedListener) this);
            baseFragmentActivity.a((BaseFragmentActivity.IOnKeyListener) this);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        AppInfo.d(getClass().getSimpleName() + ".onCreate");
        super.onCreate(bundle);
        this.isCreated = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.a(TAG, getClass().getSimpleName() + this + " onCreateView()");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AppInfo.d(getClass().getSimpleName() + ".onDestroy");
        super.onDestroy();
        Log.a(TAG, getClass().getName() + this + " onDestroy()");
        ActivityFragmentActive activityFragmentActive = this.fragmentActive;
        if (activityFragmentActive != null) {
            HttpManager.a(activityFragmentActive);
            ImageLoaderHostManager.b(this.fragmentActive);
            this.fragmentActive.a();
            this.fragmentActive = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.a(TAG, getClass().getName() + this + " onDestroyView()");
        ActivityFragmentActive activityFragmentActive = this.fragmentActive;
        if (activityFragmentActive != null) {
            UIRunnableManager.a(activityFragmentActive);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Log.a(TAG, getClass().getName() + this + " onDetach()");
        FragmentActivity activity = getActivity();
        if (isActivityListenerEnable() && (activity instanceof BaseFragmentActivity)) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
            if (this == baseFragmentActivity.c()) {
                baseFragmentActivity.a((BaseFragmentActivity.IOnBackPressedListener) null);
            }
            if (this == baseFragmentActivity.d()) {
                baseFragmentActivity.a((BaseFragmentActivity.IOnKeyListener) null);
            }
        }
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
        Log.a(TAG, getClass().getName() + this + " onPause()");
        if (AppInfo.b() != null) {
            AppInfo.b().b(getSimpleName());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
        Log.a(TAG, getClass().getName() + this + " onResume()");
        RecyclingImageLoader.c();
        if (AppInfo.b() != null) {
            AppInfo.b().a(getSimpleName());
        }
        if (!this.isViewPagerFragment) {
            generateRouterName();
        } else if (this.isUserVisibleHint) {
            generateRouterName();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("router_name", this.curPageRouterName);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Log.a(TAG, getClass().getName() + this + " onStart()");
        if (!getUserVisibleHint() || isClosePageAPM()) {
            return;
        }
        PageTimeUtils.a((PageTimeUtils.APMInterface) this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Log.a(TAG, getClass().getName() + this + " onStop()");
        if (isClosePageAPM()) {
            return;
        }
        PageTimeUtils.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        if (bundle != null) {
            this.curPageRouterName = bundle.getString("router_name");
        }
        super.onViewStateRestored(bundle);
    }

    public boolean postDelaySafeRunOnUiThread(Runnable runnable, long j) {
        return UIRunnableManager.a(this.fragmentActive, runnable, j);
    }

    public boolean postSafeRunOnUiThread(Runnable runnable) {
        return UIRunnableManager.a(this.fragmentActive, runnable, 0L);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
        this.isViewPagerFragment = true;
        this.isUserVisibleHint = z;
        Log.a(TAG, getClass().getName() + this + " setUserVisibleHint(), isVisibleToUser:" + z + ", isCreated:" + this.isCreated);
        if (this.isCreated) {
            if (z) {
                generateRouterName();
            }
            if (isClosePageAPM()) {
                return;
            }
            if (z) {
                PageTimeUtils.a((PageTimeUtils.APMInterface) this);
            } else {
                PageTimeUtils.b(this);
            }
        }
    }
}
