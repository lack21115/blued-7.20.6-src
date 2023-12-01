package skin.support.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import skin.support.R;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatTextHelperV17.class */
public class SkinCompatTextHelperV17 extends SkinCompatTextHelper {
    private int f;
    private int g;

    public SkinCompatTextHelperV17(TextView textView) {
        super(textView);
        this.f = 0;
        this.g = 0;
    }

    @Override // skin.support.widget.SkinCompatTextHelper
    protected void a() {
        this.f44289c = b(this.f44289c);
        Drawable a2 = this.f44289c != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.f44289c) : null;
        this.e = b(this.e);
        Drawable a3 = this.e != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.e) : null;
        this.d = b(this.d);
        Drawable a4 = this.d != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.d) : null;
        this.b = b(this.b);
        Drawable a5 = this.b != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.b) : null;
        Drawable a6 = this.f != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.f) : null;
        if (a6 == null) {
            a6 = a2;
        }
        Drawable drawable = null;
        if (this.g != 0) {
            drawable = SkinCompatVectorResources.a(this.f44288a.getContext(), this.g);
        }
        if (drawable == null) {
            drawable = a4;
        }
        if (this.f44289c == 0 && this.e == 0 && this.d == 0 && this.b == 0 && this.f == 0 && this.g == 0) {
            return;
        }
        this.f44288a.setCompoundDrawablesWithIntrinsicBounds(a6, a3, drawable, a5);
    }

    @Override // skin.support.widget.SkinCompatTextHelper
    public void a(int i, int i2, int i3, int i4) {
        this.f = i;
        this.e = i2;
        this.g = i3;
        this.b = i4;
        a();
    }

    @Override // skin.support.widget.SkinCompatTextHelper
    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f44288a.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.SkinCompatTextHelper_android_drawableStart)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_drawableStart, 0);
            this.f = resourceId;
            this.f = SkinCompatHelper.b(resourceId);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SkinCompatTextHelper_android_drawableEnd)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_drawableEnd, 0);
            this.g = resourceId2;
            this.g = SkinCompatHelper.b(resourceId2);
        }
        obtainStyledAttributes.recycle();
        super.a(attributeSet, i);
    }
}
