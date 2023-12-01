package com.blued.android.module.common.base.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.ui.xpop.widget.SmartDragLayout;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/CommonDialogFragment.class */
public abstract class CommonDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static String f10640a = "enable_drag";
    private boolean b = false;

    private void a(final SmartDragLayout smartDragLayout) {
        smartDragLayout.b(true);
        smartDragLayout.c(true);
        smartDragLayout.d(false);
        smartDragLayout.a(false);
        smartDragLayout.setOnCloseListener(new SmartDragLayout.OnCloseListener() { // from class: com.blued.android.module.common.base.dialog.CommonDialogFragment.1
            @Override // com.blued.android.framework.ui.xpop.widget.SmartDragLayout.OnCloseListener
            public void a() {
                CommonDialogFragment.this.dismiss();
            }

            @Override // com.blued.android.framework.ui.xpop.widget.SmartDragLayout.OnCloseListener
            public void a(int i, float f, boolean z) {
            }

            @Override // com.blued.android.framework.ui.xpop.widget.SmartDragLayout.OnCloseListener
            public void b() {
            }
        });
        smartDragLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.base.dialog.CommonDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommonDialogFragment.this.dismiss();
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.common.base.dialog.CommonDialogFragment.3
            @Override // java.lang.Runnable
            public void run() {
                smartDragLayout.a();
            }
        }, 50L);
    }

    public abstract void a(View view);

    public abstract int d();

    public int e() {
        return AppInfo.l;
    }

    public int f() {
        return AppInfo.m;
    }

    protected boolean g() {
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity(), R.style.FilterDialogFragment);
        dialog.getWindow().addFlags(Integer.MIN_VALUE);
        dialog.getWindow().setStatusBarColor(0);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (g()) {
            getActivity().getWindow().setSoftInputMode(48);
        }
        getDialog().requestWindowFeature(1);
        Window window = getDialog().getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.windowAnimations = R.style.BottomDialogAnimation;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(e(), f());
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(f10640a)) {
            this.b = true;
        }
        View view = null;
        if (!this.b) {
            if (d() != 0) {
                view = layoutInflater.inflate(d(), (ViewGroup) window.findViewById(16908290), false);
                a(view);
            }
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout._xpopup_bottom_popup_view, (ViewGroup) window.findViewById(16908290), false);
        if (d() != 0) {
            View inflate2 = layoutInflater.inflate(d(), (ViewGroup) null, false);
            SmartDragLayout smartDragLayout = (SmartDragLayout) inflate.findViewById(R.id.bottomPopupContainer);
            smartDragLayout.addView(inflate2);
            a(smartDragLayout);
            a(inflate2);
        }
        return inflate;
    }
}
