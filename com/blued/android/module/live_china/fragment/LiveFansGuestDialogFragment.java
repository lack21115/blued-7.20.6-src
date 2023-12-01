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
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGuestDialogFragment.class */
public class LiveFansGuestDialogFragment extends BaseDialogFragment {
    public static int d;
    public Context a;
    public View c;
    public LiveFansWebDialogFragment e;
    private ViewPager f;
    private MyAdapter g;
    private int h;
    private long i;
    private short j;
    private String k;
    private int l;
    private boolean m;
    private ILiveFansGuestDialog n;
    public int b = 2;
    private ViewPager.OnPageChangeListener o = new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansGuestDialogFragment.1
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            LiveFansGuestDialogFragment.this.h = i;
            int unused = LiveFansGuestDialogFragment.this.h;
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGuestDialogFragment$ILiveFansGuestDialog.class */
    public interface ILiveFansGuestDialog {
        void t_();

        void u_();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGuestDialogFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        FragmentManager a;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.a = fragmentManager;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        public int getCount() {
            return LiveFansGuestDialogFragment.this.b;
        }

        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                Bundle bundle = new Bundle();
                bundle.putLong("lid", LiveFansGuestDialogFragment.this.i);
                bundle.putInt("from", 0);
                LiveFansMemberFragment liveFansMemberFragment = new LiveFansMemberFragment();
                liveFansMemberFragment.setArguments(bundle);
                return liveFansMemberFragment;
            }
            Bundle bundle2 = new Bundle();
            LiveFansGuestFragment liveFansGuestFragment = new LiveFansGuestFragment();
            bundle2.putString("uid", LiveFansGuestDialogFragment.this.k);
            bundle2.putLong("lid", LiveFansGuestDialogFragment.this.i);
            bundle2.putInt("level", LiveFansGuestDialogFragment.this.l);
            bundle2.putShort(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, LiveFansGuestDialogFragment.this.j);
            bundle2.putBoolean("DefaultTagFansGroup", LiveFansGuestDialogFragment.this.m);
            liveFansGuestFragment.setArguments(bundle2);
            return liveFansGuestFragment;
        }
    }

    private void e() {
        if (getArguments() != null) {
            this.k = getArguments().getString("uid");
            this.i = getArguments().getLong("lid");
            this.l = getArguments().getInt("level");
            this.m = getArguments().getBoolean("DefaultTagFansGroup");
            this.j = getArguments().getShort(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE);
            if (LiveRoomManager.a().s()) {
                this.b = 2;
            } else {
                this.b = 1;
            }
        }
    }

    public void a(int i) {
        this.f.setCurrentItem(i);
    }

    public void a(ILiveFansGuestDialog iLiveFansGuestDialog) {
        this.n = iLiveFansGuestDialog;
    }

    public void b(int i) {
        if (getDialog() == null) {
            return;
        }
        Window window = getDialog().getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = i;
        attributes.x = 0;
        attributes.y = AppInfo.m - i;
        getDialog().onWindowAttributesChanged(attributes);
    }

    public void d() {
        this.e = new LiveFansWebDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", LiveRoomInfo.a().B());
        bundle.putInt("type", 0);
        this.e.setArguments(bundle);
        this.e.show(getFragmentManager(), "webDialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        int i = AppInfo.m;
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = i;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - i;
        dialog.onWindowAttributesChanged(attributes);
        e();
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_fans_guest, viewGroup);
        this.c = inflate;
        this.f = inflate.findViewById(R.id.fans_view_pager);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.g = myAdapter;
        this.f.setAdapter(myAdapter);
        this.f.setOffscreenPageLimit(2);
        this.f.setOnPageChangeListener(this.o);
        ILiveFansGuestDialog iLiveFansGuestDialog = this.n;
        if (iLiveFansGuestDialog != null) {
            iLiveFansGuestDialog.t_();
        }
        int i = d;
        if (i == 0 || i == 1) {
            this.f.setCurrentItem(d);
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_FANS_ENTER_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        return this.c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        ILiveFansGuestDialog iLiveFansGuestDialog = this.n;
        if (iLiveFansGuestDialog != null) {
            iLiveFansGuestDialog.u_();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onPause() {
        Dialog dialog;
        super.onPause();
        LiveFansWebDialogFragment liveFansWebDialogFragment = this.e;
        if (liveFansWebDialogFragment == null || (dialog = liveFansWebDialogFragment.getDialog()) == null || !dialog.isShowing()) {
            return;
        }
        this.e.dismiss();
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
