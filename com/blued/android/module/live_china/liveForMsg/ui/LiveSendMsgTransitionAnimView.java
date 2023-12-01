package com.blued.android.module.live_china.liveForMsg.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.view.LiveMsgBgFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/LiveSendMsgTransitionAnimView.class */
public final class LiveSendMsgTransitionAnimView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13542a = new Companion(null);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13543c;
    private String d;
    private Activity e;
    private ViewGroup f;
    private View g;
    private View h;
    private LiveZanExtraModel.EmojiModel i;
    private Runnable j;
    private int k;
    private CardView l;
    private ImageView m;
    private LiveMsgBgFrameLayout n;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/ui/LiveSendMsgTransitionAnimView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSendMsgTransitionAnimView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
    }

    private final void a() {
        int[] iArr = new int[2];
        View view = this.g;
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        int i = iArr[0];
        int i2 = iArr[1];
        View view2 = this.g;
        Integer num = null;
        Integer valueOf = view2 == null ? null : Integer.valueOf(view2.getWidth());
        View view3 = this.g;
        if (view3 != null) {
            num = Integer.valueOf(view3.getHeight());
        }
        CardView cardView = new CardView(this.b);
        this.l = cardView;
        if (cardView != null) {
            Intrinsics.a(valueOf);
            int intValue = valueOf.intValue();
            Intrinsics.a(num);
            cardView.setLayoutParams(new FrameLayout.LayoutParams(intValue, num.intValue()));
        }
        CardView cardView2 = this.l;
        if (cardView2 != null) {
            cardView2.setTranslationX(i);
        }
        CardView cardView3 = this.l;
        if (cardView3 != null) {
            cardView3.setTranslationY(i2 - DensityUtils.a(this.e));
        }
        CardView cardView4 = this.l;
        if (cardView4 != null) {
            cardView4.setCardBackgroundColor(ContextCompat.getColor(this.b, R.color.transparent));
        }
        CardView cardView5 = this.l;
        if (cardView5 != null) {
            cardView5.setCardElevation(2.0f);
        }
        CardView cardView6 = this.l;
        if (cardView6 != null) {
            cardView6.setRadius(DensityUtils.a(getContext(), 14.0f));
        }
        ImageView imageView = new ImageView(this.b);
        this.m = imageView;
        if (imageView != null) {
            imageView.setLayoutParams(new FrameLayout.LayoutParams(valueOf.intValue(), num.intValue()));
        }
        ImageView imageView2 = this.m;
        if (imageView2 != null) {
            imageView2.setImageBitmap(BitmapUtils.a(this.g, Bitmap.Config.ARGB_8888));
        }
        CardView cardView7 = this.l;
        if (cardView7 != null) {
            cardView7.addView(this.m);
        }
        LiveMsgBgFrameLayout liveMsgBgFrameLayout = new LiveMsgBgFrameLayout(this.b);
        this.n = liveMsgBgFrameLayout;
        if (liveMsgBgFrameLayout != null) {
            liveMsgBgFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        LiveMsgBgFrameLayout liveMsgBgFrameLayout2 = this.n;
        if (liveMsgBgFrameLayout2 != null) {
            liveMsgBgFrameLayout2.a(LiveRoomManager.a().M(), LiveRoomInfo.a().r());
        }
        LiveMsgBgFrameLayout liveMsgBgFrameLayout3 = this.n;
        if (liveMsgBgFrameLayout3 != null) {
            liveMsgBgFrameLayout3.setAlpha(0.0f);
        }
        CardView cardView8 = this.l;
        if (cardView8 != null) {
            cardView8.addView(this.n);
        }
        addView(this.l);
        CardView cardView9 = this.l;
        if (cardView9 == null) {
            return;
        }
        cardView9.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.ui.-$$Lambda$LiveSendMsgTransitionAnimView$jNCuVFQPk3edCSvOEbk7dFaJRzc
            @Override // java.lang.Runnable
            public final void run() {
                LiveSendMsgTransitionAnimView.a(LiveSendMsgTransitionAnimView.this);
            }
        });
    }

    private final void a(Activity activity, ViewGroup viewGroup, View view) {
        if (activity == null) {
            return;
        }
        this.e = activity;
        this.f = viewGroup;
        this.h = view;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        viewGroup.addView(this, viewGroup.getChildCount());
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveSendMsgTransitionAnimView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveSendMsgTransitionAnimView this$0, DecelerateInterpolator decelerate, DecelerateInterpolator txInterpolator, AccelerateInterpolator tyInterpolator, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ValueAnimator animation) {
        LiveMsgBgFrameLayout liveMsgBgFrameLayout;
        CardView cardView;
        LiveMsgBgFrameLayout liveMsgBgFrameLayout2;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(decelerate, "$decelerate");
        Intrinsics.e(txInterpolator, "$txInterpolator");
        Intrinsics.e(tyInterpolator, "$tyInterpolator");
        Intrinsics.e(animation, "animation");
        if (this$0.e == null) {
            return;
        }
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        float interpolation = decelerate.getInterpolation(floatValue);
        float interpolation2 = txInterpolator.getInterpolation(floatValue);
        float interpolation3 = tyInterpolator.getInterpolation(floatValue);
        CardView cardView2 = this$0.l;
        ViewGroup.LayoutParams layoutParams = cardView2 == null ? null : cardView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (((f2 - f) * interpolation) + f);
        }
        CardView cardView3 = this$0.l;
        ViewGroup.LayoutParams layoutParams2 = cardView3 == null ? null : cardView3.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = (int) (((f4 - f3) * interpolation) + f3);
        }
        CardView cardView4 = this$0.l;
        if (cardView4 != null) {
            cardView4.setLayoutParams(cardView4 == null ? null : cardView4.getLayoutParams());
        }
        CardView cardView5 = this$0.l;
        if (cardView5 != null) {
            cardView5.setTranslationX(f5 + ((f6 - f5) * interpolation2));
        }
        CardView cardView6 = this$0.l;
        if (cardView6 != null) {
            cardView6.setTranslationY(f7 + ((f8 - f7) * interpolation3));
        }
        ImageView imageView = this$0.m;
        if (imageView != null) {
            imageView.setTranslationX((-f) * 0.1f * floatValue);
        }
        ImageView imageView2 = this$0.m;
        if (imageView2 != null) {
            imageView2.setTranslationY((-f3) * 0.4f * floatValue);
        }
        ImageView imageView3 = this$0.m;
        if (imageView3 != null) {
            imageView3.setScaleX(1 - (floatValue / 5));
        }
        ImageView imageView4 = this$0.m;
        if (imageView4 != null) {
            imageView4.setScaleY(1 - (floatValue / 5));
        }
        if (this$0.k == 1) {
            if (interpolation > 0.33f && (liveMsgBgFrameLayout2 = this$0.n) != null) {
                liveMsgBgFrameLayout2.setAlpha((interpolation - 0.33f) * 3.03f);
            }
        } else if (interpolation > 0.25f && (liveMsgBgFrameLayout = this$0.n) != null) {
            liveMsgBgFrameLayout.setAlpha((interpolation - 0.25f) * 4.0f);
        }
        if (floatValue > 0.75d && !this$0.f13543c) {
            Runnable runnable = this$0.j;
            if (runnable != null) {
                runnable.run();
            }
            this$0.j = null;
            this$0.f13543c = true;
        }
        if (interpolation <= 0.9f || (cardView = this$0.l) == null) {
            return;
        }
        cardView.setAlpha(1.0f - ((interpolation - 0.9f) * 10.0f));
    }

    private final void b() {
        if (this.e == null) {
            return;
        }
        int[] iArr = new int[2];
        View view = this.h;
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        CardView cardView = this.l;
        Intrinsics.a(cardView);
        final float translationX = cardView.getTranslationX();
        float f = iArr[0];
        float a2 = DensityUtils.a(getContext(), 6.0f);
        CardView cardView2 = this.l;
        Intrinsics.a(cardView2);
        final float translationY = cardView2.getTranslationY();
        int i = iArr[1];
        View view2 = this.h;
        Intrinsics.a(view2);
        float height = (i + view2.getHeight()) - DensityUtils.a(this.e);
        float a3 = DensityUtils.a(getContext(), 8.0f);
        View view3 = this.g;
        Intrinsics.a(view3);
        final float width = view3.getWidth();
        final float a4 = DensityUtils.a(getContext(), 15.0f);
        View view4 = this.g;
        Intrinsics.a(view4);
        final float height2 = view4.getHeight();
        final float a5 = DensityUtils.a(getContext(), 15.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(0.8f);
        final DecelerateInterpolator decelerateInterpolator2 = new DecelerateInterpolator(0.9f);
        final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(0.9f);
        final float f2 = f + a2;
        final float f3 = height - a3;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.liveForMsg.ui.-$$Lambda$LiveSendMsgTransitionAnimView$XatM2w4zPFn-hPLJP-wZdmzhgSs
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveSendMsgTransitionAnimView.a(LiveSendMsgTransitionAnimView.this, decelerateInterpolator, decelerateInterpolator2, accelerateInterpolator, width, a4, height2, a5, translationX, f2, translationY, f3, valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.liveForMsg.ui.LiveSendMsgTransitionAnimView$startAnim$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LiveSendMsgTransitionAnimView.this.getMActivity();
                ViewParent parent = LiveSendMsgTransitionAnimView.this.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(LiveSendMsgTransitionAnimView.this);
            }
        });
        ofFloat.start();
    }

    public final void a(Activity activity, ViewGroup parent, FrameLayout msgView, View targetView, LiveZanExtraModel.EmojiModel model, Runnable showMsgTask) {
        Intrinsics.e(activity, "activity");
        Intrinsics.e(parent, "parent");
        Intrinsics.e(msgView, "msgView");
        Intrinsics.e(targetView, "targetView");
        Intrinsics.e(model, "model");
        Intrinsics.e(showMsgTask, "showMsgTask");
        this.g = msgView;
        this.i = model;
        this.j = showMsgTask;
        this.k = 3;
        a(activity, parent, targetView);
    }

    public final void a(Activity activity, ViewGroup parent, TextView msgView, View targetView, Runnable showMsgTask) {
        Intrinsics.e(activity, "activity");
        Intrinsics.e(parent, "parent");
        Intrinsics.e(msgView, "msgView");
        Intrinsics.e(targetView, "targetView");
        Intrinsics.e(showMsgTask, "showMsgTask");
        this.g = msgView;
        this.d = msgView.getText().toString();
        this.j = showMsgTask;
        this.k = 2;
        a(activity, parent, targetView);
    }

    public final void a(Activity activity, ViewGroup parent, String msg, View msgView, View targetView, Runnable showMsgTask) {
        Intrinsics.e(activity, "activity");
        Intrinsics.e(parent, "parent");
        Intrinsics.e(msg, "msg");
        Intrinsics.e(msgView, "msgView");
        Intrinsics.e(targetView, "targetView");
        Intrinsics.e(showMsgTask, "showMsgTask");
        this.g = msgView;
        this.d = msg;
        this.j = showMsgTask;
        this.k = 1;
        a(activity, parent, targetView);
        if (msgView instanceof EditText) {
            ((EditText) msgView).setText("");
        }
    }

    public final int getFrom() {
        return this.k;
    }

    public final Activity getMActivity() {
        return this.e;
    }

    public final Context getMContext() {
        return this.b;
    }

    public final LiveZanExtraModel.EmojiModel getMEmojiModel() {
        return this.i;
    }

    public final ImageView getMImgView() {
        return this.m;
    }

    public final LiveMsgBgFrameLayout getMMsgBgView() {
        return this.n;
    }

    public final ViewGroup getMParent() {
        return this.f;
    }

    public final CardView getMRootView() {
        return this.l;
    }

    public final boolean getMSendFinish() {
        return this.f13543c;
    }

    public final View getMSendMsgView() {
        return this.g;
    }

    public final Runnable getMShowMsgTask() {
        return this.j;
    }

    public final View getMTargetView() {
        return this.h;
    }

    public final String getMText() {
        return this.d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final void setFrom(int i) {
        this.k = i;
    }

    public final void setMActivity(Activity activity) {
        this.e = activity;
    }

    public final void setMEmojiModel(LiveZanExtraModel.EmojiModel emojiModel) {
        this.i = emojiModel;
    }

    public final void setMImgView(ImageView imageView) {
        this.m = imageView;
    }

    public final void setMMsgBgView(LiveMsgBgFrameLayout liveMsgBgFrameLayout) {
        this.n = liveMsgBgFrameLayout;
    }

    public final void setMParent(ViewGroup viewGroup) {
        this.f = viewGroup;
    }

    public final void setMRootView(CardView cardView) {
        this.l = cardView;
    }

    public final void setMSendFinish(boolean z) {
        this.f13543c = z;
    }

    public final void setMSendMsgView(View view) {
        this.g = view;
    }

    public final void setMShowMsgTask(Runnable runnable) {
        this.j = runnable;
    }

    public final void setMTargetView(View view) {
        this.h = view;
    }

    public final void setMText(String str) {
        this.d = str;
    }
}
