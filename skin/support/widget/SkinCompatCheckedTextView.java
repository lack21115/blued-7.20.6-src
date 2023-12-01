package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import skin.support.appcompat.R;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatCheckedTextView.class */
public class SkinCompatCheckedTextView extends AppCompatCheckedTextView implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f44263a = {16843016};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatTextHelper f44264c;
    private SkinCompatBackgroundHelper d;

    public SkinCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public SkinCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.d = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        SkinCompatTextHelper a2 = SkinCompatTextHelper.a(this);
        this.f44264c = a2;
        a2.a(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f44263a, i, 0);
        this.b = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b != 0) {
            setCheckMarkDrawable(SkinCompatVectorResources.a(getContext(), this.b));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatTextHelper skinCompatTextHelper = this.f44264c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.d();
        }
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        this.b = i;
        a();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44264c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44264c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.b(i, i2, i3, i4);
        }
    }

    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        SkinCompatTextHelper skinCompatTextHelper = this.f44264c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(context, i);
        }
    }
}
