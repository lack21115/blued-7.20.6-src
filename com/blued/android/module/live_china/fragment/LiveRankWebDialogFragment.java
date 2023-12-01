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
import androidx.fragment.app.Fragment;
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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankWebDialogFragment.class */
public class LiveRankWebDialogFragment extends BaseDialogFragment implements PopLiveActivityWebView.PopLiveWebEvent {
    public Context a;
    public PopLiveActivityWebView b;
    public ImageView c;
    private ILiveWebDialog d;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRankWebDialogFragment$ILiveWebDialog.class */
    public interface ILiveWebDialog {
        void a();
    }

    private void e() {
    }

    private void f() {
        LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live_china.fragment.LiveRankWebDialogFragment.2
            /* renamed from: a */
            public void onChanged(String str) {
                if (LiveRankWebDialogFragment.this.b != null) {
                    LiveRankWebDialogFragment.this.b.g();
                }
            }
        });
    }

    @Override // com.blued.android.module.live_china.view.PopLiveActivityWebView.PopLiveWebEvent
    public void d() {
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_rank_web, (ViewGroup) null);
        int height = (getActivity().getWindowManager().getDefaultDisplay().getHeight() - DensityUtils.a(getActivity())) - DensityUtils.a(this.a, 200.0f);
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
        View inflate = layoutInflater.inflate(R.layout.dialog_live_rank_web, viewGroup);
        PopLiveActivityWebView popLiveActivityWebView = (PopLiveActivityWebView) inflate.findViewById(R.id.live_activity_web_view);
        this.b = popLiveActivityWebView;
        popLiveActivityWebView.a((Fragment) this);
        this.b.setPopLiveWebEvent(this);
        String F = LiveRoomInfo.a().F();
        String str = F;
        if (!TextUtils.isEmpty(F)) {
            str = F;
            if (!F.contains("?blued_mode=hide_nav")) {
                if (F.contains("?")) {
                    str = F + "&blued_mode=hide_nav";
                } else {
                    str = F + "?blued_mode=hide_nav";
                }
            }
        }
        this.b.a(str, -1, false);
        this.c = (ImageView) inflate.findViewById(R.id.iv_close);
        ILiveWebDialog iLiveWebDialog = this.d;
        if (iLiveWebDialog != null) {
            iLiveWebDialog.a();
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRankWebDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRankWebDialogFragment.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        f();
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
