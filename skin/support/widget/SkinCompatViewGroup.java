package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatViewGroup.class */
public abstract class SkinCompatViewGroup extends ViewGroup implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper a;

    public SkinCompatViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }
}
