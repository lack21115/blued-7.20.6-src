package com.blued.android.module.shortvideo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IView;
import com.blued.android.module.shortvideo.manager.StvFragmentManager;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.utils.StvDialogUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/ShortVideoBaseFragment.class */
public abstract class ShortVideoBaseFragment<V, T extends ShortVideoBasePresent<V>> extends KeyBoardFragment implements PermissionCallbacks, IView {
    protected static String j = ShortVideoBaseFragment.class.getSimpleName();
    private Dialog b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15743c = false;
    protected T k;
    protected Context l;
    protected ViewGroup m;

    @Override // com.blued.android.framework.permission.PermissionCallbacks
    public void U_() {
    }

    public View a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, Bundle bundle) {
        this.m = (ViewGroup) layoutInflater.inflate(R.layout.activity_stv_base, viewGroup, false);
        this.m.addView(layoutInflater.inflate(i, viewGroup, false));
        b(bundle);
        T c2 = c(bundle);
        this.k = c2;
        if (c2 != null) {
            c2.a(this);
            this.k.a();
        }
        if (getSimpleName().equals(ShineFragment.class.getSimpleName()) || getSimpleName().equals(TrimFragment.class.getSimpleName())) {
            this.b = StvDialogUtils.a(getContext());
        } else {
            this.b = StvDialogUtils.b(getContext());
        }
        if (!getSimpleName().equals(AuthRecorderFragment.class.getSimpleName()) && !getSimpleName().equals(AuthPreviewFragment.class.getSimpleName())) {
            StvFragmentManager.a().a(getClass().getSimpleName());
        }
        h();
        return this.m;
    }

    public void a(float f) {
    }

    public void a(Runnable runnable) {
        postSafeRunOnUiThread(runnable);
    }

    @Override // com.blued.android.framework.permission.PermissionCallbacks
    public void a(String[] strArr) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    protected abstract void b(Bundle bundle);

    @Override // com.blued.android.module.shortvideo.contract.IView
    public void b(boolean z) {
        try {
            if (z) {
                if (this.b == null || this.b.isShowing()) {
                    return;
                }
                this.b.show();
            } else if (this.b == null || !this.b.isShowing()) {
            } else {
                this.b.dismiss();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected abstract T c(Bundle bundle);

    public void c(boolean z) {
    }

    @Override // com.blued.android.module.shortvideo.contract.IView
    public void g() {
        this.f15743c = true;
    }

    protected abstract void h();

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.k == null || getActivity() == null) {
            return;
        }
        this.k.a(getActivity(), i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        T t = this.k;
        return t != null ? t.g() : super.onBackPressed();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getContext();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        T t = this.k;
        if (t != null) {
            t.E();
        }
        if (!getSimpleName().equals(AuthRecorderFragment.class.getSimpleName()) && !getSimpleName().equals(AuthPreviewFragment.class.getSimpleName())) {
            StvFragmentManager.a().b(getClass().getSimpleName());
        }
        super.onDestroy();
        StvLogUtils.a(ShortVideoBaseFragment.class.getSimpleName() + " onDestroy()", new Object[0]);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        T t = this.k;
        if (t != null) {
            t.e();
        }
        AudioManagerUtils.a().a(this.f15743c);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        T t = this.k;
        if (t != null) {
            t.c();
        }
        this.f15743c = false;
        AudioManagerUtils.a().b();
        if (getSimpleName().equals(ShineFragment.class.getSimpleName())) {
            PermissionHelper.c(this);
        } else {
            PermissionHelper.b(this);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        T t = this.k;
        if (t != null) {
            t.a(bundle);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        T t = this.k;
        if (t != null) {
            t.f();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        T t = this.k;
        if (t != null) {
            t.d();
        }
    }
}
