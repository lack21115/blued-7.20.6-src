package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.view.PageTabLayout;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.ui.msg.ShareToGroupsFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/YYInviteFragment.class */
public class YYInviteFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f21003a;
    private ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    private PageTabLayout f21004c;
    private Bundle d;
    private View e;
    private View f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/fragment/YYInviteFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        private String[] b;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.b = YYInviteFragment.this.d();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return i != 1 ? i != 2 ? InviteChatRecentFragment.a(YYInviteFragment.this.d) : ShareToGroupsFragment.a(YYInviteFragment.this.d) : InviteFriendsFragment.a(YYInviteFragment.this.d);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b[i];
        }
    }

    private void e() {
        this.f = this.e.findViewById(R.id.invite_default_view);
        this.b = (ViewPager) this.e.findViewById(R.id.invite_pagers);
        this.f21004c = this.e.findViewById(R.id.invite_tablayout);
        this.b.setId(R.id.invite_pagers);
        this.f21004c.setupWithViewPager(this.b);
        this.b.setAdapter(new MyAdapter(getChildFragmentManager()));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.yy_room.fragment.YYInviteFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYInviteFragment.this.dismiss();
            }
        });
    }

    public String[] d() {
        return new String[]{getResources().getString(2131893151), getResources().getString(2131892981)};
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getDialog().getWindow().getDecorView().setSystemUiVisibility(9216);
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setLayout(-1, -1);
        this.d = getArguments();
        e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21003a = getActivity();
        setStyle(0, 2131952825);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_yy_invite_layout, viewGroup, false);
        this.e = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
