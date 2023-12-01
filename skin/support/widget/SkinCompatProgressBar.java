package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatProgressBar.class */
public class SkinCompatProgressBar extends ProgressBar implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatProgressBarHelper f44276a;

    public SkinCompatProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public SkinCompatProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatProgressBarHelper skinCompatProgressBarHelper = new SkinCompatProgressBarHelper(this);
        this.f44276a = skinCompatProgressBarHelper;
        skinCompatProgressBarHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatProgressBarHelper skinCompatProgressBarHelper = this.f44276a;
        if (skinCompatProgressBarHelper != null) {
            skinCompatProgressBarHelper.a();
        }
    }
}
