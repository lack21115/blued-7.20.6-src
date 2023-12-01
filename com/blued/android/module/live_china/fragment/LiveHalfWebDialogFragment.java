package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHalfWebDialogFragment.class */
public class LiveHalfWebDialogFragment extends BaseDialogFragment implements PopLiveActivityWebView.PopLiveWebEvent {

    /* renamed from: a  reason: collision with root package name */
    protected View f12954a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public PopLiveActivityWebView f12955c;
    private ILiveWebDialog d;
    private String e;
    private int f;
    private boolean g;
    private int h = 0;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHalfWebDialogFragment$ILiveWebDialog.class */
    public interface ILiveWebDialog {
        void a();
    }

    private void g() {
        if (getArguments() != null) {
            this.e = getArguments().getString("url");
            this.f = getArguments().getInt("webview_radius");
            this.g = getArguments().getBoolean("fullScreen");
            this.h = getArguments().getInt("height", 0);
            if (this.f == 0) {
                this.f = 25;
            }
        }
        if (TextUtils.isEmpty(this.e)) {
            dismissAllowingStateLoss();
        }
    }

    private void h() {
        LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live_china.fragment.LiveHalfWebDialogFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (LiveHalfWebDialogFragment.this.f12955c != null) {
                    LiveHalfWebDialogFragment.this.f12955c.g();
                }
            }
        });
    }

    public void a(HTMLNoticeModel hTMLNoticeModel) {
        if (hTMLNoticeModel == null || TextUtils.isEmpty(hTMLNoticeModel.html_msg) || TextUtils.isEmpty(hTMLNoticeModel.html_href)) {
            return;
        }
        this.f12955c.setJsBridgeData(hTMLNoticeModel);
    }

    @Override // com.blued.android.module.live_china.view.PopLiveActivityWebView.PopLiveWebEvent
    public void d() {
        dismiss();
    }

    protected int e() {
        return R.layout.dialog_live_activty_web;
    }

    public boolean f() {
        if (getDialog() != null) {
            return getDialog().isShowing();
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.b = getActivity();
        g();
        View inflate = getActivity().getLayoutInflater().inflate(e(), (ViewGroup) null);
        WindowManager windowManager = getActivity().getWindowManager();
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        int i = this.h;
        int i2 = i;
        if (i == 0) {
            i2 = point.y - (this.g ? 0 : DensityUtils.a(getActivity()) + DensityUtils.a(this.b, 250.0f));
        }
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, i2));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = i2;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - i2;
        if (this.h == 0 && this.g) {
            if (Build.VERSION.SDK_INT < 19) {
                window.setFlags(1024, 1024);
            } else {
                window.setFlags(67108864, 67108864);
            }
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(e(), viewGroup);
        this.f12954a = inflate;
        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) inflate.findViewById(R.id.live_activity_web_view);
        this.f12955c = popLiveActivityWebView;
        popLiveActivityWebView.a(this);
        this.f12955c.setWebViewRadius(this.f);
        this.f12955c.setPopLiveWebEvent(this);
        if (!TextUtils.isEmpty(this.e) && !this.e.contains("blued_mode=hide_nav")) {
            if (this.e.contains("?")) {
                this.e += "&blued_mode=hide_nav";
            } else {
                this.e += "?blued_mode=hide_nav";
            }
        }
        this.f12955c.a(this.e, -1, false);
        ILiveWebDialog iLiveWebDialog = this.d;
        if (iLiveWebDialog != null) {
            iLiveWebDialog.a();
        }
        return this.f12954a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        h();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
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
