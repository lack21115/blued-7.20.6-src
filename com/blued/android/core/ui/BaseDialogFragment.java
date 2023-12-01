package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import java.lang.reflect.Field;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/BaseDialogFragment.class */
public class BaseDialogFragment extends DialogFragment implements DialogInterface.OnKeyListener, BaseFragmentActivity.IOnBackPressedListener, PageTimeUtils.APMInterface {
    private ActivityFragmentActive a = new ActivityFragmentActive(getLifecycle());
    private DialogInterface.OnDismissListener b;

    public boolean S_() {
        return false;
    }

    public ActivityFragmentActive a() {
        ActivityFragmentActive activityFragmentActive = this.a;
        ActivityFragmentActive activityFragmentActive2 = activityFragmentActive;
        if (activityFragmentActive == null) {
            Log.e("BaseDialogFragment", "current fragmentActive is null, but someone want to use it");
            activityFragmentActive2 = ActivityFragmentActive.a;
        }
        return activityFragmentActive2;
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.b = onDismissListener;
    }

    public boolean a(Runnable runnable) {
        return UIRunnableManager.a(this.a, runnable, 0L);
    }

    public boolean a(Runnable runnable, long j) {
        return UIRunnableManager.a(this.a, runnable, j);
    }

    public String b() {
        return getClass().getSimpleName();
    }

    @Override // com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return null;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ImageLoaderHostManager.a(this.a, this);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        ImageLoaderHostManager.a(this.a, this);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        try {
            dismissAllowingStateLoss();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppInfo.d(getClass().getSimpleName() + ".onCreateView");
        Log.a("BaseDialogFragment", getClass().getName() + " onCreateView()");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.a("BaseDialogFragment", getClass().getName() + " onDestroy()");
        ActivityFragmentActive activityFragmentActive = this.a;
        if (activityFragmentActive != null) {
            HttpManager.a(activityFragmentActive);
            ImageLoaderHostManager.b(this.a);
            this.a.a();
            this.a = null;
        }
    }

    public void onDestroyView() {
        AppInfo.d(getClass().getSimpleName() + ".onDestroyView");
        super.onDestroyView();
        Log.a("BaseDialogFragment", getClass().getName() + " onDestroyView()");
        ActivityFragmentActive activityFragmentActive = this.a;
        if (activityFragmentActive != null) {
            UIRunnableManager.a(activityFragmentActive);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.b;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            onBackPressed();
            return true;
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        if (AppInfo.b() != null) {
            AppInfo.b().b(b());
        }
    }

    public void onResume() {
        super.onResume();
        Log.a("BaseDialogFragment", getClass().getName() + " onResume()");
        RecyclingImageLoader.c();
        if (AppInfo.b() != null) {
            AppInfo.b().a(b());
        }
    }

    public void onStart() {
        super.onStart();
        if (!S_()) {
            PageTimeUtils.a((PageTimeUtils.APMInterface) this);
        }
        Log.a("BaseDialogFragment", getClass().getName() + " onStart()");
    }

    public void onStop() {
        super.onStop();
        if (!S_()) {
            PageTimeUtils.b(this);
        }
        Log.a("BaseDialogFragment", getClass().getName() + " onStop()");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getDialog() != null) {
            getDialog().setOnKeyListener(this);
        }
    }

    public void setUserVisibleHint(boolean z) {
        Log.a("BaseDialogFragment", getClass().getName() + " setUserVisibleHint(), isVisibleToUser:" + z);
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, false);
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
