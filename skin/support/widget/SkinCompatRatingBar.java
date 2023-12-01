package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import skin.support.appcompat.R;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatRatingBar.class */
public class SkinCompatRatingBar extends AppCompatRatingBar implements SkinCompatSupportable {
    private SkinCompatProgressBarHelper a;

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatProgressBarHelper skinCompatProgressBarHelper = new SkinCompatProgressBarHelper(this);
        this.a = skinCompatProgressBarHelper;
        skinCompatProgressBarHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatProgressBarHelper skinCompatProgressBarHelper = this.a;
        if (skinCompatProgressBarHelper != null) {
            skinCompatProgressBarHelper.a();
        }
    }
}
