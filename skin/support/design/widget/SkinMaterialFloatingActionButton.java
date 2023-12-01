package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import skin.support.content.res.SkinCompatResources;
import skin.support.design.R;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatImageHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialFloatingActionButton.class */
public class SkinMaterialFloatingActionButton extends FloatingActionButton implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private int f44238a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatImageHelper f44239c;

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44238a = 0;
        this.b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_backgroundTint, 0);
        this.f44238a = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_rippleColor, 0);
        obtainStyledAttributes.recycle();
        a();
        b();
        SkinCompatImageHelper skinCompatImageHelper = new SkinCompatImageHelper(this);
        this.f44239c = skinCompatImageHelper;
        skinCompatImageHelper.a(attributeSet, i);
    }

    private void a() {
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b != 0) {
            setBackgroundTintList(SkinCompatResources.d(getContext(), this.b));
        }
    }

    private void b() {
        int b = SkinCompatHelper.b(this.f44238a);
        this.f44238a = b;
        if (b != 0) {
            setRippleColor(SkinCompatResources.c(getContext(), this.f44238a));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        a();
        b();
        SkinCompatImageHelper skinCompatImageHelper = this.f44239c;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.a();
        }
    }
}
