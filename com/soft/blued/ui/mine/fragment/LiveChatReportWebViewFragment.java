package com.soft.blued.ui.mine.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.mine.model.LiveChatSwitchModel;
import com.soft.blued.ui.web.NoTitleWebViewShowFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/LiveChatReportWebViewFragment.class */
public class LiveChatReportWebViewFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f31589a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f31590c;
    private ImageView d;
    private ImageView e;
    private TabPageIndicatorWithDot f;
    private LinearLayout g;
    private ViewPager h;
    private MyAdapter i;
    private int j = 0;
    private ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.mine.fragment.LiveChatReportWebViewFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i == 1) {
                LiveChatReportWebViewFragment.this.d();
                return;
            }
            LiveChatReportWebViewFragment.this.e.setVisibility(8);
            LiveChatReportWebViewFragment.this.e.setOnClickListener(null);
            if (LiveChatReportWebViewFragment.this.g.getHeight() > 0) {
                LiveChatReportWebViewFragment.this.g();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LiveChatReportWebViewFragment.this.j = i;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/LiveChatReportWebViewFragment$HeightEvaluator.class */
    public class HeightEvaluator implements TypeEvaluator<ViewGroup.LayoutParams> {
        private ViewGroup b;

        public HeightEvaluator(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public ViewGroup.LayoutParams evaluate(float f, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2) {
            ViewGroup.LayoutParams layoutParams3 = this.b.getLayoutParams();
            layoutParams3.height = (int) (layoutParams.height + (f * (layoutParams2.height - layoutParams.height)));
            return layoutParams3;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/LiveChatReportWebViewFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f31594a;

        /* renamed from: c  reason: collision with root package name */
        private String[] f31595c;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f31595c = LiveChatReportWebViewFragment.this.f31589a.getResources().getStringArray(R.array.live_report_title);
            this.f31594a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: a */
        public NoTitleWebViewShowFragment getItem(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return new NoTitleWebViewShowFragment().a(H5Url.a(70));
            }
            return new NoTitleWebViewShowFragment().a(H5Url.a(1));
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f31595c.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f31595c[i];
        }
    }

    public static void a(Context context) {
        TerminalActivity.d(context, LiveChatReportWebViewFragment.class, null);
    }

    private void c() {
        ImageView imageView = (ImageView) this.b.findViewById(2131363120);
        this.d = imageView;
        imageView.setImageResource(2131234059);
        this.d.setVisibility(0);
        this.d.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.b.findViewById(2131363126);
        this.e = imageView2;
        imageView2.setImageResource(2131233917);
        this.e.setVisibility(8);
        this.e.setOnClickListener(this);
        this.e.setImageResource(R.drawable.icon_enter_chat_room);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        UserHttpUtils.a(UserInfo.getInstance().getLoginUserInfo().getUid(), new BluedUIHttpResponse<BluedEntityA<LiveChatSwitchModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.mine.fragment.LiveChatReportWebViewFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveChatSwitchModel> bluedEntityA) {
                if (bluedEntityA.getSingleData() == null || StringUtils.a(bluedEntityA.getSingleData().switch_status, 0) != 1) {
                    LiveChatReportWebViewFragment.this.e.setVisibility(8);
                    return;
                }
                LiveChatReportWebViewFragment.this.e.setVisibility(0);
                LiveChatReportWebViewFragment.this.e.setOnClickListener(LiveChatReportWebViewFragment.this);
            }
        }, getFragmentActive());
    }

    private void e() {
        if (this.g.getHeight() != 0) {
            g();
            return;
        }
        this.f31590c.setVisibility(0);
        f();
    }

    private void f() {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.g, "layoutParams", new HeightEvaluator(this.g), new ViewGroup.LayoutParams(-1, 0), new ViewGroup.LayoutParams(-1, DensityUtils.a(getContext(), 54.0f)));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofObject);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f31590c.setVisibility(8);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.g, "layoutParams", new HeightEvaluator(this.g), new ViewGroup.LayoutParams(-1, DensityUtils.a(getContext(), 54.0f)), new ViewGroup.LayoutParams(-1, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofObject);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    public void a() {
        this.h = (ViewPager) this.b.findViewById(R.id.viewpager);
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.i = myAdapter;
        this.h.setAdapter(myAdapter);
        this.h.setOffscreenPageLimit(2);
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.b.findViewById(2131373299);
        this.f = tabPageIndicatorWithDot;
        tabPageIndicatorWithDot.setViewPager(this.h);
        this.f.setOnPageChangeListener(this.k);
        this.h.setCurrentItem(this.j);
    }

    protected void b() {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        getActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363095:
                if (this.g.getHeight() > 0) {
                    g();
                    return;
                }
                return;
            case 2131363120:
                b();
                return;
            case 2131363126:
                EventTrackYY.a(ChatRoomProtos.Event.ANCHOR_REPORT_FORM_PAGE_MORE_CLICK);
                e();
                return;
            case R.id.ll_live_chat /* 2131367970 */:
                EventTrackYY.a(ChatRoomProtos.Event.ANCHOR_REPORT_FORM_PAGE_MORE_YY_CLICK);
                g();
                YYChatRoomsListFragment.f17120a.a(getContext(), "anchor_report_yy_hall");
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(18);
        this.f31589a = getActivity();
        View view = this.b;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_live_chat_report_web_view, (ViewGroup) null);
            this.b = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.ll_live_chat);
            this.f31590c = this.b.findViewById(2131363095);
            this.g.setOnClickListener(this);
            this.f31590c.setOnClickListener(this);
            c();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        BluedStatistics.f().a(true);
        return this.b;
    }
}
