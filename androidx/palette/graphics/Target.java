package androidx.palette.graphics;

/* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Target.class */
public final class Target {
    public static final Target DARK_MUTED;
    public static final Target DARK_VIBRANT;
    public static final Target LIGHT_MUTED;
    public static final Target LIGHT_VIBRANT;
    public static final Target MUTED;
    public static final Target VIBRANT;

    /* renamed from: a  reason: collision with root package name */
    final float[] f3147a;
    final float[] b;

    /* renamed from: c  reason: collision with root package name */
    final float[] f3148c;
    boolean d;

    /* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Target$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Target f3149a;

        public Builder() {
            this.f3149a = new Target();
        }

        public Builder(Target target) {
            this.f3149a = new Target(target);
        }

        public Target build() {
            return this.f3149a;
        }

        public Builder setExclusive(boolean z) {
            this.f3149a.d = z;
            return this;
        }

        public Builder setLightnessWeight(float f) {
            this.f3149a.f3148c[1] = f;
            return this;
        }

        public Builder setMaximumLightness(float f) {
            this.f3149a.b[2] = f;
            return this;
        }

        public Builder setMaximumSaturation(float f) {
            this.f3149a.f3147a[2] = f;
            return this;
        }

        public Builder setMinimumLightness(float f) {
            this.f3149a.b[0] = f;
            return this;
        }

        public Builder setMinimumSaturation(float f) {
            this.f3149a.f3147a[0] = f;
            return this;
        }

        public Builder setPopulationWeight(float f) {
            this.f3149a.f3148c[2] = f;
            return this;
        }

        public Builder setSaturationWeight(float f) {
            this.f3149a.f3148c[0] = f;
            return this;
        }

        public Builder setTargetLightness(float f) {
            this.f3149a.b[1] = f;
            return this;
        }

        public Builder setTargetSaturation(float f) {
            this.f3149a.f3147a[1] = f;
            return this;
        }
    }

    static {
        Target target = new Target();
        LIGHT_VIBRANT = target;
        c(target);
        d(LIGHT_VIBRANT);
        Target target2 = new Target();
        VIBRANT = target2;
        b(target2);
        d(VIBRANT);
        Target target3 = new Target();
        DARK_VIBRANT = target3;
        a(target3);
        d(DARK_VIBRANT);
        Target target4 = new Target();
        LIGHT_MUTED = target4;
        c(target4);
        e(LIGHT_MUTED);
        Target target5 = new Target();
        MUTED = target5;
        b(target5);
        e(MUTED);
        Target target6 = new Target();
        DARK_MUTED = target6;
        a(target6);
        e(DARK_MUTED);
    }

    Target() {
        float[] fArr = new float[3];
        this.f3147a = fArr;
        this.b = new float[3];
        this.f3148c = new float[3];
        this.d = true;
        a(fArr);
        a(this.b);
        b();
    }

    Target(Target target) {
        float[] fArr = new float[3];
        this.f3147a = fArr;
        this.b = new float[3];
        this.f3148c = new float[3];
        this.d = true;
        System.arraycopy(target.f3147a, 0, fArr, 0, fArr.length);
        float[] fArr2 = target.b;
        float[] fArr3 = this.b;
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        float[] fArr4 = target.f3148c;
        float[] fArr5 = this.f3148c;
        System.arraycopy(fArr4, 0, fArr5, 0, fArr5.length);
    }

    private static void a(Target target) {
        float[] fArr = target.b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private void b() {
        float[] fArr = this.f3148c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void b(Target target) {
        float[] fArr = target.b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void c(Target target) {
        float[] fArr = target.b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void d(Target target) {
        float[] fArr = target.f3147a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private static void e(Target target) {
        float[] fArr = target.f3147a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        float f;
        int length = this.f3148c.length;
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            f = f2;
            if (i >= length) {
                break;
            }
            float f3 = this.f3148c[i];
            float f4 = f;
            if (f3 > 0.0f) {
                f4 = f + f3;
            }
            i++;
            f2 = f4;
        }
        if (f == 0.0f) {
            return;
        }
        int length2 = this.f3148c.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length2) {
                return;
            }
            float[] fArr = this.f3148c;
            if (fArr[i3] > 0.0f) {
                fArr[i3] = fArr[i3] / f;
            }
            i2 = i3 + 1;
        }
    }

    public float getLightnessWeight() {
        return this.f3148c[1];
    }

    public float getMaximumLightness() {
        return this.b[2];
    }

    public float getMaximumSaturation() {
        return this.f3147a[2];
    }

    public float getMinimumLightness() {
        return this.b[0];
    }

    public float getMinimumSaturation() {
        return this.f3147a[0];
    }

    public float getPopulationWeight() {
        return this.f3148c[2];
    }

    public float getSaturationWeight() {
        return this.f3148c[0];
    }

    public float getTargetLightness() {
        return this.b[1];
    }

    public float getTargetSaturation() {
        return this.f3147a[1];
    }

    public boolean isExclusive() {
        return this.d;
    }
}
