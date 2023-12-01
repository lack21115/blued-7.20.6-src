package android.animation;

import android.animation.Keyframe;
import android.animation.Keyframes;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/animation/IntKeyframeSet.class */
public class IntKeyframeSet extends KeyframeSet implements Keyframes.IntKeyframes {
    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
        this.firstTime = true;
    }

    @Override // android.animation.KeyframeSet
    /* renamed from: clone */
    public IntKeyframeSet mo57clone() {
        List<Keyframe> list = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new IntKeyframeSet(intKeyframeArr);
            }
            intKeyframeArr[i2] = (Keyframe.IntKeyframe) list.get(i2).mo58clone();
            i = i2 + 1;
        }
    }

    @Override // android.animation.Keyframes.IntKeyframes
    public int getIntValue(float f) {
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                this.lastValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            float f2 = f;
            if (this.mInterpolator != null) {
                f2 = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator == null ? this.firstValue + ((int) (this.deltaValue * f2)) : ((Number) this.mEvaluator.evaluate(f2, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
        } else if (f <= 0.0f) {
            Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.mKeyframes.get(1);
            int intValue = intKeyframe.getIntValue();
            int intValue2 = intKeyframe2.getIntValue();
            float fraction = intKeyframe.getFraction();
            float fraction2 = intKeyframe2.getFraction();
            TimeInterpolator interpolator = intKeyframe2.getInterpolator();
            float f3 = f;
            if (interpolator != null) {
                f3 = interpolator.getInterpolation(f);
            }
            float f4 = (f3 - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? ((int) ((intValue2 - intValue) * f4)) + intValue : ((Number) this.mEvaluator.evaluate(f4, Integer.valueOf(intValue), Integer.valueOf(intValue2))).intValue();
        } else if (f >= 1.0f) {
            Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            int intValue3 = intKeyframe3.getIntValue();
            int intValue4 = intKeyframe4.getIntValue();
            float fraction3 = intKeyframe3.getFraction();
            float fraction4 = intKeyframe4.getFraction();
            TimeInterpolator interpolator2 = intKeyframe4.getInterpolator();
            float f5 = f;
            if (interpolator2 != null) {
                f5 = interpolator2.getInterpolation(f);
            }
            float f6 = (f5 - fraction3) / (fraction4 - fraction3);
            return this.mEvaluator == null ? ((int) ((intValue4 - intValue3) * f6)) + intValue3 : ((Number) this.mEvaluator.evaluate(f6, Integer.valueOf(intValue3), Integer.valueOf(intValue4))).intValue();
        } else {
            Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNumKeyframes) {
                    return ((Number) this.mKeyframes.get(this.mNumKeyframes - 1).getValue()).intValue();
                }
                Keyframe.IntKeyframe intKeyframe6 = (Keyframe.IntKeyframe) this.mKeyframes.get(i2);
                if (f < intKeyframe6.getFraction()) {
                    TimeInterpolator interpolator3 = intKeyframe6.getInterpolator();
                    float f7 = f;
                    if (interpolator3 != null) {
                        f7 = interpolator3.getInterpolation(f);
                    }
                    float fraction5 = (f7 - intKeyframe5.getFraction()) / (intKeyframe6.getFraction() - intKeyframe5.getFraction());
                    int intValue5 = intKeyframe5.getIntValue();
                    int intValue6 = intKeyframe6.getIntValue();
                    return this.mEvaluator == null ? ((int) ((intValue6 - intValue5) * fraction5)) + intValue5 : ((Number) this.mEvaluator.evaluate(fraction5, Integer.valueOf(intValue5), Integer.valueOf(intValue6))).intValue();
                }
                intKeyframe5 = intKeyframe6;
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.KeyframeSet, android.animation.Keyframes
    public Class getType() {
        return Integer.class;
    }

    @Override // android.animation.KeyframeSet, android.animation.Keyframes
    public Object getValue(float f) {
        return Integer.valueOf(getIntValue(f));
    }

    @Override // android.animation.KeyframeSet, android.animation.Keyframes
    public void invalidateCache() {
        this.firstTime = true;
    }
}
