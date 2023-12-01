package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.PathParser;
import android.view.InflateException;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/PathInterpolator.class */
public class PathInterpolator extends BaseInterpolator {
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolator(float f, float f2) {
        initQuad(f, f2);
    }

    public PathInterpolator(float f, float f2, float f3, float f4) {
        initCubic(f, f2, f3, f4);
    }

    public PathInterpolator(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public PathInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.PathInterpolator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.PathInterpolator);
        parseInterpolatorFromTypeArray(obtainStyledAttributes);
        setChangingConfiguration(obtainStyledAttributes.getChangingConfigurations());
        obtainStyledAttributes.recycle();
    }

    public PathInterpolator(Path path) {
        initPath(path);
    }

    private void initCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        float[] approximate = path.approximate(0.002f);
        int length = approximate.length / 3;
        if (approximate[1] != 0.0f || approximate[2] != 0.0f || approximate[approximate.length - 2] != 1.0f || approximate[approximate.length - 1] != 1.0f) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1)");
        }
        this.mX = new float[length];
        this.mY = new float[length];
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return;
            }
            int i4 = i3 + 1;
            float f3 = approximate[i3];
            int i5 = i4 + 1;
            float f4 = approximate[i4];
            float f5 = approximate[i5];
            if (f3 == f2 && f4 != f) {
                throw new IllegalArgumentException("The Path cannot have discontinuity in the X axis.");
            }
            if (f4 < f) {
                throw new IllegalArgumentException("The Path cannot loop back on itself.");
            }
            this.mX[i] = f4;
            this.mY[i] = f5;
            f = f4;
            f2 = f3;
            i++;
            i2 = i5 + 1;
        }
    }

    private void initQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray) {
        if (typedArray.hasValue(4)) {
            String string = typedArray.getString(4);
            Path createPathFromPathData = PathParser.createPathFromPathData(string);
            if (createPathFromPathData == null) {
                throw new InflateException("The path is null, which is created from " + string);
            }
            initPath(createPathFromPathData);
        } else if (!typedArray.hasValue(0)) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else {
            if (!typedArray.hasValue(1)) {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
            float f = typedArray.getFloat(0, 0.0f);
            float f2 = typedArray.getFloat(1, 0.0f);
            boolean hasValue = typedArray.hasValue(2);
            if (hasValue != typedArray.hasValue(3)) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            if (hasValue) {
                initCubic(f, f2, typedArray.getFloat(2, 0.0f), typedArray.getFloat(3, 0.0f));
            } else {
                initQuad(f, f2);
            }
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.mX.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.mX[length] - this.mX[i];
        if (f2 == 0.0f) {
            return this.mY[i];
        }
        float f3 = (f - this.mX[i]) / f2;
        float f4 = this.mY[i];
        return ((this.mY[length] - f4) * f3) + f4;
    }
}
