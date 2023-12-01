package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.ui.video.fragment.ShineVideoListFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/ShineVideoListIndepFragment.class */
public class ShineVideoListIndepFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f16126a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f16127c;
    public MyAdapter d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/ShineVideoListIndepFragment$MyAdapter.class */
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
            return 1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.Fragment, com.blued.community.ui.video.fragment.ShineVideoListFragment] */
        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            ?? shineVideoListFragment = new ShineVideoListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ShineVideoListFragment.f6774a, 1);
            shineVideoListFragment.setArguments(bundle);
            return shineVideoListFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return ShineVideoListIndepFragment.this.f16126a.getResources().getString(R.string.post_shine_video);
        }
    }

    public static void a(Context context) {
        TerminalActivity.d(context, ShineVideoListIndepFragment.class, (Bundle) null);
    }

    public void a() {
        this.f16127c = (ViewPager) this.b.findViewById(R.id.viewpager);
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText((int) R.string.post_shine_video);
        findViewById.a();
        findViewById.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.discover.fragment.ShineVideoListIndepFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ShineVideoListIndepFragment.this.getActivity().finish();
            }
        });
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.d = myAdapter;
        this.f16127c.setAdapter(myAdapter);
        this.d.notifyDataSetChanged();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16126a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_shine_video_list_independent, viewGroup, false);
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
