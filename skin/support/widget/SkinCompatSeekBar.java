package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import skin.support.appcompat.R;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatSeekBar.class */
public class SkinCompatSeekBar extends AppCompatSeekBar implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatSeekBarHelper f44285a;

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatSeekBarHelper skinCompatSeekBarHelper = new SkinCompatSeekBarHelper(this);
        this.f44285a = skinCompatSeekBarHelper;
        skinCompatSeekBarHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatSeekBarHelper skinCompatSeekBarHelper = this.f44285a;
        if (skinCompatSeekBarHelper != null) {
            skinCompatSeekBarHelper.a();
        }
    }
}
