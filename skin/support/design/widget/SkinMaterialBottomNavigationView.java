package skin.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.android.internal.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import skin.support.content.res.SkinCompatResources;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialBottomNavigationView.class */
public class SkinMaterialBottomNavigationView extends BottomNavigationView implements SkinCompatSupportable {
    private static final int[] a = {-16842910};
    private static final int[] b = {R.attr.state_checked};
    private SkinCompatBackgroundHelper c;
    private int d;
    private int e;
    private int f;

    public SkinMaterialBottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinMaterialBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.c = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        this.f = c();
        this.f = c();
        b();
        a();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [int[], int[][]] */
    private ColorStateList a(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList d = SkinCompatResources.d(getContext(), typedValue.resourceId);
            int c = SkinCompatResources.c(getContext(), this.f);
            int defaultColor = d.getDefaultColor();
            return new ColorStateList(new int[]{a, b, EMPTY_STATE_SET}, new int[]{d.getColorForState(a, defaultColor), c, defaultColor});
        }
        return null;
    }

    private void a() {
        int b2 = SkinCompatHelper.b(this.d);
        this.d = b2;
        if (b2 != 0) {
            setItemTextColor(SkinCompatResources.d(getContext(), this.d));
            return;
        }
        int b3 = SkinCompatHelper.b(this.f);
        this.f = b3;
        if (b3 != 0) {
            setItemTextColor(a(R.attr.textColorSecondary));
        }
    }

    private void b() {
        int b2 = SkinCompatHelper.b(this.e);
        this.e = b2;
        if (b2 != 0) {
            setItemIconTintList(SkinCompatResources.d(getContext(), this.e));
            return;
        }
        int b3 = SkinCompatHelper.b(this.f);
        this.f = b3;
        if (b3 != 0) {
            setItemIconTintList(a(R.attr.textColorSecondary));
        }
    }

    private int c() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(skin.support.design.R.attr.colorPrimary, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        b();
        a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }
}
