package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import skin.support.content.res.SkinCompatVectorResources;
import skin.support.design.R;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialCollapsingToolbarLayout.class */
public class SkinMaterialCollapsingToolbarLayout extends CollapsingToolbarLayout implements SkinCompatSupportable {
    private int a;
    private int b;
    private SkinCompatBackgroundHelper c;

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.a = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_contentScrim, 0);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_statusBarScrim, 0);
        obtainStyledAttributes.recycle();
        b();
        a();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
    }

    private void a() {
        Drawable a;
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b == 0 || (a = SkinCompatVectorResources.a(getContext(), this.b)) == null) {
            return;
        }
        setStatusBarScrim(a);
    }

    private void b() {
        Drawable a;
        int b = SkinCompatHelper.b(this.a);
        this.a = b;
        if (b == 0 || (a = SkinCompatVectorResources.a(getContext(), this.a)) == null) {
            return;
        }
        setContentScrim(a);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        b();
        a();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }
}
