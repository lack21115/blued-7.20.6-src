package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import skin.support.appcompat.R;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatRadioButton.class */
public class SkinCompatRadioButton extends AppCompatRadioButton implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatTextHelper f44279a;
    private SkinCompatCompoundButtonHelper b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44280c;

    public SkinCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public SkinCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatCompoundButtonHelper skinCompatCompoundButtonHelper = new SkinCompatCompoundButtonHelper(this);
        this.b = skinCompatCompoundButtonHelper;
        skinCompatCompoundButtonHelper.a(attributeSet, i);
        SkinCompatTextHelper a2 = SkinCompatTextHelper.a(this);
        this.f44279a = a2;
        a2.a(attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44280c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44280c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatCompoundButtonHelper skinCompatCompoundButtonHelper = this.b;
        if (skinCompatCompoundButtonHelper != null) {
            skinCompatCompoundButtonHelper.a();
        }
        SkinCompatTextHelper skinCompatTextHelper = this.f44279a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatRadioButton, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44280c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatRadioButton, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        super.setButtonDrawable(i);
        SkinCompatCompoundButtonHelper skinCompatCompoundButtonHelper = this.b;
        if (skinCompatCompoundButtonHelper != null) {
            skinCompatCompoundButtonHelper.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44279a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44279a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.b(i, i2, i3, i4);
        }
    }

    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        SkinCompatTextHelper skinCompatTextHelper = this.f44279a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(context, i);
        }
    }
}
