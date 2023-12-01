package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Animation;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/TranslateAnimation.class */
public class TranslateAnimation extends Animation {
    private float mFromXDelta;
    private int mFromXType;
    private float mFromXValue;
    private float mFromYDelta;
    private int mFromYType;
    private float mFromYValue;
    private float mToXDelta;
    private int mToXType;
    private float mToXValue;
    private float mToYDelta;
    private int mToYType;
    private float mToYValue;

    public TranslateAnimation(float f, float f2, float f3, float f4) {
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
        this.mFromXValue = 0.0f;
        this.mToXValue = 0.0f;
        this.mFromYValue = 0.0f;
        this.mToYValue = 0.0f;
        this.mFromXValue = f;
        this.mToXValue = f2;
        this.mFromYValue = f3;
        this.mToYValue = f4;
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
    }

    public TranslateAnimation(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4) {
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
        this.mFromXValue = 0.0f;
        this.mToXValue = 0.0f;
        this.mFromYValue = 0.0f;
        this.mToYValue = 0.0f;
        this.mFromXValue = f;
        this.mToXValue = f2;
        this.mFromYValue = f3;
        this.mToYValue = f4;
        this.mFromXType = i;
        this.mToXType = i2;
        this.mFromYType = i3;
        this.mToYType = i4;
    }

    public TranslateAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
        this.mFromXValue = 0.0f;
        this.mToXValue = 0.0f;
        this.mFromYValue = 0.0f;
        this.mToYValue = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TranslateAnimation);
        Animation.Description parseValue = Animation.Description.parseValue(obtainStyledAttributes.peekValue(0));
        this.mFromXType = parseValue.type;
        this.mFromXValue = parseValue.value;
        Animation.Description parseValue2 = Animation.Description.parseValue(obtainStyledAttributes.peekValue(1));
        this.mToXType = parseValue2.type;
        this.mToXValue = parseValue2.value;
        Animation.Description parseValue3 = Animation.Description.parseValue(obtainStyledAttributes.peekValue(2));
        this.mFromYType = parseValue3.type;
        this.mFromYValue = parseValue3.value;
        Animation.Description parseValue4 = Animation.Description.parseValue(obtainStyledAttributes.peekValue(3));
        this.mToYType = parseValue4.type;
        this.mToYValue = parseValue4.value;
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromXDelta;
        float f3 = this.mFromYDelta;
        if (this.mFromXDelta != this.mToXDelta) {
            f2 = this.mFromXDelta + ((this.mToXDelta - this.mFromXDelta) * f);
        }
        if (this.mFromYDelta != this.mToYDelta) {
            f3 = this.mFromYDelta + ((this.mToYDelta - this.mFromYDelta) * f);
        }
        transformation.getMatrix().setTranslate(f2, f3);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.mFromXDelta = resolveSize(this.mFromXType, this.mFromXValue, i, i3);
        this.mToXDelta = resolveSize(this.mToXType, this.mToXValue, i, i3);
        this.mFromYDelta = resolveSize(this.mFromYType, this.mFromYValue, i2, i4);
        this.mToYDelta = resolveSize(this.mToYType, this.mToYValue, i2, i4);
    }
}
