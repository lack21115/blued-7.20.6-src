package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLiangWebDialogFragment.class */
public class LiveLiangWebDialogFragment extends BaseDialogFragment implements PopLiveActivityWebView.PopLiveWebEvent {

    /* renamed from: a  reason: collision with root package name */
    public Context f13000a;
    public PopLiveActivityWebView b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f13001c;
    public ImageView d;
    public ImageView e;
    private ILiveWebDialog f;
    private int g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLiangWebDialogFragment$ILiveWebDialog.class */
    public interface ILiveWebDialog {
        void a();

        void b();
    }

    private void e() {
        if (getArguments() != null) {
            this.g = getArguments().getInt("flag", 0);
        }
    }

    private void f() {
        LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live_china.fragment.LiveLiangWebDialogFragment.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (LiveLiangWebDialogFragment.this.b != null) {
                    LiveLiangWebDialogFragment.this.b.g();
                }
            }
        });
    }

    @Override // com.blued.android.module.live_china.view.PopLiveActivityWebView.PopLiveWebEvent
    public void d() {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f13000a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_liang_web, (ViewGroup) null);
        int height = (getActivity().getWindowManager().getDefaultDisplay().getHeight() - DensityUtils.a(getActivity())) - DensityUtils.a(this.f13000a, 200.0f);
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

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_liang_web, viewGroup);
        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) inflate.findViewById(R.id.live_activity_web_view);
        this.b = popLiveActivityWebView;
        popLiveActivityWebView.a(this);
        this.b.setPopLiveWebEvent(this);
        String E = LiveRoomInfo.a().E();
        String str = E;
        if (!TextUtils.isEmpty(E)) {
            str = E;
            if (!E.contains("?blued_mode=hide_nav")) {
                if (E.contains("?")) {
                    str = E + "&blued_mode=hide_nav";
                } else {
                    str = E + "?blued_mode=hide_nav";
                }
            }
        }
        this.b.a(str, -1, false);
        this.f13001c = (ImageView) inflate.findViewById(R.id.liang_back);
        this.d = (ImageView) inflate.findViewById(R.id.liang_share);
        this.e = (ImageView) inflate.findViewById(R.id.liang_close);
        ILiveWebDialog iLiveWebDialog = this.f;
        if (iLiveWebDialog != null) {
            iLiveWebDialog.a();
        }
        this.f13001c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveLiangWebDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveLiangWebDialogFragment.this.dismiss();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveLiangWebDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (LiveLiangWebDialogFragment.this.f != null) {
                    LiveLiangWebDialogFragment.this.f.b();
                }
                LiveLiangWebDialogFragment.this.dismiss();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveLiangWebDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveLiangWebDialogFragment.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        f();
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
