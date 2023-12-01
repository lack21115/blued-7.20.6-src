package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/FlingAnimation.class */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/FlingAnimation$DragForce.class */
    public static final class DragForce implements Force {
        private float b;

        /* renamed from: a  reason: collision with root package name */
        private float f2805a = -4.2f;

        /* renamed from: c  reason: collision with root package name */
        private final DynamicAnimation.MassState f2806c = new DynamicAnimation.MassState();

        DragForce() {
        }

        float a() {
            return this.f2805a / (-4.2f);
        }

        DynamicAnimation.MassState a(float f, float f2, long j) {
            float f3 = (float) j;
            this.f2806c.b = (float) (f2 * Math.exp((f3 / 1000.0f) * this.f2805a));
            DynamicAnimation.MassState massState = this.f2806c;
            float f4 = this.f2805a;
            massState.f2804a = (float) ((f - (f2 / f4)) + ((f2 / f4) * Math.exp((f4 * f3) / 1000.0f)));
            if (isAtEquilibrium(this.f2806c.f2804a, this.f2806c.b)) {
                this.f2806c.b = 0.0f;
            }
            return this.f2806c;
        }

        void a(float f) {
            this.f2805a = f * (-4.2f);
        }

        void b(float f) {
            this.b = f * 62.5f;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f, float f2) {
            return f2 * this.f2805a;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f, float f2) {
            return Math.abs(f2) < this.b;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.i = dragForce;
        dragForce.b(a());
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.i = dragForce;
        dragForce.b(a());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean a(float f, float f2) {
        return f >= this.g || f <= this.h || this.i.isAtEquilibrium(f, f2);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean a(long j) {
        DynamicAnimation.MassState a2 = this.i.a(this.b, this.f2801a, j);
        this.b = a2.f2804a;
        this.f2801a = a2.b;
        if (this.b < this.h) {
            this.b = this.h;
            return true;
        } else if (this.b <= this.g) {
            return a(this.b, this.f2801a);
        } else {
            this.b = this.g;
            return true;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void b(float f) {
        this.i.b(f);
    }

    public float getFriction() {
        return this.i.a();
    }

    public FlingAnimation setFriction(float f) {
        if (f > 0.0f) {
            this.i.a(f);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f) {
        super.setMaxValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f) {
        super.setMinValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f) {
        super.setStartVelocity(f);
        return this;
    }
}
