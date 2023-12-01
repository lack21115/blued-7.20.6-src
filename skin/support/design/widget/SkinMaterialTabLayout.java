package skin.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import skin.support.content.res.SkinCompatResources;
import skin.support.design.R;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialTabLayout.class */
public class SkinMaterialTabLayout extends TabLayout implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private int f44242a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f44243c;

    public SkinMaterialTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44242a = 0;
        this.b = 0;
        this.f44243c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, 0);
        this.f44242a = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabIndicatorColor, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab), R.styleable.SkinTextAppearance);
        try {
            this.b = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.b = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextColor, 0);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f44243c = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabSelectedTextColor, 0);
            }
            obtainStyledAttributes.recycle();
            applySkin();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        int b = SkinCompatHelper.b(this.f44242a);
        this.f44242a = b;
        if (b != 0) {
            setSelectedTabIndicatorColor(SkinCompatResources.c(getContext(), this.f44242a));
        }
        int b2 = SkinCompatHelper.b(this.b);
        this.b = b2;
        if (b2 != 0) {
            setTabTextColors(SkinCompatResources.d(getContext(), this.b));
        }
        int b3 = SkinCompatHelper.b(this.f44243c);
        this.f44243c = b3;
        if (b3 != 0) {
            int c2 = SkinCompatResources.c(getContext(), this.f44243c);
            if (getTabTextColors() != null) {
                setTabTextColors(getTabTextColors().getDefaultColor(), c2);
            }
        }
    }
}
