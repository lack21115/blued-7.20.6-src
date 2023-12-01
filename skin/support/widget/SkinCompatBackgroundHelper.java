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

    /* renamed from: a  reason: collision with root package name */
    private final View f44257a;
    private int b = 0;

    public SkinCompatBackgroundHelper(View view) {
        this.f44257a = view;
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
            if (this.f44257a.getBackground() != null) {
                colorFilter = this.f44257a.getBackground().getColorFilter();
            }
        }
        Drawable a2 = SkinCompatVectorResources.a(this.f44257a.getContext(), this.b);
        if (a2 != null) {
            int paddingLeft = this.f44257a.getPaddingLeft();
            int paddingTop = this.f44257a.getPaddingTop();
            int paddingRight = this.f44257a.getPaddingRight();
            int paddingBottom = this.f44257a.getPaddingBottom();
            ViewCompat.setBackground(this.f44257a, a2);
            this.f44257a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        if (colorFilter != null) {
            this.f44257a.getBackground().setColorFilter(colorFilter);
        }
    }

    public void a(int i) {
        this.b = i;
        a();
    }

    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f44257a.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinBackgroundHelper, i, 0);
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
