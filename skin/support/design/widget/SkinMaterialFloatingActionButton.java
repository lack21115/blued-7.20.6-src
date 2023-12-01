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
    private int a;
    private int b;
    private SkinCompatImageHelper c;

    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinMaterialFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_backgroundTint, 0);
        this.a = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_rippleColor, 0);
        obtainStyledAttributes.recycle();
        a();
        b();
        SkinCompatImageHelper skinCompatImageHelper = new SkinCompatImageHelper(this);
        this.c = skinCompatImageHelper;
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
        int b = SkinCompatHelper.b(this.a);
        this.a = b;
        if (b != 0) {
            setRippleColor(SkinCompatResources.c(getContext(), this.a));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        a();
        b();
        SkinCompatImageHelper skinCompatImageHelper = this.c;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.a();
        }
    }
}
