package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import skin.support.R;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatTextHelper.class */
public class SkinCompatTextHelper extends SkinCompatHelper {
    private static final String f = SkinCompatTextHelper.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    final TextView f44288a;
    private int g = 0;
    private int h = 0;
    protected int b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f44289c = 0;
    protected int d = 0;
    protected int e = 0;

    public SkinCompatTextHelper(TextView textView) {
        this.f44288a = textView;
    }

    public static SkinCompatTextHelper a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new SkinCompatTextHelperV17(textView) : new SkinCompatTextHelper(textView);
    }

    private void e() {
        int b = b(this.h);
        this.h = b;
        if (b != 0) {
            try {
                this.f44288a.setHintTextColor(SkinCompatResources.d(this.f44288a.getContext(), this.h));
            } catch (Exception e) {
            }
        }
    }

    private void f() {
        int b = b(this.g);
        this.g = b;
        if (b != 0) {
            try {
                this.f44288a.setTextColor(SkinCompatResources.d(this.f44288a.getContext(), this.g));
            } catch (Exception e) {
            }
        }
    }

    protected void a() {
        b();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f44289c = i;
        this.e = i2;
        this.d = i3;
        this.b = i4;
        a();
    }

    public void a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.SkinTextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
            this.g = obtainStyledAttributes.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SkinTextAppearance_android_textColorHint)) {
            this.h = obtainStyledAttributes.getResourceId(R.styleable.SkinTextAppearance_android_textColorHint, 0);
        }
        obtainStyledAttributes.recycle();
        f();
        e();
    }

    public void a(AttributeSet attributeSet, int i) {
        Context context = this.f44288a.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SkinCompatTextHelper, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_textAppearance, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.SkinCompatTextHelper_android_drawableLeft)) {
            this.f44289c = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_drawableLeft, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SkinCompatTextHelper_android_drawableTop)) {
            this.e = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_drawableTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SkinCompatTextHelper_android_drawableRight)) {
            this.d = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_drawableRight, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SkinCompatTextHelper_android_drawableBottom)) {
            this.b = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatTextHelper_android_drawableBottom, 0);
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, R.styleable.SkinTextAppearance);
            if (obtainStyledAttributes2.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
                this.g = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            }
            if (obtainStyledAttributes2.hasValue(R.styleable.SkinTextAppearance_android_textColorHint)) {
                this.h = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColorHint, 0);
            }
            obtainStyledAttributes2.recycle();
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, R.styleable.SkinTextAppearance, i, 0);
        if (obtainStyledAttributes3.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
            this.g = obtainStyledAttributes3.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
        }
        if (obtainStyledAttributes3.hasValue(R.styleable.SkinTextAppearance_android_textColorHint)) {
            this.h = obtainStyledAttributes3.getResourceId(R.styleable.SkinTextAppearance_android_textColorHint, 0);
        }
        obtainStyledAttributes3.recycle();
        d();
    }

    protected void b() {
        int b = b(this.f44289c);
        this.f44289c = b;
        Drawable drawable = null;
        Drawable a2 = b != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.f44289c) : null;
        int b2 = b(this.e);
        this.e = b2;
        Drawable a3 = b2 != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.e) : null;
        int b3 = b(this.d);
        this.d = b3;
        Drawable a4 = b3 != 0 ? SkinCompatVectorResources.a(this.f44288a.getContext(), this.d) : null;
        int b4 = b(this.b);
        this.b = b4;
        if (b4 != 0) {
            drawable = SkinCompatVectorResources.a(this.f44288a.getContext(), this.b);
        }
        if (this.f44289c == 0 && this.e == 0 && this.d == 0 && this.b == 0) {
            return;
        }
        this.f44288a.setCompoundDrawablesWithIntrinsicBounds(a2, a3, a4, drawable);
    }

    public void b(int i, int i2, int i3, int i4) {
        this.f44289c = i;
        this.e = i2;
        this.d = i3;
        this.b = i4;
        b();
    }

    public int c() {
        return this.g;
    }

    public void d() {
        a();
        f();
        e();
    }
}
