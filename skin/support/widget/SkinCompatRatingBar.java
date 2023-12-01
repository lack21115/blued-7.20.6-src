package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import skin.support.appcompat.R;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatRatingBar.class */
public class SkinCompatRatingBar extends AppCompatRatingBar implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatProgressBarHelper f44282a;

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatProgressBarHelper skinCompatProgressBarHelper = new SkinCompatProgressBarHelper(this);
        this.f44282a = skinCompatProgressBarHelper;
        skinCompatProgressBarHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatProgressBarHelper skinCompatProgressBarHelper = this.f44282a;
        if (skinCompatProgressBarHelper != null) {
            skinCompatProgressBarHelper.a();
        }
    }
}
