package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.anythink.basead.c.h;
import com.anythink.core.common.e.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseShakeView.class */
public abstract class BaseShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected ImageView f6086a;
    h b;

    /* renamed from: c  reason: collision with root package name */
    private Animation f6087c;
    private int d;
    private a e;

    /* renamed from: com.anythink.basead.ui.BaseShakeView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseShakeView$2.class */
    final class AnonymousClass2 implements Animation.AnimationListener {
        AnonymousClass2() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
            BaseShakeView.b(BaseShakeView.this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseShakeView$3.class */
    final class AnonymousClass3 implements Interpolator {
        AnonymousClass3() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if ((BaseShakeView.this.d / 2) % 3 == 0) {
                f = 0.0f;
            }
            return f;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseShakeView$a.class */
    public interface a {
        boolean a();
    }

    public BaseShakeView(Context context) {
        super(context);
        this.d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.e != null) {
                    return BaseShakeView.this.e.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.e != null) {
                    return BaseShakeView.this.e.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.e != null) {
                    return BaseShakeView.this.e.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = 0;
        this.b = new h() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.c.h
            public final boolean a() {
                if (BaseShakeView.this.isShown() && BaseShakeView.this.e != null) {
                    return BaseShakeView.this.e.a();
                }
                return false;
            }
        };
        a();
    }

    static /* synthetic */ int b(BaseShakeView baseShakeView) {
        int i = baseShakeView.d;
        baseShakeView.d = i + 1;
        return i;
    }

    private void b() {
        if (this.f6086a != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.8f, 1, 0.8f);
            this.f6087c = rotateAnimation;
            rotateAnimation.setDuration(150L);
            this.f6087c.setRepeatMode(2);
            this.f6087c.setRepeatCount(-1);
            this.f6087c.setAnimationListener(new AnonymousClass2());
            this.f6087c.setInterpolator(new AnonymousClass3());
            this.f6086a.startAnimation(this.f6087c);
        }
    }

    abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6086a != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.8f, 1, 0.8f);
            this.f6087c = rotateAnimation;
            rotateAnimation.setDuration(150L);
            this.f6087c.setRepeatMode(2);
            this.f6087c.setRepeatCount(-1);
            this.f6087c.setAnimationListener(new AnonymousClass2());
            this.f6087c.setInterpolator(new AnonymousClass3());
            this.f6086a.startAnimation(this.f6087c);
        }
        com.anythink.expressad.shake.a.a().a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animation animation = this.f6087c;
        if (animation != null) {
            animation.cancel();
        }
        com.anythink.expressad.shake.a.a().b(this.b);
    }

    public void setOnShakeListener(a aVar, k kVar) {
        this.b.a(kVar.N(), kVar.O());
        this.e = aVar;
    }
}
