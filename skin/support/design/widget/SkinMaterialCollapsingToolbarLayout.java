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

    /* renamed from: a  reason: collision with root package name */
    private int f44235a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44236c;

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44235a = 0;
        this.b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i, R.style.Widget_Design_CollapsingToolbar);
        this.f44235a = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_contentScrim, 0);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_statusBarScrim, 0);
        obtainStyledAttributes.recycle();
        b();
        a();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44236c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
    }

    private void a() {
        Drawable a2;
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b == 0 || (a2 = SkinCompatVectorResources.a(getContext(), this.b)) == null) {
            return;
        }
        setStatusBarScrim(a2);
    }

    private void b() {
        Drawable a2;
        int b = SkinCompatHelper.b(this.f44235a);
        this.f44235a = b;
        if (b == 0 || (a2 = SkinCompatVectorResources.a(getContext(), this.f44235a)) == null) {
            return;
        }
        setContentScrim(a2);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        b();
        a();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44236c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }
}
