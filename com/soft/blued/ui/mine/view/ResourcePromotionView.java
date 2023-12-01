package com.soft.blued.ui.mine.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.ResourcePromotionViewBinding;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.mine.model.MinePageAdModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.net.URL;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/view/ResourcePromotionView.class */
public final class ResourcePromotionView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ResourcePromotionViewBinding f31643a;
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f31644c;
    private final Lazy d;
    private final Lazy e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private IRequestHost j;
    private MinePageAdModel k;
    private final Runnable l;
    private boolean m;
    private final Runnable n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcePromotionView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcePromotionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourcePromotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        CardView cardView;
        ImageView imageView;
        Intrinsics.e(context, "context");
        this.b = LazyKt.a(new Function0<Integer>() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$openWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final Integer invoke() {
                return Integer.valueOf(DensityUtils.a(ResourcePromotionView.this.getContext(), 140.0f));
            }
        });
        this.f31644c = LazyKt.a(new Function0<Integer>() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$openHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final Integer invoke() {
                return Integer.valueOf(DensityUtils.a(ResourcePromotionView.this.getContext(), 105.0f));
            }
        });
        this.d = LazyKt.a(new Function0<Integer>() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$scaleWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final Integer invoke() {
                return Integer.valueOf(DensityUtils.a(ResourcePromotionView.this.getContext(), 60.0f));
            }
        });
        this.e = LazyKt.a(new Function0<Integer>() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$scaleHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final Integer invoke() {
                return Integer.valueOf(DensityUtils.a(ResourcePromotionView.this.getContext(), 45.0f));
            }
        });
        ResourcePromotionViewBinding a2 = ResourcePromotionViewBinding.a(LayoutInflater.from(getContext()).inflate(R.layout.resource_promotion_view, this));
        this.f31643a = a2;
        if (a2 != null && (imageView = a2.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.view.-$$Lambda$ResourcePromotionView$QBsYnn2yhGnn_lA1VkUBGpJkKeg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourcePromotionView.a(ResourcePromotionView.this, view);
                }
            });
        }
        ResourcePromotionViewBinding resourcePromotionViewBinding = this.f31643a;
        if (resourcePromotionViewBinding != null && (cardView = resourcePromotionViewBinding.f29578a) != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.view.-$$Lambda$ResourcePromotionView$8kXquvuqdcph5wU0k7VZgJ804s8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourcePromotionView.b(ResourcePromotionView.this, view);
                }
            });
        }
        this.l = new Runnable() { // from class: com.soft.blued.ui.mine.view.-$$Lambda$ResourcePromotionView$gyrqK0c22qrV8h26UqE79s1otBA
            @Override // java.lang.Runnable
            public final void run() {
                ResourcePromotionView.c(ResourcePromotionView.this);
            }
        };
        this.m = true;
        this.n = new Runnable() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$mFlipRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                z = ResourcePromotionView.this.f;
                if (z) {
                    ResourcePromotionView.this.c();
                    Log.v("drb", "开始任务延迟8秒任务");
                    ResourcePromotionView.this.postDelayed(this, 8000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, ValueAnimator valueAnimator) {
        Intrinsics.e(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = intValue;
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ResourcePromotionView this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Log.v("drb", "ivResourcePromotionClose OnClick");
        ResourcePromotionViewBinding resourcePromotionViewBinding = this$0.f31643a;
        FrameLayout root = resourcePromotionViewBinding == null ? null : resourcePromotionViewBinding.getRoot();
        if (root != null) {
            root.setVisibility(8);
        }
        BluedPreferences.ag(true);
        view.startAnimation(AnimationUtils.loadAnimation(this$0.getContext(), 2130772119));
        MinePageAdModel minePageAdModel = this$0.k;
        FindHttpUtils.b(minePageAdModel == null ? null : minePageAdModel.hidden_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view, ValueAnimator valueAnimator) {
        Intrinsics.e(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = intValue;
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ResourcePromotionView this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Log.v("drb", "cvView OnClick");
        MinePageAdModel minePageAdModel = this$0.k;
        if (TextUtils.isEmpty(minePageAdModel == null ? null : minePageAdModel.getJump_url())) {
            return;
        }
        ResourcePromotionViewBinding resourcePromotionViewBinding = this$0.f31643a;
        SVGAImageView sVGAImageView = resourcePromotionViewBinding == null ? null : resourcePromotionViewBinding.f29579c;
        if (sVGAImageView != null) {
            sVGAImageView.setCallback(null);
        }
        this$0.d();
        Context context = this$0.getContext();
        MinePageAdModel minePageAdModel2 = this$0.k;
        WebViewShowInfoFragment.show(context, minePageAdModel2 == null ? null : minePageAdModel2.getJump_url());
        SettingsProtos.Event event = SettingsProtos.Event.MINE_RESOURCE_CLICK;
        MinePageAdModel minePageAdModel3 = this$0.k;
        EventTrackSettings.a(event, minePageAdModel3 == null ? null : minePageAdModel3.getJump_url());
        MinePageAdModel minePageAdModel4 = this$0.k;
        FindHttpUtils.b(minePageAdModel4 == null ? null : minePageAdModel4.click_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ResourcePromotionView this$0) {
        SVGAImageView sVGAImageView;
        Intrinsics.e(this$0, "this$0");
        ResourcePromotionViewBinding resourcePromotionViewBinding = this$0.f31643a;
        if (resourcePromotionViewBinding == null || (sVGAImageView = resourcePromotionViewBinding.f29579c) == null) {
            return;
        }
        this$0.a(sVGAImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        String material;
        MinePageAdModel minePageAdModel = this.k;
        boolean z = false;
        if (minePageAdModel != null && minePageAdModel.material_type == 2) {
            z = true;
        }
        if (z) {
            g();
            return;
        }
        MinePageAdModel minePageAdModel2 = this.k;
        if (minePageAdModel2 != null && (material = minePageAdModel2.getMaterial()) != null) {
            ImageWrapper a2 = ImageLoader.a(this.j, material);
            ResourcePromotionViewBinding binding = getBinding();
            a2.a(binding == null ? null : binding.f29579c);
        }
        h();
    }

    private final void f() {
        SVGAImageView sVGAImageView;
        ResourcePromotionViewBinding resourcePromotionViewBinding = this.f31643a;
        ViewGroup.LayoutParams layoutParams = (resourcePromotionViewBinding == null || (sVGAImageView = resourcePromotionViewBinding.f29579c) == null) ? null : sVGAImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = getOpenHeight();
        }
        if (layoutParams != null) {
            layoutParams.width = getOpenWidth();
        }
        ResourcePromotionViewBinding resourcePromotionViewBinding2 = this.f31643a;
        SVGAImageView sVGAImageView2 = resourcePromotionViewBinding2 == null ? null : resourcePromotionViewBinding2.f29579c;
        if (sVGAImageView2 != null) {
            sVGAImageView2.setLayoutParams(layoutParams);
        }
        ResourcePromotionViewBinding resourcePromotionViewBinding3 = this.f31643a;
        ImageView imageView = resourcePromotionViewBinding3 == null ? null : resourcePromotionViewBinding3.b;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private final void g() {
        this.g = true;
        i();
    }

    private final int getOpenHeight() {
        return ((Number) this.f31644c.getValue()).intValue();
    }

    private final int getOpenWidth() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final int getScaleHeight() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final int getScaleWidth() {
        return ((Number) this.d.getValue()).intValue();
    }

    private final void h() {
        this.g = false;
        i();
    }

    private final void i() {
        boolean z = this.h && this.g;
        if (z != this.f) {
            if (z) {
                Log.v("drb", Intrinsics.a("updateRunning:", (Object) Integer.valueOf(this.i)));
                postDelayed(this.n, this.i);
            } else {
                Log.v("drb", "移除任务");
                removeCallbacks(this.n);
            }
            this.f = z;
        }
    }

    public final void a() {
        MinePageAdModel.PopupAd popup;
        h();
        f();
        MinePageAdModel minePageAdModel = this.k;
        if (minePageAdModel == null || (popup = minePageAdModel.getPopup()) == null) {
            return;
        }
        if (popup.getMaterial_type() == 2) {
            SVGAParser.a(SVGAParser.f15958a.b(), new URL(popup.getMaterial()), new SVGAParser.ParseCompletion() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$open$1$1
                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.e(videoItem, "videoItem");
                    ResourcePromotionViewBinding binding = ResourcePromotionView.this.getBinding();
                    if (binding == null) {
                        return;
                    }
                    binding.getRoot().setVisibility(0);
                    SVGAImageView sVGAImageView = binding.f29579c;
                    sVGAImageView.setLoops(1);
                    sVGAImageView.setVideoItem(videoItem);
                    sVGAImageView.a(0, true);
                }

                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                }
            }, (SVGAParser.PlayCallback) null, 4, (Object) null);
            ResourcePromotionViewBinding binding = getBinding();
            if (binding == null) {
                return;
            }
            binding.f29579c.setCallback(new SVGACallback() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$open$1$2$1
                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onFinished() {
                    SVGAImageView sVGAImageView;
                    Log.v("drb", "callback onFinished");
                    ResourcePromotionViewBinding binding2 = ResourcePromotionView.this.getBinding();
                    if (binding2 == null || (sVGAImageView = binding2.f29579c) == null) {
                        return;
                    }
                    ResourcePromotionView.this.a(sVGAImageView);
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onPause() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onRepeat() {
                }

                @Override // com.blued.android.module.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                }
            });
            return;
        }
        ResourcePromotionViewBinding binding2 = getBinding();
        FrameLayout root = binding2 == null ? null : binding2.getRoot();
        if (root != null) {
            root.setVisibility(0);
        }
        ImageWrapper a2 = ImageLoader.a(this.j, popup.getMaterial());
        ResourcePromotionViewBinding binding3 = getBinding();
        a2.a(binding3 == null ? null : binding3.f29579c);
        removeCallbacks(this.l);
        postDelayed(this.l, m.ag);
    }

    public final void a(final View view) {
        Intrinsics.e(view, "view");
        ValueAnimator ofInt = ValueAnimator.ofInt(getOpenWidth(), getScaleWidth());
        Intrinsics.c(ofInt, "ofInt(\n            openW…     scaleWidth\n        )");
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.mine.view.-$$Lambda$ResourcePromotionView$OhuCGQ-1BVG1HV7EMycsc6FRrlk
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ResourcePromotionView.a(View.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(getOpenHeight(), getScaleHeight());
        Intrinsics.c(ofInt2, "ofInt(\n            openH…    scaleHeight\n        )");
        ofInt2.setDuration(300L);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.mine.view.-$$Lambda$ResourcePromotionView$LVERUyYBwW1PLFIxJafzoI-FVc4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ResourcePromotionView.b(View.this, valueAnimator);
            }
        });
        ofInt.start();
        ofInt2.start();
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$scaleWithAnim$3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ResourcePromotionViewBinding binding = ResourcePromotionView.this.getBinding();
                ImageView imageView = binding == null ? null : binding.b;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ResourcePromotionView.this.i = 5000;
                ResourcePromotionView.this.e();
            }
        });
    }

    public final void a(MinePageAdModel minePageAdModel, IRequestHost requestHost) {
        Intrinsics.e(requestHost, "requestHost");
        this.k = minePageAdModel;
        this.j = requestHost;
    }

    public final void b() {
    }

    public final void c() {
        Log.v("drb", "showNext");
        MinePageAdModel minePageAdModel = this.k;
        if (TextUtils.isEmpty(minePageAdModel == null ? null : minePageAdModel.getMaterial())) {
            h();
            return;
        }
        SVGAParser b = SVGAParser.f15958a.b();
        MinePageAdModel minePageAdModel2 = this.k;
        SVGAParser.a(b, new URL(minePageAdModel2 == null ? null : minePageAdModel2.getMaterial()), new SVGAParser.ParseCompletion() { // from class: com.soft.blued.ui.mine.view.ResourcePromotionView$showNext$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.e(videoItem, "videoItem");
                ResourcePromotionViewBinding binding = ResourcePromotionView.this.getBinding();
                if (binding == null) {
                    return;
                }
                binding.getRoot().setVisibility(0);
                SVGAImageView sVGAImageView = binding.f29579c;
                sVGAImageView.setLoops(1);
                sVGAImageView.setVideoItem(videoItem);
                sVGAImageView.a(0, true);
                binding.f29579c.setCallback(null);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    public final void d() {
        SVGAImageView sVGAImageView;
        Log.v("drb", "resetScale");
        ResourcePromotionViewBinding resourcePromotionViewBinding = this.f31643a;
        if (resourcePromotionViewBinding != null) {
            resourcePromotionViewBinding.getRoot().setVisibility(0);
        }
        ResourcePromotionViewBinding resourcePromotionViewBinding2 = this.f31643a;
        ViewGroup.LayoutParams layoutParams = (resourcePromotionViewBinding2 == null || (sVGAImageView = resourcePromotionViewBinding2.f29579c) == null) ? null : sVGAImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = getScaleHeight();
        }
        if (layoutParams != null) {
            layoutParams.width = getScaleWidth();
        }
        ResourcePromotionViewBinding resourcePromotionViewBinding3 = this.f31643a;
        SVGAImageView sVGAImageView2 = resourcePromotionViewBinding3 == null ? null : resourcePromotionViewBinding3.f29579c;
        if (sVGAImageView2 != null) {
            sVGAImageView2.setLayoutParams(layoutParams);
        }
        this.i = 0;
        e();
        ResourcePromotionViewBinding resourcePromotionViewBinding4 = this.f31643a;
        ImageView imageView = resourcePromotionViewBinding4 == null ? null : resourcePromotionViewBinding4.b;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    public final ResourcePromotionViewBinding getBinding() {
        return this.f31643a;
    }

    public final boolean getMFirst() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.h = i == 0;
        i();
    }

    public final void setBinding(ResourcePromotionViewBinding resourcePromotionViewBinding) {
        this.f31643a = resourcePromotionViewBinding;
    }

    public final void setMFirst(boolean z) {
        this.m = z;
    }
}
