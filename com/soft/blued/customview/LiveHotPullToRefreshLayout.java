package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.blued.android.module.common.utils.RefreshUtils;
import com.blued.android.module.live_china.observer.LiveTabNewObserver;
import com.google.android.material.appbar.AppBarLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LiveHotPullToRefreshLayout.class */
public class LiveHotPullToRefreshLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14749a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public int f14750c;
    public AppBarLayout d;
    public View e;
    public View f;
    Runnable g;
    private int h;
    private int i;
    private FrameLayout j;
    private FrameLayout k;

    /* renamed from: com.soft.blued.customview.LiveHotPullToRefreshLayout$3  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/LiveHotPullToRefreshLayout$3.class */
    class AnonymousClass3 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveHotPullToRefreshLayout f14753a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f14753a.k.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public LiveHotPullToRefreshLayout(Context context) {
        this(context, null);
    }

    public LiveHotPullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Runnable() { // from class: com.soft.blued.customview.LiveHotPullToRefreshLayout.4
            @Override // java.lang.Runnable
            public void run() {
                if (Math.abs(LiveHotPullToRefreshLayout.this.d.getTop()) >= LiveHotPullToRefreshLayout.this.i) {
                    if (LiveHotPullToRefreshLayout.this.k.getChildCount() == 0) {
                        LiveHotPullToRefreshLayout.this.j.getLayoutParams().height = LiveHotPullToRefreshLayout.this.e.getHeight();
                        LiveHotPullToRefreshLayout.this.k.addView(LiveHotPullToRefreshLayout.this.getView());
                    }
                    if (LiveHotPullToRefreshLayout.this.k.getVisibility() == 8) {
                        LiveHotPullToRefreshLayout.this.k.setVisibility(0);
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setFillAfter(true);
                        LiveHotPullToRefreshLayout.this.k.setAnimation(translateAnimation);
                        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.customview.LiveHotPullToRefreshLayout.4.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                LiveHotPullToRefreshLayout.this.k.clearAnimation();
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }
                        });
                        translateAnimation.start();
                    }
                }
            }
        };
        b();
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.live_hot_list_new_content, this);
        this.b = inflate;
        this.e = inflate.findViewById(R.id.ll_tab);
        this.f = this.b.findViewById(R.id.ll_top);
        this.j = (FrameLayout) this.b.findViewById(R.id.fl_up_tab);
        this.k = (FrameLayout) this.b.findViewById(R.id.fl_down_tab);
        AppBarLayout appBarLayout = (AppBarLayout) this.b.findViewById(R.id.appbar);
        this.d = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soft.blued.customview.LiveHotPullToRefreshLayout.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                if (i >= 0) {
                    LiveHotPullToRefreshLayout.this.f14749a = true;
                } else {
                    LiveHotPullToRefreshLayout.this.f14749a = false;
                }
                if (i == 0) {
                    LiveTabNewObserver.a().c();
                }
                int i2 = LiveHotPullToRefreshLayout.this.f14750c;
                LiveHotPullToRefreshLayout.this.f14750c = i;
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soft.blued.customview.LiveHotPullToRefreshLayout.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LiveHotPullToRefreshLayout liveHotPullToRefreshLayout = LiveHotPullToRefreshLayout.this;
                liveHotPullToRefreshLayout.h = liveHotPullToRefreshLayout.f.getHeight();
                LiveHotPullToRefreshLayout liveHotPullToRefreshLayout2 = LiveHotPullToRefreshLayout.this;
                liveHotPullToRefreshLayout2.i = liveHotPullToRefreshLayout2.d.getHeight();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getView() {
        if (this.e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.e.getParent()).removeAllViews();
        }
        return this.e;
    }

    public void a() {
        RefreshUtils.a(this.d);
    }
}
