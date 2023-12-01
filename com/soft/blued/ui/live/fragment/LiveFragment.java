package com.soft.blued.ui.live.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.utils.click.IClickAgain;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.fragment.LiveMainFragment;
import com.blued.android.module.live_china.fragment.LiveTabFragmentNew;
import com.blued.android.module.live_china.fragment.LiveVipDialogFragment;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveListRefreshObserver;
import com.blued.android.module.live_china.rank.LiveRankDialogFragment;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.view.FloatSpreadView;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.home.model.LiveBubble;
import com.soft.blued.ui.live.fitem.FitemPersonalCollection;
import com.soft.blued.ui.live.fragment.LiveFragment;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.model.LivePersonalCollectionModel;
import com.soft.blued.ui.live.presenter.LivePresenter;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment.class */
public class LiveFragment extends MvpFragment<LivePresenter> implements View.OnClickListener, SingleSessionListener, OnClickCallback, LiveListRefreshObserver.ILiveListRefreshObserver, LiveListSetSelectedTab.iLiveListSetSelectedTab, HomeTabClick.TabClickListener, LiveFloatRedBagViewScrollObserver.IFloatRedBagViewScrollObserver {
    private PopHolder A;
    private Unbinder C;

    /* renamed from: a  reason: collision with root package name */
    ImageView f17455a;
    public boolean b;
    @BindView
    View beauty_close;
    @BindView
    View beauty_open;

    /* renamed from: c  reason: collision with root package name */
    public String f17456c;
    public int d;
    @BindView
    View fl_floor;
    private Context g;
    @BindView
    TabPageIndicatorWithDot indicator;
    @BindView
    ImageView ivTitleRequestLive;
    private BluedLiveState k;
    private long l;
    @BindView
    View layoutTitleRequestLive;
    @BindView
    View layoutTitleRequestLiveCount;
    @BindView
    FrameLayout layoutTitleRight;
    private MyAdapter m;
    @BindView
    FloatSpreadView mFloatSpreadView;
    @BindView
    ShapeTextView mRightNewDot;
    @BindView
    View mTitle;
    @BindView
    FrameLayout mTitleBarRoot;
    @BindView
    ImageView mTitleLeft;
    @BindView
    ImageView mTitleRight;
    @BindView
    CustomViewPager mViewPager;
    private int n;
    private boolean o;
    @BindView
    ImageView second_floor;
    @BindView
    TextView tvTitleRequestLive;
    @BindView
    TextView tvTitleRequestLiveSecond;
    @BindView
    View view_hard;
    @BindView
    View view_soft;
    private PopMenu w;
    private List<LivePersonalCollectionModel> x;
    private FreedomAdapter y;
    private List<FitemPersonalCollection> z;
    private String f = LiveFragment.class.getSimpleName();
    public int e = 3;
    private int p = 0;
    private int q = 0;
    private String r = "";
    private int s = 1;
    private ViewPager.OnPageChangeListener t = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (LiveFragment.this.o) {
                KeyboardUtils.a(LiveFragment.this.getActivity());
                LiveFragment.this.s = i;
                if (LiveFragment.this.s != 2) {
                    return;
                }
                LiveFragment.this.indicator.c(2);
                ChatManager.getInstance().deleteSessionAndChatting((short) 1, 6L);
                LiveFragment.this.x();
            }
        }
    };
    private boolean u = false;
    private Boolean v = false;
    private List<Unbinder> B = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.live.fragment.LiveFragment$10  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment$10.class */
    public class AnonymousClass10 implements Animation.AnimationListener {
        AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            LiveFragment.this.y();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LiveFragment.this.tvTitleRequestLive.setText(LiveFragment.this.tvTitleRequestLiveSecond.getText());
            LiveFragment.this.tvTitleRequestLiveSecond.setVisibility(8);
            LiveFragment.this.u = false;
            LiveFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$10$6ysEMt2jYl05_5wjlM8P8DBNcjc
                @Override // java.lang.Runnable
                public final void run() {
                    LiveFragment.AnonymousClass10.this.a();
                }
            }, 200L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LiveFragment.this.tvTitleRequestLiveSecond.setVisibility(0);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        FragmentManager f17474a;

        /* renamed from: c  reason: collision with root package name */
        private String[] f17475c;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f17475c = LiveFragment.this.g.getResources().getStringArray(BluedConfig.a().P() ? 2130903094 : 2130903099);
            this.f17474a = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveFragment.this.e;
        }

        /* JADX WARN: Type inference failed for: r0v15, types: [com.soft.blued.ui.live.fragment.LiveHomeFragment, androidx.fragment.app.Fragment] */
        /* JADX WARN: Type inference failed for: r0v22, types: [androidx.fragment.app.Fragment, com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew] */
        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            bundle.putString("live_pay_beans_details", LiveFragment.this.r);
            LiveFragment.this.r = "";
            if (i == 0) {
                return BluedConfig.a().P() ? LiveTabFragmentNew.a.a("11", "Nearby", UserFindResult.USER_SORT_BY.NEARBY, LiveFragment.this.r) : LiveRecommendFragment.a("12", 0, LiveFragment.this.r);
            } else if (i != 1) {
                if (i != 2) {
                    return null;
                }
                ?? liveListFollowFragmentNew = new LiveListFollowFragmentNew();
                liveListFollowFragmentNew.setArguments(bundle);
                return liveListFollowFragmentNew;
            } else if (BluedConfig.a().P()) {
                LiveMainFragment liveMainFragment = new LiveMainFragment();
                liveMainFragment.setArguments(bundle);
                return liveMainFragment;
            } else {
                ?? liveHomeFragment = new LiveHomeFragment();
                liveHomeFragment.setArguments(bundle);
                return liveHomeFragment;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f17475c[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment$PopHolder.class */
    public class PopHolder {
        @BindView
        RecyclerView rv_personal_collection;

        PopHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment$PopHolder_ViewBinding.class */
    public class PopHolder_ViewBinding implements Unbinder {
        private PopHolder b;

        public PopHolder_ViewBinding(PopHolder popHolder, View view) {
            this.b = popHolder;
            popHolder.rv_personal_collection = (RecyclerView) Utils.a(view, R.id.rv_personal_collection, "field 'rv_personal_collection'", RecyclerView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            PopHolder popHolder = this.b;
            if (popHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            popHolder.rv_personal_collection = null;
        }
    }

    private void A() {
        this.e = 3;
    }

    private void B() {
        LiveRoomHttpUtils.H(new BluedUIHttpResponse<BluedEntity<LivePersonalCollectionModel, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveFragment.16
            public void onUIUpdate(BluedEntity<LivePersonalCollectionModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    LiveFragment.this.mTitleLeft.setVisibility(8);
                    return;
                }
                EventTrackLive.c(LiveProtos.Event.LIVE_COLLECTION_ENTER_ICON_SHOW);
                LiveFragment.this.x = bluedEntity.data;
                LiveFragment.this.mTitleLeft.setVisibility(0);
            }
        });
    }

    private void C() {
        List<LivePersonalCollectionModel> list;
        if (this.g == null || (list = this.x) == null || list.isEmpty()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.g).inflate(R.layout.pop_live_personal_collection_left_menu, (ViewGroup) null);
        PopHolder popHolder = new PopHolder();
        this.A = popHolder;
        Unbinder a2 = ButterKnife.a(popHolder, viewGroup);
        this.C = a2;
        this.B.add(a2);
        D();
        PopMenu popMenu = new PopMenu(this.g, viewGroup);
        this.w = popMenu;
        popMenu.a(this.mTitle);
    }

    private void D() {
        List<FitemPersonalCollection> list = this.z;
        if (list == null) {
            this.z = new ArrayList();
        } else {
            list.clear();
        }
        for (LivePersonalCollectionModel livePersonalCollectionModel : this.x) {
            this.z.add(new FitemPersonalCollection(livePersonalCollectionModel));
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.17
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return ((FreedomItem) LiveFragment.this.z.get(i)).a(gridLayoutManager.getSpanCount());
            }
        });
        this.A.rv_personal_collection.setLayoutManager(gridLayoutManager);
        this.y = new FreedomAdapter(this.g, getFragmentActive(), this.z, this);
        this.A.rv_personal_collection.setAdapter(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
        view.animate().translationY(0.0f).alpha(1.0f).setDuration(250L).setStartDelay(100L).setInterpolator(new OvershootInterpolator(1.5f)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, LiveBubble liveBubble) {
        int[] iArr = new int[2];
        this.mTitleBarRoot.getLocationInWindow(iArr);
        view.getLocationInWindow(r0);
        int[] iArr2 = {(int) (iArr2[0] + (view.getWidth() / 2.0f)), (int) (iArr2[1] + ((view.getHeight() - DensityUtils.a(this.g, 15.0f)) / 2.0f))};
        this.f17455a = new ImageView(this.g);
        int a2 = DensityUtils.a(this.g, 34.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
        float f = iArr2[0] - iArr[0];
        float f2 = a2 / 2.0f;
        layoutParams.leftMargin = (int) (f - f2);
        layoutParams.topMargin = (int) ((iArr2[1] - iArr[1]) - f2);
        this.f17455a.setLayoutParams(layoutParams);
        this.mTitleBarRoot.addView(this.f17455a);
        ImageLoader.a(getFragmentActive(), liveBubble.image).b((int) R.drawable.user_bg_round_border_white).d((int) R.drawable.user_bg_round_border_white).c().a(this.f17455a);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        LiveRankDialogFragment.a.a(getChildFragmentManager(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        ((LivePresenter) j()).m();
    }

    private void b(int i) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.q = i;
        if (i <= 99) {
            this.tvTitleRequestLiveSecond.setText(String.valueOf(i));
        } else {
            this.tvTitleRequestLiveSecond.setText("99+");
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f));
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.setDuration(180L);
        this.tvTitleRequestLive.startAnimation(animationSet);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(180L);
        translateAnimation.setAnimationListener(new AnonymousClass10());
        this.tvTitleRequestLiveSecond.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Integer num) {
        LiveVipDialogFragment.a.a(getChildFragmentManager(), 1);
    }

    private void c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        this.mFloatSpreadView.setFragment(this);
        this.mFloatSpreadView.a(true);
        if (this.m == null) {
            this.m = new MyAdapter(getChildFragmentManager());
        }
        this.mViewPager.setAdapter(this.m);
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (LiveFragment.this.o) {
                    if (i == 2) {
                        LiveFragment.this.mFloatSpreadView.setVisibility(8);
                    } else {
                        LiveFragment.this.b(true);
                    }
                }
            }
        });
        if (BlueAppLocal.d()) {
            this.indicator.setTabPaddingLeftRight(DensityUtils.a(this.g, 10.0f));
        } else {
            this.indicator.setTabPaddingLeftRight(DensityUtils.a(this.g, 5.0f));
        }
        this.indicator.setViewPager(this.mViewPager);
        this.indicator.setOnPageChangeListener(this.t);
        this.indicator.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.3
            @Override // com.soft.blued.customview.TabPageIndicatorWithDot.OnTitleClickListener
            public void onClick(int i) {
                if (i == 2) {
                    LiveFragment.this.indicator.c(2);
                }
            }
        });
        this.mViewPager.setCurrentItem(this.s);
        this.view_soft.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFragment.this.view_soft.setSelected(true);
                LiveFragment.this.view_hard.setSelected(false);
                BluedPreferences.k(0);
            }
        });
        this.view_hard.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFragment.this.view_soft.setSelected(false);
                LiveFragment.this.view_hard.setSelected(true);
                BluedPreferences.k(1);
            }
        });
        if (BluedPreferences.bu() == 0) {
            this.view_soft.setSelected(true);
            this.view_hard.setSelected(false);
        } else {
            this.view_soft.setSelected(false);
            this.view_hard.setSelected(true);
        }
        this.beauty_open.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFragment.this.beauty_open.setSelected(true);
                LiveFragment.this.beauty_close.setSelected(false);
                BluedPreferences.l(0);
            }
        });
        this.beauty_close.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFragment.this.beauty_open.setSelected(false);
                LiveFragment.this.beauty_close.setSelected(true);
                BluedPreferences.l(1);
            }
        });
        if (BluedPreferences.bv() == 0) {
            this.beauty_open.setSelected(true);
            this.beauty_close.setSelected(false);
        } else {
            this.beauty_open.setSelected(false);
            this.beauty_close.setSelected(true);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fl_floor.getLayoutParams();
        layoutParams.width = AppInfo.l;
        int i = (int) (AppInfo.l * 1.2666667f);
        this.p = i;
        layoutParams.height = i;
        this.fl_floor.setLayoutParams(layoutParams);
        LiveEventBus.get(LiveEventBusUtil.p).observe(this, new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$h2HFmTAQH7kg_Y4pDh95u9bfzA0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveFragment.this.a(obj);
            }
        });
        e();
    }

    private void e() {
        ImageView imageView = this.f17455a;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.f17455a = null;
        }
        boolean z = false;
        if (this.mTitleBarRoot != null) {
            z = false;
            for (int i = 0; i < this.mTitleBarRoot.getChildCount(); i++) {
                if (this.mTitleBarRoot.getChildAt(i) instanceof ImageView) {
                    z = true;
                }
            }
        }
        if (this.f17455a != null || z || this.s == 2) {
            return;
        }
        ((LivePresenter) j()).n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        ((LivePresenter) j()).a(true);
    }

    private boolean v() {
        BluedLiveState bluedLiveState = this.k;
        if (bluedLiveState == null) {
            return false;
        }
        int i = bluedLiveState.is_permission;
        int a2 = UserRelationshipUtils.a(this.k.block, this.k.vbadge, this.k.verify, this.k.mobile);
        LogUtils.c("avatar_v_status:" + this.k.avatar_v_status + ", anchorState:" + a2 + ", permission:" + i);
        if (this.k.avatar_v_status == 0 || this.k.avatar_v_status == 2) {
            return false;
        }
        return (2 == i || 1 == i) && a2 == 0;
    }

    private void w() {
        if (StatusBarHelper.a()) {
            this.mTitle.setPadding(0, StatusBarHelper.a(getActivity()), 0, 0);
        }
        this.mTitleLeft.setVisibility(8);
        this.mTitleLeft.setOnClickListener(this);
        B();
        this.layoutTitleRequestLive.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$9o-S2VmvfH-cJ6z6pa2tF-CTGFs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFragment.this.b(view);
            }
        });
        this.mTitleRight.setOnClickListener(new SingleClickProxy(this, 2000L, (IClickAgain) null));
        this.mRightNewDot.setVisibility(8);
        this.mTitle.post(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.8
            @Override // java.lang.Runnable
            public void run() {
                if (LiveFragment.this.mTitle != null) {
                    LiveFragment liveFragment = LiveFragment.this;
                    liveFragment.n = liveFragment.mTitle.getHeight();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f17455a != null) {
            ((LivePresenter) j()).p();
            this.f17455a.animate().translationY(this.f17455a.getHeight()).alpha(0.0f).setDuration(250L).setStartDelay(100L).setInterpolator(new AnticipateInterpolator(1.5f)).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LiveFragment.this.f17455a.setVisibility(8);
                    LiveFragment.this.f17455a = null;
                }
            }).start();
            final TextView e = this.indicator.e(2);
            if (e.getVisibility() != 0) {
                e.setAlpha(0.0f);
                e.setVisibility(0);
                e.setTranslationY(this.f17455a.getHeight());
                e.post(new Runnable() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$enLYbOciJJjDZXtxLUpOgeV0CGM
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveFragment.a(e);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.2f, 1, 0.0f, 1, 0.0f);
        long j = 220;
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -0.2f, 1, 0.0f, 1, 0.0f);
        translateAnimation2.setDuration(j);
        translateAnimation2.setStartOffset(j);
        translateAnimation2.setFillAfter(true);
        animationSet.addAnimation(translateAnimation2);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.2f, 1, 0.0f, 1, 0.0f);
        translateAnimation3.setDuration(j);
        translateAnimation3.setStartOffset(440);
        translateAnimation3.setFillAfter(true);
        animationSet.addAnimation(translateAnimation3);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, -0.2f, 1, 0.0f, 1, 0.0f);
        translateAnimation4.setDuration(j);
        translateAnimation4.setStartOffset((long) LiveProtos.Event.LIVE_ONLINE_USER_PAGE_USER_SHOW_VALUE);
        translateAnimation4.setFillAfter(true);
        animationSet.addAnimation(translateAnimation4);
        this.ivTitleRequestLive.startAnimation(animationSet);
    }

    private void z() {
        TerminalActivity.d(getContext(), RequestAnchorLiveListFragment.class, (Bundle) null);
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_PLEASE_MSG_CLICK);
    }

    public void a() {
    }

    public void a(float f, int i) {
        View view;
        if (this.mTitle == null || (view = this.fl_floor) == null || view.getVisibility() != 0) {
            return;
        }
        this.mTitle.setAlpha(1.0f - Math.min(f * 1.8f, 1.0f));
        this.fl_floor.setTranslationY(Math.min((i - this.p) + this.n + this.d, 0));
    }

    @Override // com.soft.blued.ui.discover.observer.LiveListSetSelectedTab.iLiveListSetSelectedTab
    public void a(int i) {
        CustomViewPager customViewPager = this.mViewPager;
        if (customViewPager == null || customViewPager.getAdapter() == null || i >= this.mViewPager.getAdapter().getCount()) {
            return;
        }
        this.mViewPager.setCurrentItem(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) {
        super.a(bundle);
        A();
        w();
        d();
        a(this.b, "", 0);
        this.l = 0L;
        LiveListSetSelectedTab.a().a(this);
        LiveFloatRedBagViewScrollObserver.a().a(this);
        this.o = true;
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("arg_subfragment_args");
        if (bundleExtra != null) {
            this.r = bundleExtra.getString("live_pay_beans_details", "");
        }
        LiveEventBus.get("live_start_live", String.class).observe(this, new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$-i37a8NoR4SuCMV2ti4g8N-MTNc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveFragment.this.e((String) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.R, Integer.class).observe(this, new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$2qzvwjeC8UdZJ2_dVrX_kZ7UQAM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveFragment.this.b((Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.aa, Integer.class).observe(this, new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$_cxKAtXaVZHyZkL-L_3pZSGCOgc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveFragment.this.a((Integer) obj);
            }
        });
    }

    public void a(Fragment fragment) {
        ((LivePresenter) j()).a(true);
    }

    @Override // com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver.IFloatRedBagViewScrollObserver
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (this.o && this.mViewPager.getCurrentItem() != 0) {
            this.mViewPager.getCurrentItem();
        }
    }

    public void a(CountModel countModel) {
        int i;
        int i2 = countModel.count;
        LogUtils.c("requestLiveCount:" + this.q + ", nextCount:" + i2);
        BluedLiveState bluedLiveState = this.k;
        if (bluedLiveState != null && bluedLiveState.allow_applied == 0) {
            this.mTitleRight.setVisibility(8);
            this.layoutTitleRequestLive.setVisibility(8);
        } else if (!v() || i2 == 0) {
            this.q = 0;
            this.tvTitleRequestLive.setText("0");
            this.layoutTitleRequestLive.setVisibility(8);
            this.mTitleRight.setVisibility(0);
        } else {
            this.layoutTitleRequestLive.setVisibility(0);
            this.mTitleRight.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.layoutTitleRequestLive.getLayoutParams();
            if (i2 > 99 || (i = this.q) > 99) {
                layoutParams.width = DisplayUtil.a(AppInfo.d(), 68.0f);
            } else if (i2 > 9 || i > 9) {
                layoutParams.width = DisplayUtil.a(AppInfo.d(), 60.0f);
            } else {
                layoutParams.width = DisplayUtil.a(AppInfo.d(), 52.0f);
            }
            this.layoutTitleRequestLive.setLayoutParams(layoutParams);
            if (i2 != this.q) {
                b(i2);
            } else {
                y();
            }
        }
    }

    public void a(BluedLiveState bluedLiveState) {
        Log.i("xpm", "receive setLiveState");
        try {
            this.k = bluedLiveState;
            if (bluedLiveState.allow_applied == 0) {
                this.mTitleRight.setVisibility(8);
                this.layoutTitleRequestLive.setVisibility(8);
            } else if (!v()) {
                this.layoutTitleRequestLive.setVisibility(8);
                this.mTitleRight.setVisibility(0);
            } else if (this.q == 0) {
                this.layoutTitleRequestLive.setVisibility(8);
                this.mTitleRight.setVisibility(0);
            } else {
                this.layoutTitleRequestLive.setVisibility(0);
                this.mTitleRight.setVisibility(8);
            }
            if (!bluedLiveState.isLiveClickEvent) {
                LogUtils.c("No click event, only update state");
                return;
            }
            bluedLiveState.isLiveClickEvent = false;
            LogUtils.c("click event, start live");
            BluedPreferences.aK();
            LiveUtils.a(this.g, bluedLiveState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(final LiveBubble liveBubble) {
        if (this.indicator == null || liveBubble == null || TextUtils.isEmpty(liveBubble.image) || this.f17455a != null || this.s == 2) {
            return;
        }
        final TextView e = this.indicator.e(2);
        e.post(new Runnable() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveFragment$p_D9w-AI6PLofuU5HcXoImTSZ0o
            @Override // java.lang.Runnable
            public final void run() {
                LiveFragment.this.a(e, liveBubble);
            }
        });
        ((LivePresenter) j()).o();
    }

    public void a(String str, boolean z) {
        super.a(str, z);
    }

    public void a(boolean z, String str, int i) {
        if (this.o) {
            this.b = z;
            this.f17456c = str;
            this.d = i;
            if (TextUtils.isEmpty(str)) {
                this.mTitle.setAlpha(1.0f);
                this.fl_floor.setVisibility(8);
            } else {
                this.fl_floor.setVisibility(0);
                ImageLoader.a(getFragmentActive(), str).b((int) R.drawable.live_icon_second_flow).a(this.second_floor);
            }
            a(0.0f, 0);
        }
    }

    public ViewPager b() {
        return this.mViewPager;
    }

    public void b(boolean z) {
        FloatSpreadView floatSpreadView = this.mFloatSpreadView;
        if (floatSpreadView != null) {
            floatSpreadView.a(z);
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("live".equals(str)) {
            ((LivePresenter) j()).a(false);
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        if ("live".equals(str)) {
            c(str);
        }
    }

    public void f() {
        super.f();
        this.g = getActivity();
        c();
    }

    public int g() {
        return R.layout.fragment_live;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.o) {
            if (i2 == -1) {
                if (i != 100) {
                    if (i == 10111 && !TextUtils.isEmpty(intent.getStringExtra("string_edit"))) {
                        LiveRoomHttpUtils.b(intent.getStringExtra("string_edit"), new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveFragment.11
                            public boolean onUIFailure(int i3, String str) {
                                LiveFragment.this.v = true;
                                return super.onUIFailure(i3, str);
                            }

                            public void onUIFinish() {
                                if (LiveFragment.this.v.booleanValue()) {
                                    LiveFragment.this.v = false;
                                    AppMethods.a(LiveFragment.this.g.getString(R.string.feedback_error));
                                }
                                super.onUIFinish();
                            }

                            public void onUIUpdate(BluedEntity bluedEntity) {
                                AppMethods.a(LiveFragment.this.getString(R.string.Live_feedback_success));
                            }
                        }, getFragmentActive());
                    }
                } else if (intent != null && !"".equals(intent.toString()) && !TextUtils.isEmpty("string_edit")) {
                    String stringExtra = intent.getStringExtra("string_edit");
                    ((LivePresenter) j()).a(intent.getStringExtra("feed_id"), stringExtra);
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            EventTrackLive.c(LiveProtos.Event.LIVE_COLLECTION_ENTER_ICON_CLICK);
            C();
        } else if (id == 2131363126 && !ClickUtils.a(view.getId())) {
            EventTrackLive.a(LiveProtos.Event.LIVE_START_FROM_LIVELIST);
            InstantLog.a("live_start_from_livelist");
            ((LivePresenter) j()).a(true);
            this.mRightNewDot.setVisibility(8);
            ChatManager.getInstance().deleteSessionAndChatting((short) 1, 7L);
        }
    }

    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        String str;
        LivePersonalCollectionModel livePersonalCollectionModel = this.z.get(i).b;
        if (livePersonalCollectionModel.redirect_type == 1) {
            str = "https://app.blued.cn/?action=" + livePersonalCollectionModel.redirect;
        } else {
            str = livePersonalCollectionModel.redirect;
        }
        WebViewShowInfoFragment.show(this.g, str);
        this.w.d();
        EventTrackLive.e(LiveProtos.Event.LIVE_COLLECTION_BTN_CLICK, str);
    }

    public void onDestroy() {
        super.onDestroy();
        HomeTabClick.b("live", this);
        LiveListSetSelectedTab.a().b(this);
        LiveFloatRedBagViewScrollObserver.a().b(this);
    }

    public void onPause() {
        this.l = System.currentTimeMillis();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.l != 0) {
            if (System.currentTimeMillis() - this.l > 300000) {
                ((LivePresenter) j()).a(false);
            }
            this.l = 0L;
        }
        TextView textView = this.tvTitleRequestLive;
        if (textView != null) {
            int i = this.q;
            if (i <= 99) {
                textView.setText(String.valueOf(i));
            } else {
                textView.setText("99+");
            }
        }
        ((LivePresenter) j()).m();
        if (this.mViewPager.getCurrentItem() == 2) {
            this.mFloatSpreadView.setVisibility(8);
        } else {
            b(true);
        }
    }

    public void onSessionDataChanged(SessionModel sessionModel) {
        if (this.o) {
            Log.v("pk", "直播 sessionData.sessionType = " + ((int) sessionModel.sessionType) + " -- sessionId = " + sessionModel.sessionId);
            if (sessionModel.sessionType == 1 && sessionModel.sessionId == 7) {
                postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveFragment.this.mRightNewDot != null) {
                            LiveFragment.this.mRightNewDot.setVisibility(0);
                        }
                    }
                });
            }
            if (sessionModel.sessionType == 1 && sessionModel.sessionId == 6) {
                postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveFragment.this.indicator != null) {
                            LiveFragment.this.indicator.b(2);
                        }
                    }
                });
            }
        }
    }

    public void onSessionRemoved(short s, long j) {
        Log.v("pk", "直播 onSessionRemoved sessionData.sessionType = " + ((int) s) + " -- sessionId = " + j);
        if (this.o) {
            if (s == 1 && j == 7) {
                postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveFragment.this.mRightNewDot != null) {
                            LiveFragment.this.mRightNewDot.setVisibility(8);
                        }
                    }
                });
            }
            if (s == 1 && j == 6) {
                postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveFragment.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveFragment.this.indicator != null) {
                            LiveFragment.this.indicator.c(2);
                        }
                    }
                });
            }
        }
    }

    public void onStart() {
        super.onStart();
        LiveListRefreshObserver.a().a(this);
        ChatHelperV4.a().e(this);
        ChatHelperV4.a().g(this);
    }

    public void onStop() {
        super.onStop();
        LiveListRefreshObserver.a().b(this);
        ChatHelperV4.a().f(this);
        ChatHelperV4.a().h(this);
    }

    public boolean q() {
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            HomeTabClick.a("live", this);
        }
    }
}
