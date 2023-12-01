package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatRelativeLayout.class */
public class SkinCompatRelativeLayout extends RelativeLayout implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44283a;

    public SkinCompatRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44283a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44283a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44283a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }
}
