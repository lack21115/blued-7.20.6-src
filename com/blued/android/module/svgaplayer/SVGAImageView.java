package com.blued.android.module.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.utils.SVGARange;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAImageView.class */
public class SVGAImageView extends ImageView {
    private final String a;
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private FillMode f;
    private SVGACallback g;
    private ValueAnimator h;
    private SVGAClickAreaListener i;
    private boolean j;
    private boolean k;
    private final AnimatorListener l;
    private final AnimatorUpdateListener m;
    private int n;
    private int o;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAImageView$AnimatorListener.class */
    public static final class AnimatorListener implements Animator.AnimatorListener {
        private final WeakReference<SVGAImageView> a;

        public AnimatorListener(SVGAImageView view) {
            Intrinsics.e(view, "view");
            this.a = new WeakReference<>(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SVGAImageView sVGAImageView = this.a.get();
            if (sVGAImageView == null) {
                return;
            }
            sVGAImageView.b = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SVGAImageView sVGAImageView = this.a.get();
            if (sVGAImageView != null) {
                sVGAImageView.a(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            SVGACallback callback;
            SVGAImageView sVGAImageView = this.a.get();
            if (sVGAImageView == null || (callback = sVGAImageView.getCallback()) == null) {
                return;
            }
            callback.onRepeat();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SVGAImageView sVGAImageView = this.a.get();
            if (sVGAImageView == null) {
                return;
            }
            sVGAImageView.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAImageView$AnimatorUpdateListener.class */
    public static final class AnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private final WeakReference<SVGAImageView> a;

        public AnimatorUpdateListener(SVGAImageView view) {
            Intrinsics.e(view, "view");
            this.a = new WeakReference<>(view);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SVGAImageView sVGAImageView = this.a.get();
            if (sVGAImageView != null) {
                sVGAImageView.a(valueAnimator);
            }
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAImageView$FillMode.class */
    public enum FillMode {
        Backward,
        Forward,
        Clear
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAImageView$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FillMode.values().length];
            iArr[FillMode.Backward.ordinal()] = 1;
            iArr[FillMode.Forward.ordinal()] = 2;
            iArr[FillMode.Clear.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = "SVGAImageView";
        this.e = true;
        this.f = FillMode.Forward;
        this.j = true;
        this.k = true;
        this.l = new AnimatorListener(this);
        this.m = new AnimatorUpdateListener(this);
        this.p = true;
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        if (attributeSet != null) {
            a(attributeSet);
        }
    }

    public /* synthetic */ SVGAImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final SVGAParser.ParseCompletion a(final WeakReference<SVGAImageView> weakReference) {
        return new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.svgaplayer.SVGAImageView$createParseCompletion$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.e(videoItem, "videoItem");
                SVGAImageView sVGAImageView = weakReference.get();
                if (sVGAImageView != null) {
                    sVGAImageView.a(videoItem);
                }
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Animator animator) {
        this.b = false;
        d();
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            int i = WhenMappings.a[this.f.ordinal()];
            if (i == 1) {
                sVGADrawable.a(this.n);
            } else if (i == 2) {
                sVGADrawable.a(this.o);
            } else if (i == 3) {
                sVGADrawable.a(true);
            }
        }
        SVGACallback sVGACallback = this.g;
        if (sVGACallback != null) {
            sVGACallback.onFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ValueAnimator valueAnimator) {
        SVGAVideoData a;
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null || (a = sVGADrawable.a().a()) == null) {
            return;
        }
        Integer animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        sVGADrawable.a(animatedValue.intValue());
        double c = (sVGADrawable.c() + 1) / a.e();
        SVGACallback sVGACallback = this.g;
        if (sVGACallback != null) {
            sVGACallback.onStep(sVGADrawable.c(), c);
        }
    }

    private final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.c = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.d = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, false);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterDetached, true);
        this.j = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            switch (string.hashCode()) {
                case 48:
                    if (string.equals("0")) {
                        this.f = FillMode.Backward;
                        break;
                    }
                    break;
                case 49:
                    if (string.equals("1")) {
                        this.f = FillMode.Forward;
                        break;
                    }
                    break;
                case 50:
                    if (string.equals("2")) {
                        this.f = FillMode.Clear;
                        break;
                    }
                    break;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            a(string2);
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final SVGAVideoEntity sVGAVideoEntity) {
        post(new Runnable() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAImageView$JNfXpdDb71hB-Pkvj_fRgapaRrE
            @Override // java.lang.Runnable
            public final void run() {
                SVGAImageView.a(SVGAVideoEntity.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SVGAVideoEntity videoItem, SVGAImageView this$0) {
        Intrinsics.e(videoItem, "$videoItem");
        Intrinsics.e(this$0, "this$0");
        SVGAVideoData a = videoItem.a();
        if (a != null) {
            a.a(this$0.j);
        }
        this$0.setVideoItem(videoItem);
        SVGADrawable sVGADrawable = this$0.getSVGADrawable();
        if (sVGADrawable != null) {
            ImageView.ScaleType scaleType = this$0.getScaleType();
            Intrinsics.c(scaleType, "scaleType");
            sVGADrawable.a(scaleType);
        }
        if (this$0.k) {
            this$0.a();
        }
    }

    private final void a(String str) {
        WeakReference<SVGAImageView> weakReference = new WeakReference<>(this);
        SVGAParser sVGAParser = new SVGAParser(getContext());
        if (StringsKt.a(str, "http://", false, 2, (Object) null) || StringsKt.a(str, "https://", false, 2, (Object) null)) {
            SVGAParser.a(sVGAParser, new URL(str), a(weakReference), (SVGAParser.PlayCallback) null, 4, (Object) null);
        } else {
            SVGAParser.a(sVGAParser, str, a(weakReference), (SVGAParser.PlayCallback) null, 4, (Object) null);
        }
    }

    private final void b(SVGARange sVGARange, boolean z) {
        SVGAVideoData a;
        LogUtils.a.a(this.a, "================ start animation ================");
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null || (a = sVGADrawable.a().a()) == null) {
            return;
        }
        f();
        this.n = Math.max(0, sVGARange != null ? sVGARange.a() : 0);
        SVGAVideoData a2 = sVGADrawable.a().a();
        int min = Math.min((a2 != null ? a2.e() : 1) - 1, ((sVGARange != null ? sVGARange.a() : 0) + (sVGARange != null ? sVGARange.b() : Integer.MAX_VALUE)) - 1);
        this.o = min;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.n, min);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration((long) ((((this.o - this.n) + 1) * (1000 / a.d())) / g()));
        int i = this.c;
        ofInt.setRepeatCount(i <= 0 ? 99999 : i - 1);
        LogUtils logUtils = LogUtils.a;
        String str = this.a;
        logUtils.a(str, "play:: mStartFrame=" + this.n + ", mEndFrame=" + this.o + ",duration = " + ofInt.getDuration());
        ofInt.addUpdateListener(this.m);
        ofInt.addListener(this.l);
        if (z) {
            ofInt.reverse();
        } else {
            ofInt.start();
        }
        this.h = ofInt;
    }

    private final void f() {
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return;
        }
        sVGADrawable.a(false);
        ImageView.ScaleType scaleType = getScaleType();
        Intrinsics.c(scaleType, "scaleType");
        sVGADrawable.a(scaleType);
    }

    private final double g() {
        Method declaredMethod;
        double d = 1.0d;
        try {
            Class<?> cls = Class.forName("android.animation.ValueAnimator");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getDurationScale", new Class[0])) == null) {
                return 1.0d;
            }
            Object invoke = declaredMethod.invoke(cls, new Object[0]);
            if (invoke != null) {
                double floatValue = ((Float) invoke).floatValue();
                if (floatValue == 0.0d) {
                    try {
                        Method declaredMethod2 = cls.getDeclaredMethod("setDurationScale", Float.TYPE);
                        if (declaredMethod2 == null) {
                            return floatValue;
                        }
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(cls, Float.valueOf(1.0f));
                        LogUtils.a.a(this.a, "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                        return 1.0d;
                    } catch (Exception e) {
                        e = e;
                        d = floatValue;
                        e.printStackTrace();
                        return d;
                    }
                }
                return floatValue;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Deprecated
    public static /* synthetic */ void getClearsAfterStop$annotations() {
    }

    private final SVGADrawable getSVGADrawable() {
        Drawable drawable = getDrawable();
        if (drawable instanceof SVGADrawable) {
            return (SVGADrawable) drawable;
        }
        return null;
    }

    public final void a() {
        a((SVGARange) null, false);
    }

    public final void a(int i, boolean z) {
        SVGAVideoData a;
        c();
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null || (a = sVGADrawable.a().a()) == null) {
            return;
        }
        sVGADrawable.a(i);
        if (z) {
            a();
            ValueAnimator valueAnimator = this.h;
            if (valueAnimator != null) {
                valueAnimator.setCurrentPlayTime(Math.max(0.0f, Math.min(1.0f, i / a.e())) * ((float) valueAnimator.getDuration()));
            }
        }
    }

    public final void a(SVGAVideoEntity sVGAVideoEntity, SVGADynamicEntity sVGADynamicEntity) {
        if (sVGAVideoEntity == null) {
            setImageDrawable(null);
            return;
        }
        SVGADynamicEntity sVGADynamicEntity2 = sVGADynamicEntity;
        if (sVGADynamicEntity == null) {
            sVGADynamicEntity2 = new SVGADynamicEntity();
        }
        SVGADrawable sVGADrawable = new SVGADrawable(sVGAVideoEntity, sVGADynamicEntity2);
        sVGADrawable.a(true);
        setImageDrawable(sVGADrawable);
    }

    public final void a(SVGARange sVGARange, boolean z) {
        a(false);
        b(sVGARange, z);
    }

    public final void a(boolean z) {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.h;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.h;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.d();
        }
        SVGADrawable sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 == null) {
            return;
        }
        sVGADrawable2.a(z);
    }

    public final void b() {
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.a(true);
        }
        SVGADrawable sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.e();
        }
        setImageDrawable(null);
    }

    public final void c() {
        a(false);
        SVGACallback sVGACallback = this.g;
        if (sVGACallback != null) {
            sVGACallback.onPause();
        }
    }

    public final void d() {
        a(this.d);
    }

    public final void e() {
        a(this.e);
        if (this.e) {
            b();
        }
    }

    public final SVGACallback getCallback() {
        return this.g;
    }

    public final boolean getClearsAfterDetached() {
        return this.e;
    }

    public final boolean getClearsAfterStop() {
        return this.d;
    }

    public final FillMode getFillMode() {
        return this.f;
    }

    public final int getLoops() {
        return this.c;
    }

    public final boolean getMIsNeedOnDetachedFromWindow() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.p) {
            e();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SVGADrawable sVGADrawable;
        SVGAClickAreaListener sVGAClickAreaListener;
        if ((motionEvent != null && motionEvent.getAction() == 0) && (sVGADrawable = getSVGADrawable()) != null) {
            for (Map.Entry<String, int[]> entry : sVGADrawable.b().h().entrySet()) {
                String key = entry.getKey();
                int[] value = entry.getValue();
                if (motionEvent.getX() >= value[0] && motionEvent.getX() <= value[2] && motionEvent.getY() >= value[1] && motionEvent.getY() <= value[3] && (sVGAClickAreaListener = this.i) != null) {
                    sVGAClickAreaListener.a(key);
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setCallback(SVGACallback sVGACallback) {
        this.g = sVGACallback;
    }

    public final void setClearsAfterDetached(boolean z) {
        this.e = z;
    }

    public final void setClearsAfterStop(boolean z) {
        this.d = z;
    }

    public final void setFillMode(FillMode fillMode) {
        Intrinsics.e(fillMode, "<set-?>");
        this.f = fillMode;
    }

    public final void setLoops(int i) {
        this.c = i;
    }

    public final void setMIsNeedOnDetachedFromWindow(boolean z) {
        this.p = z;
    }

    public final void setOnAnimKeyClickListener(SVGAClickAreaListener clickListener) {
        Intrinsics.e(clickListener, "clickListener");
        this.i = clickListener;
    }

    public final void setVideoItem(SVGAVideoEntity sVGAVideoEntity) {
        a(sVGAVideoEntity, new SVGADynamicEntity());
    }
}
