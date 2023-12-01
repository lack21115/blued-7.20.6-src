package skin.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.R;
import com.google.android.material.textfield.TextInputEditText;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatSupportable;
import skin.support.widget.SkinCompatTextHelper;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialTextInputEditText.class */
public class SkinMaterialTextInputEditText extends TextInputEditText implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatTextHelper f44244a;
    private SkinCompatBackgroundHelper b;

    public SkinMaterialTextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SkinMaterialTextInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.b = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        SkinCompatTextHelper a2 = SkinCompatTextHelper.a(this);
        this.f44244a = a2;
        a2.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatTextHelper skinCompatTextHelper = this.f44244a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.d();
        }
    }

    public int getTextColorResId() {
        SkinCompatTextHelper skinCompatTextHelper = this.f44244a;
        if (skinCompatTextHelper != null) {
            return skinCompatTextHelper.c();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44244a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        SkinCompatTextHelper skinCompatTextHelper = this.f44244a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.b(i, i2, i3, i4);
        }
    }

    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        SkinCompatTextHelper skinCompatTextHelper = this.f44244a;
        if (skinCompatTextHelper != null) {
            skinCompatTextHelper.a(context, i);
        }
    }
}
