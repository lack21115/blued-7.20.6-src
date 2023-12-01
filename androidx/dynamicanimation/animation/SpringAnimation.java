package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/SpringAnimation.class */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private SpringForce i;
    private float j;
    private boolean k;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.i = null;
        this.j = Float.MAX_VALUE;
        this.k = false;
    }

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        this.i = null;
        this.j = Float.MAX_VALUE;
        this.k = false;
    }

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat, float f) {
        super(k, floatPropertyCompat);
        this.i = null;
        this.j = Float.MAX_VALUE;
        this.k = false;
        this.i = new SpringForce(f);
    }

    private void b() {
        SpringForce springForce = this.i;
        if (springForce == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double finalPosition = springForce.getFinalPosition();
        if (finalPosition > this.g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (finalPosition < this.h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean a(float f, float f2) {
        return this.i.isAtEquilibrium(f, f2);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean a(long j) {
        if (this.k) {
            float f = this.j;
            if (f != Float.MAX_VALUE) {
                this.i.setFinalPosition(f);
                this.j = Float.MAX_VALUE;
            }
            this.b = this.i.getFinalPosition();
            this.f2801a = 0.0f;
            this.k = false;
            return true;
        }
        if (this.j != Float.MAX_VALUE) {
            this.i.getFinalPosition();
            long j2 = j / 2;
            DynamicAnimation.MassState a2 = this.i.a(this.b, this.f2801a, j2);
            this.i.setFinalPosition(this.j);
            this.j = Float.MAX_VALUE;
            DynamicAnimation.MassState a3 = this.i.a(a2.f2804a, a2.b, j2);
            this.b = a3.f2804a;
            this.f2801a = a3.b;
        } else {
            DynamicAnimation.MassState a4 = this.i.a(this.b, this.f2801a, j);
            this.b = a4.f2804a;
            this.f2801a = a4.b;
        }
        this.b = Math.max(this.b, this.h);
        this.b = Math.min(this.b, this.g);
        if (a(this.b, this.f2801a)) {
            this.b = this.i.getFinalPosition();
            this.f2801a = 0.0f;
            return true;
        }
        return false;
    }

    public void animateToFinalPosition(float f) {
        if (isRunning()) {
            this.j = f;
            return;
        }
        if (this.i == null) {
            this.i = new SpringForce(f);
        }
        this.i.setFinalPosition(f);
        start();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void b(float f) {
    }

    public boolean canSkipToEnd() {
        return this.i.b > 0.0d;
    }

    public SpringForce getSpring() {
        return this.i;
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.i = springForce;
        return this;
    }

    public void skipToEnd() {
        if (!canSkipToEnd()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f) {
            this.k = true;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void start() {
        b();
        this.i.a(a());
        super.start();
    }
}
