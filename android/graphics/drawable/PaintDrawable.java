package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import com.android.internal.R;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/PaintDrawable.class */
public class PaintDrawable extends ShapeDrawable {
    public PaintDrawable() {
    }

    public PaintDrawable(int i) {
        getPaint().setColor(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.ShapeDrawable
    public boolean inflateTag(String str, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (str.equals("corners")) {
            TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.DrawableCorners);
            int dimensionPixelSize = obtainAttributes.getDimensionPixelSize(0, 0);
            setCornerRadius(dimensionPixelSize);
            int dimensionPixelSize2 = obtainAttributes.getDimensionPixelSize(1, dimensionPixelSize);
            int dimensionPixelSize3 = obtainAttributes.getDimensionPixelSize(2, dimensionPixelSize);
            int dimensionPixelSize4 = obtainAttributes.getDimensionPixelSize(3, dimensionPixelSize);
            int dimensionPixelSize5 = obtainAttributes.getDimensionPixelSize(4, dimensionPixelSize);
            if (dimensionPixelSize2 != dimensionPixelSize || dimensionPixelSize3 != dimensionPixelSize || dimensionPixelSize4 != dimensionPixelSize || dimensionPixelSize5 != dimensionPixelSize) {
                setCornerRadii(new float[]{dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize5});
            }
            obtainAttributes.recycle();
            return true;
        }
        return super.inflateTag(str, resources, xmlPullParser, attributeSet);
    }

    public void setCornerRadii(float[] fArr) {
        if (fArr != null) {
            setShape(new RoundRectShape(fArr, null, null));
        } else if (getShape() != null) {
            setShape(null);
        }
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        float[] fArr = null;
        if (f > 0.0f) {
            float[] fArr2 = new float[8];
            int i = 0;
            while (true) {
                int i2 = i;
                fArr = fArr2;
                if (i2 >= 8) {
                    break;
                }
                fArr2[i2] = f;
                i = i2 + 1;
            }
        }
        setCornerRadii(fArr);
    }
}
