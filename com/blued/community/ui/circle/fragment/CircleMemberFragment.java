package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.community.R;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.presenter.CircleMemberPresenter;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMemberFragment.class */
public class CircleMemberFragment extends MvpFragment<CircleMemberPresenter> {
    private CommonTopTitleNoTrans a;
    private ShapeTextView b;
    private PageTabLayout c;
    private FrameLayout d;
    private CustomViewPager e;
    private MyAdapter f;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMemberFragment$MyAdapter.class */
    public class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        public int getCount() {
            return CircleMemberFragment.this.j().m().size();
        }

        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            bundle.putString("circle_id", CircleMemberFragment.this.j().o());
            bundle.putInt("admin_level", CircleMemberFragment.this.j().p());
            if (i == 0) {
                CircleJoinMemberFragment circleJoinMemberFragment = new CircleJoinMemberFragment();
                circleJoinMemberFragment.setArguments(bundle);
                return circleJoinMemberFragment;
            }
            CircleMuteMemberFragment circleMuteMemberFragment = new CircleMuteMemberFragment();
            circleMuteMemberFragment.setArguments(bundle);
            return circleMuteMemberFragment;
        }

        public CharSequence getPageTitle(int i) {
            return CircleMemberFragment.this.j().m().get(i);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    public static void a(Context context, MyCircleModel myCircleModel) {
        if (myCircleModel == null || TextUtils.isEmpty(myCircleModel.circle_id)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("admin_level", myCircleModel.admin_level);
        bundle.putString("circle_id", myCircleModel.circle_id);
        TerminalActivity.d(context, CircleMemberFragment.class, bundle);
    }

    private void b() {
        this.a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.top_title);
        this.b = (ShapeTextView) this.i.findViewById(R.id.shape_tab);
        this.c = (PageTabLayout) this.i.findViewById(R.id.tab_layout);
        this.d = (FrameLayout) this.i.findViewById(R.id.fl_tab_title);
        this.e = (CustomViewPager) this.i.findViewById(R.id.viewPager);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        if (j().m().size() > 1) {
            this.a.setCenterText(R.string.circle_list_title);
            this.d.setVisibility(0);
        } else {
            this.a.setCenterText(R.string.circle_member_title);
            this.d.setVisibility(8);
        }
        this.a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleMemberFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleMemberFragment.this.t();
            }
        });
        PagerAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.f = myAdapter;
        this.e.setAdapter(myAdapter);
        this.c.setupWithViewPager(this.e);
        this.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.community.ui.circle.fragment.CircleMemberFragment.2
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_member;
    }
}
