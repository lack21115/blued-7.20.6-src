package com.blued.android.module.common.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.utils.DialogUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/fragment/LiveBaseDialogFragment.class */
public abstract class LiveBaseDialogFragment extends BaseDialogFragment {
    protected String a;
    protected View b;
    public Bundle c;
    protected LayoutInflater d;
    public Dialog e;
    protected int f = -1;
    protected int g = -1;
    protected int h = 0;
    protected float i = 0.0f;
    private FrameLayout j;

    protected Dialog a(int i) {
        return new Dialog(getContext(), i);
    }

    protected void a(Dialog dialog) {
        View view = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.fragment_live_base_dialog, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        dialog.setContentView(view, layoutParams);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        layoutParams.width = -1;
        layoutParams.height = -1;
        window.setAttributes(attributes);
    }

    public abstract int d();

    protected abstract void e();

    public void f() {
    }

    public void g() {
    }

    public void h() {
        DialogUtils.a(this.e);
    }

    public void i() {
        DialogUtils.b(this.e);
    }

    public void j() {
        dismissAllowingStateLoss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog a = a(R.style.transparentDialogNoAnimStyle);
        a(a);
        return a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = getClass().getSimpleName();
        LogUtils.c(this.a + ".onCreateView");
        this.d = layoutInflater;
        Bundle arguments = getArguments();
        this.c = arguments;
        if (arguments == null) {
            this.c = new Bundle();
        }
        int i = -1;
        this.f = this.c.getInt("dlg_width", -1);
        this.g = this.c.getInt("dlg_height", -1);
        this.h = this.c.getInt("dlg_gravity", 0);
        this.i = this.c.getFloat("dlg_dim", 0.0f);
        LogUtils.c("dlgDim: " + this.i);
        if (this.i > 0.0f && getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setDimAmount(this.i);
        }
        FrameLayout frameLayout = this.j;
        if (frameLayout == null) {
            this.j = (FrameLayout) this.d.inflate(R.layout.fragment_live_base_dialog, viewGroup, false);
            this.b = this.d.inflate(d(), (ViewGroup) null, false);
            int i2 = this.f;
            int i3 = i2;
            if (i2 == -1) {
                i3 = -1;
            }
            int i4 = this.g;
            if (i4 != -1) {
                i = i4;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i);
            int i5 = this.h;
            if (i5 == 1) {
                layoutParams.gravity = 80;
            } else if (i5 == 2) {
                layoutParams.gravity = 48;
            } else {
                layoutParams.gravity = 17;
            }
            this.j.addView(this.b, layoutParams);
            f();
            e();
            this.e = DialogUtils.a((Context) getActivity());
        } else if (frameLayout.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        return this.j;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        DialogUtils.b(this.e);
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g();
    }
}
