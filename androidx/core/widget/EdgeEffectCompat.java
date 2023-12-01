package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.core.os.BuildCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/EdgeEffectCompat.class */
public final class EdgeEffectCompat {

    /* renamed from: a  reason: collision with root package name */
    private EdgeEffect f2751a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/EdgeEffectCompat$Api31Impl.class */
    static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable th) {
                return new EdgeEffect(context);
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable th) {
                return 0.0f;
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
            try {
                return edgeEffect.onPullDistance(f, f2);
            } catch (Throwable th) {
                edgeEffect.onPull(f, f2);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f2751a = new EdgeEffect(context);
    }

    public static EdgeEffect create(Context context, AttributeSet attributeSet) {
        return BuildCompat.isAtLeastS() ? Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (BuildCompat.isAtLeastS()) {
            return Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static void onPull(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        if (BuildCompat.isAtLeastS()) {
            return Api31Impl.onPullDistance(edgeEffect, f, f2);
        }
        onPull(edgeEffect, f, f2);
        return f;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.f2751a.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.f2751a.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f2751a.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.f2751a.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.f2751a.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.f2751a, f, f2);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.f2751a.onRelease();
        return this.f2751a.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.f2751a.setSize(i, i2);
    }
}
