package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.PageTabLayout;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentFeed.class */
public class UserInfoFragmentFeed extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f20312a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public ShapeTextView f20313c;
    public List<String> d;
    public CustomViewPager e;
    public MyAdapter f;
    public PageTabLayout g;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentFeed$MyAdapter.class */
    public class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return UserInfoFragmentFeed.this.d.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return i == 0 ? new UserInfoFragmentMyFeedTab() : new UserInfoFragmentMyZanTab();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return UserInfoFragmentFeed.this.d.get(i);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    private void a() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText(getString(R.string.find_feed));
        findViewById.setLeftClickListener(this);
        findViewById.a();
    }

    private void a(int i) {
        ((ImageView) this.g.a(i).a().findViewById(R.id.shape_new)).setVisibility(0);
    }

    public static void a(Context context) {
        TerminalActivity.d(context, UserInfoFragmentFeed.class, new Bundle());
    }

    private void b() {
        this.d = new ArrayList();
        String[] stringArray = this.f20312a.getResources().getStringArray(R.array.user_feed_title);
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.d.add(stringArray[i2]);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        ((ImageView) this.g.a(i).a().findViewById(R.id.shape_new)).setVisibility(8);
    }

    private void c() {
        ShapeTextView findViewById = this.b.findViewById(R.id.feed_bg);
        this.f20313c = findViewById;
        ShapeHelper.b(findViewById, 2131102360);
        this.e = (CustomViewPager) this.b.findViewById(2131373100);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.f = myAdapter;
        this.e.setAdapter(myAdapter);
        PageTabLayout findViewById2 = this.b.findViewById(R.id.tablayout);
        this.g = findViewById2;
        findViewById2.setupWithViewPager(this.e);
        this.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentFeed.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    UserInfoFragmentFeed.this.b(i);
                    BluedPreferences.co();
                }
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                break;
            }
            View inflate = LayoutInflater.from(this.f20312a).inflate(R.layout.item_tab_with_new, (ViewGroup) null);
            ShapeTextView findViewById3 = inflate.findViewById(R.id.shape_tv);
            ShapeHelper.a(findViewById3, 2131102254);
            findViewById3.setText(this.d.get(i2));
            this.g.a(i2).a(inflate);
            i = i2 + 1;
        }
        if (BluedPreferences.cn()) {
            a(1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20312a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_userinfo_my_feed, viewGroup, false);
            b();
            a();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
