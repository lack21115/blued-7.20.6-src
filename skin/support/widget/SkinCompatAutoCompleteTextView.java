package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import skin.support.appcompat.R;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatAutoCompleteTextView.class */
public class SkinCompatAutoCompleteTextView extends AppCompatAutoCompleteTextView implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f44255a = {16843126};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatTextHelper f44256c;
    private SkinCompatBackgroundHelper d;

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f44255a, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.b = obtainStyledAttributes.getResourceId(0, 0);
        }
        obtainStyledAttributes.recycle();
        a();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.d = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        SkinCompatTextHelper a2 = SkinCompatTextHelper.a(this);
        this.f44256c = a2;
        a2.a(attributeSet, i);
    }

    private void a() {
        Drawable a2;
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b == 0 || (a2 = SkinCompatVectorResources.a(getContext(), this.b)) == null) {
            return;
        }
        setDropDownBackgroundDrawable(a2);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatTextHelper skinCompatTextHelper = this.f44256c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.d();
        }
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44256c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44256c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.b(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        super.setDropDownBackgroundResource(i);
        this.b = i;
        a();
    }

    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        SkinCompatTextHelper skinCompatTextHelper = this.f44256c;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(context, i);
        }
    }
}
