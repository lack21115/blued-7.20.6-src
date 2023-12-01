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
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBaseDialogFragment.class */
public abstract class LiveBaseDialogFragment<T> extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f12719a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public IDialogEvent f12720c;
    private ViewPager d;
    private FragmentPagerAdapter e;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBaseDialogFragment$IDialogEvent.class */
    public interface IDialogEvent<T> {
        void a();

        void a(T t);
    }

    public void a(IDialogEvent iDialogEvent) {
        this.f12720c = iDialogEvent;
    }

    public void a(T t) {
    }

    public void b(T t) {
        IDialogEvent iDialogEvent = this.f12720c;
        if (iDialogEvent != null) {
            iDialogEvent.a(t);
        }
    }

    public abstract void d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract FragmentPagerAdapter h();

    public void i() {
        IDialogEvent iDialogEvent = this.f12720c;
        if (iDialogEvent != null) {
            iDialogEvent.a();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f12719a = getContext();
        this.b = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_base_view, (ViewGroup) null);
        int f = f();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(this.b, new ViewGroup.LayoutParams(-1, f));
        Window window = dialog.getWindow();
        window.setWindowAnimations(g());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = e();
        attributes.height = f;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - f;
        dialog.onWindowAttributesChanged(attributes);
        LiveEventBus.get("live_dialog_cancel", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                LiveBaseDialogFragment.this.dismiss();
            }
        });
        d();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_base_view, viewGroup);
        this.d = (ViewPager) inflate.findViewById(R.id.lover_view_pager);
        FragmentPagerAdapter h = h();
        this.e = h;
        this.d.setAdapter(h);
        this.d.setCurrentItem(0);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i();
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
