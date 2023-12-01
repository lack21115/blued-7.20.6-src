package skin.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import skin.support.content.res.SkinCompatResources;
import skin.support.design.R;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatHelper;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/design/widget/SkinMaterialBottomNavigationView.class */
public class SkinMaterialBottomNavigationView extends BottomNavigationView implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f44233a = {-16842910};
    private static final int[] b = {16842912};

    /* renamed from: c  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44234c;
    private int d;
    private int e;
    private int f;

    public SkinMaterialBottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44234c = skinCompatBackgroundHelper;
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
            int c2 = SkinCompatResources.c(getContext(), this.f);
            int defaultColor = d.getDefaultColor();
            return new ColorStateList(new int[]{f44233a, b, EMPTY_STATE_SET}, new int[]{d.getColorForState(f44233a, defaultColor), c2, defaultColor});
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
            setItemTextColor(a(16842808));
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
            setItemIconTintList(a(16842808));
        }
    }

    private int c() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44234c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        b();
        a();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44234c;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }
}
