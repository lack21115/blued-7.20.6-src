package skin.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.android.internal.R;
import com.google.android.material.navigation.NavigationView;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatThemeUtils;
import skin.support.content.res.SkinCompatV7ThemeUtils;
import skin.support.content.res.SkinCompatVectorResources;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialNavigationView.class */
public class SkinMaterialNavigationView extends NavigationView implements SkinCompatSupportable {
    private static final int[] a = {R.attr.state_checked};
    private static final int[] b = {-16842910};
    private int c;
    private int d;
    private int e;
    private int f;
    private SkinCompatBackgroundHelper g;

    public SkinMaterialNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinMaterialNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int resourceId;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.g = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.design.R.styleable.NavigationView, i, skin.support.design.R.style.Widget_Design_NavigationView);
        if (obtainStyledAttributes.hasValue(skin.support.design.R.styleable.NavigationView_itemIconTint)) {
            this.f = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.NavigationView_itemIconTint, 0);
        } else {
            this.e = SkinCompatV7ThemeUtils.a(context);
        }
        if (obtainStyledAttributes.hasValue(skin.support.design.R.styleable.NavigationView_itemTextAppearance) && (resourceId = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.NavigationView_itemTextAppearance, 0)) != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, skin.support.design.R.styleable.SkinTextAppearance);
            if (obtainStyledAttributes2.hasValue(skin.support.design.R.styleable.SkinTextAppearance_android_textColor)) {
                this.d = obtainStyledAttributes2.getResourceId(skin.support.design.R.styleable.SkinTextAppearance_android_textColor, 0);
            }
            obtainStyledAttributes2.recycle();
        }
        if (obtainStyledAttributes.hasValue(skin.support.design.R.styleable.NavigationView_itemTextColor)) {
            this.d = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.NavigationView_itemTextColor, 0);
        } else {
            this.e = SkinCompatV7ThemeUtils.a(context);
        }
        if (this.d == 0) {
            this.d = SkinCompatThemeUtils.a(context);
        }
        this.c = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.NavigationView_itemBackground, 0);
        obtainStyledAttributes.recycle();
        c();
        b();
        a();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [int[], int[][]] */
    private ColorStateList a(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList d = SkinCompatResources.d(getContext(), typedValue.resourceId);
            int c = SkinCompatResources.c(getContext(), this.e);
            int defaultColor = d.getDefaultColor();
            return new ColorStateList(new int[]{b, a, EMPTY_STATE_SET}, new int[]{d.getColorForState(b, defaultColor), c, defaultColor});
        }
        return null;
    }

    private void a() {
        Drawable a2;
        int b2 = SkinCompatHelper.b(this.c);
        this.c = b2;
        if (b2 == 0 || (a2 = SkinCompatVectorResources.a(getContext(), this.c)) == null) {
            return;
        }
        setItemBackground(a2);
    }

    private void b() {
        int b2 = SkinCompatHelper.b(this.d);
        this.d = b2;
        if (b2 != 0) {
            setItemTextColor(SkinCompatResources.d(getContext(), this.d));
            return;
        }
        int b3 = SkinCompatHelper.b(this.e);
        this.e = b3;
        if (b3 != 0) {
            setItemTextColor(a(R.attr.textColorPrimary));
        }
    }

    private void c() {
        int b2 = SkinCompatHelper.b(this.f);
        this.f = b2;
        if (b2 != 0) {
            setItemIconTintList(SkinCompatResources.d(getContext(), this.f));
            return;
        }
        int b3 = SkinCompatHelper.b(this.e);
        this.e = b3;
        if (b3 != 0) {
            setItemIconTintList(a(R.attr.textColorSecondary));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.g;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        c();
        b();
        a();
    }

    public void setItemBackgroundResource(int i) {
        super.setItemBackgroundResource(i);
        this.c = i;
        a();
    }

    public void setItemTextAppearance(int i) {
        super.setItemTextAppearance(i);
        if (i != 0) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, skin.support.design.R.styleable.SkinTextAppearance);
            if (obtainStyledAttributes.hasValue(skin.support.design.R.styleable.SkinTextAppearance_android_textColor)) {
                this.d = obtainStyledAttributes.getResourceId(skin.support.design.R.styleable.SkinTextAppearance_android_textColor, 0);
            }
            obtainStyledAttributes.recycle();
            b();
        }
    }
}
