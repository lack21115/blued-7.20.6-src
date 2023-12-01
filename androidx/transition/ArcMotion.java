package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ArcMotion.class */
public class ArcMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private static final float f3405a = (float) Math.tan(Math.toRadians(35.0d));
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f3406c;
    private float d;
    private float e;
    private float f;
    private float g;

    public ArcMotion() {
        this.b = 0.0f;
        this.f3406c = 0.0f;
        this.d = 70.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = f3405a;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.f3406c = 0.0f;
        this.d = 70.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = f3405a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }

    private static float a(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    public float getMaximumAngle() {
        return this.d;
    }

    public float getMinimumHorizontalAngle() {
        return this.b;
    }

    public float getMinimumVerticalAngle() {
        return this.f3406c;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Path path = new Path();
        path.moveTo(f, f2);
        float f8 = f3 - f;
        float f9 = f4 - f2;
        float f10 = (f8 * f8) + (f9 * f9);
        float f11 = (f + f3) / 2.0f;
        float f12 = (f2 + f4) / 2.0f;
        float f13 = 0.25f * f10;
        boolean z = f2 > f4;
        if (Math.abs(f8) < Math.abs(f9)) {
            float abs = Math.abs(f10 / (f9 * 2.0f));
            if (z) {
                f6 = abs + f4;
                f5 = f3;
            } else {
                f6 = abs + f2;
                f5 = f;
            }
            f7 = this.f;
        } else {
            float f14 = f10 / (f8 * 2.0f);
            if (z) {
                f6 = f2;
                f5 = f14 + f;
            } else {
                f5 = f3 - f14;
                f6 = f4;
            }
            f7 = this.e;
        }
        float f15 = f13 * f7 * f7;
        float f16 = f11 - f5;
        float f17 = f12 - f6;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.g;
        float f20 = f13 * f19 * f19;
        if (f18 >= f15) {
            f15 = f18 > f20 ? f20 : 0.0f;
        }
        float f21 = f6;
        float f22 = f5;
        if (f15 != 0.0f) {
            float sqrt = (float) Math.sqrt(f15 / f18);
            f22 = ((f5 - f11) * sqrt) + f11;
            f21 = f12 + (sqrt * (f6 - f12));
        }
        path.cubicTo((f + f22) / 2.0f, (f2 + f21) / 2.0f, (f22 + f3) / 2.0f, (f21 + f4) / 2.0f, f3, f4);
        return path;
    }

    public void setMaximumAngle(float f) {
        this.d = f;
        this.g = a(f);
    }

    public void setMinimumHorizontalAngle(float f) {
        this.b = f;
        this.e = a(f);
    }

    public void setMinimumVerticalAngle(float f) {
        this.f3406c = f;
        this.f = a(f);
    }
}
