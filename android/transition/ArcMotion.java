package android.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.FloatMath;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/transition/ArcMotion.class */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcMotion);
        setMinimumVerticalAngle(obtainStyledAttributes.getFloat(1, 0.0f));
        setMinimumHorizontalAngle(obtainStyledAttributes.getFloat(0, 0.0f));
        setMaximumAngle(obtainStyledAttributes.getFloat(2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }

    private static float toTangent(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // android.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Path path = new Path();
        path.moveTo(f, f2);
        if (f2 == f4) {
            f8 = (f + f3) / 2.0f;
            f9 = f2 + ((this.mMinimumHorizontalTangent * Math.abs(f3 - f)) / 2.0f);
        } else if (f == f3) {
            f8 = f + ((this.mMinimumVerticalTangent * Math.abs(f4 - f2)) / 2.0f);
            f9 = (f2 + f4) / 2.0f;
        } else {
            float f10 = f3 - f;
            float f11 = f2 - f4;
            float f12 = (f10 * f10) + (f11 * f11);
            float f13 = (f + f3) / 2.0f;
            float f14 = (f2 + f4) / 2.0f;
            float f15 = f12 * 0.25f;
            if (Math.abs(f10) < Math.abs(f11)) {
                f6 = f4 + (f12 / (2.0f * f11));
                f5 = f3;
                f7 = this.mMinimumVerticalTangent * f15 * this.mMinimumVerticalTangent;
            } else {
                f5 = f3 + (f12 / (2.0f * f10));
                f6 = f4;
                f7 = this.mMinimumHorizontalTangent * f15 * this.mMinimumHorizontalTangent;
            }
            float f16 = f13 - f5;
            float f17 = f14 - f6;
            float f18 = (f16 * f16) + (f17 * f17);
            float f19 = this.mMaximumTangent * f15 * this.mMaximumTangent;
            float f20 = 0.0f;
            if (f18 < f7) {
                f20 = f7;
            } else if (f18 > f19) {
                f20 = f19;
            }
            f8 = f5;
            f9 = f6;
            if (f20 != 0.0f) {
                float sqrt = FloatMath.sqrt(f20 / f18);
                f8 = f13 + ((f5 - f13) * sqrt);
                f9 = f14 + ((f6 - f14) * sqrt);
            }
        }
        path.cubicTo((f + f8) / 2.0f, (f2 + f9) / 2.0f, (f8 + f3) / 2.0f, (f9 + f4) / 2.0f, f3, f4);
        return path;
    }

    public void setMaximumAngle(float f) {
        this.mMaximumAngle = f;
        this.mMaximumTangent = toTangent(f);
    }

    public void setMinimumHorizontalAngle(float f) {
        this.mMinimumHorizontalAngle = f;
        this.mMinimumHorizontalTangent = toTangent(f);
    }

    public void setMinimumVerticalAngle(float f) {
        this.mMinimumVerticalAngle = f;
        this.mMinimumVerticalTangent = toTangent(f);
    }
}
