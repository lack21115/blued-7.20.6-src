package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframe.class */
public abstract class Keyframe implements Cloneable {
    float mFraction;
    boolean mHasValue;
    private TimeInterpolator mInterpolator = null;
    Class mValueType;
    boolean mValueWasSetOnStart;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframe$FloatKeyframe.class */
    public static class FloatKeyframe extends Keyframe {
        float mValue;

        FloatKeyframe(float f) {
            this.mFraction = f;
            this.mValueType = Float.TYPE;
        }

        FloatKeyframe(float f, float f2) {
            this.mFraction = f;
            this.mValue = f2;
            this.mValueType = Float.TYPE;
            this.mHasValue = true;
        }

        @Override // android.animation.Keyframe
        /* renamed from: clone */
        public FloatKeyframe mo58clone() {
            FloatKeyframe floatKeyframe = this.mHasValue ? new FloatKeyframe(getFraction(), this.mValue) : new FloatKeyframe(getFraction());
            floatKeyframe.setInterpolator(getInterpolator());
            floatKeyframe.mValueWasSetOnStart = this.mValueWasSetOnStart;
            return floatKeyframe;
        }

        public float getFloatValue() {
            return this.mValue;
        }

        @Override // android.animation.Keyframe
        public Object getValue() {
            return Float.valueOf(this.mValue);
        }

        @Override // android.animation.Keyframe
        public void setValue(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.mValue = ((Float) obj).floatValue();
            this.mHasValue = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframe$IntKeyframe.class */
    public static class IntKeyframe extends Keyframe {
        int mValue;

        IntKeyframe(float f) {
            this.mFraction = f;
            this.mValueType = Integer.TYPE;
        }

        IntKeyframe(float f, int i) {
            this.mFraction = f;
            this.mValue = i;
            this.mValueType = Integer.TYPE;
            this.mHasValue = true;
        }

        @Override // android.animation.Keyframe
        /* renamed from: clone */
        public IntKeyframe mo58clone() {
            IntKeyframe intKeyframe = this.mHasValue ? new IntKeyframe(getFraction(), this.mValue) : new IntKeyframe(getFraction());
            intKeyframe.setInterpolator(getInterpolator());
            intKeyframe.mValueWasSetOnStart = this.mValueWasSetOnStart;
            return intKeyframe;
        }

        public int getIntValue() {
            return this.mValue;
        }

        @Override // android.animation.Keyframe
        public Object getValue() {
            return Integer.valueOf(this.mValue);
        }

        @Override // android.animation.Keyframe
        public void setValue(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.mValue = ((Integer) obj).intValue();
            this.mHasValue = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframe$ObjectKeyframe.class */
    public static class ObjectKeyframe extends Keyframe {
        Object mValue;

        ObjectKeyframe(float f, Object obj) {
            this.mFraction = f;
            this.mValue = obj;
            this.mHasValue = obj != null;
            this.mValueType = this.mHasValue ? obj.getClass() : Object.class;
        }

        @Override // android.animation.Keyframe
        /* renamed from: clone */
        public ObjectKeyframe mo58clone() {
            ObjectKeyframe objectKeyframe = new ObjectKeyframe(getFraction(), hasValue() ? this.mValue : null);
            objectKeyframe.mValueWasSetOnStart = this.mValueWasSetOnStart;
            objectKeyframe.setInterpolator(getInterpolator());
            return objectKeyframe;
        }

        @Override // android.animation.Keyframe
        public Object getValue() {
            return this.mValue;
        }

        @Override // android.animation.Keyframe
        public void setValue(Object obj) {
            this.mValue = obj;
            this.mHasValue = obj != null;
        }
    }

    public static Keyframe ofFloat(float f) {
        return new FloatKeyframe(f);
    }

    public static Keyframe ofFloat(float f, float f2) {
        return new FloatKeyframe(f, f2);
    }

    public static Keyframe ofInt(float f) {
        return new IntKeyframe(f);
    }

    public static Keyframe ofInt(float f, int i) {
        return new IntKeyframe(f, i);
    }

    public static Keyframe ofObject(float f) {
        return new ObjectKeyframe(f, null);
    }

    public static Keyframe ofObject(float f, Object obj) {
        return new ObjectKeyframe(f, obj);
    }

    @Override // 
    /* renamed from: clone */
    public abstract Keyframe mo58clone();

    public float getFraction() {
        return this.mFraction;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public Class getType() {
        return this.mValueType;
    }

    public abstract Object getValue();

    public boolean hasValue() {
        return this.mHasValue;
    }

    public void setFraction(float f) {
        this.mFraction = f;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
    }

    public abstract void setValue(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValueWasSetOnStart(boolean z) {
        this.mValueWasSetOnStart = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean valueWasSetOnStart() {
        return this.mValueWasSetOnStart;
    }
}
