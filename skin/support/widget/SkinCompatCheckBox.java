package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import skin.support.appcompat.R;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatCheckBox.class */
public class SkinCompatCheckBox extends AppCompatCheckBox implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatCompoundButtonHelper f44261a;
    private SkinCompatTextHelper b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44262c;

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatCompoundButtonHelper skinCompatCompoundButtonHelper = new SkinCompatCompoundButtonHelper(this);
        this.f44261a = skinCompatCompoundButtonHelper;
        skinCompatCompoundButtonHelper.a(attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44262c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        SkinCompatTextHelper a2 = SkinCompatTextHelper.a(this);
        this.b = a2;
        a2.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatCompoundButtonHelper skinCompatCompoundButtonHelper = this.f44261a;
        if (skinCompatCompoundButtonHelper != null) {
            skinCompatCompoundButtonHelper.a();
        }
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44262c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatTextHelper skinCompatTextHelper = this.b;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.d();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44262c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        super.setButtonDrawable(i);
        SkinCompatCompoundButtonHelper skinCompatCompoundButtonHelper = this.f44261a;
        if (skinCompatCompoundButtonHelper != null) {
            skinCompatCompoundButtonHelper.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.b;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.b;
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
        SkinCompatTextHelper skinCompatTextHelper = this.b;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(context, i);
        }
    }
}
