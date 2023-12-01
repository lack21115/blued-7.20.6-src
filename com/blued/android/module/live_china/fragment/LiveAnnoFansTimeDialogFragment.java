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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.view.scrollpicker.StringScrollPicker;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoFansTimeDialogFragment.class */
public class LiveAnnoFansTimeDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    List<CharSequence> a;
    IEventCallback b;
    private View c;
    private StringScrollPicker d;
    private Context e;
    private int f;
    private boolean g = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveAnnoFansTimeDialogFragment$IEventCallback.class */
    public interface IEventCallback {
        void save(int i);
    }

    private void d() {
        if (getArguments() != null) {
            this.f = getArguments().getInt("aheadTime");
        }
    }

    private void e() {
        this.d = (StringScrollPicker) this.c.findViewById(R.id.sp_ahead_time);
        this.c.findViewById(R.id.tv_cancel).setOnClickListener(this);
        this.c.findViewById(R.id.tv_save).setOnClickListener(this);
        f();
    }

    private void f() {
        this.a = new ArrayList();
        int i = 0;
        while (i < 12) {
            List<CharSequence> list = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("开播前");
            i++;
            sb.append(i);
            sb.append("0分钟");
            list.add(sb.toString());
        }
        this.d.setData(this.a);
        StringScrollPicker stringScrollPicker = this.d;
        int i2 = this.f;
        stringScrollPicker.setSelectedPosition(i2 < 10 ? 0 : (i2 / 10) - 1);
    }

    private boolean g() {
        if (this.b == null) {
            return true;
        }
        int selectedPosition = (this.d.getSelectedPosition() + 1) * 10;
        this.f = selectedPosition;
        this.b.save(selectedPosition);
        return true;
    }

    public void a(IEventCallback iEventCallback) {
        this.b = iEventCallback;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_cancel) {
            dismissAllowingStateLoss();
        } else if (view.getId() == R.id.tv_save && g()) {
            dismissAllowingStateLoss();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.e = getContext();
        this.g = true;
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_announce_ahead_time, (ViewGroup) null);
        int a = DensityUtils.a(this.e, 364.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a;
        dialog.onWindowAttributesChanged(attributes);
        d();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.c;
        if (view == null) {
            this.c = layoutInflater.inflate(R.layout.dialog_live_announce_ahead_time, viewGroup, false);
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveAnnoFansTimeDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                LiveAnnoFansTimeDialogFragment.this.g = false;
            }
        }, 300L);
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
