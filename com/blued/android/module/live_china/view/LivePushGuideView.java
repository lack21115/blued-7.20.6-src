package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.IsLast180DayExtraModel;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePushGuideView.class */
public final class LivePushGuideView extends FrameLayout implements PushGuideObserver.IPushGuideObserver {
    public static final Companion a = new Companion(null);
    private final Context b;
    private BaseFragment c;
    private boolean d;
    private int e;
    private LivePushGuideShadeView f;
    private View g;
    private View h;
    private View i;
    private View j;
    private int k;
    private int l;
    private int m;
    private int n;
    private final ImageView o;
    private final TextView p;
    private final ShapeTextView q;
    private int r;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePushGuideView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePushGuideView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
        this.o = new ImageView(getContext());
        this.p = new TextView(getContext());
        this.q = new ShapeTextView(getContext());
        PushGuideObserver.a.a().b();
        PushGuideObserver.a.a().a((PushGuideObserver.IPushGuideObserver) this);
    }

    private final int a(MotionEvent motionEvent) {
        LivePushGuideShadeView livePushGuideShadeView;
        if (this.f == null) {
            return 0;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.e;
        if (i != 1) {
            if (i == 2) {
                int i2 = 3;
                if (livePushGuideShadeView.getTargetX() < x) {
                    i2 = 3;
                    if (x < livePushGuideShadeView.getTargetX() + livePushGuideShadeView.getTargetW()) {
                        i2 = 3;
                        if (livePushGuideShadeView.getTargetY() < y) {
                            i2 = 3;
                            if (y < livePushGuideShadeView.getTargetY() + livePushGuideShadeView.getTargetH()) {
                                i2 = 1;
                            }
                        }
                    }
                }
                return i2;
            } else if (i != 3) {
                return 3;
            } else {
                int i3 = 3;
                if (livePushGuideShadeView.getTargetX() < x) {
                    i3 = 3;
                    if (x < livePushGuideShadeView.getTargetX() + livePushGuideShadeView.getTargetW()) {
                        i3 = 3;
                        if (livePushGuideShadeView.getTargetY() < y) {
                            i3 = 3;
                            if (y < livePushGuideShadeView.getTargetY() + livePushGuideShadeView.getTargetH()) {
                                i3 = 1;
                            }
                        }
                    }
                }
                return i3;
            }
        } else if (livePushGuideShadeView.getTargetX() >= x || x >= livePushGuideShadeView.getTargetX() + livePushGuideShadeView.getTargetW() || livePushGuideShadeView.getTargetY() >= y || y >= livePushGuideShadeView.getTargetY() + livePushGuideShadeView.getTargetH()) {
            return 3;
        } else {
            View view = this.h;
            if (view == null) {
                return 2;
            }
            int[] iArr = new int[2];
            Intrinsics.a(view);
            view.getLocationOnScreen(iArr);
            int i4 = iArr[0];
            int i5 = iArr[1];
            View view2 = this.h;
            Intrinsics.a(view2);
            int width = view2.getWidth();
            View view3 = this.h;
            Intrinsics.a(view3);
            int height = view3.getHeight();
            int i6 = 2;
            if (i4 < x) {
                i6 = 2;
                if (x < i4 + width) {
                    i6 = 2;
                    if (i5 < y) {
                        i6 = 2;
                        if (y < i5 + height) {
                            i6 = 1;
                        }
                    }
                }
            }
            return i6;
        }
    }

    private final void a(int i) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.a = 560L;
        if (this.o.getParent() == null) {
            int a2 = DensityUtils.a(getContext(), 82.0f);
            this.o.setLayoutParams(new FrameLayout.LayoutParams(a2, a2));
            this.o.setAlpha(0.0f);
            addView(this.o);
            longRef.a = 100L;
        }
        this.o.animate().alpha(0.0f).setDuration(200L).setListener(new LivePushGuideView$showFinger$1(longRef, this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, LivePushGuideShadeView it, LivePushGuideView this$0) {
        int targetY;
        int a2;
        int i2;
        float f;
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        float f2 = 0.0f;
        if (i == 1) {
            f2 = (it.getTargetX() + it.getTargetW()) - DensityUtils.a(this$0.getContext(), 91.0f);
            targetY = it.getTargetY();
            a2 = DensityUtils.a(this$0.getContext(), 86.0f);
        } else if (i == 2) {
            f2 = ((it.getTargetX() + it.getTargetW()) - DensityUtils.a(this$0.getContext(), 61.0f)) - (this$0.p.getWidth() / 2);
            i2 = (it.getTargetY() - DensityUtils.a(this$0.getContext(), 11.0f)) - this$0.p.getHeight();
            f = i2;
            this$0.p.setTranslationX(f2);
            this$0.p.setTranslationY(DensityUtils.a(this$0.getContext(), 15.0f) + f);
            this$0.p.animate().alpha(1.0f).translationY(f).setDuration(500L).setListener(null);
        } else if (i != 3) {
            f = 0.0f;
            this$0.p.setTranslationX(f2);
            this$0.p.setTranslationY(DensityUtils.a(this$0.getContext(), 15.0f) + f);
            this$0.p.animate().alpha(1.0f).translationY(f).setDuration(500L).setListener(null);
        } else {
            f2 = (it.getTargetX() + DensityUtils.a(this$0.getContext(), 52.0f)) - this$0.p.getWidth();
            targetY = it.getTargetY();
            a2 = DensityUtils.a(this$0.getContext(), 75.0f);
        }
        i2 = targetY + a2;
        f = i2;
        this$0.p.setTranslationX(f2);
        this$0.p.setTranslationY(DensityUtils.a(this$0.getContext(), 15.0f) + f);
        this$0.p.animate().alpha(1.0f).translationY(f).setDuration(500L).setListener(null);
    }

    private final void a(final View view) {
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$_Q66Ks6B3kDgh8t3WmV9Rr4pbTs
            @Override // java.lang.Runnable
            public final void run() {
                LivePushGuideView.a(View.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(android.view.View r6, com.blued.android.module.live_china.view.LivePushGuideView r7) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LivePushGuideView.a(android.view.View, com.blued.android.module.live_china.view.LivePushGuideView):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePushGuideView this$0) {
        ViewPropertyAnimator animate;
        Intrinsics.e(this$0, "this$0");
        LivePushGuideShadeView livePushGuideShadeView = this$0.f;
        ViewPropertyAnimator viewPropertyAnimator = null;
        if (livePushGuideShadeView != null && (animate = livePushGuideShadeView.animate()) != null) {
            viewPropertyAnimator = animate.alpha(0.7f);
        }
        if (viewPropertyAnimator == null) {
            return;
        }
        viewPropertyAnimator.setDuration(500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePushGuideView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePushGuideView this$0, ViewGroup parent, BaseFragment fragment) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(parent, "$parent");
        Intrinsics.e(fragment, "$fragment");
        this$0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        parent.addView(this$0, parent.getChildCount());
        ActivityFragmentActive fragmentActive = fragment.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragment.fragmentActive");
        this$0.a(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        LivePushGuideShadeView livePushGuideShadeView;
        if (this.f == null) {
            return;
        }
        if (i == 1) {
            this.o.setTranslationX((livePushGuideShadeView.getTargetX() + livePushGuideShadeView.getTargetW()) - DensityUtils.a(getContext(), 48.0f));
            this.o.setTranslationY(livePushGuideShadeView.getTargetY() + DensityUtils.a(getContext(), 2.0f));
            BaseFragment baseFragment = this.c;
            BaseFragment baseFragment2 = baseFragment;
            if (baseFragment == null) {
                Intrinsics.c("mFragment");
                baseFragment2 = null;
            }
            ImageLoader.c(baseFragment2.getFragmentActive(), "live_push_guide_left.png").g().g(-1).a(this.o);
        } else if (i == 2) {
            this.o.setTranslationX((livePushGuideShadeView.getTargetX() + livePushGuideShadeView.getTargetW()) - DensityUtils.a(getContext(), 103.0f));
            this.o.setTranslationY(livePushGuideShadeView.getTargetY() - DensityUtils.a(getContext(), 14.0f));
            BaseFragment baseFragment3 = this.c;
            BaseFragment baseFragment4 = baseFragment3;
            if (baseFragment3 == null) {
                Intrinsics.c("mFragment");
                baseFragment4 = null;
            }
            ImageLoader.c(baseFragment4.getFragmentActive(), "live_push_guide_left.png").g().g(-1).a(this.o);
        } else if (i == 3) {
            this.o.setTranslationX(livePushGuideShadeView.getTargetX() - DensityUtils.a(getContext(), 30.0f));
            this.o.setTranslationY(livePushGuideShadeView.getTargetY() - DensityUtils.a(getContext(), 8.0f));
            BaseFragment baseFragment5 = this.c;
            BaseFragment baseFragment6 = baseFragment5;
            if (baseFragment5 == null) {
                Intrinsics.c("mFragment");
                baseFragment6 = null;
            }
            ImageLoader.c(baseFragment6.getFragmentActive(), "live_push_guide_right.png").g().g(-1).a(this.o);
        }
        this.o.animate().alpha(1.0f).setDuration(500L).setListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePushGuideView this$0) {
        Intrinsics.e(this$0, "this$0");
        int i = this$0.e;
        if (i == 1) {
            this$0.a(this$0.g);
        } else if (i == 2) {
            this$0.a(this$0.i);
        } else if (i == 3) {
            this$0.a(this$0.j);
        } else if (i != 4) {
        } else {
            this$0.b();
        }
    }

    private final void c(int i) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.a = 560L;
        if (this.p.getParent() == null) {
            this.p.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.p.setAlpha(0.0f);
            addView(this.p);
            this.p.setTextSize(2, 12.0f);
            this.p.setTextColor(BluedSkinUtils.a(this.b, R.color.syc_dark_b));
            longRef.a = 100L;
        }
        this.p.animate().alpha(0.0f).translationY(this.p.getTranslationY() + DensityUtils.a(getContext(), 30.0f)).setDuration(200L).setListener(new LivePushGuideView$showTips$1(longRef, this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final LivePushGuideView this$0) {
        Intrinsics.e(this$0, "this$0");
        boolean z = true;
        if (this$0.e < 1 && this$0.k == 1 && this$0.l == 1) {
            this$0.e = 1;
        } else if (this$0.e < 2 && this$0.m == 1) {
            this$0.e = 2;
        } else if (this$0.e >= 3 || this$0.n != 1) {
            if (this$0.e == 0) {
                z = false;
            }
            this$0.a(z);
            this$0.e = 4;
            return;
        } else {
            this$0.e = 3;
        }
        long j = 0;
        if (this$0.f == null) {
            Context context = this$0.getContext();
            Intrinsics.c(context, "context");
            LivePushGuideShadeView livePushGuideShadeView = new LivePushGuideShadeView(context);
            this$0.f = livePushGuideShadeView;
            if (livePushGuideShadeView != null) {
                livePushGuideShadeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            LivePushGuideShadeView livePushGuideShadeView2 = this$0.f;
            if (livePushGuideShadeView2 != null) {
                livePushGuideShadeView2.setAlpha(0.0f);
            }
            this$0.addView(this$0.f);
            j = 250;
            LivePushGuideShadeView livePushGuideShadeView3 = this$0.f;
            if (livePushGuideShadeView3 != null) {
                livePushGuideShadeView3.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$wqYDGvsWF0E1Dj3c_N5OIXqRODI
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePushGuideView.a(LivePushGuideView.this);
                    }
                });
            }
            EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$N39qoeQfXYPSW8byCnGCyz1-0IU
            @Override // java.lang.Runnable
            public final void run() {
                LivePushGuideView.b(LivePushGuideView.this);
            }
        }, j);
    }

    private final boolean c() {
        LivePushGuideShadeView livePushGuideShadeView = this.f;
        if (livePushGuideShadeView == null) {
            return false;
        }
        return livePushGuideShadeView.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final int i) {
        final LivePushGuideShadeView livePushGuideShadeView = this.f;
        if (livePushGuideShadeView == null) {
            return;
        }
        if (i == 1) {
            this.p.setText(R.string.live_push_guide_tips_follow);
            this.p.setBackgroundResource(R.drawable.live_push_guide_tips_top);
            this.p.setMaxWidth(DensityUtils.a(getContext(), 206.0f));
            this.p.setPadding(DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 12.0f), DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 8.0f));
        } else if (i == 2) {
            this.p.setText(R.string.live_push_guide_tips_msg_hot_word);
            this.p.setBackgroundResource(R.drawable.live_push_guide_tips_down);
            this.p.setMaxWidth(DensityUtils.a(getContext(), 206.0f));
            this.p.setPadding(DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 6.5f), DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 13.5f));
        } else if (i == 3) {
            this.p.setText(R.string.live_push_guide_tips_live_recommend);
            this.p.setBackgroundResource(R.drawable.live_push_guide_tips_top);
            this.p.setMaxWidth(DensityUtils.a(getContext(), 120.0f));
            this.p.setPadding(DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 12.0f), DensityUtils.a(getContext(), 8.0f), DensityUtils.a(getContext(), 8.0f));
        }
        this.p.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$ktyptVEerNuxvRSn1vehZ9mIlCY
            @Override // java.lang.Runnable
            public final void run() {
                LivePushGuideView.a(i, livePushGuideShadeView, this);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e(int r8) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LivePushGuideView.e(int):void");
    }

    @Override // com.blued.android.module.live_china.observer.PushGuideObserver.IPushGuideObserver
    public void a() {
        int i;
        int i2;
        int i3;
        int i4;
        if (!this.d || (i = this.k) == 0 || (i2 = this.l) == 0 || (i3 = this.m) == 0 || (i4 = this.n) == 0) {
            return;
        }
        if (i != -1 || i2 != -1 || i3 != -1 || i4 != -1) {
            if (ClickUtils.a(getId())) {
                return;
            }
            post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$bGFXbKuIv_IJ8FSq49Q14lK0LtM
                @Override // java.lang.Runnable
                public final void run() {
                    LivePushGuideView.c(LivePushGuideView.this);
                }
            });
            return;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
        PushGuideObserver.a.a().b((PushGuideObserver.IPushGuideObserver) this);
    }

    @Override // com.blued.android.module.live_china.observer.PushGuideObserver.IPushGuideObserver
    public void a(View view, View view2) {
        this.g = view;
        this.h = view2;
        this.k = view == null ? -1 : 1;
        this.l = view2 == null ? -1 : 1;
        a();
    }

    public final void a(final ViewGroup parent, final BaseFragment fragment) {
        Intrinsics.e(parent, "parent");
        Intrinsics.e(fragment, "fragment");
        this.c = fragment;
        parent.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$h2IYvDFi0JmdZDjF7XODo4R-_g4
            @Override // java.lang.Runnable
            public final void run() {
                LivePushGuideView.a(LivePushGuideView.this, parent, fragment);
            }
        });
    }

    public final void a(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        LiveRoomHttpUtils.w(new BluedUIHttpResponse<BluedEntity<Object, IsLast180DayExtraModel>>(this) { // from class: com.blued.android.module.live_china.view.LivePushGuideView$activate$1
            final /* synthetic */ LivePushGuideView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b.a(false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, IsLast180DayExtraModel> bluedEntity) {
                IsLast180DayExtraModel isLast180DayExtraModel;
                if (!((bluedEntity == null || (isLast180DayExtraModel = bluedEntity.extra) == null || isLast180DayExtraModel.getResult() != 1) ? false : true)) {
                    this.b.a(false);
                    return;
                }
                this.b.d = true;
                this.b.a();
            }
        }, fragmentActive);
    }

    public final void a(boolean z) {
        LivePushGuideShadeView livePushGuideShadeView = this.f;
        if (livePushGuideShadeView != null) {
            livePushGuideShadeView.setAnimIng(true);
        }
        if (z) {
            animate().alpha(0.0f).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LivePushGuideView$dismiss$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.e(animation, "animation");
                    super.onAnimationEnd(animation);
                    ViewParent parent = LivePushGuideView.this.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(LivePushGuideView.this);
                    }
                    PushGuideObserver.a.a().b((PushGuideObserver.IPushGuideObserver) LivePushGuideView.this);
                    EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_POP_CLOSE, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid);
                }
            });
            return;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
        PushGuideObserver.a.a().b((PushGuideObserver.IPushGuideObserver) this);
    }

    public void b() {
        a(true);
    }

    public final Context getMContext() {
        return this.b;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                if (c()) {
                    return true;
                }
                int a2 = a(motionEvent);
                this.r = a2;
                boolean z2 = false;
                if (a2 != 1) {
                    z2 = true;
                }
                return z2;
            } else if (action == 1) {
                if (c()) {
                    return true;
                }
                int a3 = a(motionEvent);
                int i = this.r;
                if (a3 != i) {
                    return true;
                }
                if (i != 1) {
                    if (i != 2 && i == 3) {
                        a();
                    }
                    z = true;
                }
                return z;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.blued.android.module.live_china.observer.PushGuideObserver.IPushGuideObserver
    public void setLiveRecommendViewData(View view) {
        this.j = view;
        this.n = view == null ? -1 : 1;
        a();
    }

    @Override // com.blued.android.module.live_china.observer.PushGuideObserver.IPushGuideObserver
    public void setMsgHotWordViewData(View view) {
        this.i = view;
        this.m = view == null ? -1 : 1;
        a();
    }
}
