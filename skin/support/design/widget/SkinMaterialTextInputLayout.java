package skin.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import skin.support.content.res.SkinCompatResources;
import skin.support.design.R;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatEditText;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialTextInputLayout.class */
public class SkinMaterialTextInputLayout extends TextInputLayout implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44245a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f44246c;
    private int d;
    private int e;
    private int f;

    public SkinMaterialTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.f44246c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44245a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout);
        if (obtainStyledAttributes.hasValue(R.styleable.TextInputLayout_android_textColorHint)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_android_textColorHint, 0);
            this.e = resourceId;
            this.f = resourceId;
            d();
        }
        b(obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0));
        a(obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0));
        this.b = obtainStyledAttributes.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        obtainStyledAttributes.recycle();
    }

    private void a() {
        TextView counterView;
        int b = SkinCompatHelper.b(this.f44246c);
        this.f44246c = b;
        if (b == 0 || (counterView = getCounterView()) == null) {
            return;
        }
        counterView.setTextColor(SkinCompatResources.c(getContext(), this.f44246c));
        c();
    }

    private void a(int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, skin.support.R.styleable.SkinTextAppearance);
            if (obtainStyledAttributes.hasValue(skin.support.R.styleable.SkinTextAppearance_android_textColor)) {
                this.f44246c = obtainStyledAttributes.getResourceId(skin.support.R.styleable.SkinTextAppearance_android_textColor, 0);
            }
            obtainStyledAttributes.recycle();
        }
        a();
    }

    private void b() {
        TextView errorView;
        int b = SkinCompatHelper.b(this.d);
        this.d = b;
        if (b == 0 || b == R.color.design_error || (errorView = getErrorView()) == null) {
            return;
        }
        errorView.setTextColor(SkinCompatResources.c(getContext(), this.d));
        c();
    }

    private void b(int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, skin.support.R.styleable.SkinTextAppearance);
            if (obtainStyledAttributes.hasValue(skin.support.R.styleable.SkinTextAppearance_android_textColor)) {
                this.d = obtainStyledAttributes.getResourceId(skin.support.R.styleable.SkinTextAppearance_android_textColor, 0);
            }
            obtainStyledAttributes.recycle();
        }
        b();
    }

    private void c() {
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("updateEditTextBackground", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        int b = SkinCompatHelper.b(this.e);
        this.e = b;
        if (b != 0 && b != R.color.abc_hint_foreground_material_light) {
            setFocusedTextColor(SkinCompatResources.d(getContext(), this.e));
        } else if (getEditText() != null) {
            int i = 0;
            if (getEditText() instanceof SkinCompatEditText) {
                i = ((SkinCompatEditText) getEditText()).getTextColorResId();
            } else if (getEditText() instanceof SkinMaterialTextInputEditText) {
                i = ((SkinMaterialTextInputEditText) getEditText()).getTextColorResId();
            }
            int b2 = SkinCompatHelper.b(i);
            if (b2 != 0) {
                setFocusedTextColor(SkinCompatResources.d(getContext(), b2));
            }
        }
    }

    private void e() {
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("updateLabelState", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TextView getCounterView() {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mCounterView");
            declaredField.setAccessible(true);
            return (TextView) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private TextView getErrorView() {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mErrorView");
            declaredField.setAccessible(true);
            return (TextView) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setDefaultTextColor(ColorStateList colorStateList) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, colorStateList);
            e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFocusedTextColor(ColorStateList colorStateList) {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, colorStateList);
            e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        b();
        a();
        d();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44245a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setCounterEnabled(boolean z) {
        super.setCounterEnabled(z);
        if (z) {
            a();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorEnabled(boolean z) {
        super.setErrorEnabled(z);
        if (z) {
            b();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorTextAppearance(int i) {
        super.setErrorTextAppearance(i);
        b(i);
    }
}
