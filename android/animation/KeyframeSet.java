package android.animation;

import android.animation.Keyframe;
import android.graphics.Path;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/animation/KeyframeSet.class */
public class KeyframeSet implements Keyframes {
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    TimeInterpolator mInterpolator;
    List<Keyframe> mKeyframes;
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.mNumKeyframes = keyframeArr.length;
        this.mKeyframes = Arrays.asList(keyframeArr);
        this.mFirstKeyframe = keyframeArr[0];
        this.mLastKeyframe = keyframeArr[this.mNumKeyframes - 1];
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }

    public static KeyframeSet ofFloat(float... fArr) {
        boolean z = false;
        boolean z2 = false;
        int length = fArr.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length != 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f, fArr[0]);
            int i = 1;
            while (true) {
                int i2 = i;
                z2 = z;
                if (i2 >= length) {
                    break;
                }
                floatKeyframeArr[i2] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(i2 / (length - 1), fArr[i2]);
                if (Float.isNaN(fArr[i2])) {
                    z = true;
                }
                i = i2 + 1;
            }
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(1.0f, fArr[0]);
            if (Float.isNaN(fArr[0])) {
                z2 = true;
            }
        }
        if (z2) {
            Log.w("Animator", "Bad value (NaN) in float animator");
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofInt(int... iArr) {
        int length = iArr.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length != 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f, iArr[0]);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                intKeyframeArr[i2] = (Keyframe.IntKeyframe) Keyframe.ofInt(i2 / (length - 1), iArr[i2]);
                i = i2 + 1;
            }
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.ofInt(1.0f, iArr[0]);
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            if (keyframeArr[i2] instanceof Keyframe.FloatKeyframe) {
                z = true;
            } else if (keyframeArr[i2] instanceof Keyframe.IntKeyframe) {
                z2 = true;
            } else {
                z3 = true;
            }
            i = i2 + 1;
        }
        if (z && !z2 && !z3) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return new FloatKeyframeSet(floatKeyframeArr);
                }
                floatKeyframeArr[i4] = (Keyframe.FloatKeyframe) keyframeArr[i4];
                i3 = i4 + 1;
            }
        } else if (!z2 || z || z3) {
            return new KeyframeSet(keyframeArr);
        } else {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[length];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    return new IntKeyframeSet(intKeyframeArr);
                }
                intKeyframeArr[i6] = (Keyframe.IntKeyframe) keyframeArr[i6];
                i5 = i6 + 1;
            }
        }
    }

    public static KeyframeSet ofObject(Object... objArr) {
        int length = objArr.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length != 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f, objArr[0]);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                objectKeyframeArr[i2] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(i2 / (length - 1), objArr[i2]);
                i = i2 + 1;
            }
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(1.0f, objArr[0]);
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    public static PathKeyframes ofPath(Path path) {
        return new PathKeyframes(path);
    }

    public static PathKeyframes ofPath(Path path, float f) {
        return new PathKeyframes(path, f);
    }

    @Override // 
    /* renamed from: clone */
    public KeyframeSet mo57clone() {
        List<Keyframe> list = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new KeyframeSet(keyframeArr);
            }
            keyframeArr[i2] = list.get(i2).mo58clone();
            i = i2 + 1;
        }
    }

    @Override // android.animation.Keyframes
    public List<Keyframe> getKeyframes() {
        return this.mKeyframes;
    }

    @Override // android.animation.Keyframes
    public Class getType() {
        return this.mFirstKeyframe.getType();
    }

    @Override // android.animation.Keyframes
    public Object getValue(float f) {
        if (this.mNumKeyframes == 2) {
            float f2 = f;
            if (this.mInterpolator != null) {
                f2 = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator.evaluate(f2, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        } else if (f <= 0.0f) {
            Keyframe keyframe = this.mKeyframes.get(1);
            TimeInterpolator interpolator = keyframe.getInterpolator();
            float f3 = f;
            if (interpolator != null) {
                f3 = interpolator.getInterpolation(f);
            }
            float fraction = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((f3 - fraction) / (keyframe.getFraction() - fraction), this.mFirstKeyframe.getValue(), keyframe.getValue());
        } else if (f >= 1.0f) {
            Keyframe keyframe2 = this.mKeyframes.get(this.mNumKeyframes - 2);
            TimeInterpolator interpolator2 = this.mLastKeyframe.getInterpolator();
            float f4 = f;
            if (interpolator2 != null) {
                f4 = interpolator2.getInterpolation(f);
            }
            float fraction2 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((f4 - fraction2) / (this.mLastKeyframe.getFraction() - fraction2), keyframe2.getValue(), this.mLastKeyframe.getValue());
        } else {
            Keyframe keyframe3 = this.mFirstKeyframe;
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNumKeyframes) {
                    return this.mLastKeyframe.getValue();
                }
                Keyframe keyframe4 = this.mKeyframes.get(i2);
                if (f < keyframe4.getFraction()) {
                    TimeInterpolator interpolator3 = keyframe4.getInterpolator();
                    float f5 = f;
                    if (interpolator3 != null) {
                        f5 = interpolator3.getInterpolation(f);
                    }
                    float fraction3 = keyframe3.getFraction();
                    return this.mEvaluator.evaluate((f5 - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
                }
                keyframe3 = keyframe4;
                i = i2 + 1;
            }
        }
    }

    @Override // android.animation.Keyframes
    public void invalidateCache() {
    }

    @Override // android.animation.Keyframes
    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNumKeyframes) {
                return str;
            }
            str = str + this.mKeyframes.get(i2).getValue() + "  ";
            i = i2 + 1;
        }
    }
}
