package com.blued.community.ui.feed.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.FullScreenDialog;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.community.R;
import com.blued.community.databinding.FragmentFeedInteractBinding;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedInteractItemModel;
import com.blued.community.ui.feed.observer.LikeListDataObserver;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedInteractPopWindow.class */
public final class FeedInteractPopWindow extends AttachPopupView {
    static final /* synthetic */ KProperty<Object>[] t = {Reflection.a(new PropertyReference1Impl(FeedInteractPopWindow.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentFeedInteractBinding;", 0))};
    private CommonRecycleAdapter<FeedInteractItemModel> A;
    private int B;
    private final float[] C;
    private final Context u;
    private final BluedIngSelfFeed v;
    private final LogData w;
    private final boolean x;
    private final IRequestHost y;
    private final ViewBindingProperty z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInteractPopWindow(Context mContext, BluedIngSelfFeed feedData, LogData logData, boolean z, IRequestHost fragmentActive) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(feedData, "feedData");
        Intrinsics.e(logData, "logData");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.u = mContext;
        this.v = feedData;
        this.w = logData;
        this.x = z;
        this.y = fragmentActive;
        this.z = new CustomViewBindingProperty(new Function1<FeedInteractPopWindow, FragmentFeedInteractBinding>() { // from class: com.blued.community.ui.feed.dialog.FeedInteractPopWindow$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentFeedInteractBinding invoke(FeedInteractPopWindow popView) {
                Intrinsics.e(popView, "popView");
                return FragmentFeedInteractBinding.a(popView.getPopupImplView());
            }
        });
        this.B = -1;
        this.C = new float[2];
    }

    private final void B() {
        FragmentFeedInteractBinding viewBinding = getViewBinding();
        RecyclerView recyclerView = viewBinding == null ? null : viewBinding.d;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        this.A = new FeedInteractPopWindow$createAdapter$1(this, getContext());
        FragmentFeedInteractBinding viewBinding2 = getViewBinding();
        RecyclerView recyclerView2 = viewBinding2 == null ? null : viewBinding2.d;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.A);
    }

    private final void C() {
        if (UserInfoHelper.a(this.v.relationship)) {
            return;
        }
        this.v.iliked = 1;
        this.v.isPlayLikeAnim = true;
        LikeListDataObserver.a().a(UserInfoUtils.c(), this.v.iliked);
        LiveEventBus.get("feed_like_change").post(this.v);
        FeedHttpUtils.a(this.u, (BluedUIHttpResponse) null, UserInfoUtils.c(), this.v.feed_id, this.v.is_ads, this.v.liked_url, this.y);
    }

    private final void D() {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = getContext().getResources().getStringArray(R.array.feed_interact_str);
        Intrinsics.c(stringArray, "context.resources.getStr….array.feed_interact_str)");
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            FeedInteractItemModel feedInteractItemModel = new FeedInteractItemModel();
            feedInteractItemModel.setId(i3);
            String e = FeedMethods.e(feedInteractItemModel.getId());
            Intrinsics.c(e, "getFeedInteractDrawable(model.id)");
            feedInteractItemModel.setDrawableRes(e);
            String str = stringArray[i2];
            Intrinsics.c(str, "names[index]");
            feedInteractItemModel.setName(str);
            arrayList.add(feedInteractItemModel);
            if (this.v.expression_id > 0 && feedInteractItemModel.getId() == this.v.expression_id) {
                this.B = i2;
            }
            i = i3;
        }
        CommonRecycleAdapter<FeedInteractItemModel> commonRecycleAdapter = this.A;
        if (commonRecycleAdapter == null) {
            return;
        }
        commonRecycleAdapter.setDataAndNotify(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        G();
    }

    private final void F() {
        postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedInteractPopWindow$KM00UXDRsyyufudU2F_JZrlZUg4
            @Override // java.lang.Runnable
            public final void run() {
                FeedInteractPopWindow.d(FeedInteractPopWindow.this);
            }
        }, 50L);
    }

    private final void G() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FragmentFeedInteractBinding viewBinding = getViewBinding();
        if (viewBinding != null && (frameLayout2 = viewBinding.f18872c) != null) {
            frameLayout2.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(200L);
            frameLayout2.startAnimation(translateAnimation);
        }
        FragmentFeedInteractBinding viewBinding2 = getViewBinding();
        if (viewBinding2 == null || (frameLayout = viewBinding2.b) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "alpha", 1.0f, 0.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 1f, 0f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedInteractPopWindow$dismissAnim$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FeedInteractPopWindow.this.q();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PathMeasure mPathMeasure, FeedInteractPopWindow this$0, ImageView imageView, ValueAnimator valueAnimator) {
        Intrinsics.e(mPathMeasure, "$mPathMeasure");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(imageView, "$imageView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        mPathMeasure.getPosTan(((Float) animatedValue).floatValue(), this$0.C, null);
        imageView.setTranslationX(this$0.C[0]);
        imageView.setTranslationY(this$0.C[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final View view, final FeedInteractItemModel feedInteractItemModel, final int i) {
        FeedProtos.SourcePage f = EventTrackFeed.f(this.w.feedFrom);
        if (this.w.isFromFeedDetail) {
            f = FeedProtos.SourcePage.FEED_DETAIL_PAGE;
        }
        FeedProtos.FeedProto build = EventTrackFeed.a(FeedProtos.Event.MORE_EMOJI_PANEL_ONE_CLICK, this.v, this.w.feedFrom).setSourcePage(f).setId(EventTrackFeed.a(String.valueOf(feedInteractItemModel.getId()))).build();
        boolean z = true;
        if (i == 0) {
            if (1 == this.v.iliked) {
                A();
                postDelayed(new Runnable() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedInteractPopWindow$2OBjJgtdAbpPnx-P1FCz4zSIwMo
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedInteractPopWindow.c(FeedInteractPopWindow.this);
                    }
                }, 200L);
                return;
            }
            C();
            b(view, feedInteractItemModel, i);
            EventTrackUtils.a(build);
            return;
        }
        if (feedInteractItemModel.getId() == this.v.expression_id) {
            z = false;
        }
        if (!z) {
            final IRequestHost iRequestHost = this.y;
            FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<BusFeedInteractModel>>(iRequestHost) { // from class: com.blued.community.ui.feed.dialog.FeedInteractPopWindow$onClickModel$3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BusFeedInteractModel> parseData) {
                    Intrinsics.e(parseData, "parseData");
                    BusFeedInteractModel busFeedInteractModel = new BusFeedInteractModel();
                    busFeedInteractModel.setFeedId(FeedInteractPopWindow.this.getFeedData().feed_id);
                    busFeedInteractModel.setExpression_id(0);
                    busFeedInteractModel.setInteraction_id(0);
                    busFeedInteractModel.setInteraction_count(FeedInteractPopWindow.this.getFeedData().interaction_count - 1);
                    if (busFeedInteractModel.getInteraction_count() < 0) {
                        busFeedInteractModel.setInteraction_count(0);
                    }
                    busFeedInteractModel.setAdd(false);
                    CommEventBusUtil.f20461a.a(busFeedInteractModel);
                    FeedInteractPopWindow.this.E();
                }
            }, this.v.feed_id, feedInteractItemModel.getId(), this.v.interaction_id, this.y);
            return;
        }
        final IRequestHost iRequestHost2 = this.y;
        FeedHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<BusFeedInteractModel>>(iRequestHost2) { // from class: com.blued.community.ui.feed.dialog.FeedInteractPopWindow$onClickModel$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BusFeedInteractModel> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.getSingleData() != null) {
                    BusFeedInteractModel singleData = parseData.getSingleData();
                    singleData.setFeedId(FeedInteractPopWindow.this.getFeedData().feed_id);
                    singleData.setAdd(true);
                    CommEventBusUtil.f20461a.a(singleData);
                    FeedInteractPopWindow.this.b(view, feedInteractItemModel, i);
                }
            }
        }, this.v.feed_id, feedInteractItemModel.getId(), this.v.interaction_id, this.y);
        EventTrackUtils.a(build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedInteractPopWindow this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(View view, FeedInteractItemModel feedInteractItemModel, int i) {
        Window window;
        View view2;
        FullScreenDialog fullScreenDialog = this.r;
        final FrameLayout frameLayout = (FrameLayout) ((fullScreenDialog == null || (window = fullScreenDialog.getWindow()) == null) ? null : window.getDecorView());
        if (frameLayout == null) {
            return;
        }
        final ImageView imageView = new ImageView(getContext());
        ImageLoader.c(null, feedInteractItemModel.getDrawableRes()).a(imageView);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(FeedMethods.c(50), FeedMethods.c(50)));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        FragmentFeedInteractBinding viewBinding = getViewBinding();
        if (viewBinding != null && (view2 = viewBinding.f18871a) != null) {
            view2.getLocationInWindow(iArr2);
        }
        int[] iArr3 = new int[2];
        iArr3[0] = AppInfo.l / 2;
        if (z()) {
            iArr3[1] = iArr2[1] - FeedMethods.c(200);
            if (iArr3[1] < 0) {
                iArr3[1] = 0;
            }
        } else {
            iArr3[1] = iArr2[1] + FeedMethods.c(200);
        }
        float f = iArr[0];
        float f2 = iArr[1];
        int i2 = iArr2[0];
        int i3 = iArr2[1];
        Path path = new Path();
        path.moveTo(f, f2);
        float f3 = i2;
        path.quadTo((f + f3) / 2, iArr3[1], f3, i3);
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
        Intrinsics.c(ofFloat, "ofFloat(0f, mPathMeasure.length)");
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedInteractPopWindow$JISzB6j_Ri7ow6b-Kvjj1UKR_Vo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedInteractPopWindow.a(PathMeasure.this, this, imageView, valueAnimator);
            }
        });
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "ScaleX", 1.0f, 0.0f);
        Intrinsics.c(ofFloat2, "ofFloat(imageView, \"ScaleX\", 1f, 0f)");
        ObjectAnimator objectAnimator = ofFloat2;
        objectAnimator.setDuration(300L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "ScaleY", 1.0f, 0.0f);
        Intrinsics.c(ofFloat3, "ofFloat(imageView, \"ScaleY\", 1f, 0f)");
        ObjectAnimator objectAnimator2 = ofFloat3;
        objectAnimator2.setDuration(300L);
        objectAnimator.start();
        objectAnimator2.start();
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.dialog.FeedInteractPopWindow$onCloseWithAnim$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrameLayout.this.removeView(imageView);
                this.E();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FeedInteractPopWindow this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedInteractPopWindow this$0) {
        final FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Intrinsics.e(this$0, "this$0");
        FragmentFeedInteractBinding viewBinding = this$0.getViewBinding();
        if (viewBinding != null && (frameLayout2 = viewBinding.f18872c) != null) {
            frameLayout2.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(200L);
            frameLayout2.startAnimation(translateAnimation);
        }
        FragmentFeedInteractBinding viewBinding2 = this$0.getViewBinding();
        if (viewBinding2 == null || (frameLayout = viewBinding2.b) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "alpha", 0.1f, 1.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0.1f, 1f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.community.ui.feed.dialog.FeedInteractPopWindow$showAnim$1$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrameLayout.this.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    private final FragmentFeedInteractBinding getViewBinding() {
        return (FragmentFeedInteractBinding) this.z.b(this, t[0]);
    }

    public final void A() {
        if (UserInfoHelper.a(this.v.relationship)) {
            return;
        }
        this.v.iliked = 0;
        LikeListDataObserver.a().a(UserInfoUtils.c(), this.v.iliked);
        LiveEventBus.get("feed_like_change").post(this.v);
        FeedHttpUtils.a(this.u, (BluedUIHttpResponse) null, UserInfoUtils.c(), this.v.feed_id, this.v.is_ads, this.y);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        super.b();
        if (CommunityManager.f19086a.a().s()) {
            FragmentFeedInteractBinding viewBinding = getViewBinding();
            if (viewBinding != null && (frameLayout2 = viewBinding.b) != null) {
                frameLayout2.setBackgroundResource(R.drawable.feed_interact_pop_bg_dark);
            }
        } else {
            FragmentFeedInteractBinding viewBinding2 = getViewBinding();
            if (viewBinding2 != null && (frameLayout = viewBinding2.b) != null) {
                frameLayout.setBackgroundResource(R.drawable.feed_interact_pop_bg);
            }
        }
        B();
        getRootView().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedInteractPopWindow$VJQALvTlZsSy6mBHEMtmGiL264I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedInteractPopWindow.a(FeedInteractPopWindow.this, view);
            }
        });
        D();
        F();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView
    public void c() {
        super.c();
        PartShadowContainer partShadowContainer = this.f9959c;
        if (partShadowContainer == null) {
            return;
        }
        partShadowContainer.setBackgroundResource(R.color.transparent);
    }

    public final CommonRecycleAdapter<FeedInteractItemModel> getAdapter() {
        return this.A;
    }

    public final BluedIngSelfFeed getFeedData() {
        return this.v;
    }

    public final IRequestHost getFragmentActive() {
        return this.y;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.fragment_feed_interact;
    }

    public final LogData getLogData() {
        return this.w;
    }

    public final Context getMContext() {
        return this.u;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxHeight() {
        return FeedMethods.c(98);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return FeedMethods.c(314);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getPopupLayoutId() {
        return super.getPopupLayoutId();
    }

    public final void setAdapter(CommonRecycleAdapter<FeedInteractItemModel> commonRecycleAdapter) {
        this.A = commonRecycleAdapter;
    }

    public final boolean z() {
        return this.x;
    }
}
