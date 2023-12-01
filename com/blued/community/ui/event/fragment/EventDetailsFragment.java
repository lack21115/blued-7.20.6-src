package com.blued.community.ui.event.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import com.amap.api.fence.GeoFence;
import com.amap.api.location.CoordinateConverter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.ObservableScrollView;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FragmentEventDetailsBinding;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.adapter.EventRecommendAdapter;
import com.blued.community.ui.event.adapter.EventReviewAdapter;
import com.blued.community.ui.event.adapter.EventSceneAdapter;
import com.blued.community.ui.event.dialog.EventScoreDialogFragment;
import com.blued.community.ui.event.dialog.EventSignUpPopupWindow;
import com.blued.community.ui.event.fragment.EventMemberFragment;
import com.blued.community.ui.event.manager.EventMethods;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventIdentifyModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.event.vm.EventDetailsViewModel;
import com.blued.community.ui.feed.fragment.FeedDetailsFragment;
import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.community.ui.send.fragment.EventScoreAddPostFragment;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment.class */
public final class EventDetailsFragment extends MVVMBaseFragment<EventDetailsViewModel> implements View.OnClickListener {
    private final ViewBindingProperty c;
    private BasePopupView d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private int j;
    private final ValueAnimator k;
    private boolean l;
    private Timer m;
    private int n;
    private boolean o;
    private boolean p;
    private EventLogData q;
    private int r;
    private boolean s;
    private BottomMenuPop t;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(EventDetailsFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentEventDetailsBinding;", 0))};
    public static final Companion a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str, EventLogData eventLogData) {
            Intrinsics.e(context, "context");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("event_id", str);
            bundle.putSerializable("log_data", eventLogData);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, EventDetailsFragment.class, bundle);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentPagerAdapter {
        private final List<String> a;
        private final List<Fragment> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm, List<String> mTabs, List<Fragment> mTabsFragments) {
            super(fm);
            Intrinsics.e(fm, "fm");
            Intrinsics.e(mTabs, "mTabs");
            Intrinsics.e(mTabsFragments, "mTabsFragments");
            this.a = mTabs;
            this.b = mTabsFragments;
        }

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            super.destroyItem(container, i, object);
        }

        public int getCount() {
            return this.a.size();
        }

        public Fragment getItem(int i) {
            return this.b.get(i);
        }

        public long getItemId(int i) {
            return this.b.get(i).hashCode();
        }

        public int getItemPosition(Object object) {
            Intrinsics.e(object, "object");
            if (object instanceof Fragment) {
                int indexOf = this.b.indexOf(object);
                if (indexOf != -1) {
                    return indexOf;
                }
                return -2;
            }
            return super.getItemPosition(object);
        }

        public CharSequence getPageTitle(int i) {
            return this.a.get(i);
        }

        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            Object instantiateItem = super.instantiateItem(container, i);
            Intrinsics.c(instantiateItem, "super.instantiateItem(container, position)");
            return instantiateItem;
        }
    }

    public EventDetailsFragment() {
        super(R.layout.fragment_event_details);
        this.c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<EventDetailsFragment, FragmentEventDetailsBinding>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventDetailsBinding invoke(EventDetailsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventDetailsBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<EventDetailsFragment, FragmentEventDetailsBinding>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventDetailsBinding invoke(EventDetailsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventDetailsBinding.a(fragment.requireView());
            }
        });
        this.e = LazyKt.a(new Function0<EventSceneAdapter>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$photoAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final EventSceneAdapter invoke() {
                ActivityFragmentActive fragmentActive = EventDetailsFragment.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                return new EventSceneAdapter(fragmentActive, DensityUtils.a(EventDetailsFragment.this.getContext(), 107.0f));
            }
        });
        this.f = LazyKt.a(new Function0<EventRecommendAdapter>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$recommendAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final EventRecommendAdapter invoke() {
                ActivityFragmentActive fragmentActive = EventDetailsFragment.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                return new EventRecommendAdapter(fragmentActive);
            }
        });
        this.g = LazyKt.a(new Function0<EventReviewAdapter>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$feedAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final EventReviewAdapter invoke() {
                return new EventReviewAdapter(EventDetailsFragment.this);
            }
        });
        this.h = LazyKt.a(new Function0<List<String>>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$mTabs$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final List<String> invoke() {
                return new ArrayList();
            }
        });
        this.i = LazyKt.a(new Function0<List<Fragment>>() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$mTabsFragments$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final List<Fragment> invoke() {
                return new ArrayList();
            }
        });
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 24);
        Intrinsics.c(ofInt, "ofInt(0, 24)");
        this.k = ofInt;
    }

    private final void A() {
        EventTrackFeed.l(FeedProtos.Event.ACTIVITY_DETAIL_PUBLISH_FEED_CLICK, j().i());
        Context context = getContext();
        if (context == null) {
            return;
        }
        EventScoreAddPostFragment.b.a(context, a().i(), j().j().activity_score, j().j().activity_evaluate);
    }

    private final void B() {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        FragmentEventDetailsBinding s = s();
        String str = null;
        if (TextUtils.equals((s == null || (shapeTextView = s.as) == null) ? null : shapeTextView.getText(), getString(R.string.event_sign_up_to_group))) {
            K();
            String[] strArr = a().j().scene_images;
            Intrinsics.c(strArr, "mViewModel.eventData.scene_images");
            int i = 0;
            if (!(strArr.length == 0)) {
                i = a().j().scene_images.length;
            }
            EventTrackFeed.a(FeedProtos.Event.ACTIVITY_DETAIL_PAGE_SIGNUP_BTN_CLICK, a().j().id, a().j().group_id, i);
            return;
        }
        FragmentEventDetailsBinding s2 = s();
        CharSequence text = (s2 == null || (shapeTextView2 = s2.as) == null) ? null : shapeTextView2.getText();
        Context context = getContext();
        if (context != null) {
            str = context.getString(R.string.event_to_group);
        }
        if (TextUtils.equals(text, str)) {
            L();
        }
    }

    private final void C() {
        I();
    }

    private final void D() {
        I();
    }

    private final void E() {
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$onClickSign$1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                EventDetailsFragment.this.F();
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] perms) {
                Intrinsics.e(perms, "perms");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        EventHttpUtils eventHttpUtils = EventHttpUtils.a;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        eventHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.community.ui.event.fragment.EventDetailsFragment$requestSignIn$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> parseData) {
                EventDetailsViewModel j;
                Intrinsics.e(parseData, "parseData");
                ToastUtils.a(R.string.sign_in_success);
                CommEventBusUtil commEventBusUtil = CommEventBusUtil.a;
                j = EventDetailsFragment.this.j();
                commEventBusUtil.c(j.i());
            }
        }, j().i(), getFragmentActive());
    }

    private final void G() {
        EventLogData eventLogData = this.q;
        if (eventLogData != null) {
            eventLogData.setUid(a().j().uid);
        }
        EventLogData eventLogData2 = this.q;
        if (eventLogData2 != null) {
            eventLogData2.setSourcePage(FeedProtos.SourcePage.ACTIVITY_DETAIL);
        }
        EventUserInfoDlgFragment.a.a(getParentFragmentManager(), a().j().uid, a().i(), this.q);
    }

    private final void H() {
        I();
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_DETAIL_PAGE_ALL_USER_CLICK, j().i());
    }

    private final void I() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (EventMethods.a(a().j().uid) || a().j().join_num > 0) {
            EventMemberFragment.Companion companion = EventMemberFragment.a;
            String i = a().i();
            String str = a().j().uid;
            Intrinsics.c(str, "mViewModel.eventData.uid");
            companion.a(context, i, str, a().j().quota_num, this.p);
        }
    }

    private final void J() {
        EventDetailsModel eventDetailsModel;
        this.s = true;
        EventTrackFeed.l(FeedProtos.Event.ACTIVITY_DETAIL_EVALUATE_CLICK, a().i());
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_COMMENT_CLICK, a().i());
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null || (eventDetailsModel = (EventDetailsModel) a().d().getValue()) == null) {
            return;
        }
        EventScoreDialogFragment.a.a(eventDetailsModel, fragmentManager);
    }

    private final void K() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.d = new XPopup.Builder(context).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).d((Boolean) true).a((BasePopupView) new EventSignUpPopupWindow(context, new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$z_vDrDVVqE8Qug7IMl0tByvTDig
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.t(EventDetailsFragment.this, view);
            }
        }, a().j())).h();
    }

    private final void L() {
        LogData logData = new LogData();
        logData.from = "event_details";
        logData.activity_id = a().j().id;
        CommunityServiceManager.b().a(getContext(), a().j().group_id, (GroupInfoModel) null, logData, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
    }

    private final void M() {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        s.a.setVisibility(8);
        this.k.cancel();
        s.a.clearAnimation();
        Timer timer = this.m;
        if (timer == null) {
            return;
        }
        timer.cancel();
    }

    private final void N() {
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_SHARE_CLICK, a().i());
        CommunityShareUtils.b().a(getContext(), (EventDetailsModel) a().d().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        Context context;
        FragmentEventDetailsBinding s = s();
        if (s == null || (context = getContext()) == null) {
            return;
        }
        String string = context.getString(R.string.event_details_owner_evaluate);
        Intrinsics.c(string, "context.getString(R.stri…t_details_owner_evaluate)");
        String str = string;
        if (i > 0) {
            str = string + " (" + i + ')';
        }
        s.af.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, EventDetailsModel model, View view) {
        Intrinsics.e(context, "$context");
        Intrinsics.e(model, "$model");
        CommunityServiceManager.b().a(context, model.online_url);
    }

    private final void a(ShapeTextView shapeTextView, boolean z) {
        if (z) {
            ShapeHelper.b(shapeTextView, R.color.syc_a);
        } else if (BluedSkinUtils.c()) {
            ShapeHelper.b(shapeTextView, R.color.event_details_btn_bg);
        } else {
            ShapeHelper.b(shapeTextView, R.color.event_details_btn_night_bg);
        }
    }

    private final void a(TabPageIndicatorWithDot tabPageIndicatorWithDot, int i) {
        FragmentEventDetailsBinding s = s();
        if (s != null && s.q.getVisibility() == 0) {
            tabPageIndicatorWithDot.f = i;
            this.j = i;
            int a2 = StatusBarHelper.a(getActivity()) + s.M.getHeight();
            if (i == 0) {
                int[] iArr = new int[2];
                s.q.getLocationOnScreen(iArr);
                s.R.smoothScrollBy(0, iArr[1] - a2);
            } else if (i != 1) {
            } else {
                int[] iArr2 = new int[2];
                s.c.getLocationOnScreen(iArr2);
                s.R.smoothScrollBy(0, (iArr2[1] - a2) - this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentEventDetailsBinding viewBinding, EventDetailsFragment this$0, int i, int i2, ValueAnimator valueAnimator) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        float f = 1;
        float f2 = intValue;
        float f3 = f2 / 24;
        ViewGroup.LayoutParams layoutParams = viewBinding.a.getLayoutParams();
        if (this$0.getActivity() != null) {
            layoutParams.width = i + DensityUtils.a(this$0.getActivity(), f2);
            layoutParams.height = i2 + DensityUtils.a(this$0.getActivity(), f2);
            ShapeHelper.a(viewBinding.a, layoutParams.width);
            viewBinding.a.setLayoutParams(layoutParams);
            viewBinding.a.setAlpha(f - f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentEventDetailsBinding viewBinding, EventDetailsFragment this$0, ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        if (viewBinding.q.getVisibility() == 0) {
            int[] iArr = new int[2];
            viewBinding.q.getLocationOnScreen(iArr);
            if (iArr[1] <= StatusBarHelper.a(this$0.getActivity()) + viewBinding.M.getHeight()) {
                viewBinding.r.setVisibility(0);
            } else {
                viewBinding.r.setVisibility(4);
            }
            int[] iArr2 = new int[2];
            viewBinding.c.getLocationOnScreen(iArr2);
            if (iArr2[1] <= StatusBarHelper.a(this$0.getActivity()) + viewBinding.M.getHeight() + this$0.n) {
                viewBinding.S.f = 1;
                viewBinding.S.a(1);
                viewBinding.S.postInvalidate();
                viewBinding.T.f = 1;
                viewBinding.T.a(1);
                viewBinding.T.postInvalidate();
                return;
            }
            viewBinding.S.f = 0;
            viewBinding.S.a(0);
            viewBinding.S.postInvalidate();
            viewBinding.T.f = 0;
            viewBinding.T.a(0);
            viewBinding.T.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, Context context, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        BottomMenuPop bottomMenuPop = this$0.t;
        BottomMenuPop bottomMenuPop2 = bottomMenuPop;
        if (bottomMenuPop == null) {
            Intrinsics.c("menuPop");
            bottomMenuPop2 = null;
        }
        bottomMenuPop2.p();
        if (this$0.a().j().mode_id == 2) {
            CommunityServiceManager.b().a(context, this$0.a().j().user_info.name, this$0.a().i(), this$0.a().j().mode_id, this$0.a().j().uid, 0, 0);
        } else {
            this$0.a().s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_DETAIL_PAGE_CANCEL_YES_CLICK, this$0.a().i());
        this$0.a().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, FragmentEventDetailsBinding viewBinding) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        this$0.n = viewBinding.T.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, FragmentEventDetailsBinding viewBinding, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        TabPageIndicatorWithDot tabPageIndicatorWithDot = viewBinding.S;
        Intrinsics.c(tabPageIndicatorWithDot, "viewBinding.tablayout");
        this$0.a(tabPageIndicatorWithDot, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, FragmentEventDetailsBinding viewBinding, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        this$0.j().w();
        viewBinding.ay.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, EventDetailsModel model, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        this$0.k(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        FeedDetailParams feedDetailParams = new FeedDetailParams(0);
        Context context = this$0.getContext();
        Object item = baseQuickAdapter.getItem(i);
        if (item == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.model.BluedIngSelfFeed");
        }
        FeedDetailsFragment.a(context, (BluedIngSelfFeed) item, 25, feedDetailParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, Boolean bool) {
        Intrinsics.e(this$0, "this$0");
        this$0.a().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (str.equals(this$0.j().i())) {
            this$0.j().j().is_sign_in = 1;
            this$0.a(this$0.j().j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0, Ref.ObjectRef userModel, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(userModel, "$userModel");
        this$0.a(((UserBasicModel) userModel.a).uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0329 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x032a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final com.blued.community.ui.event.model.EventDetailsModel r9) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.event.fragment.EventDetailsFragment.a(com.blued.community.ui.event.model.EventDetailsModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsModel model, final EventDetailsFragment this$0, View view) {
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        if (model.is_subscribe != 1) {
            EventTrackFeed.a(FeedProtos.Event.ACTIVITY_SUBSCRIBE_BTN_CLICK, model.id, model.uid, FeedProtos.SourcePage.ACTIVITY_DETAIL);
            EventDetailsViewModel j = this$0.j();
            ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.a(fragmentActive);
            return;
        }
        Context context = this$0.getContext();
        Context context2 = this$0.getContext();
        String string = context2 == null ? null : context2.getString(R.string.event_cancel_sub_dialog_title);
        Context context3 = this$0.getContext();
        String string2 = context3 == null ? null : context3.getString(R.string.event_cancel_sub_dialog_content);
        Context context4 = this$0.getContext();
        String string3 = context4 == null ? null : context4.getString(R.string.common_ok);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$GDcmiYPtpYSIJsr9WaMu0VKG4gk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventDetailsFragment.b(EventDetailsFragment.this, dialogInterface, i);
            }
        };
        Context context5 = this$0.getContext();
        CommonAlertDialog.a(context, string, string2, string3, onClickListener, context5 == null ? null : context5.getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsModel model, EventDetailsFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        EventTrackFeed.h(FeedProtos.Event.ACTIVITY_DETAIL_PHOTO_CLICK, model.id, (String) baseQuickAdapter.getItem(i));
        CommunityServiceManager.b().a((Context) this$0.getActivity(), model.scene_images, i, 0, (LoadOptions) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(EventIdentifyModel eventIdentifyModel) {
        if (eventIdentifyModel.verify == 1 && eventIdentifyModel.video_verify == 1) {
            CommunityServiceManager.b().a(getContext(), a().j().user_info.name, a().i(), a().j().mode_id, a().j().uid, 0, 0);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("from", GeoFence.BUNDLE_KEY_FENCESTATUS);
        bundle.putString("event_id", a().j().id);
        CommunityServiceManager.b().a(getContext(), bundle);
    }

    private final void a(String str) {
        if (str == null) {
            return;
        }
        EventLogData eventLogData = this.q;
        if (eventLogData != null) {
            eventLogData.setUid(str);
        }
        EventLogData eventLogData2 = this.q;
        if (eventLogData2 != null) {
            eventLogData2.setSourcePage(FeedProtos.SourcePage.ACTIVITY_DETAIL);
        }
        EventUserInfoDlgFragment.a.a(getParentFragmentManager(), str, a().i(), this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends BluedIngSelfFeed> list) {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        if (!(!list.isEmpty())) {
            s.q.setVisibility(8);
            s.c.setVisibility(8);
            return;
        }
        s.c.setVisibility(0);
        r().setNewData(list);
        r().setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$l9zggLltiAaRPZFL-4uCk4Y5Obs
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventDetailsFragment.a(EventDetailsFragment.this, baseQuickAdapter, view, i);
            }
        });
        s.q.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        EventDetailsViewModel j = this$0.j();
        ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.b(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsFragment this$0, FragmentEventDetailsBinding viewBinding, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        TabPageIndicatorWithDot tabPageIndicatorWithDot = viewBinding.T;
        Intrinsics.c(tabPageIndicatorWithDot, "viewBinding.tablayoutHover");
        this$0.a(tabPageIndicatorWithDot, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsFragment this$0, EventDetailsModel eventDetailsModel) {
        Intrinsics.e(this$0, "this$0");
        if (eventDetailsModel.id.equals(this$0.j().i())) {
            this$0.j().j().evaluate_status = 1;
            this$0.j().j().activity_evaluate = eventDetailsModel.activity_evaluate;
            this$0.j().j().activity_score = eventDetailsModel.activity_score;
            this$0.a(this$0.j().j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object item = baseQuickAdapter.getItem(i);
        if (item == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.event.model.EventDetailsModel");
        }
        EventDetailsModel eventDetailsModel = (EventDetailsModel) item;
        EventLogData eventLogData = this$0.q;
        if (eventLogData != null) {
            eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_FEED_DETAIL);
        }
        Companion companion = a;
        Context requireContext = this$0.requireContext();
        Intrinsics.c(requireContext, "requireContext()");
        companion.a(requireContext, eventDetailsModel.id, this$0.q);
        EventTrackFeed.b(FeedProtos.Event.ACTIVITY_DETAIL_SOMEONE_CLICK, eventDetailsModel.id, i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventDetailsFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (str.equals(this$0.j().j().uid)) {
            this$0.j().j().is_subscribe = 1;
            this$0.a(this$0.j().j());
        }
    }

    private final void b(final EventDetailsModel eventDetailsModel) {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), eventDetailsModel.user_info.avatar).b(R.drawable.user_bg_round).c().a(s.w);
        s.aj.setText(eventDetailsModel.user_info.name);
        UserInfoHelper.a(s.t, eventDetailsModel.user_info.vbadge, 3);
        UserInfoHelper.a(s.h, eventDetailsModel.user_info);
        String str = null;
        if (eventDetailsModel.is_first == 1) {
            TextView textView = s.aD;
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.event_score_first_none);
            }
            textView.setText(str);
        } else if (eventDetailsModel.score <= 0.0f || getContext() == null) {
            TextView textView2 = s.aD;
            Context context2 = getContext();
            textView2.setText(context2 == null ? null : context2.getString(R.string.event_score_none));
        } else {
            TextView textView3 = s.aD;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = requireContext().getString(R.string.event_details_score);
            Intrinsics.c(string, "requireContext().getStri…ring.event_details_score)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(eventDetailsModel.score)}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView3.setText(format);
        }
        if (TextUtils.isEmpty(eventDetailsModel.max_evaluate)) {
            s.aC.setVisibility(8);
        } else {
            s.aC.setVisibility(0);
            s.aC.setText(Intrinsics.a("| ", (Object) eventDetailsModel.max_evaluate));
        }
        if (eventDetailsModel.publish_activity_count > 0) {
            s.m.setText(Intrinsics.a(getString(R.string.publish_event), (Object) Integer.valueOf(eventDetailsModel.publish_activity_count)));
            s.m.setVisibility(0);
        } else {
            s.m.setVisibility(8);
        }
        if (TextUtils.isEmpty(eventDetailsModel.ip_location)) {
            s.ag.setVisibility(8);
        } else {
            TextView textView4 = s.ag;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String string2 = getString(R.string.feed_ip_location);
            Intrinsics.c(string2, "getString(R.string.feed_ip_location)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{eventDetailsModel.ip_location}, 1));
            Intrinsics.c(format2, "format(format, *args)");
            textView4.setText(format2);
            s.ag.setVisibility(0);
        }
        if (eventDetailsModel.is_subscribe == 1) {
            s.y.setVisibility(8);
            s.aB.setText(R.string.event_cancel_sub_organizer);
            s.aB.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_k));
        } else {
            if (eventDetailsModel.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                s.A.setVisibility(8);
            } else {
                s.A.setVisibility(0);
                EventTrackFeed.a(FeedProtos.Event.ACTIVITY_SUBSCRIBE_BTN_SHOW, eventDetailsModel.id, eventDetailsModel.uid, FeedProtos.SourcePage.ACTIVITY_DETAIL);
            }
            s.y.setVisibility(0);
            s.aB.setText(R.string.event_sub_organizer);
            s.aB.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_m));
        }
        s.A.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$5P9WtoGX6E4RCaPcSEoS4rdGbkc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.a(EventDetailsModel.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(List<? extends EventDetailsModel> list) {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        s.O.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        if (!(!list.isEmpty()) || list.size() < 2) {
            s.b.setVisibility(8);
        } else {
            q().setNewData(list);
            s.az.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$bgBKEA2ATukQzpD4m0x1adovkUM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.k(EventDetailsFragment.this, view);
                }
            });
            s.b.setVisibility(0);
            EventTrackFeed.j(FeedProtos.Event.ACTIVITY_DETAIL_MORE_BTN_SHOW, a().j().id);
        }
        q().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$LSiQ2gUhSDsnSoilCEFQ0nBaVbk
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventDetailsFragment.b(EventDetailsFragment.this, baseQuickAdapter, view, i);
            }
        });
        s.O.setAdapter(q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        if (z) {
            FragmentEventDetailsBinding s = s();
            TextView textView = s == null ? null : s.ay;
            if (textView != null) {
                textView.setVisibility(0);
            }
            FragmentEventDetailsBinding s2 = s();
            TextView textView2 = s2 == null ? null : s2.C;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(0);
            return;
        }
        FragmentEventDetailsBinding s3 = s();
        TextView textView3 = s3 == null ? null : s3.ay;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        FragmentEventDetailsBinding s4 = s();
        TextView textView4 = s4 == null ? null : s4.C;
        if (textView4 == null) {
            return;
        }
        textView4.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventDetailsFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (str.equals(this$0.j().j().uid)) {
            this$0.j().j().is_subscribe = 0;
            this$0.a(this$0.j().j());
        }
    }

    private final void c(EventDetailsModel eventDetailsModel) {
        if (CommunityPreferences.g(eventDetailsModel.id) && i(eventDetailsModel)) {
            EventLogData eventLogData = this.q;
            if (eventLogData != null) {
                eventLogData.setSourcePage(FeedProtos.SourcePage.ACTIVITY_DETAIL);
            }
            EventSignDlgFragment.a.a(getParentFragmentManager(), a().i(), this.q);
            CommunityPreferences.h(a().i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z) {
        FragmentEventDetailsBinding s = s();
        TextView textView = s == null ? null : s.ay;
        if (textView == null) {
            return;
        }
        textView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.D();
    }

    private final void d(EventDetailsModel eventDetailsModel) {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        this.r = EventMethods.a(eventDetailsModel);
        if (eventDetailsModel.status == 1 && eventDetailsModel.apply_status == 1 && eventDetailsModel.is_sign_in == 1 && eventDetailsModel.evaluate_status == 0) {
            this.r = CommunityManager.a.a().s() ? R.drawable.icon_event_signed_dark : R.drawable.icon_event_signed;
        }
        if (this.r == 0) {
            s.x.setVisibility(8);
            return;
        }
        s.x.setVisibility(0);
        s.x.setImageResource(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CommunityServiceManager.b().a(this$0.getContext(), new String[]{this$0.j().j().pic}, 0, 19, (LoadOptions) null);
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.Object] */
    private final void e(EventDetailsModel eventDetailsModel) {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        List<UserBasicModel> list = eventDetailsModel.joiners;
        if (list == null || list.isEmpty()) {
            s.j.setVisibility(8);
            s.aA.setVisibility(0);
            if (this.o) {
                s.aA.setText(getText(R.string.event_main_no_sign_up));
                return;
            } else {
                s.aA.setText(getText(R.string.event_visitor_no_sign_up));
                return;
            }
        }
        s.aA.setVisibility(8);
        s.j.setVisibility(0);
        s.H.removeAllViews();
        int d = RangesKt.d(eventDetailsModel.joiners.size(), 5);
        int a2 = (AppInfo.l - DisplayUtil.a(AppInfo.d(), 315.0f)) / 5;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= d) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.a = eventDetailsModel.joiners.get(i2);
            View inflate = getLayoutInflater().inflate(R.layout.item_event_detail_joiners, (ViewGroup) null);
            inflate.setPadding(0, 0, a2, 0);
            ImageLoader.a(getFragmentActive(), ((UserBasicModel) objectRef.a).avatar).b(R.drawable.user_bg_round).c().a((ImageView) inflate.findViewById(R.id.item_event_detail_joiner_avatar));
            ((TextView) inflate.findViewById(R.id.item_event_detail_joiner_name)).setText(((UserBasicModel) objectRef.a).name);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$Y4fiE5ACU8c1a14spdLhVwVWH78
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.a(EventDetailsFragment.this, objectRef, view);
                }
            });
            s.H.addView(inflate);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.H();
    }

    private final void f(EventDetailsModel eventDetailsModel) {
        Context context;
        boolean z;
        FragmentEventDetailsBinding s = s();
        if (s == null || (context = getContext()) == null) {
            return;
        }
        s.E.setVisibility(0);
        e(eventDetailsModel);
        if (!this.o || this.p || eventDetailsModel.quota_num == eventDetailsModel.join_num || eventDetailsModel.status != 1 || eventDetailsModel.wait_audit <= 0) {
            s.aw.setVisibility(8);
            z = false;
        } else {
            s.aw.setVisibility(0);
            s.aw.setText(context.getString(R.string.event_waiting_to_verified_tab) + eventDetailsModel.wait_audit + context.getString(R.string.event_sign_up_nums));
            z = true;
        }
        s.am.setText(String.valueOf(eventDetailsModel.join_num));
        s.ak.setText(String.valueOf(eventDetailsModel.quota_num));
        if (!this.o || eventDetailsModel.mode_id != 1 || eventDetailsModel.status != 1 || eventDetailsModel.is_sure_sign_in != 1 || eventDetailsModel.activity_sign_num <= 0) {
            s.n.setVisibility(8);
            return;
        }
        TextView textView = s.n;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getString(R.string.event_signed_num);
        Intrinsics.c(string, "getString(R.string.event_signed_num)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(eventDetailsModel.activity_sign_num)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(Intrinsics.a(format, z ? " | " : ""));
        s.n.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c7, code lost:
        if (r0 != 2) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g(com.blued.community.ui.event.model.EventDetailsModel r6) {
        /*
            Method dump skipped, instructions count: 807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.event.fragment.EventDetailsFragment.g(com.blued.community.ui.event.model.EventDetailsModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.x();
    }

    private final void h(EventDetailsModel eventDetailsModel) {
        FragmentEventDetailsBinding s = s();
        if (s == null) {
            return;
        }
        String string = getString(R.string.event_to_group);
        Intrinsics.c(string, "getString(R.string.event_to_group)");
        if (eventDetailsModel.status == 0) {
            s.d.setVisibility(8);
        } else {
            s.d.setVisibility(0);
            s.d.setText(getString(R.string.post_feed));
            EventTrackFeed.l(FeedProtos.Event.ACTIVITY_DETAIL_PUBLISH_FEED_SHOW, eventDetailsModel.id);
            s.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$StA5ubUaUoPFiEKe0D3V3rK84RA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.r(EventDetailsFragment.this, view);
                }
            });
        }
        s.as.setText(string);
        ShapeTextView shapeTextView = s.as;
        Intrinsics.c(shapeTextView, "viewBinding.tvEventSignUpBtn");
        a(shapeTextView, true);
        s.as.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$hA21mcS_KVyI8FQg53IX755pTJc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.s(EventDetailsFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.N();
    }

    private final boolean i(EventDetailsModel eventDetailsModel) {
        return eventDetailsModel.is_sure_sign_in == 1 && eventDetailsModel.is_sign_in == 0 && eventDetailsModel.mode_id == 1 && !this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BottomMenuPop bottomMenuPop = this$0.t;
        BottomMenuPop bottomMenuPop2 = bottomMenuPop;
        if (bottomMenuPop == null) {
            Intrinsics.c("menuPop");
            bottomMenuPop2 = null;
        }
        bottomMenuPop2.p();
        this$0.y();
    }

    private final void j(final EventDetailsModel eventDetailsModel) {
        final Context context;
        String str;
        FragmentEventDetailsBinding s = s();
        if (s == null || (context = getContext()) == null) {
            return;
        }
        if (eventDetailsModel.mode_id == 2) {
            s.I.setVisibility(0);
            s.f.setVisibility(8);
            if (TextUtils.isEmpty(eventDetailsModel.online_text)) {
                s.an.setText("线上活动");
                s.ao.setText((CharSequence) null);
            } else {
                s.an.setText("地址");
                s.ao.setText(eventDetailsModel.online_text);
            }
            s.ao.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$rN_5uv0kx_KUwfviTrBoVyogw54
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.a(context, eventDetailsModel, view);
                }
            });
        } else if (eventDetailsModel.mode_id == 1) {
            s.I.setVisibility(8);
            s.f.setVisibility(0);
            if (!TextUtils.isEmpty(eventDetailsModel.city) && !TextUtils.isEmpty(eventDetailsModel.location)) {
                str = eventDetailsModel.city + (char) 183 + ((Object) eventDetailsModel.location);
            } else if (!TextUtils.isEmpty(eventDetailsModel.city)) {
                str = eventDetailsModel.city;
                Intrinsics.c(str, "model.city");
            } else if (TextUtils.isEmpty(eventDetailsModel.location)) {
                str = "";
            } else {
                str = eventDetailsModel.location;
                Intrinsics.c(str, "model.location");
            }
            s.ah.setText(str);
            if (TextUtils.isEmpty(eventDetailsModel.location_detail)) {
                s.ac.setVisibility(8);
            } else {
                s.ac.setVisibility(0);
                s.ac.setText(eventDetailsModel.location_detail);
            }
            if (TextUtils.isEmpty(eventDetailsModel.distance) || eventDetailsModel.show_distance != 1) {
                s.ad.setVisibility(8);
                s.o.setVisibility(8);
            } else {
                s.ad.setVisibility(0);
                s.o.setVisibility(0);
                s.ad.setText(EventMethods.b(eventDetailsModel.distance));
            }
            s.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$iKq8WLqmC4dFPijyxxqV-ILVNso
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.a(EventDetailsFragment.this, eventDetailsModel, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        EventListFragment.a.a(context);
        EventTrackFeed.j(FeedProtos.Event.ACTIVITY_DETAIL_MORE_BTN_CLICK, this$0.a().j().id);
    }

    private final void k(EventDetailsModel eventDetailsModel) {
        if (l(eventDetailsModel)) {
            CommunityServiceManager.b().a(getContext(), eventDetailsModel.longitude, eventDetailsModel.latitude, eventDetailsModel.location_detail, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.B();
    }

    private final boolean l(EventDetailsModel eventDetailsModel) {
        new CoordinateConverter(getContext());
        String str = eventDetailsModel.latitude;
        Intrinsics.c(str, "model.latitude");
        double parseDouble = Double.parseDouble(str);
        String str2 = eventDetailsModel.longitude;
        Intrinsics.c(str2, "model.longitude");
        return !(TextUtils.isEmpty(eventDetailsModel.latitude) && TextUtils.isEmpty(eventDetailsModel.longitude)) && CoordinateConverter.isAMapDataAvailable(parseDouble, Double.parseDouble(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.M();
        this$0.A();
    }

    private final FragmentEventDetailsBinding s() {
        return (FragmentEventDetailsBinding) this.c.b(this, b[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.L();
    }

    private final List<String> t() {
        return (List) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(EventDetailsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a().u();
        String[] strArr = this$0.a().j().scene_images;
        Intrinsics.c(strArr, "mViewModel.eventData.scene_images");
        int i = 0;
        if (!(strArr.length == 0)) {
            i = this$0.a().j().scene_images.length;
        }
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_DETAIL_PAGE_SIGNUP_POP_APPLY_CLICK, this$0.a().j().id, this$0.a().j().group_id, i);
    }

    private final List<Fragment> u() {
        return (List) this.i.getValue();
    }

    private final void v() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SIGN_IN_SUCCESS", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$WlXc2SU-FmSHAzaRB-ydnNwhJkQ
            public final void onChanged(Object obj) {
                EventDetailsFragment.a(EventDetailsFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SUBSCRIBE_SUCCESS", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$oaGIM9Y29eWSjDoxgEwMEcYESdc
            public final void onChanged(Object obj) {
                EventDetailsFragment.b(EventDetailsFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_ACTIVITY_CANCEL_SUBSCRIBE", String.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$v3d2pk6_VLGZY_nFdexQsIilEzM
            public final void onChanged(Object obj) {
                EventDetailsFragment.c(EventDetailsFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SCORED", EventDetailsModel.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$QUNX0NGLN-84E1e009tOB4GxNl4
            public final void onChanged(Object obj) {
                EventDetailsFragment.b(EventDetailsFragment.this, (EventDetailsModel) obj);
            }
        });
    }

    private final void w() {
        final FragmentEventDetailsBinding s = s();
        if (s == null || getContext() == null) {
            return;
        }
        s.Y.getLayoutParams().height = StatusBarHelper.a(getActivity());
        s.V.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$-pW2DMuct_e8sMfyjb-eug_uJe8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.g(EventDetailsFragment.this, view);
            }
        });
        s.W.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$SDI_tLc05yHKcHHXL-taQfXsbeQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.h(EventDetailsFragment.this, view);
            }
        });
        s.X.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$jC1q2qFSFmTVh4WH_EnO6sM-8j8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.i(EventDetailsFragment.this, view);
            }
        });
        s.R.setScrollViewListener(new ObservableScrollView.ScrollViewListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$-grxP_eBHMSI4zgi4wj7jLElqd0
            @Override // com.blued.android.module.common.view.ObservableScrollView.ScrollViewListener
            public final void onScrollChanged(ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
                EventDetailsFragment.a(FragmentEventDetailsBinding.this, this, observableScrollView, i, i2, i3, i4);
            }
        });
    }

    private final void x() {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        this.t = new BottomMenuPop(context);
        ArrayList arrayList = new ArrayList();
        BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
        menuItemInfo.a = context.getString(R.string.event_cancel_registration);
        menuItemInfo.b = R.color.syc_h;
        menuItemInfo.d = new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$j6WEvJiCEZkA1XQtjJuXi_6ottY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.j(EventDetailsFragment.this, view);
            }
        };
        BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
        menuItemInfo2.a = context.getString(R.string.report);
        menuItemInfo2.b = R.color.syc_h;
        menuItemInfo2.d = new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$ZCRTpPo2b7AtmwJHO-srdyIhBLY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventDetailsFragment.a(EventDetailsFragment.this, context, view);
            }
        };
        if (a().j().apply_status == 1 && a().j().status != 3 && a().j().status != 4 && a().j().status != 5) {
            arrayList.add(menuItemInfo);
        }
        arrayList.add(menuItemInfo2);
        BottomMenuPop bottomMenuPop = this.t;
        BottomMenuPop bottomMenuPop2 = bottomMenuPop;
        if (bottomMenuPop == null) {
            Intrinsics.c("menuPop");
            bottomMenuPop2 = null;
        }
        bottomMenuPop2.b = arrayList;
        XPopup.Builder builder = new XPopup.Builder(context);
        BottomMenuPop bottomMenuPop3 = this.t;
        if (bottomMenuPop3 == null) {
            Intrinsics.c("menuPop");
            bottomMenuPop3 = null;
        }
        builder.a((BasePopupView) bottomMenuPop3).h();
    }

    private final void y() {
        TextView e;
        BluedAlertDialog a2 = CommonAlertDialog.a(getContext(), "", requireContext().getString(R.string.event_cancel_registration_dialog), (String) null, new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$NwM93P1tZb7u_MXDfAmOWHVVT_w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventDetailsFragment.a(EventDetailsFragment.this, dialogInterface, i);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        if (a2 == null || (e = a2.e()) == null) {
            return;
        }
        e.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
    }

    private final void z() {
        final FragmentEventDetailsBinding s;
        if ((!t().isEmpty()) || (s = s()) == null) {
            return;
        }
        u().add(new Fragment());
        u().add(new Fragment());
        List<String> t = t();
        String string = requireContext().getString(R.string.event_details_details);
        Intrinsics.c(string, "requireContext().getStri…ng.event_details_details)");
        t.add(string);
        List<String> t2 = t();
        String string2 = requireContext().getString(R.string.event_details_evaluate);
        Intrinsics.c(string2, "requireContext().getStri…g.event_details_evaluate)");
        t2.add(string2);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        PagerAdapter myAdapter = new MyAdapter(childFragmentManager, t(), u());
        CustomViewPager customViewPager = new CustomViewPager(getContext(), null);
        customViewPager.setAdapter(myAdapter);
        s.S.setViewPager(customViewPager);
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.c(childFragmentManager2, "childFragmentManager");
        PagerAdapter myAdapter2 = new MyAdapter(childFragmentManager2, t(), u());
        CustomViewPager customViewPager2 = new CustomViewPager(getContext(), null);
        customViewPager2.setAdapter(myAdapter2);
        s.T.setViewPager(customViewPager2);
        s.S.setIndicatorColor(R.color.syc_a);
        s.T.setIndicatorColor(R.color.syc_a);
        s.S.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$KUyuBZNGybB9U6zst9wKqs6pf-c
            @Override // com.blued.android.module.common.view.TabPageIndicatorWithDot.OnTitleClickListener
            public final void onClick(int i) {
                EventDetailsFragment.a(EventDetailsFragment.this, s, i);
            }
        });
        s.T.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$Gx_wbK1JgGSZgHwCKwYSxNY2hfo
            @Override // com.blued.android.module.common.view.TabPageIndicatorWithDot.OnTitleClickListener
            public final void onClick(int i) {
                EventDetailsFragment.b(EventDetailsFragment.this, s, i);
            }
        });
        s.S.f = 0;
        s.T.f = 0;
        s.S.b();
        s.T.b();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ShapeFrameLayout shapeFrameLayout;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        ShapeFrameLayout shapeFrameLayout2;
        ShapeLinearLayout shapeLinearLayout;
        Context context;
        StatusBarHelper.a(getActivity(), false);
        w();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = (EventLogData) arguments.getSerializable("log_data");
        }
        final FragmentEventDetailsBinding s = s();
        if (s != null && (context = getContext()) != null) {
            s.P.setNestedScrollingEnabled(false);
            s.P.setHasFixedSize(true);
            s.P.setLayoutManager(new LinearLayoutManager(context));
            s.P.setAdapter(r());
            s.ay.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$fq1BxlKQ7DM2j9grichcgt42zdw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.a(EventDetailsFragment.this, s, view);
                }
            });
            s.av.getBackground().setAlpha(30);
            if (BluedSkinUtils.c()) {
                s.au.getBackground().setAlpha(30);
            } else {
                s.au.getBackground().setAlpha(60);
            }
            z();
            s.S.f = this.j;
            s.T.post(new Runnable() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$U97yCUOQ1EUCKBJrFYUepiev4_c
                @Override // java.lang.Runnable
                public final void run() {
                    EventDetailsFragment.a(EventDetailsFragment.this, s);
                }
            });
            if (CommunityManager.a.a().s()) {
                s.S.setRealTextColor(R.color.syc_EAEAEA);
                s.S.setRealTabTextColorUnfocused(R.color.syc_dark_989898);
                s.T.setRealTextColor(R.color.syc_EAEAEA);
                s.T.setRealTabTextColorUnfocused(R.color.syc_dark_989898);
                s.i.setImageResource(R.drawable.event_detail_joiners_right_arrow);
            } else {
                s.S.setRealTextColor(R.color.syc_dark_1e1f23);
                s.S.setRealTabTextColorUnfocused(R.color.syc_999999);
                s.T.setRealTextColor(R.color.syc_dark_1e1f23);
                s.T.setRealTabTextColorUnfocused(R.color.syc_999999);
                s.i.setImageResource(R.drawable.event_detail_joiners_right_arrow_dark);
            }
        }
        FragmentEventDetailsBinding s2 = s();
        if (s2 != null && (shapeLinearLayout = s2.F) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$nQKI0gHfTbIqcS3aE6t9Dzj95tE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.a(EventDetailsFragment.this, view);
                }
            });
        }
        FragmentEventDetailsBinding s3 = s();
        if (s3 != null && (shapeFrameLayout2 = s3.N) != null) {
            shapeFrameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$nLnU4iy_Uu2WjltIqoYfpP-aX48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.b(EventDetailsFragment.this, view);
                }
            });
        }
        FragmentEventDetailsBinding s4 = s();
        if (s4 != null && (textView2 = s4.n) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$Eiw0pDznPjoSJDUijYWLZgj1jW4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.c(EventDetailsFragment.this, view);
                }
            });
        }
        FragmentEventDetailsBinding s5 = s();
        if (s5 != null && (textView = s5.aw) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$R5SqKZJRT96THTWdqIkj_2guqdw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.d(EventDetailsFragment.this, view);
                }
            });
        }
        FragmentEventDetailsBinding s6 = s();
        if (s6 != null && (imageView = s6.u) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$ml5bNKGsJSTzDTYXUDAovv3HyKk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.e(EventDetailsFragment.this, view);
                }
            });
        }
        FragmentEventDetailsBinding s7 = s();
        if (s7 != null && (shapeFrameLayout = s7.k) != null) {
            shapeFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$PmXFuLE0QvaxrRZ9OAcxUUj2bmc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventDetailsFragment.f(EventDetailsFragment.this, view);
                }
            });
        }
        v();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LifecycleExtKt.a(lifecycleOwner, a().d(), new EventDetailsFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(lifecycleOwner, a().f(), new EventDetailsFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(lifecycleOwner, a().g(), new EventDetailsFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(lifecycleOwner, a().p(), new EventDetailsFragment$liveDataObserver$4(this));
        LifecycleExtKt.a(lifecycleOwner, a().o(), new EventDetailsFragment$liveDataObserver$5(this));
        LifecycleExtKt.a(lifecycleOwner, a().e(), new EventDetailsFragment$liveDataObserver$6(this));
        LifecycleExtKt.a(lifecycleOwner, a().h(), new EventDetailsFragment$liveDataObserver$7(this));
        LiveEventBus.get("event_examine_user", Boolean.TYPE).observeForever(new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$dN0xYRVtRfl6DF0LNJAu5kYiPEc
            public final void onChanged(Object obj) {
                EventDetailsFragment.a(EventDetailsFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ShapeTextView shapeTextView3;
        Tracker.onClick(view);
        int i = 0;
        if (view != null && view.getId() == R.id.tv_event_sign_up_btn) {
            FragmentEventDetailsBinding s = s();
            CharSequence text = (s == null || (shapeTextView = s.as) == null) ? null : shapeTextView.getText();
            Context context = getContext();
            if (TextUtils.equals(text, context == null ? null : context.getString(R.string.event_sign_up_to_group))) {
                K();
                String[] strArr = a().j().scene_images;
                Intrinsics.c(strArr, "mViewModel.eventData.scene_images");
                if (!(strArr.length == 0)) {
                    i = a().j().scene_images.length;
                }
                EventTrackFeed.a(FeedProtos.Event.ACTIVITY_DETAIL_PAGE_SIGNUP_BTN_CLICK, a().j().id, a().j().group_id, i);
                return;
            }
            FragmentEventDetailsBinding s2 = s();
            CharSequence text2 = (s2 == null || (shapeTextView2 = s2.as) == null) ? null : shapeTextView2.getText();
            Context context2 = getContext();
            if (TextUtils.equals(text2, context2 == null ? null : context2.getString(R.string.event_to_group))) {
                L();
                return;
            }
            FragmentEventDetailsBinding s3 = s();
            CharSequence text3 = (s3 == null || (shapeTextView3 = s3.as) == null) ? null : shapeTextView3.getText();
            Context context3 = getContext();
            TextUtils.equals(text3, context3 == null ? null : context3.getString(R.string.event_sign_up_exmine));
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        Activity activity = getActivity();
        if (activity != null) {
            StatusBarHelper.a(activity, true);
        }
        M();
        Timer timer = this.m;
        if (timer == null) {
            return;
        }
        timer.cancel();
    }

    public final EventSceneAdapter p() {
        return (EventSceneAdapter) this.e.getValue();
    }

    public final EventRecommendAdapter q() {
        return (EventRecommendAdapter) this.f.getValue();
    }

    public final EventReviewAdapter r() {
        return (EventReviewAdapter) this.g.getValue();
    }
}
