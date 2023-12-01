package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatView.class */
public class SkinCompatView extends View implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44292a;

    public SkinCompatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44292a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44292a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44292a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }
}
