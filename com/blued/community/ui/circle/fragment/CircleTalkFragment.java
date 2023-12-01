package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.community.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTalkFragment.class */
public class CircleTalkFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f19295a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f19296c;
    public CustomViewPager d;
    public MyAdapter e;
    public PageTabLayout f;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTalkFragment$MyAdapter.class */
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
            return CircleTalkFragment.this.f19296c.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return i == 0 ? new CircleMyPublishFragment() : new CircleMyRespondFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return CircleTalkFragment.this.f19296c.get(i);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(R.id.top_title);
        commonTopTitleNoTrans.setCenterText(getString(R.string.my_new_base_talk));
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.f();
    }

    public static void a(Context context) {
        TerminalActivity.d(context, CircleTalkFragment.class, new Bundle());
    }

    private void b() {
        this.f19296c = new ArrayList();
        String[] stringArray = this.f19295a.getResources().getStringArray(R.array.my_base_talk);
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.f19296c.add(stringArray[i2]);
            i = i2 + 1;
        }
    }

    private void c() {
        this.d = (CustomViewPager) this.b.findViewById(R.id.viewPager);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.e = myAdapter;
        this.d.setAdapter(myAdapter);
        PageTabLayout pageTabLayout = (PageTabLayout) this.b.findViewById(R.id.tablayout);
        this.f = pageTabLayout;
        pageTabLayout.setupWithViewPager(this.d);
        this.d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.community.ui.circle.fragment.CircleTalkFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.ctt_left) {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19295a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_my_base_talk, viewGroup, false);
            b();
            a();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
