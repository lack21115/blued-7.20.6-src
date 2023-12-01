package android.animation;

import android.animation.Keyframe;
import android.animation.Keyframes;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/animation/FloatKeyframeSet.class */
public class FloatKeyframeSet extends KeyframeSet implements Keyframes.FloatKeyframes {
    private float deltaValue;
    private boolean firstTime;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
        this.firstTime = true;
    }

    @Override // android.animation.KeyframeSet
    /* renamed from: clone */
    public FloatKeyframeSet mo57clone() {
        List<Keyframe> list = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new FloatKeyframeSet(floatKeyframeArr);
            }
            floatKeyframeArr[i2] = (Keyframe.FloatKeyframe) list.get(i2).mo58clone();
            i = i2 + 1;
        }
    }

    @Override // android.animation.Keyframes.FloatKeyframes
    public float getFloatValue(float f) {
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                this.lastValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            float f2 = f;
            if (this.mInterpolator != null) {
                f2 = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator == null ? this.firstValue + (this.deltaValue * f2) : ((Number) this.mEvaluator.evaluate(f2, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
        } else if (f <= 0.0f) {
            Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.mKeyframes.get(1);
            float floatValue = floatKeyframe.getFloatValue();
            float floatValue2 = floatKeyframe2.getFloatValue();
            float fraction = floatKeyframe.getFraction();
            float fraction2 = floatKeyframe2.getFraction();
            TimeInterpolator interpolator = floatKeyframe2.getInterpolator();
            float f3 = f;
            if (interpolator != null) {
                f3 = interpolator.getInterpolation(f);
            }
            float f4 = (f3 - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? ((floatValue2 - floatValue) * f4) + floatValue : ((Number) this.mEvaluator.evaluate(f4, Float.valueOf(floatValue), Float.valueOf(floatValue2))).floatValue();
        } else if (f >= 1.0f) {
            Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            float floatValue3 = floatKeyframe3.getFloatValue();
            float floatValue4 = floatKeyframe4.getFloatValue();
            float fraction3 = floatKeyframe3.getFraction();
            float fraction4 = floatKeyframe4.getFraction();
            TimeInterpolator interpolator2 = floatKeyframe4.getInterpolator();
            float f5 = f;
            if (interpolator2 != null) {
                f5 = interpolator2.getInterpolation(f);
            }
            float f6 = (f5 - fraction3) / (fraction4 - fraction3);
            return this.mEvaluator == null ? ((floatValue4 - floatValue3) * f6) + floatValue3 : ((Number) this.mEvaluator.evaluate(f6, Float.valueOf(floatValue3), Float.valueOf(floatValue4))).floatValue();
        } else {
            Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNumKeyframes) {
                    return ((Number) this.mKeyframes.get(this.mNumKeyframes - 1).getValue()).floatValue();
                }
                Keyframe.FloatKeyframe floatKeyframe6 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i2);
                if (f < floatKeyframe6.getFraction()) {
                    TimeInterpolator interpolator3 = floatKeyframe6.getInterpolator();
                    float f7 = f;
                    if (interpolator3 != null) {
                        f7 = interpolator3.getInterpolation(f);
                    }
                    float fraction5 = (f7 - floatKeyframe5.getFraction()) / (floatKeyframe6.getFraction() - floatKeyframe5.getFraction());
                    float floatValue5 = floatKeyframe5.getFloatValue();
                    float floatValue6 = floatKeyframe6.getFloatValue();
                    return this.mEvaluator == null ? ((floatValue6 - floatValue5) * fraction5) + floatValue5 : ((Number) this.mEvaluator.evaluate(fraction5, Float.valueOf(floatValue5), Float.valueOf(floatValue6))).floatValue();
                }
                floatKeyframe5 = floatKeyframe6;
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.KeyframeSet, android.animation.Keyframes
    public Class getType() {
        return Float.class;
    }

    @Override // android.animation.KeyframeSet, android.animation.Keyframes
    public Object getValue(float f) {
        return Float.valueOf(getFloatValue(f));
    }

    @Override // android.animation.KeyframeSet, android.animation.Keyframes
    public void invalidateCache() {
        this.firstTime = true;
    }
}
