package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatImageButton.class */
public class SkinCompatImageButton extends AppCompatImageButton implements SkinCompatSupportable {
    private SkinCompatBackgroundHelper a;
    private SkinCompatImageHelper b;

    public SkinCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        SkinCompatImageHelper skinCompatImageHelper = new SkinCompatImageHelper(this);
        this.b = skinCompatImageHelper;
        skinCompatImageHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatImageHelper skinCompatImageHelper = this.b;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.a();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setImageResource(int i) {
        SkinCompatImageHelper skinCompatImageHelper = this.b;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.a(i);
        }
    }
}
