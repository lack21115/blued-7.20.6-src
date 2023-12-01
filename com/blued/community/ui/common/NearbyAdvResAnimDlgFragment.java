package com.blued.community.ui.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.HomeTabBubble;
import com.blued.community.model.HomeTabBubbleExtra;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.das.guy.GuyProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/common/NearbyAdvResAnimDlgFragment.class */
public final class NearbyAdvResAnimDlgFragment extends LiveBaseDialogFragment {
    private int A;
    private int B;
    private boolean C;
    private View j;
    private View k;
    private ImageView l;
    private SVGAImageView m;
    private ImageView n;
    private SVGAParser o;
    private CardView p;
    private int q = 1;
    private String r = "";
    private String s = "";
    private int t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private int y;
    private long z;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyAdvResAnimDlgFragment this$0, int i, int i2, ValueAnimator animation) {
        CardView cardView;
        CardView cardView2;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        if (this$0.C) {
            CardView cardView3 = this$0.p;
            if (cardView3 == null) {
                return;
            }
            cardView3.setCardBackgroundColor(0);
            return;
        }
        if (intValue <= 1 && (cardView2 = this$0.p) != null) {
            cardView2.setCardBackgroundColor(i);
        }
        if (intValue < 9 || (cardView = this$0.p) == null) {
            return;
        }
        cardView.setCardBackgroundColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyAdvResAnimDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NearbyAdvResAnimDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        l();
    }

    private final void l() {
        if (this.x) {
            return;
        }
        this.x = true;
        ImageView imageView = this.l;
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.start();
        }
        View view = this.j;
        if (view != null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(600L);
            ofFloat2.start();
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$NearbyAdvResAnimDlgFragment$xpOp3mISTpnRzdtyb6UsOmz__2M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NearbyAdvResAnimDlgFragment.a(view2);
                }
            });
        }
        View view2 = this.k;
        if (view2 == null) {
            return;
        }
        int i = AppInfo.l / 2;
        int c2 = view2.getMeasuredHeight() != 0 ? FeedMethods.c(159) + (view2.getMeasuredHeight() / 2) : 0;
        int i2 = c2;
        if (c2 == 0) {
            i2 = FeedMethods.c(384);
        }
        if (this.u == 0) {
            this.u = AppInfo.l / 2;
        }
        if (this.v == 0) {
            this.v = (AppInfo.m * 2) / 5;
        }
        LogUtils.c("animEndY:" + this.v + ", startY:" + i2);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "ScaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "ScaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "translationX", (float) (this.u - i));
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view2, "translationY", (float) (this.v - i2));
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.2f);
        ofFloat3.setDuration(600L);
        ofFloat4.setDuration(600L);
        ofFloat5.setDuration(600L);
        ofFloat6.setDuration(600L);
        ofFloat7.setDuration(600L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.common.NearbyAdvResAnimDlgFragment$animHide$3$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i3;
                Bundle bundle;
                Bundle bundle2;
                Bundle bundle3;
                Bundle bundle4;
                NearbyAdvResAnimDlgFragment.this.dismissAllowingStateLoss();
                i3 = NearbyAdvResAnimDlgFragment.this.w;
                if (i3 == 12) {
                    HomeTabBubble homeTabBubble = new HomeTabBubble();
                    homeTabBubble.bubble_type = 1102;
                    bundle = NearbyAdvResAnimDlgFragment.this.f10822c;
                    String string = bundle.getString("activity_text");
                    String str = string;
                    if (TextUtils.isEmpty(string)) {
                        str = "同城活动";
                    }
                    homeTabBubble.bubble_text = str;
                    HomeTabBubbleExtra homeTabBubbleExtra = new HomeTabBubbleExtra();
                    homeTabBubbleExtra.extra_bubble_type = 2;
                    bundle2 = NearbyAdvResAnimDlgFragment.this.f10822c;
                    homeTabBubbleExtra.adv_activity_id = CommonStringUtils.a(bundle2.getString("activity_id"));
                    bundle3 = NearbyAdvResAnimDlgFragment.this.f10822c;
                    homeTabBubbleExtra.extra_bubble_img = bundle3.getString("activity_img");
                    bundle4 = NearbyAdvResAnimDlgFragment.this.f10822c;
                    homeTabBubbleExtra.extra_bubble_text = bundle4.getString("activity_text");
                    CommunityManager.f19086a.a().a(homeTabBubbleExtra);
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW).post(homeTabBubble);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.play(ofFloat5).with(ofFloat6).with(ofFloat3).with(ofFloat4).with(ofFloat7);
        animatorSet.start();
    }

    private final void m() {
        String str;
        String str2;
        this.C = false;
        if (CommunityManager.f19086a.a().s()) {
            str = "#222222";
            str2 = "#1A1A1A";
        } else {
            str = "#E7E7E7";
            str2 = "#F5F5F5";
        }
        final int parseColor = Color.parseColor(str);
        final int parseColor2 = Color.parseColor(str2);
        CardView cardView = this.p;
        if (cardView != null) {
            cardView.setCardBackgroundColor(parseColor);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 10, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.common.-$$Lambda$NearbyAdvResAnimDlgFragment$8Pe5-Bl0NCL1e3sJyKeElT-CToM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NearbyAdvResAnimDlgFragment.a(NearbyAdvResAnimDlgFragment.this, parseColor, parseColor2, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.common.NearbyAdvResAnimDlgFragment$startSvgaColorAnim$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                CardView cardView2;
                Intrinsics.e(animation, "animation");
                NearbyAdvResAnimDlgFragment.this.C = true;
                cardView2 = NearbyAdvResAnimDlgFragment.this.p;
                if (cardView2 == null) {
                    return;
                }
                cardView2.setCardBackgroundColor(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        ofInt.setDuration(1250L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setRepeatCount(10);
        ofInt.start();
        n();
    }

    private final void n() {
        SVGAParser sVGAParser = this.o;
        if (sVGAParser == null) {
            return;
        }
        SVGAParser.a(sVGAParser, new URL(this.s), new SVGAParser.ParseCompletion() { // from class: com.blued.community.ui.common.NearbyAdvResAnimDlgFragment$loadRes$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                CardView cardView;
                SVGAImageView sVGAImageView;
                SVGAImageView sVGAImageView2;
                View view;
                int i;
                Intrinsics.e(videoItem, "videoItem");
                NearbyAdvResAnimDlgFragment.this.C = true;
                cardView = NearbyAdvResAnimDlgFragment.this.p;
                if (cardView != null) {
                    cardView.setCardBackgroundColor(0);
                }
                sVGAImageView = NearbyAdvResAnimDlgFragment.this.m;
                if (sVGAImageView != null) {
                    NearbyAdvResAnimDlgFragment nearbyAdvResAnimDlgFragment = NearbyAdvResAnimDlgFragment.this;
                    view = nearbyAdvResAnimDlgFragment.k;
                    if (view != null) {
                        view.clearAnimation();
                    }
                    i = nearbyAdvResAnimDlgFragment.q;
                    sVGAImageView.setLoops(i);
                    sVGAImageView.setVideoItem(videoItem);
                    sVGAImageView.a(0, true);
                }
                sVGAImageView2 = NearbyAdvResAnimDlgFragment.this.m;
                if (sVGAImageView2 == null) {
                    return;
                }
                final NearbyAdvResAnimDlgFragment nearbyAdvResAnimDlgFragment2 = NearbyAdvResAnimDlgFragment.this;
                sVGAImageView2.setCallback(new SVGACallback() { // from class: com.blued.community.ui.common.NearbyAdvResAnimDlgFragment$loadRes$1$onComplete$2
                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onFinished() {
                        LogUtils.c("svgView callback onFinished");
                        NearbyAdvResAnimDlgFragment.this.k();
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onPause() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onRepeat() {
                    }

                    @Override // com.blued.android.module.svgaplayer.SVGACallback
                    public void onStep(int i2, double d) {
                    }
                });
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    private final void o() {
        if (this.w == 12) {
            String string = this.f10822c.getString("activity_id", "");
            this.x = true;
            Context context = getContext();
            if (context != null) {
                EventDetailsFragment.f19534a.a(context, string, null);
                dismissAllowingStateLoss();
            }
        } else if (!TextUtils.isEmpty(this.r)) {
            CommunityServiceManager.b().a(getContext(), this.r);
            dismissAllowingStateLoss();
            this.x = true;
        }
        EventTrackFeed.a(GuyProtos.Event.HOME_ADV_POP_CLICK, this.w, this.s, String.valueOf(this.B), String.valueOf(this.A), String.valueOf(this.z));
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_nearby_adv_res_anim;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.j = this.b.findViewById(R.id.nearby_adv_res_bg);
        this.k = this.b.findViewById(R.id.nearby_adv_res_content_lo);
        this.l = (ImageView) this.b.findViewById(R.id.nearby_adv_res_close);
        this.m = (SVGAImageView) this.b.findViewById(R.id.nearby_adv_res_svg);
        this.p = (CardView) this.b.findViewById(R.id.nearby_adv_res_svg_parent);
        this.n = (ImageView) this.b.findViewById(R.id.nearby_adv_res_iv);
        CardView cardView = this.p;
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$NearbyAdvResAnimDlgFragment$n1cvSR2rBKXrH6qGzF9kEvtx76s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbyAdvResAnimDlgFragment.a(NearbyAdvResAnimDlgFragment.this, view);
                }
            });
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$NearbyAdvResAnimDlgFragment$MVIliBdHm4GNZz3ZjeS8JAFQH2g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbyAdvResAnimDlgFragment.b(NearbyAdvResAnimDlgFragment.this, view);
                }
            });
        }
        this.o = SVGAParser.f15958a.b();
        EventTrackFeed.a(GuyProtos.Event.HOME_ADV_POP_SHOW, this.w, this.s, String.valueOf(this.B), String.valueOf(this.A), String.valueOf(this.z));
        CommunityManager.f19086a.a().h(true);
        CommunityManager.f19086a.a().i(true);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        super.f();
        this.q = this.f10822c.getInt("anim_loop", 1);
        String string = this.f10822c.getString("img_url", "");
        Intrinsics.c(string, "args.getString(\"img_url\", \"\")");
        this.s = string;
        String string2 = this.f10822c.getString("target_link", "");
        Intrinsics.c(string2, "args.getString(\"target_link\", \"\")");
        this.r = string2;
        this.t = this.f10822c.getInt("img_type", 0);
        this.w = this.f10822c.getInt("adv_type", 0);
        this.u = this.f10822c.getInt("anim_x", 0);
        this.v = this.f10822c.getInt("anim_y", 0);
        this.y = this.f10822c.getInt("force_gray", 0);
        this.z = this.f10822c.getLong("ads_id", 0L);
        this.A = this.f10822c.getInt("business_line", 0);
        this.B = this.f10822c.getInt("department", 0);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void g() {
        super.g();
        if (this.t == 2) {
            SVGAImageView sVGAImageView = this.m;
            if (sVGAImageView != null) {
                sVGAImageView.setVisibility(0);
            }
            ImageView imageView = this.n;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            m();
            return;
        }
        SVGAImageView sVGAImageView2 = this.m;
        if (sVGAImageView2 != null) {
            sVGAImageView2.setVisibility(8);
        }
        ImageView imageView2 = this.n;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageLoader.a((IRequestHost) null, this.s).d(R.drawable.defaultpicture).a(this.n);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CommunityManager.f19086a.a().h(false);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        super.onDismiss(dialog);
        CommunityManager.f19086a.a().h(false);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.y > 0) {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            this.b.setLayerType(2, paint);
        }
    }
}
