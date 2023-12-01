package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.setting.fragment.FriendslistFragment;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/FollowedAndFansFragment.class */
public class FollowedAndFansFragment extends BaseFragment implements FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver {

    /* renamed from: a  reason: collision with root package name */
    private Context f33855a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f33856c;
    private ImageView d;
    private ImageView e;
    private ViewPager f;
    private BaseFragment g;
    private FansFragment h;
    private FriendslistFragment i;
    private MyAdapter j;
    private ArrayList<BaseFragment> k = new ArrayList<>();
    private String l = "";

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/FollowedAndFansFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return FollowedAndFansFragment.this.k.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return FollowedAndFansFragment.this.i;
                }
                return FollowedAndFansFragment.this.h;
            }
            return FollowedAndFansFragment.this.g;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (FollowedAndFansFragment.this.d()) {
                return new String[]{FollowedAndFansFragment.this.f33855a.getResources().getString(2131886495), FollowedAndFansFragment.this.f33855a.getResources().getString(R.string.fans), FollowedAndFansFragment.this.f33855a.getResources().getString(2131888205)}[i];
            }
            String[] strArr = {FollowedAndFansFragment.this.f33855a.getResources().getString(2131886495), FollowedAndFansFragment.this.f33855a.getResources().getString(R.string.fans)};
            return i < 2 ? strArr[i] : strArr[1];
        }
    }

    private void a() {
        if (getArguments() != null) {
            if ("fans".equals(getArguments().getString("followed_or_fan"))) {
                this.f.setCurrentItem(1);
            }
            if ("followed".equals(getArguments().getString("followed_or_fan"))) {
                this.f.setCurrentItem(0);
            }
        }
    }

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        TerminalActivity.d(context, FollowedAndFansFragment.class, bundle);
    }

    private void b() {
        View findViewById = this.b.findViewById(2131370694);
        this.f33856c = findViewById;
        findViewById.setVisibility(0);
        this.d = (ImageView) this.f33856c.findViewById(2131363120);
        this.e = (ImageView) this.f33856c.findViewById(2131363126);
        this.d.setVisibility(0);
        this.d.setImageDrawable(BluedSkinUtils.b(this.f33855a, 2131233902));
        this.e.setVisibility(4);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.FollowedAndFansFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FollowedAndFansFragment.this.getActivity().finish();
            }
        });
    }

    private void c() {
        this.f = (ViewPager) this.b.findViewById(R.id.main_find_viewpager);
        this.h = new FansFragment();
        if (d()) {
            this.g = new FollowedTabsFragment();
        } else {
            this.g = new NormalFollowedFragment();
        }
        this.i = new FriendslistFragment();
        this.k.clear();
        this.k.add(this.h);
        this.k.add(this.g);
        if (d()) {
            this.k.add(this.i);
        }
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.l);
        this.h.setArguments(bundle);
        this.g.setArguments(bundle);
        this.i.setArguments(bundle);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.j = myAdapter;
        this.f.setAdapter(myAdapter);
        ((TabPageIndicatorWithDot) this.b.findViewById(2131373299)).setViewPager(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return !TextUtils.isEmpty(this.l) && this.l.equals(UserInfo.getInstance().getLoginUserInfo().getUid());
    }

    @Override // com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver
    public void a(int i) {
        if (i < this.f.getAdapter().getCount()) {
            this.f.setCurrentItem(i);
        }
    }

    @Override // com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver.IFollowAndFansSelectedTabObserver
    public void b(int i) {
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33855a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_followed_and_follower, viewGroup, false);
            this.l = getArguments().getString("uid");
            b();
            c();
            a();
            FollowAndFansSelectedTabObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FollowAndFansSelectedTabObserver.a().b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
