package skin.support.widget;

import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import skin.support.R;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatBackgroundHelper.class */
public class SkinCompatBackgroundHelper extends SkinCompatHelper {
    private final View a;
    private int b = 0;

    public SkinCompatBackgroundHelper(View view) {
        this.a = view;
    }

    public void a() {
        int b = b(this.b);
        this.b = b;
        if (b == 0) {
            return;
        }
        ColorFilter colorFilter = null;
        if (Build.VERSION.SDK_INT >= 21) {
            colorFilter = null;
            if (this.a.getBackground() != null) {
                colorFilter = this.a.getBackground().getColorFilter();
            }
        }
        Drawable a = SkinCompatVectorResources.a(this.a.getContext(), this.b);
        if (a != null) {
            int paddingLeft = this.a.getPaddingLeft();
            int paddingTop = this.a.getPaddingTop();
            int paddingRight = this.a.getPaddingRight();
            int paddingBottom = this.a.getPaddingBottom();
            ViewCompat.setBackground(this.a, a);
            this.a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        if (colorFilter != null) {
            this.a.getBackground().setColorFilter(colorFilter);
        }
    }

    public void a(int i) {
        this.b = i;
        a();
    }

    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.SkinBackgroundHelper_android_background)) {
                this.b = obtainStyledAttributes.getResourceId(R.styleable.SkinBackgroundHelper_android_background, 0);
            }
            obtainStyledAttributes.recycle();
            a();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
