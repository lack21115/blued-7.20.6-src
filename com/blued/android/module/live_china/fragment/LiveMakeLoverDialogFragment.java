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
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverDialogFragment.class */
public class LiveMakeLoverDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f13033a;
    public int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f13034c;
    private MyAdapter d;
    private long e;
    private String f;
    private int g;
    private ILiveMakeLoverDialog h;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverDialogFragment$ILiveMakeLoverDialog.class */
    public interface ILiveMakeLoverDialog {
        void a();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverDialogFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f13035a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f13035a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveMakeLoverDialogFragment.this.b;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                return null;
            }
            if (LiveMakeLoverDialogFragment.this.g == 0) {
                Bundle bundle = new Bundle();
                LiveMakeLoverApplyGuestFragment liveMakeLoverApplyGuestFragment = new LiveMakeLoverApplyGuestFragment();
                bundle.putString("uid", LiveMakeLoverDialogFragment.this.f);
                bundle.putLong("lid", LiveMakeLoverDialogFragment.this.e);
                liveMakeLoverApplyGuestFragment.setArguments(bundle);
                return liveMakeLoverApplyGuestFragment;
            } else if (LiveMakeLoverDialogFragment.this.g == 1) {
                Bundle bundle2 = new Bundle();
                LiveMakeLoverApplyRecordFragment liveMakeLoverApplyRecordFragment = new LiveMakeLoverApplyRecordFragment();
                bundle2.putString("uid", LiveMakeLoverDialogFragment.this.f);
                bundle2.putLong("lid", LiveMakeLoverDialogFragment.this.e);
                liveMakeLoverApplyRecordFragment.setArguments(bundle2);
                return liveMakeLoverApplyRecordFragment;
            } else {
                return null;
            }
        }
    }

    private void d() {
        if (getArguments() != null) {
            this.f = getArguments().getString("uid");
            this.e = getArguments().getLong("lid");
            this.g = getArguments().getInt("from");
        }
    }

    public void a(ILiveMakeLoverDialog iLiveMakeLoverDialog) {
        this.h = iLiveMakeLoverDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f13033a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_make_lover, (ViewGroup) null);
        int a2 = DensityUtils.a(getActivity(), 290.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - a2;
        dialog.onWindowAttributesChanged(attributes);
        d();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_make_lover, viewGroup);
        this.f13034c = (ViewPager) inflate.findViewById(R.id.lover_view_pager);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.d = myAdapter;
        this.f13034c.setAdapter(myAdapter);
        this.f13034c.setCurrentItem(0);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ILiveMakeLoverDialog iLiveMakeLoverDialog = this.h;
        if (iLiveMakeLoverDialog != null) {
            iLiveMakeLoverDialog.a();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
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
