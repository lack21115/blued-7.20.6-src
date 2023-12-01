package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansWebDialogFragment.class */
public class LiveFansWebDialogFragment extends BaseDialogFragment implements PopLiveActivityWebView.PopLiveWebEvent {
    public Context a;
    public PopLiveActivityWebView b;
    public String c;
    public int d;
    private ILiveWebDialog e;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansWebDialogFragment$ILiveWebDialog.class */
    public interface ILiveWebDialog {
        void a();

        void b();
    }

    private void e() {
        if (getArguments() != null) {
            this.c = getArguments().getString("url");
            this.d = getArguments().getInt("type");
        }
    }

    @Override // com.blued.android.module.live_china.view.PopLiveActivityWebView.PopLiveWebEvent
    public void d() {
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_web, (ViewGroup) null);
        int height = (getActivity().getWindowManager().getDefaultDisplay().getHeight() - DensityUtils.a(getActivity())) - DensityUtils.a(this.a, 0.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, height));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = height;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - height;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_web, viewGroup);
        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) inflate.findViewById(R.id.live_activity_web_view);
        this.b = popLiveActivityWebView;
        popLiveActivityWebView.a((Fragment) this);
        this.b.setPopLiveWebEvent(this);
        this.b.b(this.c, this.d);
        ILiveWebDialog iLiveWebDialog = this.e;
        if (iLiveWebDialog != null) {
            iLiveWebDialog.a();
        }
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        ILiveWebDialog iLiveWebDialog = this.e;
        if (iLiveWebDialog != null) {
            iLiveWebDialog.b();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
