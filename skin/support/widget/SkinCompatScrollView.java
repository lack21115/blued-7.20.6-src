package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatScrollView.class */
public class SkinCompatScrollView extends ScrollView implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper a;

    public SkinCompatScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
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
